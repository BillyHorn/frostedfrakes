angular.module('app').controller('receiptModalCtrl', ['$http', '$scope', '$uibModalInstance', 'fileUpload', 'lineItemId', 'fileReader', function($http, $scope, $uibModalInstance, fileUpload, lineItemId, fileReader){

  $scope.ok = function(receiptName){
    var file = $scope.myFile;
    var fileName = file.name.toLowerCase();
    var fileNameLength = fileName.length;
    var lastFourCharOfFileName = fileName.substring(fileNameLength-4, fileNameLength);

    if (lastFourCharOfFileName == ".jpg") {
      fileUpload.uploadFileToUrl(file, receiptName, lineItemId);
      $uibModalInstance.close();
    } else {
      alert("sorry, only JPG files are supported right now.");
    }
    // pass something in here with the commented result.then in viewReportCtrl

  };

  $scope.cancel = function () {
    $uibModalInstance.dismiss('cancel');
  };


  $scope.$on("fileProgress", function(e, progress) {
    $scope.progress = progress.loaded / progress.total;
  });

  $scope.getFile = function () {
    $scope.progress = 0;

    fileReader.readAsDataUrl($scope.file, $scope)
    .then(function(result) {
      $scope.imageSrc = result;
    });
  };


}]);



angular.module('app').service('fileReader', ['$q', '$log', function($q, $log) {

  var onLoad = function(reader, deferred, scope) {
      return function () {
          scope.$apply(function () {
              deferred.resolve(reader.result);
          });
      };
  };

  var onError = function (reader, deferred, scope) {
      return function () {
          scope.$apply(function () {
              deferred.reject(reader.result);
          });
      };
  };

  var onProgress = function(reader, scope) {
      return function (event) {
          scope.$broadcast("fileProgress",
              {
                  total: event.total,
                  loaded: event.loaded
              });
      };
  };

  var getReader = function(deferred, scope) {
      var reader = new FileReader();
      reader.onload = onLoad(reader, deferred, scope);
      reader.onerror = onError(reader, deferred, scope);
      reader.onprogress = onProgress(reader, scope);
      return reader;
  };

  var readAsDataURL = function (file, scope) {
      var deferred = $q.defer();

      var reader = getReader(deferred, scope);
      reader.readAsDataURL(file);

      return deferred.promise;
  };

  return {
      readAsDataUrl: readAsDataURL
  };
}]);
