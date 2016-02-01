angular.module('app').controller('myReportsCtrl', ['$scope', '$state', 'myReportsService', function($scope, $state, myReportsService) {
  var state = $state.current.name;
  var reports = myReportsService.getReports();

  $scope.whichReports = myReportsService.namedState(state);
  $scope.filteredReports = myReportsService.filterReports(state);
  $scope.panelType = myReportsService.panelState(state);

  // turn this into a value
  $scope.tabs = [
    { heading: "Saved", route:"myReports.saved", active:false },
    { heading: "Submitted", route:"myReports.submitted", active:false },
    { heading: "Approved", route:"myReports.approved", active:false },
    { heading: "Rejected", route:"myReports.rejected", active:false }
  ];

  $scope.go = function(route){
    $state.go(route);
  };

  $scope.active = function(route){
    return $state.is(route);
  };

  $scope.$on("$stateChangeSuccess", function() {
    $scope.tabs.forEach(function(tab) {
      tab.active = $scope.active(tab.route);
    });
  });

}]);
