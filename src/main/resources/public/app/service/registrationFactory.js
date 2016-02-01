angular.module('app').service('registrationFactory',['$http',function($http){
	
	return {
		registerCheck: function(register){
			return $http.post('/register', register);
		}
	}

}]);