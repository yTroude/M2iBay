package services;

import models.Produit;

import java.util.ArrayList;
import java.util.List;

public enum ProduitService {
    INSTANCE;
    private List<Produit> produits;

    public void addProduit(Produit produit){
        if(produits==null){
            produits= new ArrayList<>();
        }
        produits.add(produit);
    }

    public List<Produit> findAllProduits(){
        return produits;
    }
}
