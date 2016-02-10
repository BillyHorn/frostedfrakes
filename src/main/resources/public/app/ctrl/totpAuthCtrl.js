angular.module('app').controller('totpAuthCtrl', ['$scope', 'devHttp', '$state', function($scope, devHttp, $state){

	$scope.totp = function(){
		console.log("anything");
		devHttp.totpCode($scope.totpCode).then(function(){
			console.log("i worked");
		});
	};

 }]);
