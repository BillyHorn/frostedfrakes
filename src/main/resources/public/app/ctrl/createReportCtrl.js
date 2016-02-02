angular.module('app').controller('createReportCtrl', ['$scope', 'httpService', '$state', function($scope, httpService, $state) {

	$scope.projects = [];
	$scope.users = [];
	$scope.report = {};

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
       
    	  
    	  
    	  
    	  
 
      };


	  httpService.getProjects().then(function(response){
		    console.log(response);
	        $scope.projects = response.data;
	    });

	  httpService.getUsers().then(function(response){
		    console.log(response);
	        $scope.users = response.data;
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
