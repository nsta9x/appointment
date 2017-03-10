$(window).on("load", function(){
	//Header
	var temp_header 	= "template/apt_header.html";
	$("#apt_header")	.load(temp_header);
	
	//Main
	var temp_main = "template/apt_main.html";
	$("#apt_main").load(temp_main);
//	
//	var temp_login	 	= "template/apt_login.html";
//	$("#apt_login")		.load(temp_login);
//	
	//Footer
	var temp_footer = "template/footer.html";
	$("#apt_footer").load(temp_footer);
	
	

});
