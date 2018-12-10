package controllers.admin;

import controllers.Check;
import controllers.Secure;
import controllers.util.TrackerController;
import models.Commande;
import play.mvc.With;

import java.util.List;

@With(Secure.class)
@Check("administrator")
public class AdminCommande extends TrackerController {

    public static void commandes(){
        List<Commande> commandes = Commande.findAll();
        render(commandes);
    }

    public static void detailCommande(String uuid){
        Commande commande = Commande.findById(uuid);

        render(commande);
    }
}
