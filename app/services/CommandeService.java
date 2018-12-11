package services;

import models.Commande;
import models.CommandeProduit;
import models.Panier;
import models.Utilisateur;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CommandeService {
    public static final String LOG_PREFIX = "CommandeService | ";

    public static Commande addCommande(Utilisateur utilisateur, Panier panier) {
        Commande commande = new Commande();
        commande.utilisateur=utilisateur;
        commande.date= Date.from(Instant.now());
        commande.commandeProduits = new HashSet<>();
        commande.addProduitsFromPanier(panier);
        commande.save();
        return commande;
    }
}
