angular.module('app').service('httpService', ['$http', function($http){
	function login(loginData){
		return $http.post("/loginPage", loginData);
	}
	
	return{
		login: login
	}
}])