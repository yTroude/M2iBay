package services;

import models.Produit;
import models.Utilisateur;
import play.Logger;

import java.util.List;

public class ProduitService {
    public static final String LOG_PREFIX = "ProduitService | ";

    public static Produit getByUUID(String uuid) {
        Logger.debug("%s getByUUID : [%s]", LOG_PREFIX, uuid);
        Produit produit = Produit.findById(uuid);
        Logger.debug("produit : ["+produit+"]",LOG_PREFIX,produit);
        return produit;
    }

    public static List<Produit> findAll(){
        Logger.debug("%s findAll",LOG_PREFIX);
        return Produit.findAll();
    }

    public static Utilisateur getByEmailAndPassword(String email, String password) {
        Logger.debug("%s getByEmailAndPassword : [%s,%s]",email,password);
        return Utilisateur.find("email=?1 AND password=?2",email,password).first();
    }
}
