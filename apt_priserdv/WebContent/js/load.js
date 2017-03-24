$( document ).ready(function() {
	//Header
	var temp_header 	= "template/apt_header.html";
	$("#apt_header")	.load(temp_header);
	
	//Main
	var temp_main = "template/apt_main.html";
	$("#apt_main").load(temp_main);

	//Footer
	var temp_footer = "template/apt_footer.html";
	$("#apt_footer").load(temp_footer);
	
	//LogIn
	var script_login = "js/apt_login.js";
	$.getScript( script_login, function() {
	});
	
});
$(function(){
	$(window).on("scroll", function(){
		if($(window).scrollTop()>100){
			$("#apt_header").css("background-color", "white");
		}
		else{
			$("#apt_header").css("background-color", "rgba(100,120,120,0.2)");
		}
	})
})