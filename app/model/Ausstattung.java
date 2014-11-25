package model;

public class Ausstattung {

	private String ausstattungsID;
	private String ausstattungsname;
	private String beschreibung;
	
	public Ausstattung(String ausstattungsID, String ausstattungsname,
			String beschreibung) {
		super();
		this.ausstattungsID = ausstattungsID;
		this.ausstattungsname = ausstattungsname;
		this.beschreibung = beschreibung;
	}

	//Kein Set da Prim�rattribut
	public String getAusstattungsID() {
		return ausstattungsID;
	}
	
	public String getAusstattungsname() {
		return ausstattungsname;
	}
	public void setAusstattungsname(String ausstattungsname) {
		this.ausstattungsname = ausstattungsname;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	
}
