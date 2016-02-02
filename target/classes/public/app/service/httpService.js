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
    
    /* submit existing report that has been saved */
    function submitReport(data){
    	return $http.post('/report/Submit', data);
    }
    
    return {
        getUsers : getUsers,
        createProject : createProject,
        getProjects: getProjects,
        createReport: createReport,
        submitReport: submitReport
    };

}]);
