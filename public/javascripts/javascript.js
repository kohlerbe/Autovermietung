function pickdate() {
	$('.dateauswahl').pickadate({
		format : 'dd.mm.yyyy',
		today : 'Heute',
		clear : 'Loeschen',
		close : 'Schliessen',
		min : 'true'
	});
}
function picktime() {
	$('.timeauswahl').pickatime({
		format : 'HH:i',
	});
}

function checkKontakt(form) {

	var warnung = "";
	if (form.email.value == "") {
		warnung = "Bitte geben Sie ihre E-Mail-Adresse ein!\n";
		alert(warnung);
		document.formular.email.focus();
		return false;
	}
	if (form.name.value == "") {
		warnung = "Bitte geben Sie ihren Namen ein!\n";
		alert(warnung);
		document.formular.name.focus();
		return false;
	}
	if (form.nachricht.value == "") {
		warnung = "Sie haben Ihr Anliegen noch nicht beschrieben!\n";
		alert(warnung);
		document.formular.nachricht.focus();
		return false;
	}

}

// Element entfernen
function elementEntfernen(e) {
	element.parentNode.removeChild(e);
}
