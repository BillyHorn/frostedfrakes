angular.module('app').service('httpService', ['$http', function($http){
    function getUsers(){
        return $http.get('/users');
    }

<<<<<<< HEAD
    function getReport() {
      return $http.get('/report:' + reportid);
=======
    function createProject(data){
        return $http.post('/project/create', data);
>>>>>>> EFF-7
    }

    return {
        getUsers : getUsers,
<<<<<<< HEAD
        getReport : getReport
=======
        createProject : createProject
>>>>>>> EFF-7
    };
}]);
