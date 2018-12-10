package models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class CommandeProduit extends UUIDModel {
    @OneToOne
    public Commande commande;
    @OneToOne
    public Produit produit;
    public Integer quantite;

    public CommandeProduit(Commande commande, Produit produit, Integer quantite) {
        this.commande = commande;
        this.produit = produit;
        this.quantite=quantite;
    }
}
