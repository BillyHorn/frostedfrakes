angular.module('app').service('myReportsService', ['reportHttp', 'currentUser', 'savedState','submittedState','rejectedState','approvedState',
  function(reportHttp, currentUser, savedState, submittedState, rejectedState, approvedState){

  // filter and return a list of a devs reports according to the current state
  function filterReports(state) {
    // get reports for the current user
    return reportHttp.getReports(currentUser.getUser().email).then(function(response) {
      var filteredReports = [];
      var stateNumber = numberedState(state);

      var reports = response.data;

      filteredReports = reports.filter(function(element) {
        return element.state == stateNumber;
      });
      return filteredReports;
    });
  }

  // returns a nicely formatted title based upon current state
  function namedState(state) {
    switch(state) {
      case "my-reports.saved":
        return "Saved";
      case "my-reports.submitted":
        return "Submitted";
      case "my-reports.rejected":
        return "Rejected";
      case "my-reports.approved":
        return "Approved";
      case "my-reports.previouslyReviewed":
    	  return "Reviewed";
      default:
        return "Something's Gone Wrong";
    }
  }

  // returns a bootstrap panel type based upon current state for styling purposes
  function panelState(state) {
    switch(state) {
      case "my-reports.saved":
        return "panel-default";
      case "my-reports.submitted":
        return "panel-info";
      case "my-reports.approved":
        return "panel-success";
      case "my-reports.rejected":
        return "panel-danger";
      default:
        return "panel-info";
    }
  }

  /* now, I know what you're thinking. these functions are all the same, and I
  * should abstract them into one function. I did that. It made everything
  * very difficult to read, and made function calls make way less sense.
  * this is better. trust me.
  *
  * returns a number (matching the db) based upon current state
  */
  function numberedState(state) {
    switch(state) {
      case "my-reports.saved":
        return savedState;
      case "my-reports.submitted":
        return submittedState;
      case "my-reports.rejected":
        return rejectedState;
      case "my-reports.approved":
        return approvedState;
      default:
        return "Something's Gone Wrong";
    }
  }

  return {
    namedState : namedState,
    filterReports : filterReports,
    panelState : panelState
  };
}]);
