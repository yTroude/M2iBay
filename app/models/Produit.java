package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.validation.constraints.NotNull;

public class Produit {
    public String uuid;
    public String nom;
    public String description;
    public double prix;
}
