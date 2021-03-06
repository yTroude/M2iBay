package models;

import javassist.NotFoundException;
import play.Logger;
import services.ProduitService;

import java.util.Date;
import java.util.Map;

public class Panier {
    public String uuid;
    public Map<Produit,Integer> produits;   
    public Date dateCreation;

    public void addProduit(Produit produit, Integer quantite)  {
        Integer newQuantite = produits.getOrDefault(produit,0)+quantite;
        updateProduit(produit, newQuantite);
    }

    public void updateProduit(Produit produit, Integer quantite) {
        if (produits.containsKey(produit)){
            if(quantite == 0){
                produits.remove(produit);
            }
            else if (quantite>0){
                produits.replace(produit, quantite);
            }
        }
        else {
            produits.put(produit,quantite);
        }
    }

    public void removeProduit(Produit produit){
        produits.remove(produit);
    }

    public Double getTotal(){
        return produits.entrySet().stream().collect(java.util.stream.Collectors.summingDouble(entry -> entry.getValue()*entry.getKey().prix));
    }
}
