angular.module('app').controller('createReportCtrl', ['$scope', 'httpService', '$state', function($scope, httpService, $state) {

	$scope.projects = [];
	$scope.users = [];
	$scope.report = {};
	
	$scope.addLineItem = [];
	
	/* this array is the model for the line item input
	 * field and contains all line items inputted
	 * by the user from the createReport.html page
	 */
	$scope.report.lineItemsToConvert = [];
	
	/* stores all line items as single array */
	$scope.categories = [ 
	
	{id: 1, 
	name: "Mileage"},
	
		{id: 2, 
	name: "Per Diem"},
	
		{id: 3, 
	name: "Lodging"},
	
		{id: 4, 
	name: "Travels"},
	
		{id: 5, 
	name: "Meals"},
	
		{id: 6, 
	name: "Entertainment"},
	
		{id: 7, 
	name: "Other"}
	
	 
	];
	
    $scope.createReport = function(){
        console.log($scope.report);
        httpService.createReport($scope.report).then(function(){
            $state.go('home');
        }, function(response){
            console.log(response);
        });
      };
      
      
      // add new line item 
      $scope.createNewLineItem = function(){
      
      	
  			
      	
 
		


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
		  	$scope.report.submitter = $scope.submitter;
	  };
	  
	  
	  $scope.addProject = function(){
		   // $scope.project = $scope.projects.name;
		    $scope.report.project = $scope.activeProject;
	  };
	  
	  $scope.addApprover = function(){
		  $scope.report.approver = $scope.approver;
	  }
	  
	  $scope.addLineItems = function(){
	  	  $scope.report.lineItems = $scope.report.lineItemsToConvert;
	  }
	 
}]);