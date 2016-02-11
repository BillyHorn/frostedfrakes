angular.module('app').controller('totpAuthCtrl', ['$scope', 'devHttp', '$state', function($scope, devHttp, $state){

	$scope.totp = function(){
		console.log("anything");
		devHttp.totpCode($scope.totpCode).then(function(response){
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
