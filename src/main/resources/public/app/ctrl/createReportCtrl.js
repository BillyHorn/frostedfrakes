angular.module('app').controller('createReportCtrl', ['$scope', 'httpService', '$state', function($scope, httpService, $state) {
	
	$scope.reports = {};
	#scope.reports.availableUsersForReport = {};
	$scope.reports.availableProjectsForReport = {};
	
	/* And expense report has a name, a submitter, a
	  project, an approver and line items. */
	
	  httpService.getProjects().then(function(response){
	        $scope.projects = response.data;
	    });
	  
	  httpService.getUsers().then(function(response){
	        $scope.users = response.data;
	    });
	  
	 
	  $scope.addSubmitter = function(){
		  	
	  };
	  
	  
	  $scope.addProject = function(){
		 
	  };
	 
}]);