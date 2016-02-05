angular.module('app').service('devHttp',['$http',
  function($http){
    // Gets all users from the database
    function getUsers(){
      return $http.get('/users');
    }

    return {
      getUsers : getUsers
    };
}]);
