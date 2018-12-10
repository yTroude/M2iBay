package models;

import play.Logger;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.*;

@Entity
public class Commande extends UUIDModel {
    @OneToOne
    public Utilisateur utilisateur;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    public Set<CommandeProduit> commandeProduits;

    public Date date;

    public void addProduit(Produit produit, Integer quantite) {
        CommandeProduit cp = findCommandeProduit(produit);
        if (cp != null) {
            cp.quantite += quantite;
        } else {
            commandeProduits.add(new CommandeProduit(this, produit, quantite));

        }
    }

    public void updateProduit(Produit produit, Integer quantite) {
        CommandeProduit cp = findCommandeProduit(produit);
        if (cp != null) {
            cp.quantite = quantite;
        } else {
            commandeProduits.add(new CommandeProduit(this, produit, quantite));
        }
    }

    public double getTotal() {
        double total = 0;
        for (CommandeProduit cp : commandeProduits) {
            total += cp.quantite * cp.produit.prix;
        }

        return total;
    }

    public CommandeProduit findCommandeProduit(Produit produit) {
        if (commandeProduits == null) {
            Logger.debug("commandeProduits is null");
            commandeProduits = new HashSet<>();
        }
        for (CommandeProduit cp : commandeProduits) {
            if (cp.produit.equals(produit)) {
                return cp;
            }
        }
        Logger.debug("No commandeProduit found for " + produit.nom);
        return null;
    }

}
