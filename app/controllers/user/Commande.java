package controllers.user;

import controllers.Secure;
import controllers.Security;
import controllers.util.TrackerController;
import models.Panier;
import models.Utilisateur;
import play.mvc.Controller;
import play.mvc.With;
import services.CommandeService;
import services.PanierService;

@With(Secure.class)
public class Commande extends TrackerController {
    public static void finaliserCommande() {
        Utilisateur utilisateur = Security.connectedUser();
        Panier panier = PanierService.INSTANCE.getPanierByUUID(Controller.session.get("PanierUUID"));
        render(utilisateur,panier);
    }

    public static void afficherCommandes(){
        render();
    }
    public static void submitCommande(){
        Utilisateur utilisateur = Security.connectedUser();
        Panier panier = PanierService.INSTANCE.getPanierByUUID(Controller.session.get("PanierUUID"));
        models.Commande commande = CommandeService.addCommande(utilisateur,panier);
        render(commande);
    }
}
