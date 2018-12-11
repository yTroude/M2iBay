package controllers.pub;

import controllers.util.TrackerController;
import models.Produit;
import services.ProduitService;

public class PublicProduit extends TrackerController {
    public static void detailProduit(String uuid){
        Produit produit = ProduitService.getByUUID(uuid);
        render(produit);
    }
}
