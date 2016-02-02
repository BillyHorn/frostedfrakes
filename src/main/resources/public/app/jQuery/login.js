$(document).ready(function(){
	console.log("login.js");
	
	$('#login-form').keypress(function(e){
		if(e.keyCode == 13){
			$('#submitLogin').click();
		}
	});
	
	$('#register-form').keypress(function(e){
		if(e.keyCode == 13){
			$('#createbtn').click();
		}
	});
	
	$("#submitLogin").click(function(event){
		console.log("creating data");
		event.preventDefault();
		var data = 'username=' + $('#inputUsername').val() + '&password=' + $('#inputPassword').val();
		loginPage(data);
	});
	
	function loginPage(data){
		console.log("requesting permissions")
	  $.ajax({
	    data: data,
	    timeout: 1000,
	    type: 'POST',
	    url: '/login'

	  }).done(function() {
	    window.location.href = "/";

	  }).fail(function() {
		$('#errorLog').empty();
	    $('#errorLog').append("<p>Error: Your username and password is incorrect!</p>");
	    $('#errorLog').fadeIn();
	  });
	}
});	

		