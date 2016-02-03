angular.module('app').controller('viewReportCtrl', ['$scope', 'getProjects','getReport', 'projectFinderService', 'stateConverterService', 'httpService', 'getLineItems', 'getCategories',
      function($scope, getProjects, getReport, projectFinderService, stateConverterService, httpService, getLineItems, getCategories) {

      $scope.report = getReport.data;
      $scope.projects = getProjects.data;
      $scope.lineitems = getLineItems.data;
      $scope.categories = getCategories.data;
      // the index of the reports assoiciated project in the projects array used for default value in the ng-option
      $scope.index = projectFinderService.getIndex($scope.projects, $scope.report.project.projectId);
      // converts the state from number to a string so it is humanreadable
      $scope.state = stateConverterService.getString($scope.report.state);

      // submits the report to the db with either a saved or submitted status based on which button was clicked
      // also will update all lineitems assoicated with the report TODO only update modified line items
      $scope.putReport = function(state){
        $scope.report.state = state;
        $scope.report.project = $scope.selectedProject;
        httpService.putReport($scope.report);
        // iterate through the lineitems and send all of them to update
        for(var i = 0; i < $scope.lineitems.length; i++) {
          httpService.putLineItem($scope.lineitems[i]);
        }
      }

      // add a new line item to the list
      $scope.addLineItem = function(){
        $scope.lineitems.push({});
      }
}])
