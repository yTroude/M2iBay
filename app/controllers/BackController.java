package controllers;

import models.Commande;
import models.Produit;
import models.Utilisateur;
import play.libs.Codec;
import play.mvc.Controller;
import play.mvc.With;
import services.CommandeService;
import services.ProduitService;
import services.UtilisateurService;

import javax.validation.Valid;
import java.util.List;

@With(Secure.class)
public class BackController extends Controller {
    public static void index(){
        render();
    }
    public static void commandes(){
        List<Commande> commandes = CommandeService.INSTANCE.findAllCommandes();
        render(commandes);
    }
    public static void produits(){
        List<Produit> produits = ProduitService.INSTANCE.findAllProduits();
        render(produits);

    }
    public static void utilisateurs(){
        List<Utilisateur> utilisateurs = UtilisateurService.INSTANCE.findAllUtilisateurs();
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
        produit.uuid = Codec.UUID();
        ProduitService.INSTANCE.addProduit(produit);
        BackController.produits();
    }

    public static void detailCommande(String uuid){
        Commande commande = CommandeService.INSTANCE.findCommandeByUuid(uuid);
        render(commande);
    }
}
