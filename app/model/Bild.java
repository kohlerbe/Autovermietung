package model;

public class Bild {
	
	private String bildID;
	private String dateipfad;
	private String bildBeschreibung;
	
	public Bild(String bildID, String dateipfad, String bildBeschreibung) {
		super();
		this.bildID = bildID;
		this.dateipfad = dateipfad;
		this.bildBeschreibung = bildBeschreibung;
	}

	//Kein Set da Primärattribut
	public String getBildID() {
		return bildID;
	}
	
	public String getDateipfad() {
		return dateipfad;
	}
	public void setDateipfad(String dateipfad) {
		this.dateipfad = dateipfad;
	}
	public String getBildBeschreibung() {
		return bildBeschreibung;
	}
	public void setBildBeschreibung(String bildBeschreibung) {
		this.bildBeschreibung = bildBeschreibung;
	}

}
