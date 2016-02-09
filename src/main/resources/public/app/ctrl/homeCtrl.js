angular.module('app').controller('homeCtrl', ['$scope', 'getProjects','getReport', 'projectFinderService', 'stateConverterService', 'reportHttp', 'lineItemsHttp', 'getLineItems', 'getCategories','$state', 'savedState', 'submittedState',
  function($scope, getProjects, getReport, projectFinderService, stateConverterService, reportHttp, lineItemsHttp,getLineItems, getCategories, $state, savedState, submittedState) {


	$scope.report = getReport.data;


}]);
