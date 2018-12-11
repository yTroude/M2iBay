package controllers.pub;

import controllers.util.TrackerController;

import java.util.*;

import models.*;
import services.ProduitService;

public class Public extends TrackerController {

    public static void index() {
        List<Produit> produits = ProduitService.findAll();
        render(produits);
    }
}