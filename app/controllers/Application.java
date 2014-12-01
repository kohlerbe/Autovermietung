package controllers;

import model.*;
import play.*;
import play.mvc.*;
import views.html.*;
import java.util.*;

public class Application extends Controller {

    public static Result index() {

            return ok(index.render());
        }
        
    }
	    public static Result fahrzeuguebersicht() {
	        ArrayList<Fahrzeug> f = Model.sharedInstance.getFahrzeuge();
            String beschreibung = f.get(1).getBeschreibung();     
	    	return ok(fahrzeuguebersicht.render(beschreibung));
    }
    public static Result ueberUns() {
        return ok(ueberUns.render());
    }
    public static Result buchungsuebersicht() {
        return ok(buchungsuebersicht.render());
    }
    public static Result registrieren() {
        return ok(registrieren.render());
    }
    public static Result agb() {
        return ok(agb.render());
    }
    public static Result impressum() {
        return ok(impressum.render());
    }
    public static Result kontakt() {
        return ok(kontakt.render());
    }
	public static Result login() {
        return ok(login.render());
    }
}
