angular.module('app').service('categories', ['$http',
  function($http){
    function getCategories(){
      return $http.get('/categories');
    }

    return {
      getCategories : getCategories
    }
  }]);
