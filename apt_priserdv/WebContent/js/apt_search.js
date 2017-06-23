
$("#frm_search").submit(function(event){
	var temp_reservation = "template/apt_reservation.html";
	event.preventDefault();
	var spe = $("#idspe").val();
	var cp = $("#idlocation").val();
	alert(spe+cp);
	$("#apt_main").load(temp_reservation);
//	$("#apt_main").hide();
	$.get("SearchDoctor",{"spe": spe,"cp":cp}, function(r){
		alert(r);
		var r_data = jQuery.parseJSON(r);	
		switch(r_data.statut){
			case "1": afterSearch(r_data.data); break;
			case "2": alert("Wrong password."); break;
			case "4": alert(r_data.data); break;
			default: alert("Error undefined.");
		}
	});
}
);

