angular.module('app').controller('createReportCtrl', ['$scope', 'httpService', '$state', function($scope, httpService, $state) {
	
	$scope.reports = {};
	
	/* And expense report has a name, a submitter, a
	  project, an approver and line items. */
	  httpService.getProjects().then(function(response){
	        console.log(response);
	        $scope.reports.projects = response.data;
	        $scope.project.projects.unshift({name : "Select a Project"});
	    });

}]);