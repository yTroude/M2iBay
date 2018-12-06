package services;

import models.Commande;

import java.util.ArrayList;
import java.util.List;

public enum CommandeService {
    INSTANCE;
    private List<Commande> commandes;

    public void addCommande(Commande commande){
        if(commandes==null){
            commandes=new ArrayList<>();
        }
        commandes.add(commande);
    }

    public List<Commande> findAllCommandes(){
        return commandes;
    }

    public Commande findCommandeByUuid(String uuid){
        for (Commande commande : commandes){
            if(commande.uuid.equals(uuid)){
                return commande;
            }
        }
        return null;
    }

}
