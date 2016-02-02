angular.module('app').service('httpService', ['$http', function($http){

    function getUsers(){
        return $http.get('/users');
    }

    function getReport() {
      return $http.get('/report:' + reportid);
    }

    function getProjects(){
    	return $http.get('/project/get');
    }

    function createProject(data){
        return $http.post('/project/create', data);

    }

    function getProjects() {
      return $http.get('/project/get');
    }

    function createReport(data){
    	return $http.post('/report/create', data);
    }

    return {
        getUsers : getUsers,
        getReport : getReport,
        getProjects : getProjects
        createProject : createProject,
        createReport: createReport,
        login: login,
    };

function login(loginData){
		return $http.post("/loginPage", loginData);
	}

	function getUsers(){
	    return $http.get('/users');
	}
}]);
