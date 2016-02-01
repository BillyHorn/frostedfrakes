angular.module('app').controller('viewReportCtrl', ['$scope', 'getProjects', function($scope, getProjects) {
      // dummy report for creating this independent of backend
      /*$scope.report = {
        reportid:"1",
        notes:"These are notes",
        rejectionnotes:"these are rejection notes",
        state:"3",
        dev:"Billy McBillerson",
        projectname:"Frosted Frakes",
        lineitems: [
          {lineitemid:"2",
           date:"",
           value: "55",
           category: "Lodging",
           reportid: "1"},
           {lineitemid:"3",
            date:"",
            value: "75",
            category: "Other",
            reportid: "1"}
        ]
      }

      $scope.devs = {
        name1 : "chad",
        name2 : "brad",
        name3 : "phil"
      }*/
      // end dummy report

      $scope.report = getReport.data;
      $scope.projects = getProjects.data;
      console.log(JSON.stringify($scope.projects));
}])
