angular.module('app').controller('createReportCtrl', ['$scope', 'httpService', '$state', function($scope, httpService, $state) {

    $scope.createReport = function(){
        console.log($scope.report);
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
		  	$scope.submitter = $scope.users.email;
	  };
	  
	  
	  $scope.addProject = function(){
		    $scope.project = $scope.projects.name;
	  };
	 
}]);