angular.module('app').controller('receiptModalCtrl', ['$http', '$scope', '$uibModalInstance', 'fileUpload', 'lineItemId', 'fileReader', function($http, $scope, $uibModalInstance, fileUpload, lineItemId, fileReader){

  // on close modal
  $scope.ok = function(receiptName){
    // grab that file
    var file = $scope.myFile;
    // and its name
    var fileName = file.name.toLowerCase();
    // and the length of said name...
    var fileNameLength = fileName.length;
    /* and then pull out the last 4 characters of that name. you'll understand
       in a minute, I promise. */
    var lastFourCharOfFileName = fileName.substring(fileNameLength-4, fileNameLength);
    // and a regex to check against special characters
    var patt = new RegExp("^[a-zA-Z0-9äöüÄÖÜ ]*$");

    // check to see if the filename ends in ".jpg". I told you you'd understand.
    if (lastFourCharOfFileName == ".jpg") {
      // if it IS a jpg, make sure the name is good.
      if(patt.test(receiptName)) {
      // if it is, then upload it, and close the modal
      fileUpload.uploadFileToUrl(file, receiptName, lineItemId);
      $uibModalInstance.close();
    } else {
      alert("sorry, please don't use special characters in your receipt name");
    }
    } else {
      // if not, complain.
      alert("sorry, only JPG files are supported right now.");
    }
    /* if you wanted, you could pass something in here with the commented
      found in result.then in viewReportCtrl */
  };

  // if you click cancel, the modal closes.
  $scope.cancel = function () {
    $uibModalInstance.dismiss('cancel');
  };

  // this is for a progress bar. not used yet, but good to have in case.
  $scope.$on("fileProgress", function(e, progress) {
    $scope.progress = progress.loaded / progress.total;
  });

  // this method is for displaying images prior to upload.
  $scope.getFile = function () {
    $scope.progress = 0;

    fileReader.readAsDataUrl($scope.file, $scope)
    .then(function(result) {
      $scope.imageSrc = result;
    });
  };
}]);
