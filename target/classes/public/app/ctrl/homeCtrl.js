angular.module('app').controller('homeCtrl', ['$scope', 'currentUser', 'reportHttp',                               
  function($scope, currentUser, reportHttp) {
	
	/* @wPerlichek
	   obtain all currentUsers reports via reportHttp and store
	   them in a scope variable that will be used to display the
	   reports on home page */
	$scope.thisUsersReports = reportHttp.getReports(currentUser).data;

	/* get current user information to display to the user */
	$scope.thisUser = currentUser.getUser();



}]);
