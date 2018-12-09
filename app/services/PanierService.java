package services;

import models.Panier;
import play.Logger;
import play.libs.Codec;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public enum PanierService {
    INSTANCE;
    private List<Panier> paniers;

    public void initialize(){
        paniers = new ArrayList<>();
    }

    public void addPanier(Panier panier){
        paniers.add(panier);
    }

    public void clean(){
        Date now = Date.from(Instant.now());
        for (Panier panier:paniers){
            if(now.getTime()-panier.dateCreation.getTime()>=60*60*1000){
                paniers.remove(panier);
            }
        }
    }

    public Panier getPanierByUUID(String uuid){
        for (Panier panier:paniers){
            if (panier.uuid.equals(uuid)){
                return panier;
            }
        }
        return null;
    }

    public Panier newPanier(){
        Panier panier = new Panier();
        panier.uuid = Codec.UUID();
        panier.dateCreation = Date.from(Instant.now());
        panier.produits = new HashMap<>();
        return panier;
    }
}
