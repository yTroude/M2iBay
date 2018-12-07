package jobs;

import models.Commande;
import models.Produit;
import models.Utilisateur;
import play.Play;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

import java.time.Instant;
import java.util.Date;

@OnApplicationStart
public class BootstrapJob extends Job {
    public void doJob(){

        if(Play.mode.isDev()){
            if(Utilisateur.findAll().size()==0) {
                //Cree un utilisateur initial
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.password = "hunter2";
                utilisateur.email = "jean-bon@mail.com";
                utilisateur.nom = "Bon";
                utilisateur.prenom = "Jean";
                utilisateur.save();
            }
            if(Produit.findAll().size()==0) {
                //Cree un produit initial
                Produit produit = new Produit();
                produit.nom = "Tartiflette";
                produit.description = "C'est bon.";
                produit.prix = 12.34;
                produit.save();
            }
            if(Commande.findAll().size()==0) {
                //Cree une commande initiale
                Commande commande = new Commande();
                commande.utilisateur = Utilisateur.find("byNom","Bon").first();
                commande.date = Date.from(Instant.now());
                commande.addProduit(Produit.find("byNom","Tartiflette").first(), 42);
                commande.save();
            }
        }
    }
}
