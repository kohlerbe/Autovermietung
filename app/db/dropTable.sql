DROP TABLE Buchung;
DROP TABLE Fahrzeug;
DROP TABLE Station;
DROP TABLE Kunde;
DROP TABLE Adresse;
DROP TABLE Ort;

COMMIT;

--Ausgabe aller vorhandenen Tabellen.......
SELECT name FROM sqlite_master WHERE type='table' ORDER BY name;

--BEI BUCHUNG DAZU
--GesamtPreis	TEXT NOT NULL, --GesamtPreis JS-Funktion die den Gesamtpreis berechnet!