angular.module('app', ['$http',
  function($http){

    function login(loginData){
    	return $http.post("/loginPage", loginData);
    }

    //Requests the current users information
    function currentDev(){
        return $http.get('/security/current');
    }

    return {
      login : login,
      currentDev : currentDev
    };
  }]);
