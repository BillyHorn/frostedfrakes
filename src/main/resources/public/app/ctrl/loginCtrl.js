angular.module('app').controller('loginCtrl', ['$scope', '$state', 'httpService', 'logoutService',
function($scope, $state, httpService, logoutService) {
    $scope.welcome = "hello testing angular";
    
    
    
    $scope.login = function(){
    	$scope.userLogin = 'username=' + $scope.username + '&password=' + $scope.password;
    	
    	httpService.login($scope.userLogin).then(function(acceptResponse){
    		console.log("loginCtrl1.js")
    		console.log(acceptResponse);
    		$state.go("home");
    	},function(response){
    		console.log("loginCtrl2.js")
    		console.log(response);
    	});
    }
    
    
}])