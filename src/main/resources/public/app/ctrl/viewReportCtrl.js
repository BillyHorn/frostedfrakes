angular.module('app').controller('viewReportCtrl', ['$scope', 'getProjects','getReport', 'projectFinderService', 'stateConverterService', 'reportHttp', 'lineItemsHttp', 'getLineItems', 'getCategories','$state', 'savedState', 'submittedState',
  function($scope, getProjects, getReport, projectFinderService, stateConverterService, reportHttp, lineItemsHttp,getLineItems, getCategories, $state, savedState, submittedState) {

    $scope.report = getReport.data;
    $scope.projects = getProjects.data;
    for(var i = 0; i < getLineItems.data.length; i++)
    {
      var tempDate = new Date(getLineItems.data[i].date);
      tempDate.setDate(tempDate.getDate() + 1); // add one day since the conversion causes it to lose a day
      getLineItems.data[i].date = tempDate;
    }
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
      reportHttp.putReport($scope.report);
      // iterate through the lineitems and send all of them to update
      for(var i = 0; i < $scope.lineitems.length; i++) {
        $scope.lineitems[i].report = $scope.report;
        lineItemsHttp.putLineItem($scope.lineitems[i]);
      }
      if(state == savedState){
        $state.go('my-reports.saved');
      }
      if(state == submittedState){
        $state.go('my-reports.submitted');
      }
    };

    /* author @wPerlichek */
    /* unSubmit();
    /* change state of report from "submitted" (2)
    /* to "saved" (1) when the user clicks the 
    /* unsubmit button from the view reports page */
    /* send user back to save/edit page */
    $scope.unSubmit = function(){
       reportHttp.unSubmitReport($scope.report);
       $state.go('my-reports.saved' + '/' + $scope.reportId);
    };

    // add a new line item to the list
    $scope.addLineItem = function(){
      $scope.lineitems.push({});
    };

    // delete the assoicated line item from the db and the list displayed
    $scope.deleteLineItem = function(lineItem) {
      lineItemsHttp.deleteLineItem(lineItem.lineItemId);
      var index = findIndex($scope.lineitems, lineItem);
      $scope.lineitems.splice(index,1);
    };

    $scope.cancel = function() {
      $state.go('my-reports');
    };

    // helper function to find the index of the the obj in the array
    function findIndex(array, obj) {
      for(var i = 0; i < array.length; i++)
      {
        if(array[i] == obj)
        {
          return i;
        }
      }
    }
  }]);
