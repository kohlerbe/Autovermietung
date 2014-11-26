package model;

public class Station {

	private String stationsID;
	private String stationsname;
	
	public Station(String stationsID, String stationsname) {
		this.stationsID = stationsID;
		this.stationsname = stationsname;
	}

	//Kein Set da Primärattribut
	public String getStationsID() {
		return stationsID;
	}
	public String getStationsname() {
		return stationsname;
	}

	public void setStationsname(String stationsname) {
		this.stationsname = stationsname;
	}
}
