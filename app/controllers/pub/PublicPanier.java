package controllers.pub;

import controllers.util.TrackerController;
import javassist.NotFoundException;
import models.Panier;
import models.Produit;
import play.Logger;
import play.mvc.Controller;
import services.PanierService;
import services.ProduitService;

import java.util.Map;

public class PublicPanier extends TrackerController {
    public static void afficherPanier(){
        Panier panier = PanierService.INSTANCE.getPanierByUUID(Controller.session.get("PanierUUID"));
        Controller.render(panier);
    }

    public static void addToPanier(String uuid, Integer quantite){
        Panier panier = PanierService.getOrCreatePanier(Controller.session.get("PanierUUID"));
        Controller.session.put("PanierUUID",panier.uuid);

        panier.addProduit(ProduitService.getByUUID(uuid), quantite);

        afficherPanier();
    }

    public static void updateQuantitePanier(String uuid, Integer quantite){
        Panier panier = PanierService.getOrCreatePanier(Controller.session.get("PanierUUID"));
        session.put("PanierUUID",panier.uuid);

        panier.updateProduit(ProduitService.getByUUID(uuid),quantite);
        if(panier.produits.isEmpty()){
            Controller.session.remove("PanierUUID");
        }
        afficherPanier();
    }

    public static void supprimerProduitPanier(String uuid){
        Panier panier = PanierService.INSTANCE.getPanierByUUID(Controller.session.get("PanierUUID"));
        if(panier!=null){
            panier.removeProduit(ProduitService.getByUUID(uuid));
        }
        if(panier.produits.isEmpty()){
            Controller.session.remove("PanierUUID");
        }
        afficherPanier();
    }
}
