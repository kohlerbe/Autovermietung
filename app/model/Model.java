package model;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import play.db.DB;
import util.IObservable;

public class Model implements IObservable {
	/*
	 * @Override public void register(final String gameName, final String
	 * userName) { observers.add(new RoundPointsDTO(userName, gameName));
	 * System.out.println("Anzahl Observers: " + observers.size()); }
	 * 
	 * @Override public void notifyController() { update(); }
	 * 
	 * @Override public void unregister(final String gameName, final String
	 * userName) { for (RoundPointsDTO obs : observers) { if
	 * (obs.getGame().equals(gameName) && obs.getUsername().equals(userName)) {
	 * observers.remove(obs); } } } public HashSet<RoundPointsDTO>
	 * getUpdate(final String gameName) { System.out.println("Updates von: " +
	 * gameName + " holen"); HashSet<RoundPointsDTO> returns = new HashSet<>();
	 * 
	 * for (RoundPointsDTO obs : observers) { if
	 * (obs.getGame().equals(gameName)) { returns.add(obs); } }
	 * 
	 * return returns; }
	 */

	private Model() {
	}

	private static Connection connection = DB.getConnection();

	public static Model sharedInstance = new Model();

	@SuppressWarnings("unused")
	private static ArrayList<Kunde> kunden = new ArrayList<Kunde>();
	@SuppressWarnings("unused")
	private static ArrayList<Adresse> adressen = new ArrayList<Adresse>();
	// private static ArrayList<Ausstattung> ausstattungen = new
	// ArrayList<Ausstattung>();
	// private static ArrayList<Bild> bilder= new ArrayList<Bild>();
	private static ArrayList<Fahrzeug> fahrzeuge = new ArrayList<Fahrzeug>();
	@SuppressWarnings("unused")
	private static ArrayList<Ort> orte = new ArrayList<Ort>();
	private static ArrayList<Station> stationen = new ArrayList<Station>();
	private static ArrayList<Buchung> buchungen = new ArrayList<Buchung>();

