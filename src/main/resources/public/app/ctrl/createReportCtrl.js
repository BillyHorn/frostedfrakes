angular.module('app').controller('createReportCtrl', ['savedState','$scope', 'reportHttp','projectHttp', '$state', 'currentUser', function(savedState, $scope, reportHttp, projectHttp, $state, currentUser) {


	$scope.users = [];
	$scope.report = {};
	/* stores all line items as single array */

    $scope.createReport = function(){
		$scope.report.dev = currentUser.getUser();
		$scope.report.state = savedState;
        reportHttp.createReport($scope.report).then(function(response){
			$scope.report.reportId = response.data;
            $state.go('viewReport', ({reportid : $scope.report.reportId}));
        }, function(response){
            console.log(response);
        });
      };

      // add new line item
      $scope.createNewLineItem = function(){
      $scope.addLineItem.push({});

      };

	  projectHttp.getProjects().then(function(response){
	        $scope.projects = response.data;
	        console.log( $scope.projects );
	    });


}]);
