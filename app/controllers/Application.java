package controllers;

import model.*;
import play.libs.F.Callback;
import play.libs.F.Callback0;
import play.mvc.*;
import views.html.*;

import java.util.*;

import com.fasterxml.jackson.databind.JsonNode;

public class Application extends Controller {

	public static String s;
	public static int eingeloggt;
	public static HashMap<String, HashMap<String, String>> outerMap = new HashMap<String, HashMap<String, String>>();
	public static HashMap<String, String> innerMap = new HashMap<String, String>();
	
	//Ajax Variablen method(fahrzeuge)
	public static String hersteller;
	public static String modell;
	public static String bild;
	public static String beschreibung;
	public static String preisProTag;

	public static Result index() {
		if (session("connected") == null) {
			eingeloggt = 0;
			ArrayList<Fahrzeug> arrayList = Model.sharedInstance.getFahrzeuge();
			String bild1 = arrayList.get(9).getBild();
			String bild2 = arrayList.get(7).getBild();
			String bild3 = arrayList.get(6).getBild();
			return ok(index.render(eingeloggt, bild1, bild2, bild3));
		} else {
			String bild1 = "";
			String bild2 = "";
			String bild3 = "";
			eingeloggt = 1;
			return ok(index.render(eingeloggt, bild1, bild2, bild3));
		}
	}

	public static Result fahrzeuguebersicht() {
		if (session("connected") == null) {
			eingeloggt = 0;
			
		} else {
			eingeloggt = 1;
		}
		return ok(fahrzeuguebersicht.render(eingeloggt));
	}
	
	//Ajax Methode
	 public static Result fahrzeuge(int count) {
		
		ArrayList<Fahrzeug> arrayList = Model.sharedInstance.getFahrzeuge();
		
		if (count <= arrayList.size()-1){
		hersteller = arrayList.get(count).getHersteller();
		modell = arrayList.get(count).getModell();
		bild = arrayList.get(count).getBild();
		beschreibung = arrayList.get(count).getBeschreibung();
		preisProTag = arrayList.get(count).getPreisProTag();
		
		return ok(fahrzeuge.render(
			hersteller, modell, bild, beschreibung, preisProTag));
		
		}else {
		hersteller = "";
		modell = "";
		bild = "";
		beschreibung = "";
		preisProTag = "";
		
		return ok(fahrzeuge.render(
			hersteller, modell, bild, beschreibung, preisProTag));
		}
	}

	public static Result ueberUns() {
		if (session("connected") == null) {
			eingeloggt = 0;
		} else {
			eingeloggt = 1;
		}
		return ok(ueberUns.render(eingeloggt));
	}

	public static Result buchungsuebersicht() {
		if (session("connected") == null) {
			// wenn nicht eingeloggt weiterleitung auf login
			return redirect("/login");
		} else
			return ok(buchungsuebersicht.render(Model.sharedInstance
					.getBuchungen(session("connected")), session("connected")));
		// Übergabe der session mit email
	}

	public static Result registrieren() {
		if (session("connected") == null) {
			return ok(registrieren.render());
		} else {
			return redirect("/");
		}
	}

	public static Result agb() {
		if (session("connected") == null) {
			eingeloggt = 0;
		} else {
			eingeloggt = 1;
		}
		return ok(agb.render(eingeloggt));
	}

	public static Result impressum() {
		if (session("connected") == null) {
			eingeloggt = 0;
		} else {
			eingeloggt = 1;
		}
		return ok(impressum.render(eingeloggt));
	}

	public static Result kontakt() {
		if (session("connected") == null) {
			eingeloggt = 0;
		} else {
			eingeloggt = 1;
		}
		return ok(kontakt.render(eingeloggt));
	}

	public static Result login() {
		if (session("connected") == null) {
			int b = 0;
			return ok(login.render(b));
		} else {
			// wenn schon eingeloggt weiterleitung auf index
			return redirect("/");
		}
	}

	public static Result logout() {
		session().clear();
		return redirect("/");

	}

	public static Result checkFahrzeugwahl(String abholstation,
			String abholdatum, String abholzeit, String rueckgabestation,
			String rueckgabedatum, String rueckgabezeit) {

		if (session("connected") == null) {
			// wenn noch nicht eingeloggt, erst einloggen
			// weiterleitung login
			return redirect("/login");
		} else {
			String email = session("connected").toString();
			outerMap.put(email, innerMap);
			innerMap.put("abholstation", abholstation);
			innerMap.put("abholdatum", abholdatum);
			innerMap.put("abholzeit", abholzeit);
			innerMap.put("rueckgabestation", rueckgabestation);
			innerMap.put("rueckgabedatum", rueckgabedatum);
			innerMap.put("rueckgabezeit", rueckgabezeit);
			return redirect("/fahrzeugwahl");
		}

	}

