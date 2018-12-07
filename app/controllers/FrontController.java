package controllers;

import play.mvc.*;

import java.util.*;

import models.*;

public class FrontController extends Controller {

    public static void index() {
        List<Produit> produits = Produit.findAll();
        render(produits);
    }

    public static void afficherPanier(){
        //TODO
    }
    public static void detailProduit(String produitUuid){
        Produit produit = Produit.findById(produitUuid);
        render(produit);
    }
}