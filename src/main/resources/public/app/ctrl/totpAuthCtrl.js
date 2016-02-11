angular.module('app').controller('totpAuthCtrl', ['$scope', 'devHttp', '$state', function($scope, devHttp, $state){

	$scope.totp = function(){
		console.log("anything");
		devHttp.totpCode($scope.totpCode).then(function(response){
			if (response.data !== null){
				window.location.href="/";
			}
			else {
				alert("you suckiest");
			}
		}).then(function(response){
			// console.log(response);
			// alert("you suck");
		});
	};

 }]);
