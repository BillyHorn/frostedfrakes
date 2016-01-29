angular.module('app').controller('viewReportCtrl', ['$scope', function($scope) {
      // dummy report for creating this independent of backend
      $scope.report = {
        reportid:"1",
        notes:"These are notes",
        rejectionnotes:"these are rejection notes",
        state:"4",
        dev:"Billy McBillerson",
        projectname:"Frosted Frakes",
        lineitems: [
          {lineitemid:"2",
           date:"this is a date",
           value: "55",
           categoryid: "categoryid",
           reportid: "1"},
           {lineitemid:"3",
            date:"this is a date",
            value: "75",
            categoryid: "categoryid",
            reportid: "1"}
        ]
      }
      // end dummy report
}])
