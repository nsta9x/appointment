
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
function afterSearch(doctor){	
	$("#D_nom").html("Welcome " + doctor.D_nom);
//	$("#apt_main").show();
	$("#D_prenom").html(doctor.D_prenom);
//	$("#sex").html(user.C_sex);
//	$("#work").html(user.C_work);
//	$("#address").html(user.C_address + ", " + user.C_cp+" Paris");
//	$("#email").html(user.C_email);
//	$("#phone").html(user.C_tel);
//	$("#bday").html(user.C_bday);
}