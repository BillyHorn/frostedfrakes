angular.module('app').service('fileUpload', ['$http', function ($http) {

  this.uploadFileToUrl = function(file, receiptName, lineItemId){
    var fd = new FormData();
    fd.append('file', file);
    $http.post('/addReceipt?name=' + receiptName + '&lineItemId=' + lineItemId, fd, {
      transformRequest: angular.identity,
      headers: {'Content-Type': undefined}
    })
    .success(function(){
      
    })
    .error(function(){

    });
  };
}]);
