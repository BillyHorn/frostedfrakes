$(document).ready(function(){
	$('#errorLog').hide();

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
	  }).fail(function() {
		$('#errorLog').show();
		$('#errorLog').empty();
	    $('#errorLog').append("<p><strong>Error:</strong> Your username and password is incorrect!</p>");
	    $('#errorLog').fadeIn();
	  });
	}
});