	public ArrayList<Buchung> getBuchungen(String kundenmail) {
		buchungen.clear();
		String kundenbuchungenSQL = "SELECT * FROM Buchung, Kunde WHERE Kunde.KundenNr = Buchung.Kunde AND Kunde.email = '"
				+ kundenmail + "'";
		try {
			PreparedStatement pstmt = connection
					.prepareStatement(kundenbuchungenSQL);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Buchung buchung = new Buchung(rs.getString("BuchungsID"),
						rs.getString("Kunde"), rs.getString("Fahrzeug"),
						rs.getString("AbholStation"),
						rs.getString("RueckgabeStation"),
						rs.getString("Abholdatum"), rs.getString("Abholzeit"),
						rs.getString("Rueckgabedatum"),
						rs.getString("Rueckgabezeit"));
				buchungen.add(buchung);
			}

		} catch (SQLException e) {
			System.out.println("Fehler beim Abruf der Buchungen für KundenID: "
					+ kundenmail);
			e.printStackTrace();
		}
		return buchungen;
	}

	public void setBuchung(String email, int Fahrzeug, String abholstation,
			String abholdatum, String abholzeit, String rueckgabestation,
			String rueckgabedatum, String rueckgabezeit) {

		String insertBuchung = "INSERT INTO Buchung(Kunde, Fahrzeug, Abholstation, RueckgabeStation, Abholdatum, Abholzeit, Rueckgabedatum, Rueckgabezeit) "
				+ "VALUES ("
				+ getKunde(email).getKundenNr()
				+ ","
				+ Fahrzeug
				+ ","
				+ getStation(abholstation).getStationsID()
				+ ","
				+ getStation(rueckgabestation).getStationsID()
				+ ",'"
				+ abholdatum
				+ "','"
				+ abholzeit
				+ "','"
				+ rueckgabedatum
				+ "','"
				+ rueckgabezeit + "'); commit;";
		System.out.println("insertBuchungSQL: " + insertBuchung);
		try {
			PreparedStatement pstmt = connection
					.prepareStatement(insertBuchung);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Fehler beim Einfügen der Buchung in die DB");
			e.printStackTrace();
		}

		System.out.println("Fahrzeug " + Fahrzeug + " abholstation "
				+ abholstation + " abholdatum " + abholdatum + " abholzeit "
				+ abholzeit + " rueckgabestation " + rueckgabestation
				+ " rueckgabedatum " + rueckgabedatum + " rueckgabezeit "
				+ rueckgabezeit);
	}

	/*
	 * public ArrayList<Kunde> getKunden() { Kunde kunde1 = new Kunde("k1",
	 * "hans@peter.de", "Peter", "Hans", "0123142", "psw1"); Kunde kunde2 = new
	 * Kunde("k2", "hans@Gruetz.de", "Vogel", "Jörg", "0123143", "psw2"); Kunde
	 * kunde3 = new Kunde("k3", "hans@depp.de", "Götz", "Tom", "0123144",
	 * "psw3"); kunden.add(kunde1); kunden.add(kunde2); kunden.add(kunde3);
	 * return kunden; }
	 */
	public Kunde getKunde(String email) {
		String getKundeSQL = "SELECT * FROM Kunde WHERE Kunde.EMail = '"
				+ email + "'";
		try {
			PreparedStatement pstmt = connection.prepareStatement(getKundeSQL);
			ResultSet rs = pstmt.executeQuery();
			Kunde kunde = new Kunde(rs.getString("KundenNr"),
					rs.getString("EMail"), rs.getString("Nachname"),
					rs.getString("Vorname"), rs.getString("TelNr"),
					rs.getString("PSW"));
			return kunde;
		} catch (SQLException e) {
			System.out.println("Kunde mit EMail " + email + " nicht gefunden!");
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * public ArrayList<Adresse> getAdressen() { Adresse adresse1 = new
	 * Adresse("a1", "straße", "1", "13423"); Adresse adresse2 = new
	 * Adresse("a2", "straße", "2", "13423"); Adresse adresse3 = new
	 * Adresse("a3", "straße", "3", "13423"); adressen.add(adresse1);
	 * adressen.add(adresse2); adressen.add(adresse3); return adressen; }
	 */
	// public ArrayList<Ausstattung> getAusstattungen() {
	// Ausstattung ausstattung1 = new Ausstattung("as1", "Klima", "Super Kalt");
	// ausstattungen.add(ausstattung1);
	// return ausstattungen;
	// }

	public ArrayList<Fahrzeug> getFahrzeuge() {
		fahrzeuge.clear();
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("SELECT * FROM Fahrzeug");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Fahrzeug fahrzeug = new Fahrzeug(rs.getString("FahrzeugId"),
						rs.getString("Beschreibung"),
						rs.getString("Hersteller"), rs.getString("Modell"),
						rs.getString("PreisProTag"), "/assets/images/"
								+ rs.getString("Bild"));
				fahrzeuge.add(fahrzeug);
			}
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Fehler beim laden der Fahrzeuge");
			e.printStackTrace();
		}

		return fahrzeuge;
	}

	public ArrayList<Fahrzeug> getFahrzeuge(String abholstation,
			String abholdatum, String abholzeit, String rueckgabestation,
			String rueckgabedatum, String rueckgabezeit) {
		fahrzeuge.clear();
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("SELECT * FROM Fahrzeug WHERE Fahrzeug.FahrzeugID not in (select Fahrzeug FROM Buchung)"); // SQL
																	// Statement
																	// bauen!
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Fahrzeug fahrzeug = new Fahrzeug(rs.getString("FahrzeugId"),
						rs.getString("Beschreibung"),
						rs.getString("Hersteller"), rs.getString("Modell"),
						rs.getString("PreisProTag"), "/assets/images/"
								+ rs.getString("Bild"));
				fahrzeuge.add(fahrzeug);
			}
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Fehler beim laden der Fahrzeuge");
			e.printStackTrace();
		}

		return fahrzeuge;
	}

	/*
	 * public ArrayList<Ort> getOrte() { Ort ort1 = new Ort("o1", "Konstanz");
	 * orte.add(ort1); return orte; }
	 */
	public ArrayList<Station> getStationen() { // TODO Löschen o. SQL bauen wenn
												// benötigt
		Station station1 = new Station("s1", "11", "Pseudodaten!!");
		stationen.add(station1);
		return stationen;
	}

	public Station getStation(String name) {
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("SELECT * FROM Station s WHERE s.Stationsname = '"
							+ name + "'");

			ResultSet rs = pstmt.executeQuery();
			rs.next();
			Station station = new Station(rs.getString("StationsID"), rs.getString("Adresse"),
					rs.getString("Stationsname"));
			pstmt.close();
			return station;
		} catch (SQLException e) {
			System.out.println("Fehler beim laden der Station mit Name: "
					+ name);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void register(String gameName, String userName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unregister(String gameName, String userName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyController() {
		// TODO Auto-generated method stub

	}
}