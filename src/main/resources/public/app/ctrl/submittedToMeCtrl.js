angular.module('app').controller('submittedToMeCtrl', ['$scope', '$state', 'currentUser', 'httpService',
function($scope, $state, currentUser, httpService) {
	
	$scope.user = currentUser.getUser();
	
	$scope.email = (currentUser.getUser().email);
	
	$scope.stateCheck = function($report){
		if ($report.state == 2) {
			return true;
		} else {
			return false;
		}
	}
		
	httpService.pendingReports($scope.email).then(function(res){
		$scope.myPendingReports = res.data;
	});
	
	$scope.approveReport = function(report) {
		httpService.approveReport(report);
	}
	
	$scope.rejectReport = function(report) {
		httpService.rejectReport(report);
	}
	  
}]);