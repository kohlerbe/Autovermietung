package model;

public class Adresse {
	
	private String adressID;
	private String strasse;
	private String hausNr;
	private String plz;
	private String ortID;
	
	public Adresse(String adressID, String strasse, String hausNr, String plz, String ortID) {
		this.adressID = adressID;
		this.strasse = strasse;
		this.hausNr = hausNr;
		this.plz = plz;
		this.ortID = ortID;
	}
	//Kein Set da Primaerattribut
	public String getAdressID() {
		return adressID;
	}
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public String getHausNr() {
		return hausNr;
	}
	public void setHausNr(String hausNr) {
		this.hausNr = hausNr;
	}
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	public String getOrtID() {
		return ortID;
	}
	
}
