package controllers;

import controllers.pub.Public;
import models.Utilisateur;
import services.ProduitService;

public class Security extends Secure.Security {

    static boolean authenticate(String username, String password){
        Utilisateur utilisateur = ProduitService.getByEmailAndPassword(username,password);
        if(utilisateur!=null){
            return true;
        }
        return false;
    }
    static void onDisconnected(){
        Public.index();
    }
    static boolean check(String profile){
        Utilisateur utilisateur = connectedUser();
        return utilisateur.profile.equals(profile);
    }

    public static Utilisateur connectedUser(){
        return Utilisateur.find("byEmail",connected()).first();
    }

}