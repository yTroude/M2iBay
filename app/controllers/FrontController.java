package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import services.ProduitService;

public class FrontController extends Controller {

    public static void index() {

        List<Produit> produits = ProduitService.INSTANCE.findAllProduits();
        render(produits);
    }

}