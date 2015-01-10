package model;

public class Station {

	private String stationsID;
	private String stationsname;
	private String stationsadresse;
	
	public Station(String stationsID, String stationsadresse, String stationsname) {
		this.stationsID = stationsID;
		this.stationsadresse = stationsadresse;
		this.stationsname = stationsname;
	}

	//Kein Set da Primaerattribut
	public String getStationsID() {
		return stationsID;
	}
	
	public String getStationsadresse() {
		return stationsadresse;
	}
	
	public String getStationsname() {
		return stationsname;
	}

	public void setStationsname(String stationsname) {
		this.stationsname = stationsname;
	}
}
