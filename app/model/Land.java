package model;

public class Land {

	private String iso;
	private String landname;
	
	public Land(String iso, String landname) {
		this.iso = iso;
		this.landname = landname;
	}
	
	//Kein Set da Primärattribut
	public String getIso() {
		return iso;
	}
	public String getLandname() {
		return landname;
	}
	public void setLandname(String landname) {
		this.landname = landname;
	}
	
	
	
	
}
