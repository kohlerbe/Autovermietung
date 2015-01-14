	
	function pickdate (){
	$('.dateauswahl').pickadate({
	format: 'dd.mm.yyyy',
	today: 'Heute',
	clear: 'Loeschen',
	close: 'Schliessen',
	min: 'true'
	});	
	}
	function picktime (){
	$('.timeauswahl').pickatime({
	format: 'HH:i',
	});
	}
	
	function checkKontakt( form ){
    
	var warnung = "";
    if ( form.email.value == "" ) {
      warnung = "Bitte geben Sie ihre E-Mail-Adresse ein!\n";
	  alert(warnung);
	  document.formular.email.focus();
	  return false;
    }
	if ( form.name.value == "" ) {
      warnung = "Bitte geben Sie ihren Namen ein!\n";
	  alert(warnung);
	  document.formular.name.focus();
	  return false;
    }
    if ( form.nachricht.value == "" ) {
      warnung = "Sie haben Ihr Anliegen noch nicht beschrieben!\n";
	  alert(warnung);
	  document.formular.nachricht.focus();
	  return false;
    }
        
  }
	
	//AJAX NR 1 /fahrzeugübersicht mit Button
	function dynamischesLaden (){
	$('#ajax').load('/fahrzeuge', function(responseTxt, statusTxt, xhr){
	if (statusTxt == "sucess") {
		console.log("Erfolgreich!");
	} else if (statuTxt == "error") {
	alert("Ajax ERROR with status " + xhr.status + ": "	+ xhr.statusText);
	}
	});
	var element = document.getElementById("button");
	elementEntfernen(element);
	}
	
//Element entfernen
	function elementEntfernen(e){
	element.parentNode.removeChild(e);
	}


//AJAX	NR 2 /fahrzeugübersicht Aktuell
$(document).ready(function() {
    count = 0;
    for (var i = 0; i < 4; i++){
        loadcontent();
    }
}); 

 //AJAX mit Scroll Function
	function loadcontent() {
	

		$("div.loader").show();     
     
		$.ajax({
			type: 'get',
			url: '/fahrzeuge',
			async: false,
			data: { count : count },
			
			success: function (html){
				if(html){
					$('#container').append(html);
					count += 1;
				};
			},
			
			
         
    })  
 
    $("div.loader").fadeOut('normal');      
}
 
$(window).scroll(function(){
    if ($(window).scrollTop() == $(document).height() - $(window).height()){        
            loadcontent();          
    }
}); 
	
	
	
	
	