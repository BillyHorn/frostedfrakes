// this service is for... exactly what you think it is for...
angular.module('app').service('fileUpload', ['$http', '$state', function ($http, $state) {

  this.uploadFileToUrl = function(file, receiptName, lineItemId){
    var fd = new FormData();
    fd.append('file', file);
    $http.post('/addReceipt?name=' + receiptName + '&lineItemId=' + lineItemId, fd, {
      transformRequest: angular.identity,
      headers: {'Content-Type': undefined}
    })
    .success(function(){
      $state.reload();
    })
    .error(function(){

    });
  };
}]);
