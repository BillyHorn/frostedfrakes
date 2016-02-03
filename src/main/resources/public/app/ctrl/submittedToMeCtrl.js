angular.module('app').controller('submittedToMeCtrl', ['$scope', 'currentUser', 'httpService',
function($scope, currentUser, httpService) {
	
	$scope.user = currentUser.getUser();
	
	$scope.email = (currentUser.getUser().email);
		
	httpService.pendingReports($scope.email).then(function(res){
		$scope.myPendingReports = res.data;
	});
	
}]);