package model;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import play.db.DB;
import util.IObservable;

public class Model implements IObservable { // TODO
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

	// TODO @SuppressWarnings("unused") und nicht benötigte Zeilen entfernen
	@SuppressWarnings("unused")
	private static ArrayList<Kunde> kunden = new ArrayList<Kunde>();
	@SuppressWarnings("unused")
	private static ArrayList<Adresse> adressen = new ArrayList<Adresse>();
	private static ArrayList<Fahrzeug> fahrzeuge = new ArrayList<Fahrzeug>();
	@SuppressWarnings("unused")
	private static ArrayList<Ort> orte = new ArrayList<Ort>();
	@SuppressWarnings("unused")
	private static ArrayList<Station> stationen = new ArrayList<Station>();
	private static ArrayList<Buchung> buchungen = new ArrayList<Buchung>();

	public ArrayList<Buchung> getBuchungen(String kundenmail) {
		buchungen.clear();
		PreparedStatement pstmt = null;
		try {
			pstmt = connection
					.prepareStatement("SELECT * FROM Buchung, Kunde WHERE Kunde.KundenNr = Buchung.Kunde AND Kunde.email = ?");
			pstmt.setString(1, kundenmail);
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
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return buchungen;
	}

	public void setBuchung(String email, int Fahrzeug, String abholstation,
			String abholdatum, String abholzeit, String rueckgabestation,
			String rueckgabedatum, String rueckgabezeit) {
		PreparedStatement pstmt = null;
		try {
			pstmt = connection
					.prepareStatement("INSERT INTO Buchung(Kunde, Fahrzeug, Abholstation, RueckgabeStation, Abholdatum, Abholzeit, Rueckgabedatum, Rueckgabezeit) "
							+ "VALUES (?,?,?,?,?,?,?,?)");
			pstmt.setString(1, getKunde(email).getKundenNr());
			pstmt.setInt(2, Fahrzeug);
			pstmt.setString(3, getStation(abholstation).getStationsID());
			pstmt.setString(4, getStation(rueckgabestation).getStationsID());
			pstmt.setString(5, abholdatum);
			pstmt.setString(6, abholzeit);
			pstmt.setString(7, rueckgabedatum);
			pstmt.setString(8, rueckgabezeit);

			pstmt.executeUpdate();
			System.out.println("Buchung eingefügt: Fahrzeug " + Fahrzeug
					+ " abholstation " + abholstation + " abholdatum "
					+ abholdatum + " abholzeit " + abholzeit
					+ " rueckgabestation " + rueckgabestation
					+ " rueckgabedatum " + rueckgabedatum + " rueckgabezeit "
					+ rueckgabezeit);
		} catch (SQLException e) {
			System.out.println("Fehler beim Einfügen der Buchung in die DB");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Kunde getKunde(String email) {
		PreparedStatement pstmt = null;
		try {
			pstmt = connection
					.prepareStatement("SELECT * FROM Kunde WHERE Kunde.EMail =?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Kunde kunde = new Kunde(rs.getString("KundenNr"),
						rs.getString("EMail"), rs.getString("Nachname"),
						rs.getString("Vorname"), rs.getString("PSW"));
				return kunde;
			} else {
				System.out.println("Info: Kunde mit EMail " + email
						+ " nicht gefunden!");
			}

		} catch (SQLException e) {
			System.out.println("Fehler in Model.getKunde(String email)");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void setKunde(String email, int hash, String vorname,
			String nachname, String strasse, String hausnummer, String ort,
			String plz) {
		setAdresse(ort, strasse, hausnummer, plz);
		String adressID = getAdresse(ort, strasse, hausnummer, plz)
				.getAdressID();
		PreparedStatement pstmt = null;
		try {
			pstmt = connection
					.prepareStatement("INSERT INTO Kunde(Adresse, EMail, Nachname, Vorname, PSW) VALUES (?,?,?,?,?)");
			pstmt.setString(1, adressID);
			pstmt.setString(2, email);
			pstmt.setString(3, nachname);
			pstmt.setString(4, vorname);
			pstmt.setInt(5, hash);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Fehler in Model.setKunde");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void setAdresse(String Ort, String Strasse, String HausNr, String PLZ) {
		if (getAdresse(Ort, Strasse, HausNr, PLZ) == null) {
			setOrt(Ort);
			String ortId = getOrt(Ort).getOrtsID();
			PreparedStatement pstmt = null;
			try {
				pstmt = connection
						.prepareStatement("INSERT INTO Adresse(Ort, Strasse, HausNr, PLZ) VALUES (?,?,?,?)");
				pstmt.setString(1, ortId);
				pstmt.setString(2, Strasse);
				pstmt.setString(3, HausNr);
				pstmt.setString(4, PLZ);

				pstmt.executeUpdate();
				System.out.println("Adresse angelegt");
			} catch (SQLException e) {
				System.out.println("Fehler in Model.setAdresse");
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("Adresse gibts schon");
		}
	}

	public Adresse getAdresse(String Ort, String Strasse, String HausNr,
			String PLZ) {
		if (getOrt(Ort) != null) {
			PreparedStatement pstmt = null;
			try {
				pstmt = connection
						.prepareStatement("SELECT * FROM Adresse WHERE Ort = ? AND Strasse = ? AND HausNr = ? AND PLZ = ?");
				pstmt.setString(1, getOrt(Ort).getOrtsID());
				pstmt.setString(2, Strasse);
				pstmt.setString(3, HausNr);
				pstmt.setString(4, PLZ);

				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					Adresse adresse = new Adresse(Integer.toString(rs
							.getInt("AdressID")), rs.getString("Strasse"),
							rs.getString("HausNr"), rs.getString("PLZ"),
							rs.getString("Ort"));
					return adresse;
				} else {
					return null;
				}
			} catch (SQLException e) {
				System.out.println("Fehler in Model.getAdresse(...)");
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public void setOrt(String Ort) {
		if (getOrt(Ort) == null) {
			PreparedStatement pstmt = null;
			try {
				pstmt = connection
						.prepareStatement("INSERT INTO Ort(Ortsname) VALUES (?)");
				pstmt.setString(1, Ort);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Fehler in Model.setOrt");
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("Ort " + Ort + " existiert schon");
		}
	}

	public Ort getOrt(String Ortsname) {
		PreparedStatement pstmt = null;
		try {
			pstmt = connection
					.prepareStatement("SELECT * FROM Ort WHERE Ortsname = ?");
			pstmt.setString(1, Ortsname);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Ort ort = new Ort(rs.getString("OrtsID"),
						rs.getString("Ortsname"));
				return ort;
			} else {
				System.out.println("Ort: " + Ortsname + " nicht gefunden");
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Fehler in Model.getOrt(String Ortsname)");
			e.printStackTrace();
		} finally {
			try {
				System.out.println("getOrt finally try");
				pstmt.close();
				System.out.println("getOrt finally try2");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public ArrayList<Fahrzeug> getFahrzeuge() {
		fahrzeuge.clear();
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement("SELECT * FROM Fahrzeug");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Fahrzeug fahrzeug = new Fahrzeug(rs.getString("FahrzeugId"),
						rs.getString("Beschreibung"),
						rs.getString("Hersteller"), rs.getString("Modell"),
						rs.getString("PreisProTag"), "/assets/images/"
								+ rs.getString("Bild"));
				fahrzeuge.add(fahrzeug);
			}
		} catch (SQLException e) {
			System.out.println("Fehler beim laden der Fahrzeuge");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return fahrzeuge;
	}

	public ArrayList<Fahrzeug> getFahrzeuge(String abholstation,
			String abholdatum, String abholzeit, String rueckgabestation,
			String rueckgabedatum, String rueckgabezeit) {
		fahrzeuge.clear();
		PreparedStatement pstmt = null;
		try {
			pstmt = connection
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
		} catch (SQLException e) {
			System.out.println("Fehler beim laden der Fahrzeuge");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return fahrzeuge;
	}

	// TODO Löschen o. SQL bauen wenn benötigt -> Für Dropdownlist auf
	// indexseite
	// public ArrayList<Station> getStationen() {
	// Station station1 = new Station("s1", "11", "Pseudodaten!!");
	// stationen.add(station1);
	// return stationen;
	// }

	public Station getStation(String name) {
		PreparedStatement pstmt = null;
		try {
			pstmt = connection
					.prepareStatement("SELECT * FROM Station s WHERE s.Stationsname = ?");
			pstmt.setString(1, name);

			ResultSet rs = pstmt.executeQuery();
			// rs.next();
			Station station = new Station(rs.getString("StationsID"),
					rs.getString("Adresse"), rs.getString("Stationsname"));
			return station;
		} catch (SQLException e) {
			System.out.println("Fehler beim laden der Station mit Name: "
					+ name);
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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