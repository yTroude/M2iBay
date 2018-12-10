package controllers;

import controllers.publicControllers.Public;
import models.Utilisateur;

public class Security extends Secure.Security {

    static boolean authenticate(String username, String password){
        Utilisateur utilisateur = Utilisateur.find("byEmail",username).first();
        if(utilisateur!=null && utilisateur.password.equals(password)){
            return true;
        }
        return false;
    }
    static void onDisconnected(){
        Public.index();
    }
    static boolean check(String profile){
        Utilisateur utilisateur = Utilisateur.find("byEmail", connected()).first();
        return utilisateur.profile.equals(profile);
    }

}