// AJAX /fahrzeugübersicht Aktuell
$(document).ready(function() {
	count = 0;
	start = 4;  //Anzahl Fahrzeuge die immer am Anfang ausgegeben werden, dannach immer +1
	lock = false;
	for (i = 0; i < start; i++) {
		if (lock == false) {
			loadcontent();
		}
	}
});

// AJAX mit Scroll Function
function loadcontent() {
	lock = true; //Um paralleles Ausführen mit gleichem count zu verhindern
	console.log("In Loadcontent mit count: " + count);
	$("div.loader").show();

	$.ajax({
		type : 'get',
		url : '/fahrzeuge',
		async : false,
		data : {
			count : count
		},

		success : function(html) {
			if (html) {
				$('#container').append(html);
				count += 1;
				lock = false;
			}
			;
		},

	})

	$("div.loader").fadeOut('normal');
	console.log("Verlasse Loadcontent mit count: " + count);
	lock = false;
}

$(window).scroll(
		function() {
			if (i >= start
					&& $(window).scrollTop() == $(document).height()
							- $(window).height()) {
				if (lock == false) {
					loadcontent();
				}
			}
		});
