angular.module('app').controller('previouslyReviewedCtrl', ['$scope', '$state', 'currentUser', 'reportHttp', '$uibModal', 'submittedState',
	function($scope, $state, currentUser, reportHttp, $uibModal, submittedState) {

		$scope.user = currentUser.getUser();	
		$scope.email = (currentUser.getUser().email);		
		$scope.animationsEnabled = true;
		$scope.myReviewedReports = {};
		$scope.id = {};
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
			if ($report.state == submittedState) {
				return true;
			} else {
				return false;
			}
		};

		reportHttp.pendingReports($scope.email).then(function(res){
			$scope.myPendingReports = res.data;
		});
		

		var states = {
				1: "saved",
				2: "submitted",
				3: "rejected",
				4: "aproved"		
		};
		
	$scope. getStateName = function(id) {			
			return states[id];		
		};

		reportHttp
			.getApprovedRejectedReport($scope.email)
			.then(function(response) {
				$scope.myReviewedReports = response.data;
			});
		
}]);



angular.module('app').controller('ModalInstanceCtrl', [ '$scope', '$uibModalInstance', 'report', 'reportHttp', '$state',
function ($scope, $uibModalInstance, report, reportHttp, $state) {
	$scope.report = report;

	$scope.cancel = function () {
		$uibModalInstance.dismiss('cancel');
	};

	$scope.rejectReport = function() {
		reportHttp.rejectReport($scope.report).then(function(){
			console.log($scope.report);
			$state.go($state.current, {reload: true});
		});
	}
}]);
