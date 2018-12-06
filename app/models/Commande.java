package models;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Commande {
    public String uuid;
    public Utilisateur utilisateur;
    public Map<Produit, Integer> produits;
    public Date date;

    public void addProduit(Produit produit, Integer quantite){
        if (produits==null){
            produits=new HashMap<>();
        }
        if (produits.containsKey(produit)){
            produits.replace(produit, produits.get(produit)+quantite);
        }
        else {
            produits.put(produit,quantite);
        }
    }
}
