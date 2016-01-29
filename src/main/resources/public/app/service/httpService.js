angular.module('app').service('httpService', ['$http', function($http){
    function getUsers(){
        return $http.get('/users');
    }

    function createProject(data){
        return $http.post('/project/create', data);
    }

    return {
        getUsers : getUsers,
        createProject : createProject
    };
}]);
