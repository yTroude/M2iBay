package jobs;

import models.Commande;
import models.Panier;
import models.Produit;
import models.Utilisateur;
import play.Play;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;
import services.PanierService;

import java.time.Instant;
import java.util.Date;

@OnApplicationStart
public class BootstrapJob extends Job {
    public void doJob(){

        if(Play.mode.isDev()){
            Fixtures.deleteAllModels();
            Fixtures.loadModels("initial-data.yml");
            /*
            //Cree l'utilisateur admin
            Utilisateur admin = new Utilisateur();
            admin.email = "admin";
            admin.password = "admin";
            admin.nom = "admin";
            admin.prenom = "admin";
            admin.profile = "administrator";
            admin.save();
            //Cree un utilisateur initial
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.email = "jean-bon@mail.com";
            utilisateur.password = "hunter2";
            utilisateur.nom = "Bon";
            utilisateur.prenom = "Jean";
            utilisateur.profile="user";
            utilisateur.save();
            //Cree un produit initial
            Produit produit = new Produit();
            produit.nom = "Tartiflette";
            produit.description = "C'est bon.";
            produit.prix = 12.34;
            produit.save();
            //Cree une commande initiale
            Commande commande = new Commande();
            commande.utilisateur = Utilisateur.find("byNom","Bon").first();
            commande.date = Date.from(Instant.now());
            commande.addProduit(Produit.find("byNom","Tartiflette").first(), 42);
            commande.save();*/
        }

        PanierService.INSTANCE.initialize();
    }
}
