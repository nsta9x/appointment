	var temp_login	 	= "template/apt_login.html";
	$("#apt_login")		.load(temp_login);
	$("#apt_login")		.hide();
	
	//Click button Login:
	$("#btn_login").off("click");
	$("#btn_login").on("click", function(){
		$("#apt_login")		.toggle(1000);
		$("#frm_login").hide();
	var temp_client ="template/apt_client.html";
		$("#btn_login_login").click(function(){
			$("#frm_login").show();
			$("#frm_login_login").show();
			$("#frm_login_signup").hide();
			$("#frm_login_login").submit(function(event){
				event.preventDefault(); //cau lenh tranh tai lai trang
				var user = $("#account").val();
				var pass = $("#password").val();
				$("#apt_main").load(temp_client);
				$("#apt_main").hide();
			//	$.post("diachi",data gui len, data gui xuong)
				$.get("Login",{"username":user,"password":pass}, function(data){
					if(data){			
						var user = jQuery.parseJSON(data);				
						$("#div_user").html("Chao mung " + user.C_nom + " da dang nhap.");
						$("#apt_main").show();
						$("#user_nom").html(user.C_nom + " " + user.C_prenom);
						$("#sex").html(user.C_sex);
						$("#work").html(user.C_work);
						$("#address").html(user.C_address+user.C_cp+"Paris");
						$("#email").html(user.C_email);
						$("#phone").html(user.C_tel);
						$("#bday").html(user.C_bday);
					}
				});
			});
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
