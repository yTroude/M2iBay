package models;

import util.UUIDModel;

import javax.persistence.Entity;

@Entity
public class Utilisateur extends UUIDModel {
    public String nom;
    public String prenom;
    public String email;
    public String password;
}
