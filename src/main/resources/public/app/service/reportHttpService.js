angular.module('app').service('reportHttp',['$http',
  function($http){
    // Creates a new report in the database
    function createReport(data){
    	return $http.post('/report/create', data);
    }

    //Change state of report in backend to accepted (4)
    function approveReport(report) {
    	report.state = 4;
    	return $http.put('/report/update', report);
    }

    //Change state of report in backend to rejected (3)
    function rejectReport(report) {
    	report.state = 3;
    	return $http.put('/report/update', report);
    }

    function getReport(reportid) {
      return $http.get('/report/' + reportid);
    }

    function putReport(data){
      return $http.put('/report', data);
    }

    function pendingReports(devId){
    	return $http.get("/pendingReports/" + devId);
    }

    return {
      createReport : createReport,
      approveReport : approveReport,
      rejectReport : rejectReport,
      getReport : getReport,
      putReport : putReport,
      pendingReports : pendingReports
    }
  }]);
