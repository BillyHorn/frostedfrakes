angular.module('app').service('httpService', ['$http', function($http){
    function getUsers(){
        return $http.get('/users');
    }
    
    
    
    return {
        getUsers : getUsers
    };
}]);
