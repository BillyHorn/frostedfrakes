angular.module('app').service('httpService', ['$http', function($http){
    function getUsers(){
        return $http.get('/users');
    }
    
        
    return {
        getUsers : getUsers
    };

function login(loginData){
		return $http.post("/loginPage", loginData);
	}

	function getUsers(){
	    return $http.get('/users');
	}
	
	return{
		login: login,
		getUsers : getUsers
	}

}]);
    