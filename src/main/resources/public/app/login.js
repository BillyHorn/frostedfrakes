$(document).ready(function(){
	console.log("login.js");
	
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
		$('#errorLog').clear;
	    $('#errorLog').append("<p>Wrong Credentials</p>");
	  });
	}
});	

		