BEGIN TRANSACTION;
DELETE FROM Buchung;
DELETE FROM Fahrzeug;
DELETE FROM Station;
DELETE FROM Kunde;
DELETE FROM Adresse;
DELETE FROM Ort;

COMMIT;