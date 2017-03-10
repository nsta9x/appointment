/**
 * 
 */

//Click button Login:
$("#btn_login").off("click");
$("#btn_login").on("click", function(){
	alert("xh");
	var temp_login	 	= "template/apt_login.html";
	$("#apt_login")		.load(temp_login);
	$("#frm_login").hide();
	$("#btn_login_login").click(function(){
		$("#frm_login").show();
		$("#frm_login_login").show();
		$("#frm_login_signup").hide();
	});

	$("#btn_login_signup").click(function() {
		$("#frm_login").show();
		$("#frm_login_signup").show();
		$("#frm_login_login").hide();
	});

	$("#userform-close").click(function() {
		$("#apt_login").hide();
	});
});
//$("#btn_login").off("click");
//$("#btn_login").on("click", function(){
//	$("#apt_login").toggle(1000);
//	$("#frm_login").hide();
//	$("#btn_login_login").click(function(){
//		$("#frm_login").show();
//		$("#frm_login_login").show();
//		$("#frm_login_signup").hide();
//	});
//
//	$("#btn_login_signup").click(function() {
//		$("#frm_login").show();
//		$("#frm_login_signup").show();
//		$("#frm_login_login").hide();
//	});
//
//	$("#userform-close").click(function() {
//		$("#apt_login").hide();
//	});
//
//	$("#userform-login-form").submit(function(event) {
//		event.preventDefault();
//		var acc = $("#account").val();
//		var pass = $("#password").val();
//		var status = "";
//		alert("Welcome " + acc);
//		
//	    $.post('UserLogin', {"account": acc, "password": pass}, function(data) {
//	    	switch (data){
//	    	case "--Error--": 
//	    		status = "System Error. Please try again later.";
//	    		$("#userform-title").text(status);
//	    		break;
//	    	case "0": 
//	    		status = "Login Failed. Please try again.";
//	    		$("#userform-title").text(status);
//	    		$("#account").focus();
//	    		break;
//	    	default: 
//	    		status = "Welcome back, " + data + ".";
//	    		$("#userform").fadeOut( "slow", function() {
//	    			$("#nav2").text(status);
//	    			var nav05 = "<div class='btn-group'><button type='button' id='nav05' class='btn btn-info'>MY ACCOUNT</button>";
//	    			var nav06 =	"<button type='button' id='nav06' class='btn btn-info'>LOG OUT</button></div>";
//	    			$("#nav2").html(status + nav05 + nav06);
//	    		});
//	    	}
//		});
//	});
//});
//


