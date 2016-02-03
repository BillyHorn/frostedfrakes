angular.module('app').controller('viewReportCtrl', ['$scope', 'getProjects','getReport', function($scope, getProjects, getReport) {

      $scope.report = getReport.data;

      // edit report to be more humanreadable i.e. change from numbers to strings
      $scope.projects = getProjects.data;
      console.log(JSON.stringify($scope.report));
      console.log(JSON.stringify($scope.projects));
}])
