angular.module('app').controller('totpAuthCtrl', ['$scope', 'devHttp', 'currentUser', 'loginService', '$state', '$browser',function($scope, devHttp, currentUser, loginService, $state, $browser){

	$scope.totp = function(){
		console.log("anything");
		devHttp.totpCode($scope.totpCode).then(function(response){
			console.log(response);
	    	window.location.href="/";
	    }, function(response){
			$scope.error=" Invalid code / Code timed out.";
			$scope.totpCode="";
	    });
	};

	$scope.logout = function() {
		window.location.href="/logout";
	};

 }]);
