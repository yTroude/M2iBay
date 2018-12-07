package controllers;

import models.Commande;
import models.Produit;
import models.Utilisateur;
import play.mvc.Controller;
import play.mvc.With;

import java.util.List;
import java.util.stream.Collectors;

@With(Secure.class)
public class BackController extends Controller {
    public static void index(){
        render();
    }
    public static void commandes(){
        List<Commande> commandes = Commande.findAll();
        render(commandes);
    }
    public static void produits(){
        List<Produit> produits = Produit.findAll();
        render(produits);

    }
    public static void utilisateurs(){
        List<Utilisateur> utilisateurs = Utilisateur.findAll();
        render(utilisateurs);
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

    public static void detailCommande(String uuid){
        Commande commande = Commande.findById(uuid);

        render(commande);
    }

    public static void detailUtilisateur(String uuid){
        Utilisateur utilisateur = Utilisateur.findById(uuid);
        List<Commande> commandes = Commande.findAll();
        commandes = commandes.stream().filter(c->c.utilisateur.equals(utilisateur)).collect(Collectors.toList());
        render(utilisateur,commandes);
    }
}
