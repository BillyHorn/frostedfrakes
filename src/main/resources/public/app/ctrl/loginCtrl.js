/**
 * this controller pulls relevant data from login.html and parses together
 * a string to be submitted for authentication, on success the user is 
 * taken to the home page
 */

angular.module('app').controller('loginCtrl', ['$scope', '$state', 'httpService',
function($scope, $state, httpService) {
    $scope.welcome = "hello testing angular";
    
    
    
    $scope.login = function(){
    	$scope.userLogin = 'username=' + $scope.username + '&password=' + $scope.password;
    	
    	httpService.login($scope.userLogin).then(function(acceptResponse){
    		console.log(acceptResponse);
    		$state.go("home");
    	},function(response){
    		console.log(response);
    	});
    }
    
    
}])