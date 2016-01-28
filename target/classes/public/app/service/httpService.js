angular.module('app').service('httpService', ['$http', function($http){
    function getUsers(){
        return $http.get('/users');
    }

<<<<<<< HEAD
    return {
        getUsers : getUsers
=======
    function createProject(data){
        return $http.post('/project/create', data);
    }

    return {
        getUsers : getUsers,
        createProject : createProject
>>>>>>> c55cd04e45f9d2ad9c1a9c5ee0caaec9ab7dfd1a
    };
}]);
