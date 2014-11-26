package controllers;

import model.Model;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }
	    public static Result fahrzeuguebersicht() {
	    	Collection<Fahrzeug> f= Model.sharedInstance.getFahrzeuge();
	    	return ok(fahrzeuguebersicht.render());
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
