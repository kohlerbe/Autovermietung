package model;
import java.util.*;

public class Model {
	
	private Model () {
	}

	public static Model sharedInstance = new Model();	
	
	private static ArrayList<Kunde> kunden= new ArrayList<Kunde>();
	private static ArrayList<Adresse> adressen= new ArrayList<Adresse>();
	private static ArrayList<Ausstattung> ausstattungen= new ArrayList<Ausstattung>();
	private static ArrayList<Bild> bilder= new ArrayList<Bild>();
	private static ArrayList<Fahrzeug> fahrzeuge= new ArrayList<Fahrzeug>();
	private static ArrayList<Ort> orte= new ArrayList<Ort>();
	private static ArrayList<Station> stationen= new ArrayList<Station>();
	
	public ArrayList<Kunde> getKunden(){
		Kunde kunde1 = new Kunde("k1", "hans@peter.de", "Peter", "Hans", "0123142", "psw1");
		Kunde kunde2 = new Kunde("k2", "hans@Gruetz.de", "Vogel", "J�rg", "0123143", "psw2");
		Kunde kunde3 = new Kunde("k3", "hans@depp.de", "G�tz", "Tom", "0123144", "psw3");
		kunden.add(kunde1);
		kunden.add(kunde2);
		kunden.add(kunde3);
		return kunden;
	}
	public ArrayList<Adresse> getAdressen(){
		Adresse adresse1 = new Adresse("a1", "stra�e", "1", "13423");
		Adresse adresse2 = new Adresse("a2", "stra�e", "2", "13423");
		Adresse adresse3 = new Adresse("a3", "stra�e", "3", "13423");
		adressen.add(adresse1);
		adressen.add(adresse2);
		adressen.add(adresse3);
		return adressen;
	}
	public ArrayList<Ausstattung> getAusstattungen(){
		Ausstattung ausstattung1 = new Ausstattung("as1", "Klima", "Super Kalt");
		ausstattungen.add(ausstattung1);
		return ausstattungen;
	}
	public ArrayList<Bild> getBilder(){
		Bild bild1 = new Bild("b1", "/img/bild1.jpg", "super geiles Autobild");
		bilder.add(bild1);
		return bilder;
	}
	public ArrayList<Fahrzeug> getFahrzeuge(){
		Fahrzeug fahrzeug1 = new Fahrzeug("f1", "Super Auto", "Sportwagen", "BMW", "m3", "100");
		fahrzeuge.add(fahrzeug1);
		return fahrzeuge;
	}
	public ArrayList<Ort> getOrte(){
		Ort ort1 = new Ort("o1", "Konstanz");
		orte.add(ort1);
		return orte;
	}
	public ArrayList<Station> getStationen(){
		Station station1 = new Station("s1", "Station1");
		stationen.add(station1);
		return stationen;
	}
}