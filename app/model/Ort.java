package model;

public class Ort {
	
	private String ortsID;
	private String ortsname;
	
	public Ort(String ortsID, String ortsname) {
		this.ortsID = ortsID;
		this.ortsname = ortsname;
	}

	//Kein Set da Primärattribut
	public String getOrtsID() {
		return ortsID;
	}
	
	public String getOrtsname() {
		return ortsname;
	}
	public void setOrtsname(String ortsname) {
		this.ortsname = ortsname;
	}
	
	
}
