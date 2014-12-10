insert into Ort (OrtsID,Ortsname) values(1,"Konstanz");
insert into Ort (OrtsID,Ortsname) values(2,"Singen");
insert into Ort (OrtsID,Ortsname) values(3,"Radolfzell");

insert into Adresse (AdressID,Ort,Strasse,HausNr,PLZ) values(11,1,"Konstanzerstrasse","10","78462");
insert into Adresse (AdressID,Ort,Strasse,HausNr,PLZ) values(22,2,"Singenerstrasse","20","78224");
insert into Adresse (AdressID,Ort,Strasse,HausNr,PLZ) values(33,3,"Radolfzellerstrasse","30","78315");

insert into Station (StationsID,Adresse,Stationsname) values(111,11,"SK");
insert into Station (StationsID,Adresse,Stationsname) values(222,22,"SS");
insert into Station (StationsID,Adresse,Stationsname) values(333,33,"SR");

insert into Fahrzeug (FahrzeugID,Station,Beschreibung,Hersteller,Modell,PreisProTag,Bild) values(1,111,"Karosserieform: Limousine / Getriebe: Automatik / Antriebsart: Allrad / Hubraum: 2993cm3 / Kraftstoff: Diesel / Türen: 4 / Farbe: Schwarz","BMW","X6","30","bmwx6.jpg");

insert into Fahrzeug (FahrzeugID,Station,Beschreibung,Hersteller,Modell,PreisProTag,Bild) values(2,111,"Karosserieform: Coupe / Getriebe: Automatik / Gänge: 7 / Türen: 3 / PS: 170 / Farbe: Weiss","Audi","A3","20","audia3.jpg");

insert into Fahrzeug (FahrzeugID,Station,Beschreibung,Hersteller,Modell,PreisProTag,Bild) values(3,222,"Karosserieform: Coupe / Getriebe: Schaltgetriebe / Gänge: 6 / Türen: 3 / PS: 260 / Farbe: Weiss / Kraftstoff: Benzin","Volkswagen","Golf GTI","40","golfgti.jpg");

insert into Fahrzeug (FahrzeugID,Station,Beschreibung,Hersteller,Modell,PreisProTag,Bild) values(4,222,"Karosserieform: Coupe / Getriebe: Automatik / Gänge: 7 / Türen: 2 / PS: 210 / Farbe: Rot / Kraftstoff: Diesel","Honda","CR-Z","35","honda.jpg");

insert into Fahrzeug (FahrzeugID,Station,Beschreibung,Hersteller,Modell,PreisProTag,Bild) values(5,333,"Karosserieform: Limousine / Getriebe: Schaltgetriebe / Gänge: 6 / Türen: 4 / PS: 150 / Farbe: Weiss / Kraftstoff: Benzin","Suzuki","Swift","18","suzuki.jpg");

COMMIT;