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
	value: "Mileage"},

		{id: 2,
	value: "Per Diem"},

		{id: 3,
	value: "Lodging"},

		{id: 4,
	value: "Travels"},

		{id: 5,
	value: "Meals"},

		{id: 6,
	value: "Entertainment"},

		{id: 7,
	value: "Other"}


	];

    $scope.createReport = function(){
        console.log($scope.report);
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

	  httpService.getUsers().then(function(response){
		    console.log(response);
	        $scope.users = response.data;
	    });

<<<<<<< HEAD
	  //
	//   $scope.addSubmitter = function(){
	// 	  	//$scope.submitter = $scope.users.email;
	// 	  	$scope.report.dev = $scope.dev;
=======

	  $scope.addSubmitter = function(){
		  	$scope.report.dev = $scope.dev;
	  };


	  $scope.addProject = function(){
		   // $scope.project = $scope.projects.name;
		    $scope.report.project = $scope.activeProject;
	  };

	//   $scope.addApprover = function(){
	// 	  $scope.report.approver = $scope.approver;
>>>>>>> sprint1
	//   };

	//   $scope.addLineItems = function(){
	//   	  $scope.report.lineItems = $scope.report.lineItemsToConvert;
	//   };
}]);
