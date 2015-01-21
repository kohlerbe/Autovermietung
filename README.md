Web-Technologien - Autovermietung Bodensee – Team Nr.10
====================================================
<p></p>

##*Team*##
<table>
	<tr><td>Daniel Rehm</td></tr>
	<tr><td>Lukas Hansen</td></tr>
	<tr><td>Viktor Götz</td></tr>
</table>

**Unser Projekt-Link auf Heroku:**

[--WebTec Projekt Autovermietung--](http://autovermietung.herokuapp.com "WebTec : autovermietung.herokuapp.com")

###Erste Schritte###
Mit viel Elan und Motivation sahen wir die ersten Schritte vor uns sich Gedanken zu machen über das Aussehen der Seite, sowie deren Funktionen, die nachfolgend beschrieben sind.

###Inhaltsverzeichnis###

<a href="#projektbeschreibung">1. Projektbeschreibung</a>

<a href="#anforderung">2. Anforderungsanalyse</a>

<a href="#idee">3. Erste Idee</a>

<a href="#arch">4. Architektur</a>

<a href="#tech">5. Genutzte Technologien</a>

<a href="#code">6. Wichtiger "Code Snippet"</a>

<a href="#fazit">7. Fazit</a>
 
##<a name="projektbeschreibung">1. Projektbeschreibung</a>##
Dieses Projekt wurde im Rahmen der Vorlesung **Web-Technologien** angefertigt. Bei dem Projekt handelt es sich um eine Autovermietungs-Webseite, in der Kunden Autos mieten können im Stile von [*Sixt*](http://sixt.de "") und [*Europcar*](http://europcar.de "").

##<a name="anforderung">2. Anforderungsanalyse</a>##

###Funktional###
 - Anmelden / Registrieren
 - Fuhrpark anzeigen
 - Miet-Anfrage starten (Datum, Uhrzeit, Stationen)
 - Im Zeitraum verfügbare Fahrzeuge anzeigen
 - Fahrzeuge auswählen (Mieten)
 - Buchungsübersicht anzeigen
 - Kontakt zum Admin

###Nicht-Funktional###
 - Design auf allen Seiten responsive (Bootstrap)
 - Startseite Auto Karusell

###Use-Case###
<img src="/public/images/usecase.jpg">

##<a name="idee">3. First Idea</a>##

###Mockups###
Nachfolgend sind die wichtigsten Mockups mit Vergleich zur entgültigen Version aufgelistet, die wir erstellt haben, um das Design grob festzulegen. 

#####*- Registrieren*#####
<img src="/public/images/registrieren.JPG">
####*- Mieten*####
<img src="/public/images/mieten.JPG">
####*- Fahrzeugauswahl*####
<img src="/public/images/fahrzeugauswahl.JPG">
####*- Buchungsübersicht*####
<img src="/public/images/bestelluebersicht.JPG">

##<a name="arch">4. Architektur</a>##

###ERM-Datenbankentwurf###
<img src="/public/images/erm.JPG">


###UML-Diagramm###
<img src="/public/images/uml.JPG">

##<a name="tech">5. Genutzte Technologien</a>##

Neben *Java*/*Scala*:

**[HTML5]** Grundgerüst der Webseite

**[CSS3]** Cascading Style Sheets für das Design unserer Webseite

**[Bootstrap 3.3.0]** Responsive Web Design

**[JavaScript / JQuery]** Animationen, Date-/Timepicker

**[Sqlite3]** SQL-Datenbank

**[Play Framework 2.3.7]** Projekt Struktur, Backend

**[AJAX]** Dynamisches laden der Fahrzeuge beim Scrollen im Fuhrpark

**[Observer Pattern / WebSockets / JSON]** Übergabe der Fahrzeug ID im JSON-Format beim Buchen eines Fahrzeugs, um Doppelbuchungen vorzubeugen. Das gebuchte Fahrzeug verschwindet bei allen Clients.
 
##<a name="code">6. Code Snippet</a>##

Im nachfolgendem Ausschnitt wird in der Methode *checkFahrzeugwahl()* eine **doppelte Hash-Map** angelegt, um auf die Daten der zu speichernden Miet-Anfrage später zugreifen zu können:

###Code###
<img src="/public/images/wichtigercode.jpg">

##<a name="fazit">7. Fazit</a>##

###Gelerntes###

Web-Tec ist für uns das erste und nicht bei Weitem das letzte Projekt, von dem wir so profitieren konnten wie noch nie.
Da für uns Alles bis auf Datenbanken und Java neu war, konnten wir durch das Projekt viele neue Technologien rund um das "World Wide Web" kennenlernen und viele neue Erfahrung durch die Anwendung dieser sammeln.

###Probleme###

Da uns die Erfahrung in manchen Technologien fehlte, gab es hier und da längere Einarbeitungszeiten und Testphasen. Wir haben für uns die **Note 1** klar als Ziel gesetzt, deswegen haben wir die geforderten Technologien so perfekt wie möglich eingebaut.  Dies ist uns gut gelungen, jedoch hat das Projekt auf Grund mangelnder Erfahrung und viel Fehlerkorrektur, immens viel Zeit gekostet. Aber wer nicht investiert, der nicht lernt.
