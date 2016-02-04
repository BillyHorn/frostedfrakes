angular.module('app').controller('createReportCtrl', ['$scope', 'httpService', '$state', 'currentUser', function($scope, httpService, $state, currentUser) {


	$scope.users = [];
	$scope.report = {};


	/* stores all line items as single array */


    $scope.createReport = function(){
		$scope.report.dev = currentUser.getUser();
		$scope.report.state=1;
        httpService.createReport($scope.report).then(function(response){
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

	  httpService.getProjects().then(function(response){
		    console.log(response);
	        $scope.projects = response.data;
	    });


}]);
