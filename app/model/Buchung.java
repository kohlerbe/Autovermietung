package model;

public class Buchung {

	private String BuchungsId;
	private String Kunde;
	private String Fahrzeug;
	private String AbholStation;
	private String RückgabeStation;
	private String Abholdatum;
	private String Abholzeit;
	private String Rückgabedatum;
	private String Rückgabezeit;
	
	public Buchung(String buchungsId, String kunde, String fahrzeug,
			String abholStation, String rückgabeStation, String abholdatum,
			String abholzeit, String rückgabedatum, String rückgabezeit) {
		super();
		BuchungsId = buchungsId;
		Kunde = kunde;
		Fahrzeug = fahrzeug;
		AbholStation = abholStation;
		RückgabeStation = rückgabeStation;
		Abholdatum = abholdatum;
		Abholzeit = abholzeit;
		Rückgabedatum = rückgabedatum;
		Rückgabezeit = rückgabezeit;
	}

	public String getBuchungsId() {
		return BuchungsId;
	}

	public void setBuchungsId(String buchungsId) {
		BuchungsId = buchungsId;
	}

	public String getKunde() {
		return Kunde;
	}

	public void setKunde(String kunde) {
		Kunde = kunde;
	}

	public String getFahrzeug() {
		return Fahrzeug;
	}

	public void setFahrzeug(String fahrzeug) {
		Fahrzeug = fahrzeug;
	}

	public String getAbholStation() {
		return AbholStation;
	}

	public void setAbholStation(String abholStation) {
		AbholStation = abholStation;
	}

	public String getRückgabeStation() {
		return RückgabeStation;
	}

	public void setRückgabeStation(String rückgabeStation) {
		RückgabeStation = rückgabeStation;
	}

	public String getAbholdatum() {
		return Abholdatum;
	}

	public void setAbholdatum(String abholdatum) {
		Abholdatum = abholdatum;
	}

	public String getAbholzeit() {
		return Abholzeit;
	}

	public void setAbholzeit(String abholzeit) {
		Abholzeit = abholzeit;
	}

	public String getRückgabedatum() {
		return Rückgabedatum;
	}

	public void setRückgabedatum(String rückgabedatum) {
		Rückgabedatum = rückgabedatum;
	}

	public String getRückgabezeit() {
		return Rückgabezeit;
	}

	public void setRückgabezeit(String rückgabezeit) {
		Rückgabezeit = rückgabezeit;
	}
	
	

	
}
