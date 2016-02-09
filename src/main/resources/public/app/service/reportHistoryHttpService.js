angular.module('app').service('reportHistoryHttp',['$http',
  function($http){

    // local var to hold end point name
    var reportHistoryEndPoint = "/reportHistory";

    // Gets all projects from the database for the user logged in
    function getReportHistory(reportId){
      return $http.get(reportHistoryEndPoint + '/' + reportId);
    }

    return {
      getReportHistory : getReportHistory
    };
}]);
