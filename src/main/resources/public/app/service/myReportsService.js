angular.module('app').service('myReportsService', ['$http', function($http){

  // pull the current state in order to send appropriate information

  // filter and return a list of a devs reports according to the current state
  function filterReports(state) {
    var reports = getReports();
    var filteredReports = [];
    var stateNumber = numberedState(state);

    filteredReports = reports.filter(function(element) {
      return element.state == stateNumber;
    });

    return filteredReports;
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
      default:
      return "Something's Gone Wrong";
    }
  }

  // returns a bootstrap panel type based upon current state for stylin purposes
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
      return 1;
      case "my-reports.submitted":
      return 2;
      case "my-reports.rejected":
      return 3;
      case "my-reports.approved":
      return 4;
      default:
      return "Something's Gone Wrong";
    }
  }

  /* a function which will eventually pull reports from the backend. for now
   * it just shoots out dummy data.
   */
  function getReports(){

    // commented until route set up, etc.
    // return $http.get('/reports');

    // dummy return variables
    return [
      {
        reportID: 1,
        name: "Report 1",
        dev: "SomeUser",
        notes: "this is why I should not be rejected",
        rejectionNotes: "here is why you were rejected",
        project: "Project1",
        state: 3,
        lineItems: []
      },
      {
        reportID: 2,
        name: "Report 2",
        dev: "SomeOtherUser",
        notes: "Nothing to Say",
        rejectionNotes: "",
        project: "Project1",
        state: 4,
        lineItems: []
      },
      {
        reportID: 3,
        name: "Report 3",
        dev: "SomeUser",
        notes: "Why do you always reject me?",
        rejectionNotes: "",
        project: "Project2",
        state: 1,
        lineItems: []
      },
      {
        reportID: 4,
        name: "Report 4",
        dev: "SomeThirdUser",
        notes: "I should not be rejected",
        rejectionNotes: "",
        project: "Project1",
        state: 2,
        lineItems: []
      },
      {
        reportID: 5,
        name: "Report 5",
        dev: "SomeUser",
        notes: "",
        rejectionNotes: "",
        project: "Project1",
        state: 2,
        lineItems: []
      },
      {
        reportID: 6,
        name: "Report 6",
        dev: "SomeThirdUser",
        notes: "",
        rejectionNotes: "",
        project: "Project2",
        state: 1,
        lineItems: []
      },
      {
        reportID: 7,
        name: "Report 7",
        dev: "SomeOtherUser",
        notes: "I should not be rejected",
        rejectionNotes: "",
        project: "Project1",
        state: 1,
        lineItems: []
      }
    ];
  }

  return {
    getReports : getReports,
    namedState : namedState,
    filterReports : filterReports,
    panelState : panelState
  };
}]);
