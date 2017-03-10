
//Click button Login:
$("#btn_login").off("click");
$("#btn_login").on("click", function(){
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