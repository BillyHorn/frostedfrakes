angular.module('app').controller('createReportCtrl', ['$scope', 'httpService', '$state', function($scope, httpService, $state) {

	$scope.projects = [];
	$scope.users = [];
	$scope.report = {};

	/* this array is the model for the line item input
	 * field and contains all line items inputted
	 * by the user from the createReport.html page
	 */


    $scope.createReport = function(){
        console.log($scope.report);
		$scope.report.state=1;
        httpService.createReport($scope.report).then(function(){
            $state.go('home');
        }, function(response){
            console.log(response);
        });
      };


	  httpService.getProjects().then(function(response){
		    console.log(response);
	        $scope.projects = response.data;
	    });

	  httpService.getUsers().then(function(response){
		    console.log(response);
	        $scope.users = response.data;
	    });


	  $scope.addSubmitter = function(){
		  	//$scope.submitter = $scope.users.email;
		  	$scope.report.dev = $scope.dev;
	  };


	  $scope.addProject = function(){
		   // $scope.project = $scope.projects.name;
		    $scope.report.project = $scope.activeProject;
	  };

}]);
