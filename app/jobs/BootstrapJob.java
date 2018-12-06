package jobs;

import models.Commande;
import models.Produit;
import models.Utilisateur;
import org.eclipse.jdt.core.dom.PrimitiveType;
import play.Play;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.libs.Codec;
import services.CommandeService;
import services.ProduitService;
import services.UtilisateurService;

import java.time.Instant;
import java.util.Date;

@OnApplicationStart
public class BootstrapJob extends Job {
    public void doJob(){

        if(Play.mode.isDev()){
            //Cree un utilisateur initial
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.uuid= Codec.UUID();
            utilisateur.password="hunter2";
            utilisateur.email="jean-bon@mail.com";
            utilisateur.nom="Bon";
            utilisateur.prenom="Jean";
            UtilisateurService.INSTANCE.addUtilisateur(utilisateur);

            //Cree un produit initial
            Produit produit = new Produit();
            produit.nom = "Tartiflette";
            produit.description = "C'est bon.";
            produit.prix=12.34;
            produit.uuid=Codec.UUID();
            ProduitService.INSTANCE.addProduit(produit);

            //Cree une commande initiale
            Commande commande = new Commande();
            commande.uuid = Codec.UUID();
            commande.utilisateur=utilisateur;
            commande.date= Date.from(Instant.now());
            commande.addProduit(produit,42);
            CommandeService.INSTANCE.addCommande(commande);
        }
    }
}
