package model;

public class Bild {
	
	private String BildId;
	private String Beschreibung;
	private String Pfad;

	
	public Bild(String BildId, String Beschreibung, String Pfad) {
		this.BildId = BildId;
		this.Beschreibung = Beschreibung;
		this.Pfad = Pfad;
	}
	//Kein Set da Primaerattribut
	public String getBildId() {
		return BildId;
	}
	public String getBeschreibung() {
		return Beschreibung;
	}
	public String getPfad() {
		return Pfad;
	}
	public void setBildId(String BildId) {
		this.BildId = BildId;
	}
		public void setBeschreibung(String Beschreibung) {
		this.Beschreibung = Beschreibung;
	}
		public void setPfad(String Pfad) {
		this.Pfad = Pfad;
	}
}