angular.module('app').service('httpService', ['$http', function($http){
    function getUsers(){
        return $http.get('/users');
    }

    function getReport() {
      return $http.get('/report:' + reportid);
    }

    return {
        getUsers : getUsers,
        getReport : getReport
    };
}]);
