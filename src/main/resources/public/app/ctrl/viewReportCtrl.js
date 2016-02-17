// <<<<<<< HEAD
// angular.module('app').controller('viewReportCtrl', ['$scope', 'getProjects','getReport', 'projectFinderService', 'stateConverterService', 'reportHttp', 'lineItemsHttp', 'getLineItems', 'getCategories','$state', 'savedState', 'submittedState', 'reportHistoryHttp', 'createdState', 'checkUser', '$uibModal',
//   function($scope, getProjects, getReport, projectFinderService, stateConverterService, reportHttp, lineItemsHttp,getLineItems, getCategories, $state, savedState, submittedState, reportHistoryHttp, createdState, checkUser, $uibModal) {
//
//     $scope.report = getReport.data;
//     $scope.projects = getProjects.data;
//     $scope.report.reportname = $scope.report.project.name + " Report ID: " + $scope.report.reportId;
//     $scope.report.name = $scope.report.reportname;
//     $scope.current = checkUser;
//
//     // fetch the history for the report
//     reportHistoryHttp.getReportHistory($scope.report.reportId)
//           .then(function(response){
//             $scope.history = response.data;
//             // iterate through each entry to change actions to the string version, and change the time stamps into dates
//             for(var i = 0; i < $scope.history.length; i++)
//             {
//               $scope.history[i].action = stateConverterService.getString($scope.history[i].action);
//               $scope.history[i].date = getFormattedDate($scope.history[i].timeStamp);
//             }
//           });
//
//     for(var i = 0; i < getLineItems.length; i++)

angular.module('app').controller('viewReportCtrl', ['$scope', 'getProjects','getReport', 'projectFinderService', 'stateConverterService', 'reportHttp', 'lineItemsHttp', 'getLineItems', 'getCategories','$state', 'savedState', 'submittedState', 'reportHistoryHttp', 'createdState', 'checkUser', '$uibModal',
  function($scope, getProjects, getReport, projectFinderService, stateConverterService, reportHttp, lineItemsHttp,getLineItems, getCategories, $state, savedState, submittedState, reportHistoryHttp, createdState, checkUser, $uibModal) {

    $scope.report = getReport.data;
    $scope.projects = getProjects.data;
    $scope.report.reportname = $scope.report.project.name + " Report ID: " + $scope.report.reportId;
    $scope.report.name = $scope.report.reportname;
    $scope.current = checkUser;

    // fetch the history for the report
    reportHistoryHttp.getReportHistory($scope.report.reportId)
          .then(function(response){
            $scope.history = response.data;
            // iterate through each entry to change actions to the string version, and change the time stamps into dates
            for(var i = 0; i < $scope.history.length; i++)
            {
              $scope.history[i].action = stateConverterService.getString($scope.history[i].action);
              $scope.history[i].date = getFormattedDate($scope.history[i].timeStamp);
            }
          });

    for(var i = 0; i < getLineItems.length; i++)
  {
    var tempDate = new Date(getLineItems[i].date);
    tempDate.setDate(tempDate.getDate() + 1); // add one day since the conversion causes it to lose a day
    getLineItems[i].date = tempDate;
  }

    $scope.lineitems = getLineItems;
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
    //  $scope.report.newname = $scope.report.reportname;
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
       /* direct path saved view of the previously submitted report */
    //    $state.go('viewReport' + '/' + $scope.report.reportId);
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


  // openning the modal
  $scope.open = function (lineItemId) {

    // actually opens it
    var modalInstance = $uibModal.open({
      animation: true,
      templateUrl: 'receiptModal.html',
      controller: 'receiptModalCtrl',
      size: 'sm',
      // and passes in the lineItemId
      resolve: {
        lineItemId: lineItemId
      }
    });


    modalInstance.result.then(function() {

    });

    $scope.open = function (lineItemId) {

      var modalInstance = $uibModal.open({
        animation: true,
        templateUrl: 'receiptModal.html',
        controller: 'receiptModalCtrl',
        size: 'sm',
        resolve: {
          lineItemId: lineItemId
        }
      });

      modalInstance.result.then(function() {
        console.log("hi");
      });
    };
};
    // helper function to format timestamp to date
    function getFormattedDate(timestamp) {
      var newDate = new Date();
      newDate.setTime(timestamp);
      return newDate.toUTCString();
    }

  }]);
