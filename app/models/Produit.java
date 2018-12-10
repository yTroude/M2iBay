package models;

import javax.persistence.Entity;

@Entity
public class Produit extends UUIDModel {
    public String nom;
    public String description;
    public double prix;
}
