package model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import play.db.DB;

public class Updates {
	public void updates() {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		DatabaseMetaData meta = null;
		try {
			connection = DB.getConnection();
			meta = connection.getMetaData();

			// Ort
			rs = meta.getTables(null, null, "Ort", null);
			if (!rs.next()) {
				stmt = connection
						.createStatement();
				stmt.executeUpdate("CREATE TABLE Ort ( "
						+ "OrtsID	INTEGER	NOT NULL PRIMARY KEY AUTOINCREMENT,	"
						+ "Ortsname	TEXT 	NOT NULL UNIQUE); "

						+ "insert into Ort (OrtsID,Ortsname) values(1,'Konstanz');"
						+ "insert into Ort (OrtsID,Ortsname) values(2,'Singen');"
						+ "insert into Ort (OrtsID,Ortsname) values(3,'Radolfzell');");
				stmt.close();
			}
			rs.close();

			// Adresse
			rs = meta.getTables(null, null, "Adresse", null);
			if (!rs.next()) {
				stmt = connection
						.createStatement();
				stmt.executeUpdate("CREATE TABLE Adresse ( "
						+ "AdressID	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
						+ "Ort INTEGER NOT NULL, "
						+ "Strasse TEXT NOT NULL, "
						+ "HausNr TEXT NOT NULL, "
						+ "PLZ TEXT NOT NULL, "
						+ "FOREIGN KEY(Ort) REFERENCES Ort(OrtsID));"

						+ "insert into Adresse (AdressID,Ort,Strasse,HausNr,PLZ) "
						+ "values(11,1,'Konstanzerstrasse','10','78462');"

						+ "insert into Adresse (AdressID,Ort,Strasse,HausNr,PLZ) "
						+ "values(22,2,'Singenerstrasse','20','78224');"

						+ "insert into Adresse (AdressID,Ort,Strasse,HausNr,PLZ) "
						+ "values(33,3,'Radolfzellerstrasse','30','78315');"

						+ "insert into Adresse (AdressID,Ort,Strasse,HausNr,PLZ) "
						+ "values(44,3,'Radolfstreet 13','13','78315');"

						+ "insert into Adresse (AdressID,Ort,Strasse,HausNr,PLZ) "
						+ "values(55,1,'Konzilstrasse','11','78462');");
				stmt.close();
			}
			rs.close();

			// Station
			rs = meta.getTables(null, null, "Station", null);
			if (!rs.next()) {
				stmt = connection
						.createStatement();
				stmt.executeUpdate("CREATE TABLE Station ( "
						+ "StationsID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
						+ "Adresse INTEGER NOT NULL, "
						+ "Stationsname	TEXT NOT NULL, "
						+ "FOREIGN KEY(Adresse) REFERENCES Adresse(AdressID));"

						+ "insert into Station (StationsID,Adresse,Stationsname) values(111,11,'Konstanz');"
						+ "insert into Station (StationsID,Adresse,Stationsname) values(222,22,'Singen');"
						+ "insert into Station (StationsID,Adresse,Stationsname) values(333,33,'Radolfzell');");
				stmt.close();
			}
			rs.close();

			// Fahrzeug
			rs = meta.getTables(null, null, "Fahrzeug", null);
			if (!rs.next()) {
				stmt = connection
						.createStatement();
				stmt.executeUpdate("CREATE TABLE Fahrzeug ( "
						+ "FahrzeugID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
						+ "Station INTEGER NOT NULL, "
						+ "Beschreibung	TEXT NOT NULL, "
						+ "Hersteller TEXT NOT NULL, Modell TEXT NOT NULL, "
						+ "PreisProTag INTEGER NOT NULL, "
						+ "Bild	TEXT NOT NULL, "
						+ "FOREIGN KEY(Station) REFERENCES Station(StationsID));"

						+ "insert into Fahrzeug (FahrzeugID,Station,Beschreibung,Hersteller,Modell,PreisProTag,Bild) "
						+ "values(1,111,'Karosserieform: Limousine / Getriebe: Automatik / Antriebsart: Allrad / Hubraum: 2993cm3 / Kraftstoff: Diesel / Türen: 4 / Farbe: Schwarz','BMW','X6','30','bmwx6.jpg');"

						+ "insert into Fahrzeug (FahrzeugID,Station,Beschreibung,Hersteller,Modell,PreisProTag,Bild) "
						+ "values(2,111,'Karosserieform: Coupe / Getriebe: Automatik / Gänge: 7 / Türen: 3 / PS: 170 / Farbe: Weiss','Audi','A3','20','audia3.jpg');"

						+ "insert into Fahrzeug (FahrzeugID,Station,Beschreibung,Hersteller,Modell,PreisProTag,Bild) "
						+ "values(3,222,'Karosserieform: Coupe / Getriebe: Schaltgetriebe / Gänge: 6 / Türen: 3 / PS: 260 / Farbe: Weiss / Kraftstoff: Benzin','Volkswagen','Golf GTI','40','golfgti.jpg');"

						+ "insert into Fahrzeug (FahrzeugID,Station,Beschreibung,Hersteller,Modell,PreisProTag,Bild) "
						+ "values(4,222,'Karosserieform: Coupe / Getriebe: Automatik / Gänge: 7 / Türen: 2 / PS: 210 / Farbe: Rot / Kraftstoff: Diesel','Honda','CR-Z','35','honda.jpg');"

						+ "insert into Fahrzeug (FahrzeugID,Station,Beschreibung,Hersteller,Modell,PreisProTag,Bild) "
						+ "values(5,333,'Karosserieform: Limousine / Getriebe: Schaltgetriebe / Gänge: 6 / Türen: 4 / PS: 150 / Farbe: Weiss / Kraftstoff: Benzin','Suzuki','Swift','18','suzuki.jpg');"

						+ "insert into Fahrzeug (FahrzeugID,Station,Beschreibung,Hersteller,Modell,PreisProTag,Bild) "
						+ "values(6,222,'Karosserieform: Limousine / Getriebe: Automatik / Antriebsart: Allrad / Hubraum: 2967cm3 / Kraftstoff: Diesel / Türen: 4 / Farbe: Schwarz','Audi','Q7','70','audiq7.jpg');"

						+ "insert into Fahrzeug (FahrzeugID,Station,Beschreibung,Hersteller,Modell,PreisProTag,Bild) "
						+ "values(7,333,'Karosserieform: Coupe / Getriebe: Automatik / Antriebsart: Allrad / Hubraum: 3953cm3 / Kraftstoff: Diesel / Türen: 3 / Farbe: Dunkelblau','Nissan','R34 GTR','30','nissangtr.jpg');"

						+ "insert into Fahrzeug (FahrzeugID,Station,Beschreibung,Hersteller,Modell,PreisProTag,Bild) "
						+ "values(8,111,'Karosserieform: Coupe / Getriebe: Automatik / Antriebsart: Allrad / Hubraum: 4961cm3 / Kraftstoff: Diesel / Türen: 2 / Farbe: Weiss','Lamborghini','Gallardo Spyder','200','lamborghini.jpg');"

						+ "insert into Fahrzeug (FahrzeugID,Station,Beschreibung,Hersteller,Modell,PreisProTag,Bild) "
						+ "values(9,222,'Karosserieform: Limousine / Getriebe: Schaltgetriebe / Antriebsart: Heck / Hubraum: 2982cm3 / Kraftstoff: Benzin / Türen: 4 / Farbe: Schwarz','Jaguar','420','120','jaguar420.jpg');"

						+ "insert into Fahrzeug (FahrzeugID,Station,Beschreibung,Hersteller,Modell,PreisProTag,Bild) "
						+ "values(10,333,'Karosserieform: Cabrio / Getriebe: Automatik / Antriebsart: Heck  / Hubraum: 4593cm3 / Kraftstoff: Benzin / Türen: 4 / Farbe: Weissach Weiss','Porsche','918 Spyder','200','porsche918spyder.jpg');");
				stmt.close();
			}
			rs.close();

			// Kunde
			rs = meta.getTables(null, null, "Kunde", null);
			if (!rs.next()) {
				stmt = connection
						.createStatement();
				stmt.executeUpdate("CREATE TABLE Kunde ( "
						+ "KundenNr	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
						+ "Adresse	INTEGER NOT NULL, "
						+ "EMail	TEXT NOT NULL UNIQUE, "
						+ "Nachname	TEXT NOT NULL, "
						+ "Vorname	TEXT NOT NULL, "
						+ "PSW	TEXT NOT NULL, "
						+ "FOREIGN KEY(Adresse) REFERENCES Adresse(AdressID));"

						+ "insert into Kunde (Adresse,EMail,Nachname,Vorname,PSW) "
						+ "values(44,'max@mustermann.de','Maxel','Max','107876');");
				stmt.close();
			}
			rs.close();

			// Buchung
			rs = meta.getTables(null, null, "Buchung", null);
			if (!rs.next()) {
				stmt = connection
						.createStatement();
				stmt.executeUpdate("CREATE TABLE Buchung ( "
						+ "BuchungsID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
						+ "Kunde INTEGER NOT NULL, "
						+ "Fahrzeug	INTEGER NOT NULL, "
						+ "AbholStation	INTEGER NOT NULL, "
						+ "RueckgabeStation	INTEGER NOT NULL, "
						+ "Abholdatum datetime  NOT NULL, "
						+ "Rueckgabedatum datetime  NOT NULL, "
						+ "Preis INTEGER NOT NULL, "
						+ "FOREIGN KEY(Fahrzeug) REFERENCES Fahrzeug(FahrzeugID), "
						+ "FOREIGN KEY(Kunde) REFERENCES Kunde(KundenNr), "
						+ "FOREIGN KEY(AbholStation) REFERENCES Station(StationsID), "
						+ "FOREIGN KEY(Rueckgabestation) REFERENCES Station(StationsID));");
				stmt.close();
			}
			rs.close();
		} catch (SQLException e) {
			System.err.println("ERROR beim füllen der Datenbank!");
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException | NullPointerException e) {
				System.out.println("Verbindung zu DB fehlgeschlagen oder konnte nicht geschlossen werden!");
				e.printStackTrace();
			}

		}

	}
}
