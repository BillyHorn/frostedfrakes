angular.module('app').controller('homeCtrl', ['$scope', 'stateConverterService', 'currentUser', 'reportHttp', 'getThisUser',                             
  function($scope, stateConverterService, currentUser, reportHttp, getThisUser) {

	 /* obtain current user data from resolve */
     $scope.currentEmail = getThisUser.email;

	 /* @wPerlichek
	   obtain all currentUsers resports via reportHttp and store
	   them in a scope variable that will be used to display the
	   reports on the home page upon load */
	 reportHttp.getReports($scope.currentEmail).then(function(response){
		  $scope.thisUsersReports = response.data;
            for(var i = 0; i < $scope.thisUsersReports.length; i++){
              /* convert from numeric representaton of "state" to string rep */
              $scope.thisUsersReports[i].state = stateConverterService.getString($scope.thisUsersReports[i].state);
            }
        }, function(response){
            console.log(response);
        });

}]);
