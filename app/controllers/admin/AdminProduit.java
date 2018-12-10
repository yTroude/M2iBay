package controllers.admin;

import controllers.Check;
import controllers.Secure;
import controllers.util.TrackerController;
import models.Produit;
import play.mvc.With;

import java.util.List;

@With(Secure.class)
@Check("administrator")
public class AdminProduit extends TrackerController {

    public static void produits(){
        List<Produit> produits = Produit.findAll();
        render(produits);
    }

    public static void formulaireProduit(){
        render();
    }

    public static void creerProduit(Produit produit){
        validation.required(produit.description);
        validation.required(produit.nom);
        validation.required(produit.prix);
        validation.min(produit.prix,0);
        if(validation.hasErrors()){
            params.flash();
            validation.keep();
            formulaireProduit();
        }
        produit.save();
        produits();
    }
}
