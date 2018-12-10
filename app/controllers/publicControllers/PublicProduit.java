package controllers.publicControllers;

import controllers.util.TrackerController;
import models.Produit;

public class PublicProduit extends TrackerController {
    public static void detailProduit(String produitUuid){
        Produit produit = Produit.findById(produitUuid);
        render(produit);
    }
}
