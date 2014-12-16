package controllers;

import model.*;
import play.*;
import play.mvc.*;
import views.html.*;

import java.util.*;

public class Application extends Controller {

	public static String s;
	public static int a;

	public static Result index() {
		if (session("connected") == null) {
			a = -1;
		} else {
			a = 0;
		}

		return ok(index.render(a));
	}

	public static Result fahrzeuguebersicht() {
System.out.println(Model.sharedInstance.getFahrzeuge());
		return ok(fahrzeuguebersicht
				.render(Model.sharedInstance.getFahrzeuge()));
	}

	public static Result ueberUns() {
		return ok(ueberUns.render());
	}
// hier muss als übergabeparameter das ausgewählte auto übergeben werden
	public static Result buchungsuebersicht() {
		if (session("connected") == null) {
			// wenn nicht eingeloggt weiterleitung auf login
			return redirect("/login");
		} else
			return ok(buchungsuebersicht.render(Model.sharedInstance
					.getBuchungen(session("connected")))); 
		//Übergabe der session mit email
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
		if (session("connected") == null) {

			return ok(login.render());
		} else {
			// wenn schon eingeloggt weiterleitung auf index
			return redirect("/");
		}
	}

	public static Result fahrzeugwahl() {
		if (session("connected") == null) {
			// wenn noch nicht eingeloggt, kann kein fahrzeug gewählt werden,
			// weiterleitung startseite
			return redirect("/");
		} else {
			//hier alle verfügbaren Fahrzeuge zurückliefern 
			return ok(fahrzeugwahl.render(Model.sharedInstance.getFahrzeuge()));
		}
	}

	public static Result checkFahrzeugwahl(String abholstation,
			String abholdatum, String abholzeit, String rueckgabestation,
			String rueckgabedatum, String rueckgabezeit) {
		
		if (session("connected") == null) {
			// wenn noch nicht eingeloggt, erst einloggen
			// weiterleitung login
			return redirect("/login");
		} else {
		return redirect("/fahrzeugwahl");
		}
	}

	public static Result checkLogin() {
		final Map<String, String[]> values = request().body()
				.asFormUrlEncoded();
		Kunde registrierterKunde = Model.sharedInstance.getKunde(values
				.get("email")[0]);
		String checkEmail = values.get("email")[0];
		String checkPassword = values.get("password")[0];
		if (registrierterKunde != null) {
			if (registrierterKunde.getEmail().equals(checkEmail)) {
				if (registrierterKunde.getPsw().equals(checkPassword)) {
					session("connected", "" + registrierterKunde.getEmail());
					return redirect("/buchungsuebersicht");
				}
			}
		}
		// return
		// redirect(controllers.routes.Application.login("Falsche Email o. pwd"));
		return redirect("/login");
	}
	public static Result checkRegistrieren() {
		final Map<String, String[]> values = request().body()
				.asFormUrlEncoded();
		if(Model.sharedInstance.getKunde(values.get("email")[0]) == null){
			//Kunde anlegen in datenbank
			String email = values.get("email")[0];
			String password = values.get("password")[0];
			String vorname = values.get("vorname")[0];
			String nachname = values.get("nachname")[0];
			String strasse = values.get("strasse")[0];
			String hausnummer = values.get("hausnummer")[0];
			String ort = values.get("ort")[0];
			String plz = values.get("plz")[0];
			System.out.println(email + password + vorname + nachname + strasse + hausnummer + ort + plz);
			return redirect("/login");
			
		}else{
			//Kunde existiert bereits
			return redirect("/registrieren");	
		}
	}}


