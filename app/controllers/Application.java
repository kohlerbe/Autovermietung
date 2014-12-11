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

	public static Result fahrzeuguebersicht() {
		// ArrayList<Fahrzeug> f = Model.sharedInstance.getFahrzeuge();
		// String a = "@routes.Assets.at('/images/";
		return ok(fahrzeuguebersicht
				.render(Model.sharedInstance.getFahrzeuge()));
	}

	public static Result ueberUns() {
		return ok(ueberUns.render());
	}

	public static Result buchungsuebersicht() {
		ArrayList<Fahrzeug> f = Model.sharedInstance.getFahrzeuge();
		String beschreibung = f.get(0).getBeschreibung();
		String hersteller = f.get(0).getHersteller();
		String modell = f.get(0).getModell();
		String preisProTag = f.get(0).getPreisProTag();
		String bild = f.get(0).getBild();
		return ok(buchungsuebersicht.render(beschreibung, hersteller, modell,
				preisProTag, bild));
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

	public static Result fahrzeugwahl() {
		ArrayList<Fahrzeug> f = Model.sharedInstance.getFahrzeuge();
		String beschreibung = f.get(0).getBeschreibung();
		String hersteller = f.get(0).getHersteller();
		String modell = f.get(0).getModell();
		String preisProTag = f.get(0).getPreisProTag();
		String bild = f.get(0).getBild();

		return ok(fahrzeugwahl.render(beschreibung, hersteller, modell,
				preisProTag, bild));
	}

	public static Result checkLogin(String email, String password) {
		ArrayList<Kunde> registrierterKunde = Model.sharedInstance.getKunden();
		String checkEmail = email;
		String checkPassword = password;
		for (Kunde kunde : registrierterKunde) {
			if (kunde.getEmail().equals(checkEmail)) {
				if (kunde.getPsw().equals(checkPassword)) {
					session("connected", "" + kunde.getEmail());
					return redirect("/user/buchungsuebersicht/");
				}
				return redirect("/user/login/");
			}
		}
		return badRequest("Fehler");
	}

}
