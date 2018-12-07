package services;

import models.Panier;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public enum PanierService {
    INSTANCE;
    private List<Panier> paniers;

    public void addPanier(Panier panier){
        if(paniers==null){
            paniers= new ArrayList<>();
        }
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
}
