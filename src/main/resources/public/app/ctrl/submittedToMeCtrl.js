angular.module('app').controller('submittedToMeCtrl', ['$scope', '$state', 'currentUser', 'httpService', '$uibModal',
function($scope, $state, currentUser, httpService, $uibModal, $uibModalInstance) {

	$scope.user = currentUser.getUser();

	$scope.email = (currentUser.getUser().email);

	$scope.animationsEnabled = true;

	$scope.open = function(currentReport) {

		var modalInstance = $uibModal.open({
			animation: $scope.animationsEnabled,
			templateUrl: 'myModalContent.html',
			controller: 'ModalInstanceCtrl',
			resolve:{
				report: function(){
					return currentReport;
				}
			}
    	});
	};

	$scope.toggleAnimation = function () {
	   $scope.animationsEnabled = !$scope.animationsEnabled;
	 };

	$scope.stateCheck = function($report){
		if ($report.state == 2) {
			return true;
		} else {
			return false;
		}
	};

	// $scope.filterLineItems = function($item, $report){
	// 	console.log($item.report.reportId + " " + $report.reportId);
	// 	if ($item.report.reportId !== $report.reportId){
	// 		return false;
	// 	} else {
	// 		return true;
	// 	}
	// };

	httpService.pendingReports($scope.email).then(function(res){
		$scope.myPendingReports = res.data;
		// httpService.getPendingLineItems(currentUser.getUser().devId).then(function(response){
		// 	$scope.lineItems = response.data;
		// });
	});

	$scope.approveReport = function(report) {
		httpService.approveReport(report);
	};


}]);



angular.module('app').controller('ModalInstanceCtrl', [ '$scope', '$uibModalInstance', 'report', 'httpService', '$state',
function ($scope, $uibModalInstance, report, httpService, $state) {
	$scope.report = report;

	$scope.cancel = function () {
		$uibModalInstance.dismiss('cancel');
	};

	$scope.rejectReport = function() {
		httpService.rejectReport($scope.report).then(function(){
			console.log($scope.report);
			$state.go($state.current, {reload: true});
		});
	}
}]);
