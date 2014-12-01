package model;

public class Fahrzeug {

	private String fahrzeugID;
	private String beschreibung;
	private String hersteller;
	private String modell;
	private String preisProTag;
	private String bild;
	
	public Fahrzeug(String fahrzeugID, String beschreibung,
			String hersteller, String modell, String preisProTag, String bild) {
		this.fahrzeugID = fahrzeugID;
		this.beschreibung = beschreibung;
		this.hersteller = hersteller;
		this.modell = modell;
		this.preisProTag = preisProTag;
		this.bild = bild;
	}
	
	//Kein Set da PrimAttribut
	public String getFahrzeugID() {
		return fahrzeugID;
	}
	
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public String getHersteller() {
		return hersteller;
	}
	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}
	public String getModell() {
		return modell;
	}
	public void setModell(String modell) {
		this.modell = modell;
	}
	public String getPreisProTag() {
		return preisProTag;
	}
	public void setPreisProTag(String preisProTag) {
		this.preisProTag = preisProTag;
	}
	public String getBild() {
		return bild;
	}
	public void setBild(String bild) {
		this.bild = bild;
	}

	
	
	
	
}
