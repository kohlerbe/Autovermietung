package model;

public class Kunde {
	
	private String kundenNr;
	private String email;
	private String nachname;
	private String vorname;
	private String telNr;
	private String psw;
	
	public Kunde(String kundenNr, String email, String nachname,
			String vorname, String telNr, String psw) {
		this.kundenNr = kundenNr;
		this.email = email;
		this.nachname = nachname;
		this.vorname = vorname;
		this.telNr = telNr;
		this.psw = psw;
	}
	//Kein Set da Primaerattribut
	public String getKundenNr() {
		return kundenNr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getTelNr() {
		return telNr;
	}
	public void setTelNr(String telNr) {
		this.telNr = telNr;
	}
	public String getPsw(){
	return psw;
	}
	

}
