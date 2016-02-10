angular.module('app').controller('homeCtrl', ['$scope', 'currentUser', 'reportHttp', 'getThisUser',                              
  function($scope, currentUser, reportHttp, getThisUser) {

	/* obtain current user data from resolve */
  	$scope.currentEmail = getThisUser.email;
  	console.log($scope.currentEmail);

	 /* @wPerlichek
	   obtain all currentUsers resports via reportHttp and store
	   them in a scope variable that will be used to display the
	   reports on the home page */
	 reportHttp.getReports($scope.currentEmail).then(function(response){
		  $scope.thisUsersReports = response.data;
        }, function(response){
            console.log(response);
        });

}]);
