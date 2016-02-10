$(document).ready(function(){
	$('#errorLog').hide();

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
		event.preventDefault();
		var data = 'username=' + $('#inputUsername').val() + '&password=' + $('#inputPassword').val();
		loginPage(data);
	});

	function loginPage(data){
	  $.ajax({
	    data: data,
	    timeout: 1000,
	    type: 'POST',
	    url: '/login'
	  }).done(function() {
	    window.location.href = "/totpAuthentication";
	    console.log("login succed");
	  }).fail(function() {
		$('#errorLog').show();
		$('#errorLog').empty();
	    $('#errorLog').append("<p><strong>Error:</strong> Your username and password is incorrect!</p>");
	    $('#errorLog').fadeIn();
	  });
	}
});
