angular.module('app').service('httpService', ['$http', function($http){
    function getUsers(){
        return $http.get('/users');
    }


    function getReport() {
      return $http.get('/report:' + reportid);
    }
    function createProject(data){
        return $http.post('/project/create', data);

    }

    function getProjects() {
      return $http.get('/project/get');
    }

    return {
        getUsers : getUsers,
        getReport : getReport,
        createProject : createProject,
        getProjects : getProjects
    };
}]);
