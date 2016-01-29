angular.module('app').controller('myReportsCtrl', ['$scope', '$state', 'myReportsService', function($scope, $state, myReportsService) {
  var state = $state.current.name;
  var reports = myReportsService.getReports();

  $scope.whichReports = myReportsService.namedState(state);
  $scope.filteredReports = myReportsService.filterReports(state);
}]);
