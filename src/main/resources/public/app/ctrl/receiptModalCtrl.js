angular.module('app').controller('receiptModalCtrl', ['$scope', '$uibModalInstance', 'fileUpload', 'lineItemId', function($scope, $uibModalInstance, fileUpload, lineItemId){

  $scope.ok = function(receiptName){
    var file = $scope.myFile;
    fileUpload.uploadFileToUrl(file, receiptName, lineItemId);
    $uibModalInstance.close();
    // pass something in here with the commented result.then in viewReportCtrl
  };

  $scope.cancel = function () {
    $uibModalInstance.dismiss('cancel');
  };

}]);
