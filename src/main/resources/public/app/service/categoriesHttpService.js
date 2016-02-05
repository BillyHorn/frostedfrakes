angular.module('app').service('categoriesHttp', ['$http',
  function($http){

    // local var to hold end point name
    var categoriesEndPoint = "/categories";

    function getCategories(){
      return $http.get(categoriesEndPoint);
    }

    return {
      getCategories : getCategories
    }
  }]);
