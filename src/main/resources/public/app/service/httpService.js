angular.module('app').service('httpService', ['$http', function($http){
	
    function getUsers(){
        return $http.get('/users');
    }
    
    function getProjects(){
    	return $http.get('/projects');
    }

    function createProject(data){
        return $http.post('/project/create', data);
    }
    
    function createReport(data){
    	return $http.post('/project/createReport', data);
    }
    
    return {
        getUsers : getUsers,
        createProject : createProject,
        getProjects: getProjects
    };
      
}]);
