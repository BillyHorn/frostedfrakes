angular.module('app').controller('createReportCtrl', ['$scope', 'httpService', '$state', function($scope, httpService, $state) {

	$scope.projects = [];
	$scope.users = [];
	$scope.report = {};
	$scope.saves = [];

	   	 $scope.createReport = function(){
	        console.log($scope.report);
	        /* 1 is defined as "saved" */
			$scope.report.state=1;
	        httpService.createReport($scope.report).then(function(){
	        }, function(response){
	            console.log(response);
	        });
	      };
     
     	   $scope.submitReport = function(){
     	   	console.log($scope.selectedReport);
	       // console.log($scope.report); /* 2 is defined as "submitted" */
			$scope.selectedReport.state = 2;
	        httpService.submitReport($scope.selectedReport).then(function(){
	        }, function(response){
	            console.log(response);
	        });
	      };


		 httpService.getProjects().then(function(response){
	        $scope.projects = response.data;
	    });

	  	httpService.getUsers().then(function(response){
	        $scope.users = response.data;
	    });

	    httpService.getReports().then(function(response){
	    	console.log(response.data);
	        $scope.saves = response.data;
	    });

	  
	  // 
	//   $scope.addSubmitter = function(){
	// 	  	//$scope.submitter = $scope.users.email;
	// 	  	$scope.report.dev = $scope.dev;
	//   };
	  //
	  //
	//   $scope.addProject = function(){
	// 	   // $scope.project = $scope.projects.name;
	// 	    $scope.report.project = $scope.activeProject;
	//   };

}]);
