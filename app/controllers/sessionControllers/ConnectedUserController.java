package controllers.sessionControllers;

import controllers.Secure;
import models.Panier;
import play.mvc.Controller;
import play.mvc.With;
import services.PanierService;

@With(Secure.class)
public class ConnectedUserController extends Controller {

    public static void afficherCommandes(){
        render();
    }

    public static void finaliserCommande(){
        Panier panier = PanierService.INSTANCE.getPanierByUUID(session.get("PanierUUID"));
    }

}
