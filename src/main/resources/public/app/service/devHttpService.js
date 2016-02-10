angular.module('app').service('devHttp',['$http',
  function($http){

    // local var to hold end point name
    var devsEndPoint = "/users";
    
    // Gets all users from the database
    function getDevs(){
    	return $http.get(devsEndPoint);
    }
    
    function totpCode(totpCode){
    	return $http.post("/totpAuthentication", totpCode);
    }

    return {
    	getDevs : getDevs,
    	totpCode: totpCode
    };
}]);
