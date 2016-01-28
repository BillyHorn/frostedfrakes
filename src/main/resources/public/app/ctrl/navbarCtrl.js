angular.module('app').controller('navbarCtrl', ['$scope', 'logoutService', 
function($scope, logoutService) {
    $scope.logoutBtn = function(){
    	return logoutService.getLogoutStatus();
    }
}])