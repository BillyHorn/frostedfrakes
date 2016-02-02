angular.module('app').service('httpService', ['$http', function($http){

    function getUsers(){
        return $http.get('/users');
    }

<<<<<<< HEAD

    function getReport() {
      return $http.get('/report:' + reportid);
    }
=======
    function getProjects(){
    	return $http.get('/project/get');
    }

>>>>>>> sprint1
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
<<<<<<< HEAD
        getReport : getReport,
        createProject : createProject,
        getProjects : getProjects
=======
        createProject : createProject,
        getProjects: getProjects,
        createReport: createReport,
        login: login,
		getUsers : getUsers
>>>>>>> sprint1
    };

function login(loginData){
		return $http.post("/loginPage", loginData);
	}

	function getUsers(){
	    return $http.get('/users');
	}
}]);
    