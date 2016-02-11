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
            for(var i = 0; i < $scope.thisUsersReports.length; i++){
              $scope.thisUsersReports[i].state = stateConverterService.getString($scope.thisUsersReports[i].state);
            }
        }, function(response){
            console.log(response);
        });

}]);
