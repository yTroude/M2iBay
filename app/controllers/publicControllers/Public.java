package controllers.publicControllers;

import controllers.util.TrackerController;
import javassist.NotFoundException;
import play.Logger;
import play.libs.Codec;
import play.mvc.*;

import java.util.*;

import models.*;
import services.PanierService;

public class Public extends TrackerController {

    public static void index() {
        List<Produit> produits = Produit.findAll();
        render(produits);
    }
}