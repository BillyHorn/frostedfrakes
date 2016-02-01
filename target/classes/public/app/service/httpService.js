angular.module('app').service('httpService', ['$http', function($http){
    function getUsers(){
        return $http.get('/users');
    }

<<<<<<< HEAD

    function getReport() {
      return $http.get('/report:' + reportid);

=======
>>>>>>> EFF-7
    function createProject(data){
        return $http.post('/project/create', data);

    }

    return {
        getUsers : getUsers,
        getReport : getReport
        createProject : createProject
<<<<<<< HEAD

=======
>>>>>>> EFF-7
    };
}]);
