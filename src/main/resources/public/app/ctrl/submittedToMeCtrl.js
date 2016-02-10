angular.module('app').controller('submittedToMeCtrl', ['$scope', '$state', 'currentUser', 'reportHttp', '$uibModal', 'submittedState',
	function($scope, $state, currentUser, reportHttp, $uibModal, submittedState) {

		$scope.user = currentUser.getUser();
		console.log("$scope.user:");
		console.log($scope.user); // whole object dev (DB) 
		console.log($scope.user.devId);//1
		$scope.email = (currentUser.getUser().email);
		console.log("$scope.email:"); 
		console.log($scope.email); // dev.email
		
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
			if ($report.state == submittedState) {
				return true;
			} else {
				return false;
			}
		};

		reportHttp.pendingReports($scope.email).then(function(res){
			$scope.myPendingReports = res.data;
		});


		
		
		
		//steffyJ

		
		
		$scope.reviewedReport = function() {
			
			reportHttp.getApprovedRegectedReport($scope.email).then(
					function(sucess) {
						$scope.myreviewedReports = re.data;
						
					},
					function(error) {
						console.log(error);
					});
					
		};
		
		
//		$scope.myreviewedReports = function() { 
//			
//			reportHttp.getApprovedRegectedReport($scope.email);
//		};
//		
		
//		reportHttp.getApprovedRegectedReport($scope.email).then(function(re){
//			$timeout(callAtTimeout,3000);
//			$scope.myreviewedReports = re.data;
//		});
		
		
		
		
		
		
		
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
