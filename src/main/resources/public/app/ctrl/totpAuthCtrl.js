angular.module('app').controller('totpAuthCtrl', ['$scope', '$state', 'devHttp',
function($scope, $state, devHttp) {
	
	$scope.totp = function(){
		console.log("anything");
		devHttp.totpCode($scope.totpCode);
	}
  
 }]);