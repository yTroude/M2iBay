package controllers.publicControllers;

import controllers.util.TrackerController;
import javassist.NotFoundException;
import models.Panier;
import models.Produit;
import play.Logger;
import play.mvc.Controller;
import services.PanierService;

import java.util.Map;

public class PublicPanier extends TrackerController {
    public static void afficherPanier(){
        Panier panier = PanierService.INSTANCE.getPanierByUUID(Controller.session.get("PanierUUID"));
        Logger.debug("afficherPanier Panier : "+panier);
        Controller.render(panier);
    }

    public static void addToPanier(String produitUUID, Integer quantite){
        Panier panier = getOrCreatePanier();
        panier.produits.entrySet().stream().collect(java.util.stream.Collectors.summingDouble((Map.Entry<Produit, Integer> entry) -> {
            return entry.getValue() * entry.getKey().prix;
        }));
        Controller.session.put("PanierUUID",panier.uuid);

        try {
            Produit produit = Produit.find("byUuid",produitUUID).first();
            panier.addProduit(produit, quantite);
        } catch (NotFoundException e) {
            Logger.error("Product not found");
        }

        afficherPanier();
    }

    public static void updateQuantitePanier(String produitUUID, Integer quantite){
        Panier panier = getOrCreatePanier();
        Logger.debug("PanierUUID : "+panier.uuid);
        Controller.session.put("updatePanier PanierUUID",panier.uuid);

        try {
            panier.updateProduit(Produit.find("byUuid",produitUUID).first(),quantite);
        } catch (NotFoundException e) {
            Logger.error("Product not found");
        }
        afficherPanier();
    }

    private static Panier getOrCreatePanier(){
        Panier panier = PanierService.INSTANCE.getPanierByUUID(Controller.session.get("PanierUUID"));
        if (panier == null){
            panier = PanierService.INSTANCE.newPanier();
        }
        return panier;
    }
}
