angular.module('app').service('httpService', ['$http', function($http){

    // Gets all users from the database
    function getUsers(){
        return $http.get('/users');
    }

    // Creates a new project in the databse
    function createProject(data){
        return $http.post('/project/create', data);
    }

    // The list of all available functions
    return {
        getUsers : getUsers,
        createProject : createProject
    };
}]);