	public static Result fahrzeugwahl() {
		if (session("connected") == null) {
			// wenn noch nicht eingeloggt, kann kein fahrzeug gewählt werden,
			// weiterleitung startseite
			return redirect("/");
		} else {
			// Map auslesen
			String email = session("connected").toString();
			String abholstation = ((HashMap<String, String>) outerMap
					.get(email)).get("abholstation").toString();
			String abholdatum = ((HashMap<String, String>) outerMap.get(email))
					.get("abholdatum").toString();
			String abholzeit = ((HashMap<String, String>) outerMap.get(email))
					.get("abholzeit").toString();
			String rueckgabestation = ((HashMap<String, String>) outerMap
					.get(email)).get("rueckgabestation").toString();
			String rueckgabedatum = ((HashMap<String, String>) outerMap
					.get(email)).get("rueckgabedatum").toString();
			String rueckgabezeit = ((HashMap<String, String>) outerMap
					.get(email)).get("rueckgabezeit").toString();

			System.out.println("Abholstation : " + abholstation);
			System.out.println("Abholdatum : " + abholdatum);
			System.out.println("Abholzeit : " + abholzeit);
			System.out.println("rueckgabestation : " + rueckgabestation);
			System.out.println("rueckgabedatum : " + rueckgabedatum);
			System.out.println("rueckgabezeit : " + rueckgabezeit);

			return ok(fahrzeugwahl.render(Model.sharedInstance.getFahrzeuge(
					abholstation, abholdatum, abholzeit, rueckgabestation,
					rueckgabedatum, rueckgabezeit)));
		}
	}

	public static Result buchen() {

		if (session("connected") == null) {
			eingeloggt = 0;
			return redirect("/login");
		} else {
			final Map<String, String[]> values = request().body()
					.asFormUrlEncoded();

			boolean z = false;
			int i = 1;

			while (z == false
					|| i <= Model.sharedInstance.getFahrzeuge().size()) {
				if (values.get(Integer.toString(i)) != null) {
					System.out.println("Fahrzeug" + i + " gewählt");
					z = true;
					// Hier in Datenbank Daten ablegen von Kunde & Fahrzeug
					String email = session("connected").toString();
					String abholstation = ((HashMap<String, String>) outerMap
							.get(email)).get("abholstation").toString();
					String abholdatum = ((HashMap<String, String>) outerMap.get(email))
							.get("abholdatum").toString();
					String abholzeit = ((HashMap<String, String>) outerMap.get(email))
							.get("abholzeit").toString();
					String rueckgabestation = ((HashMap<String, String>) outerMap
							.get(email)).get("rueckgabestation").toString();
					String rueckgabedatum = ((HashMap<String, String>) outerMap
							.get(email)).get("rueckgabedatum").toString();
					String rueckgabezeit = ((HashMap<String, String>) outerMap
							.get(email)).get("rueckgabezeit").toString();
					int Fahrzeug = i;
					Model.sharedInstance.setBuchung(email, Fahrzeug, abholstation, abholdatum, abholzeit, rueckgabestation, rueckgabedatum, rueckgabezeit);
//					return ok(buchungsuebersicht.render(Model.sharedInstance
//							.getBuchungen(session("connected"))));
					return redirect("/buchungsuebersicht");
				} else {
					System.out.println("nicht Fahrzeug " + i + " gewählt");
					i++;

				}
			}
		}
		return redirect("/");
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
				if (registrierterKunde.getPsw().equals(
						Integer.toString(checkPassword.hashCode()))) {
					session("connected", "" + registrierterKunde.getEmail());
					return redirect("/");
				} else {
					// Passwort falsch
					int b = -1;
					return ok(login.render(b));
				}
			} else {
				// Benutzername falsch
				int b = -1;
				return ok(login.render(b));
			}
		} else {
			// Email nicht angelegt
			int b = -1;
			return ok(login.render(b));

		}
		// return
		// redirect(controllers.routes.Application.login("Falsche Email o. pwd"));

	}

	public static Result checkRegistrieren() {
		final Map<String, String[]> values = request().body()
				.asFormUrlEncoded();
		if (Model.sharedInstance.getKunde(values.get("email")[0]) == null) {
			String email = values.get("email")[0];
			String password = values.get("password")[0];
			String vorname = values.get("vorname")[0];
			String nachname = values.get("nachname")[0];
			String strasse = values.get("strasse")[0];
			String hausnummer = values.get("hausnummer")[0];
			String ort = values.get("ort")[0];
			String plz = values.get("plz")[0];
			int hash = password.hashCode();
			
			Model.sharedInstance.setKunde(email, hash, vorname, nachname, strasse, hausnummer, ort, plz);
	
			return redirect("/login");

		} else {
			// Kunde existiert bereits
			return redirect("/login");
		}
	}
	public static WebSocket<JsonNode> autoSocket() {
		System.out.println("Application Websocket");
		return new WebSocket<JsonNode>() {
			public void onReady(WebSocket.In<JsonNode> in,
					final WebSocket.Out<JsonNode> out) {
				
				final AutoObserver	obs = new AutoObserver();
				obs.auto = out;
				
				in.onMessage(new Callback<JsonNode>() {
					public void invoke(JsonNode obj) {
					}
				});
				in.onClose(new Callback0() {
					public void invoke() {
						System.out.println("Observer gelöscht");
						Model.sharedInstance.deleteObserver(obs);
					}
				});
			}
		};

	}

}
