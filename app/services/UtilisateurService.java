package services;


import models.Utilisateur;

import java.util.ArrayList;
import java.util.List;

public enum UtilisateurService {
    INSTANCE;
    private List<Utilisateur> utilisateurs;

    public void addUtilisateur(Utilisateur utilisateur){
        if (utilisateurs==null) {
            utilisateurs=new ArrayList<>();
        }
        utilisateurs.add(utilisateur);
    }

    public List<Utilisateur> findAllUtilisateurs(){
        return utilisateurs;
    }
}
