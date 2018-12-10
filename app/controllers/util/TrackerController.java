package controllers.util;

import play.Logger;
import play.libs.Codec;
import play.mvc.After;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.Http;

import java.util.Map;

public class TrackerController extends Controller {
    @Before
    public static void before(){
        //Cookie user tracking
        Http.Cookie trackerCookie = request.cookies.get("visiteuruuid");
        String visiteuruuid = "";
        if(trackerCookie ==null){
            visiteuruuid= Codec.UUID();
            response.setCookie("visiteuruuid",visiteuruuid);
        }
        else{
            visiteuruuid=trackerCookie.value;
        }
        renderArgs.put("visiteuruuid",visiteuruuid);

        //Logs
        Logger.info("---------------------------");
        Logger.info("nav - %s", request.url);
        for (Map.Entry<String,String> entry: request.params.allSimple().entrySet()) {
            Logger.debug("params: %s = %s",entry.getKey(),entry.getValue());
        }
    }

    @After
    public static void after(){
        Logger.info("---------------------------");
    }
}
