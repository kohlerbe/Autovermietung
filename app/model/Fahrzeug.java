package model;

public class Fahrzeug {

	private String fahrzeugID;
	private String beschreibung;
	private String typ;
	private String hersteller;
	private String modell;
	private String preisProTag;
	
	public Fahrzeug(String fahrzeugID, String beschreibung, String typ,
			String hersteller, String modell, String preisProTag) {
		super();
		this.fahrzeugID = fahrzeugID;
		this.beschreibung = beschreibung;
		this.typ = typ;
		this.hersteller = hersteller;
		this.modell = modell;
		this.preisProTag = preisProTag;
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
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
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

	
	
	
	
}
