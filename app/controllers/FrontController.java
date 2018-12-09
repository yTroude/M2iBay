package controllers;

import javassist.NotFoundException;
import play.Logger;
import play.mvc.*;

import java.util.*;

import models.*;
import services.PanierService;

public class FrontController extends Controller {

    public static void index() {
        List<Produit> produits = Produit.findAll();
        render(produits);
    }

    public static void afficherPanier(){
        Panier panier = PanierService.INSTANCE.getPanierByUUID(session.get("PanierUUID"));
        Logger.debug("Panier : "+panier);
        render(panier);
    }
    public static void detailProduit(String produitUuid){
        Produit produit = Produit.findById(produitUuid);
        render(produit);
    }

    public static void addToPanier(String produitUUID, Integer quantite){
        Panier panier = getOrCreatePanier();
        Logger.debug("Panier id : "+panier.uuid+ " ; Produit id : "+produitUUID+" ; qte : "+quantite);
        session.put("PanierUUID",panier.uuid);
        StringBuilder sb = new StringBuilder();
        sb.append("session : ");
        for (String s : session.all().keySet()){
            sb.append(s);
            sb.append(":");
            sb.append(session.get(s));
            sb.append(" ; ");
        }
        Logger.debug(sb.toString());

        try {
            panier.addProduit(Produit.find("byUuid",produitUUID).first(), quantite);
        } catch (NotFoundException e) {
            Logger.error("Product not found");
        }

        afficherPanier();

    }

    public static void updateQuantitePanier(String produitUUID, Integer quantite){
        Panier panier = getOrCreatePanier();
        session.put("PanierUUID",panier.uuid);

        try {
            panier.updateProduit(Produit.find("select * from Produit where uuid=79a83961-b7c8-461b-9ea4-61b1ed29f085").first(),quantite);
        } catch (NotFoundException e) {
            Logger.error("Product not found");
        }
        afficherPanier();
    }

    private static Panier getOrCreatePanier(){
        Panier panier = PanierService.INSTANCE.getPanierByUUID(session.get("PanierUUID"));
        if (panier == null){
            panier = PanierService.INSTANCE.newPanier();
        }
        return panier;
    }
}