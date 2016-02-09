angular.module('app').service('reportHttp', ['$http', 'approvedState', 'rejectedState', 'savedState',
  function($http, approvedState, rejectedState, savedState){

    // local var to hold end point name
    var reportEndPoint = "/report";

    // Creates a new report in the database
    function createReport(data){
    	return $http.post(reportEndPoint, data);
    }

    //Change state of report in backend to approved (4)
    function approveReport(report) {
    	report.state = approvedState;
    	return $http.put(reportEndPoint, report);
    }

    //Change state of report in backend to rejected (3)
    function rejectReport(report) {
    	report.state = rejectedState;
    	return $http.put(reportEndPoint, report);
    }

    function getReport(reportid) {
      return $http.get(reportEndPoint + '/id/' + reportid);
    }

    function putReport(data){
      return $http.put(reportEndPoint, data);
    }

    function pendingReports(devId){ // TODO fix this endpoint
    	return $http.get(reportEndPoint + '/pending/' + devId);
    }

    // get reports for the user provided
    function getReports(user)
    {
      return $http.get(reportEndPoint + '/email/' + user);
    }

    /* @author wPerlichek
    /* unSubmitReport()
    /* change state of an existing report
    /* from submitted (2) back to saved */
    function unSubmitReport(report){
      /* change report state to 1 */
      report.state = savedState;
      /* put request to update the existing report */
      return $http.put(reportEndPoint, report);
    }

    return {
      createReport : createReport,
      approveReport : approveReport,
      rejectReport : rejectReport,
      getReport : getReport,
      getReports : getReports,
      putReport : putReport,
      pendingReports : pendingReports,
      unSubmitReport: unSubmitReport
    }
  }]);
