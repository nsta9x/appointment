$( document ).ready(function() {
	//Header
	var temp_header 	= "template/apt_header.html";
	$("#apt_header")	.load(temp_header);
	
	//Main
	var temp_main = "template/apt_main.html";
	$("#apt_main").load(temp_main);

	//Footer
	var temp_footer = "template/footer.html";
	$("#apt_footer").load(temp_footer);
	
	//LogIn
	var script_login = "js/apt_login.js";
	$.getScript( script_login, function() {
	});
});