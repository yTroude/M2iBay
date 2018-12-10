package controllers.admin;

import controllers.Check;
import controllers.Secure;
import controllers.util.TrackerController;
import models.Commande;
import models.Produit;
import models.Utilisateur;
import play.mvc.With;

import java.util.List;
import java.util.stream.Collectors;

@With(Secure.class)
@Check("administrator")
public class Admin extends TrackerController {
    public static void index(){
        render();
    }
}
