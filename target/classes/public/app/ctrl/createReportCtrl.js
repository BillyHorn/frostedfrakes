angular.module('app').controller('createReportCtrl', ['$scope', 'httpService', '$state', 'currentUser', function($scope, httpService, $state, currentUser) {


	$scope.users = [];
	$scope.report = {};


	/* stores all line items as single array */


    $scope.createReport = function(){
        console.log($scope.report);
		$scope.report.dev = currentUser.getUser();
		$scope.report.state=1;
        httpService.createReport($scope.report).then(function(){
            $state.go('home');
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
