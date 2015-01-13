package model;

public class Buchung {

	private String BuchungsId;
	private String Kunde;
	private String Fahrzeug;
	private String AbholStation;
	private String RueckgabeStation;
	private String Abholdatum;
	private String Abholzeit;
	private String Rueckgabedatum;
	private String Rueckgabezeit;
	private String Bildpfad;
	
	public Buchung(String buchungsId, String kunde, String fahrzeug,
			String abholStation, String rueckgabeStation, String abholdatum,
			String abholzeit, String rueckgabedatum, String rueckgabezeit) {
		super();
		BuchungsId = buchungsId;
		Kunde = kunde;
		Fahrzeug = fahrzeug;
		AbholStation = abholStation;
		RueckgabeStation = rueckgabeStation;
		Abholdatum = abholdatum;
		Abholzeit = abholzeit;
		Rueckgabedatum = rueckgabedatum;
		Rueckgabezeit = rueckgabezeit;
	}

	public Buchung(String buchungsId, String kunde, String fahrzeug,
			String abholStation, String rueckgabeStation, String abholdatum,
			String abholzeit, String rueckgabedatum, String rueckgabezeit, String bildpfad) {
		super();
		BuchungsId = buchungsId;
		Kunde = kunde;
		Fahrzeug = fahrzeug;
		AbholStation = abholStation;
		RueckgabeStation = rueckgabeStation;
		Abholdatum = abholdatum;
		Abholzeit = abholzeit;
		Rueckgabedatum = rueckgabedatum;
		Rueckgabezeit = rueckgabezeit;
		Bildpfad = bildpfad;
	}
	
	public String getBildpfad() {
		return Bildpfad;
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

	public String getRueckgabeStation() {
		return RueckgabeStation;
	}

	public void setRueckgabeStation(String rueckgabeStation) {
		RueckgabeStation = rueckgabeStation;
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

	public String getRueckgabedatum() {
		return Rueckgabedatum;
	}

	public void setRueckgabedatum(String rueckgabedatum) {
		Rueckgabedatum = rueckgabedatum;
	}

	public String getRueckgabezeit() {
		return Rueckgabezeit;
	}

	public void setRueckgabezeit(String rueckgabezeit) {
		Rueckgabezeit = rueckgabezeit;
	}
	
	

	
}
