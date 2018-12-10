package controllers.admin;

import controllers.Check;
import controllers.Secure;
import controllers.util.TrackerController;
import models.Commande;
import models.Utilisateur;
import play.mvc.With;

import java.util.List;
import java.util.stream.Collectors;

@With(Secure.class)
@Check("administrator")
public class AdminUtilisateur extends TrackerController {

    public static void utilisateurs(){
        List<Utilisateur> utilisateurs = Utilisateur.findAll();
        render(utilisateurs);
    }

    public static void detailUtilisateur(String uuid){
        Utilisateur utilisateur = Utilisateur.findById(uuid);
        List<Commande> commandes = Commande.findAll();
        commandes = commandes.stream().filter(c->c.utilisateur.equals(utilisateur)).collect(Collectors.toList());
        render(utilisateur,commandes);
    }
}
