angular.module('app').service('devHttp',['$http',
  function($http){

    // local var to hold end point name
    var devsEndPoint = "/users";
    
    // Gets all users from the database
    function getDevs(){
      return $http.get(devsEndPoint);
    }

    return {
      getDevs : getDevs
    };
}]);
