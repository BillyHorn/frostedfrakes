angular.module('app').controller('homeCtrl', ['$scope', 'stateConverterService', 'currentUser', 'reportHttp', 'getThisUser', 'savedState', 'submittedState',                             
  function($scope, stateConverterService, currentUser, reportHttp, getThisUser, savedState, submittedState) {

	/* obtain current user data from resolve */
  	$scope.currentEmail = getThisUser.email;
  	console.log($scope.currentEmail);

	 /* @wPerlichek
	   obtain all currentUsers resports via reportHttp and store
	   them in a scope variable that will be used to display the
	   reports on the home page */
	 reportHttp.getReports($scope.currentEmail).then(function(response){
		  $scope.thisUsersReports = response.data;
		 /* convert numeric value of state to associated string value */
		 $scope.state = stateConverterService.getString($scope.thisUsersReports.state); 
        }, function(response){
            console.log(response);
        });


}]);
