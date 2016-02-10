// angular.module('app').controller('homeCtrl', ['$scope', 'currentUser', function($scope, currentUser) {
//
//
//
// }]);

angular.module('app').directive('fileModel', ['$parse', function ($parse) {
  return {
    restrict: 'A',
    link: function(scope, element, attrs) {
      var model = $parse(attrs.fileModel);
      var modelSetter = model.assign;

      element.bind('change', function(){
        scope.$apply(function(){
          modelSetter(scope, element[0].files[0]);
        });
      });
    }
  };
}]);

angular.module('app').service('fileUpload', ['$http', function ($http) {
  this.uploadFileToUrl = function(file){
    var fd = new FormData();
    fd.append('file', file);
    $http.post('/addReceipt', fd, {
      transformRequest: angular.identity,
      headers: {'Content-Type': undefined}
    })
    .success(function(){
      console.log("success");
    })
    .error(function(){
    });
  };
}]);

angular.module('app').service('fileDownload', ['$http', function($http) {
  this.downloadFile = function() {
    return $http.get('/getReceipt').then(function(response){
      return response.data;
    });
  };
}]);

angular.module('app').controller('homeCtrl', ['$scope', 'fileUpload', 'fileDownload', function($scope, fileUpload, fileDownload){

  $scope.uploadFile = function(){
    var file = $scope.myFile;
    console.log('file is ' );
    console.dir(file);
    fileUpload.uploadFileToUrl(file);
  };

  $scope.showImage = function(){
    fileDownload.downloadFile().then(function(data){
      $scope.imageData = data;
    });

  };


}]);
