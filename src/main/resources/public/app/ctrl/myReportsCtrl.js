angular.module('app').controller('myReportsCtrl', ['$scope', '$state', 'myReportsService', function($scope, $state, myReportsService) {

  // pull the current state
  var state = $state.current.name;

  // a name string used for the title of a display panel
  $scope.whichReports = myReportsService.namedState(state);
  // an array of reports, filtered by current state
  myReportsService.filterReports(state).then(function(res){
    $scope.filteredReports = res;
    console.log("$scope.filteredReports");
    console.log($scope.filteredReports);
  });

  // a string containing a bootstrap panel-type, for display purposes
  $scope.panelType = myReportsService.panelState(state);

  // turn this into a value
  // data to populate navigation tabs with
  $scope.tabs = [
    { heading: "Saved", route:"my-reports.saved", active:false },
    { heading: "Submitted", route:"my-reports.submitted", active:false },
    { heading: "Approved", route:"my-reports.approved", active:false },
    { heading: "Rejected", route:"my-reports.rejected", active:false },
    { heading: "Pending", route:"my-reports.submitted-to-me", active:false},
    { heading: "Reviewed", route:"my-reports.previouslyReviewed", active:false}
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
