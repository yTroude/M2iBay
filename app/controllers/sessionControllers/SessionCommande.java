package controllers.sessionControllers;

import controllers.Secure;
import controllers.util.TrackerController;
import play.mvc.With;

@With(Secure.class)
public class SessionCommande extends TrackerController {
    public static void finaliserCommande(){
        render();
    }

}
