package controllers;

import model.*;
import play.*;
import play.mvc.*;
import util.IObserver;
import views.html.*;

import java.util.*;

public class Application extends Controller implements IObserver {

	public static String s;
	public static int a;
	public static int eingeloggt;
	public static HashMap<String, HashMap<String, String>> outerMap = new HashMap<String, HashMap<String,String>>();
    public static HashMap<String, String> innerMap = new HashMap<String, String>();
    

	

	
	/*  @Override
    public final void update() {
	}
*/
	public static Result index() {
		if (session("connected") == null) {
			eingeloggt = 0;
			a = -1;
		} else {
			a = 0;
			eingeloggt = 1;
		}
		return ok(index.render(a, eingeloggt));
	}

	public static Result fahrzeuguebersicht() {
		if (session("connected") == null) {
			eingeloggt = 0;
			a = -1;
		} else {
			a = 0;
			eingeloggt = 1;
		}		
		return ok(fahrzeuguebersicht
				.render(Model.sharedInstance.getFahrzeuge(), eingeloggt));
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
					.getBuchungen(session("connected")))); 
		//Übergabe der session mit email
	}

	public static Result registrieren() {
		if(session("connected") == null){
			return ok(registrieren.render());
		}else{
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
			int b=0;
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
			//hier alle verfügbaren Fahrzeuge zurückliefern 
			
			//Map auslesen
			String email = session("connected").toString();
			   String value = ((HashMap<String, String>)outerMap.get(email)).get("abholstation").toString();
			    String value2 = ((HashMap<String, String>)outerMap.get(email)).get("abholdatum").toString();
			    String value3 = ((HashMap<String, String>)outerMap.get(email)).get("abholzeit").toString();
			String value4 = ((HashMap<String, String>)outerMap.get(email)).get("rueckgabedatum").toString();
			System.out.println("Abholstation : " + value);
		    System.out.println("Abholdatum : " + value2);
		    System.out.println("Abholzeit : " + value3);
			System.out.println("Rueckgabedatum: " +value4);
			
			return ok(fahrzeugwahl.render(Model.sharedInstance.getFahrzeuge()));
		}
	}

	public static Result buchen() {
		
		if (session("connected") == null) {
			eingeloggt = 0;
			return redirect("/login");
		} 
		else {
			final Map<String, String[]> values = request().body()
					.asFormUrlEncoded();
			
			boolean z = false;
			int i = 1;
			
			while(z == false || i <= Model.sharedInstance.getFahrzeuge().size()){
				if (values.get(Integer.toString(i)) != null) {
					System.out.println("Fahrzeug"+ i +" gewählt");
					z=true;
					// Hier in Datenbank Daten ablegen von Kunde & Fahrzeug
					return ok(buchungsuebersicht.render(Model.sharedInstance
							.getBuchungen(session("connected"))));
				} else{
					System.out.println("nicht Fahrzeug "+ i +" gewählt");
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
				if (registrierterKunde.getPsw().equals(Integer.toString(checkPassword.hashCode()))) {
					session("connected", "" + registrierterKunde.getEmail());
					return redirect("/buchungsuebersicht");
				} else {
					//Passwort falsch
					int b = -1;
					return ok(login.render(b));
				}
			} else {
				//Benutzername falsch
				int b = -1;
				return ok(login.render(b));
			}
		} else {
			//Email nicht angelegt
			int b = -1;
			return ok(login.render(b));

		}
		// return
		// redirect(controllers.routes.Application.login("Falsche Email o. pwd"));

	}
	public static Result checkRegistrieren() {
		final Map<String, String[]> values = request().body()
				.asFormUrlEncoded();
		if(Model.sharedInstance.getKunde(values.get("email")[0]) == null){
			//Hier Kunde anlegen in datenbank
			String email = values.get("email")[0];
			String password = values.get("password")[0];
			String vorname = values.get("vorname")[0];
			String nachname = values.get("nachname")[0];
			String strasse = values.get("strasse")[0];
			String hausnummer = values.get("hausnummer")[0];
			String ort = values.get("ort")[0];
			String plz = values.get("plz")[0];
			int hash = password.hashCode();
			
			System.out.println(email + password + vorname + nachname + strasse + hausnummer + ort + plz + hash);
			return redirect("/login");
			
		}else{
			//Kunde existiert bereits
			return redirect("/login");	
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}}


