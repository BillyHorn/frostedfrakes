angular.module('app').controller('myReportsCtrl', ['$scope', '$state', 'myReportsService', function($scope, $state, myReportsService) {

  // pull the current state
  var state = $state.current.name;
  // get all reports associated with a user from the backend
  var reports = myReportsService.getReports();

  // a name string used for the title of a display panel
  $scope.whichReports = myReportsService.namedState(state);
  // an array of reports, filtered by current state
  $scope.filteredReports = myReportsService.filterReports(state);
  // a string containing a bootstrap panel-type, for display purposes
  $scope.panelType = myReportsService.panelState(state);

  // turn this into a value
  // data to populate navigation tabs with
  $scope.tabs = [
    { heading: "Saved", route:"myReports.saved", active:false },
    { heading: "Submitted", route:"myReports.submitted", active:false },
    { heading: "Approved", route:"myReports.approved", active:false },
    { heading: "Rejected", route:"myReports.rejected", active:false }
  ];

  // a function for navicating between states
  $scope.go = function(route){
    $state.go(route);
  };

  // a boolean active check for the current state
  $scope.active = function(route){
    return $state.is(route);
  };

  // a reset for active-state of tabs on state-change.
  // it is possible this same idea can be implemented for ctrl-reset. remember.
  $scope.$on("$stateChangeSuccess", function() {
    $scope.tabs.forEach(function(tab) {
      tab.active = $scope.active(tab.route);
    });
  });

}]);
