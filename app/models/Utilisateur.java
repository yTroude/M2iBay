package models;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(indexes = {@Index(name = "email",  columnList="email", unique = true),
                  @Index(name = "emailAndPassword", columnList = "email, password", unique=false)})
public class Utilisateur extends UUIDModel {
    public String nom;
    public String prenom;
    public String email;
    public String password;
    public String profile;
}
