BEGIN TRANSACTION;

CREATE TABLE Ort (
	OrtsID	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	Ortsname	TEXT NOT NULL UNIQUE
);
CREATE TABLE Adresse (
	AdressID	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	Ort	INTEGER NOT NULL,
	Strasse	TEXT NOT NULL,
	HausNr	TEXT NOT NULL,
	PLZ	TEXT NOT NULL,
	FOREIGN KEY(Ort) REFERENCES Ort(OrtsID)
);
CREATE TABLE Kunde (
	KundenNr	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	Adresse	INTEGER NOT NULL,
	EMail	TEXT NOT NULL UNIQUE,
	Nachname	TEXT NOT NULL,
	Vorname	TEXT NOT NULL,
	PSW	TEXT NOT NULL,
	FOREIGN KEY(Adresse) REFERENCES Adresse(AdressID)
);
CREATE TABLE Station (
	StationsID	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	Adresse	INTEGER NOT NULL,
	Stationsname	TEXT NOT NULL,
	FOREIGN KEY(Adresse) REFERENCES Adresse(AdressID)
);
CREATE TABLE Fahrzeug (
	FahrzeugID	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	Station	INTEGER NOT NULL,
	Beschreibung	TEXT NOT NULL,
	Hersteller	TEXT NOT NULL,
	Modell	TEXT NOT NULL,
	PreisProTag	INTEGER NOT NULL,
	Bild	TEXT NOT NULL,
	FOREIGN KEY(Station) REFERENCES Station(StationsID)
);
CREATE TABLE Buchung (
	BuchungsID	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	Kunde	INTEGER NOT NULL,
	Fahrzeug	INTEGER NOT NULL,
	AbholStation	INTEGER NOT NULL,
	RueckgabeStation	INTEGER NOT NULL,
	Abholdatum	TEXT NOT NULL,
	Abholzeit	TEXT NOT NULL,
	Rueckgabedatum	TEXT NOT NULL,
	Rueckgabezeit	TEXT NOT NULL,
	FOREIGN KEY(Fahrzeug) REFERENCES Fahrzeug(FahrzeugID),
	FOREIGN KEY(Kunde) REFERENCES Kunde(KundenNr),
	FOREIGN KEY(AbholStation) REFERENCES Station(StationsID),
	FOREIGN KEY(Rueckgabestation) REFERENCES Station(StationsID)
);

COMMIT;
