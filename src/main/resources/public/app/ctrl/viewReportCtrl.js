angular.module('app').controller('viewReportCtrl', ['$scope', 'getProjects','getReport', 'projectFinderService', 'stateConverterService', 'httpService',
      function($scope, getProjects, getReport, projectFinderService, stateConverterService, httpService) {

      $scope.report = getReport.data;
      $scope.projects = getProjects.data;
      // the index of the reports assoiciated project in the projects array used for default value in the ng-option
      $scope.index = projectFinderService.getIndex($scope.projects, $scope.report.project.projectId);
      // converts the state from number to a string so it is humanreadable
      $scope.state = stateConverterService.getString($scope.report.state);
      console.log($scope.index);
      console.log(JSON.stringify($scope.report));
      console.log(JSON.stringify($scope.projects));
      // submits the report to the db with either a saved or submitted status based on which button was clicked
      $scope.putReport = function(state){
        console.log("funt times");
        $scope.report.state = state;
        $scope.report.project = $scope.selectedProject;
        httpService.putReport($scope.report);
      }
}])
