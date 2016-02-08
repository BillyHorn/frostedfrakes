angular.module('app').service('reportHttp', ['$http', 'approvedState', 'rejectedState',
  function($http, approvedState, rejectedState){

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

    return {
      createReport : createReport,
      approveReport : approveReport,
      rejectReport : rejectReport,
      getReport : getReport,
      getReports : getReports,
      putReport : putReport,
      pendingReports : pendingReports
    }
  }]);
