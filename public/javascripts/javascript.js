function pickdate() {
	$('.dateauswahl').pickadate({
		format : 'dd.mm.yyyy',
		today : 'Heute',
		clear : 'Löschen',
		close : 'Schliessen',
		min : 'true',
		monthsFull: ['Januar', 'Februar', 'März', 'April', 'Mai', 'Juni', 'Juli', 'August', 'September', 'Oktober', 'November', 'Dezember'],
		weekdaysShort: ['So', 'Mo', 'Di', 'Mi', 'Do', 'Fr', 'Sa'],
	});
}
function picktime() {
	$('.timeauswahl').pickatime({
		format : 'HH:i',
		clear : 'Löschen',
	});
}
