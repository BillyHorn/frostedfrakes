angular.module('app').controller('homeCtrl', ['$scope', 'stateConverterService', 'currentUser', 'reportHttp',
  function($scope, stateConverterService, currentUser, reportHttp) {

	 /* obtain current user data from resolve */
     $scope.currentEmail = currentUser.getUser().email;

     /* distinct model to show appropriate HTML based on user */
     $scope.roleCheck = currentUser.getUser();

     /* if the current logged in user is not an admin, show all user reports on the home page */
     if ($scope.roleCheck.role != "admin"){

	 /* @wPerlichek
	   obtain all currentUsers reports via reportHttp and store
	   them in a scope variable that will be used to display the
	   reports on the home page upon load */
	 reportHttp.getReports($scope.currentEmail).then(function(response){
		  $scope.thisUsersReports = response.data;
            for(var i = 0; i < $scope.thisUsersReports.length; i++){
              /* convert from numeric representation of "state" to string rep */
              $scope.thisUsersReports[i].state = stateConverterService.getString($scope.thisUsersReports[i].state);
            }
        }, function(response){
            console.log(response);
        });
     }
}]);
