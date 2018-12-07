package models;

import play.data.validation.Required;
import play.db.jpa.Model;
import util.UUIDModel;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Produit extends UUIDModel {
    public String nom;
    public String description;
    public double prix;
}
