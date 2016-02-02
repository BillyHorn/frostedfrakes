angular.module('app').service('httpService', ['$http', function($http){

    function getUsers(){
        return $http.get('/users');
    }

    function getProjects(){
    	return $http.get('/project/get');
    }

    function createProject(data){
        return $http.post('/project/create', data);
    }

    function createReport(data){
    	return $http.post('/report/create', data);
    }
    
<<<<<<< HEAD
    /* submit existing report that has been saved */
    function submitReport(data){
    	return $http.post('/report/Submit', data);
    }
    
=======
>>>>>>> sprint1
    return {
        getUsers : getUsers,
        createProject : createProject,
        getProjects: getProjects,
        createReport: createReport,
<<<<<<< HEAD
        submitReport: submitReport
=======
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
    