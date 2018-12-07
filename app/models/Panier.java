package models;

import javassist.NotFoundException;

import java.util.Date;
import java.util.Map;

public class Panier {
    public String uuid;
    public Map<Produit,Integer> produits;   
    public Date dateCreation;

    public void addProduit(Produit produit, Integer quantite) throws NotFoundException {
        Integer newQuantite = Integer.valueOf(produits.getOrDefault(produit,0)+quantite);
        updateProduit(produit, newQuantite);
    }

    public void updateProduit(Produit produit, Integer quantite) throws NotFoundException,IndexOutOfBoundsException {
        if (produits.containsKey(produit)){
            if(quantite == 0){
                produits.remove(produit);
            }
            else if (quantite>0){
                produits.replace(produit, quantite);
            }
            else throw(new IndexOutOfBoundsException());

        }
        else throw(new NotFoundException("Le produit "+produit.uuid+" n'existe pas dans le panier "+uuid+"."));
    }

    public void removeProduit(String produitUuid){
        Produit produit = Produit.findById(produitUuid);
        produits.remove(produit);
    }
    public void updateQuantite(Produit produit, Integer quantite){
    }


}
