angular.module('app').service('projectHttp',['$http',
  function($http){
    // Gets all projects from the database
    function getProjects(){
      return $http.get('/project/get/' + currentUser.getUser().email);
    }

    // Creates a new project in the database
    function createProject(data){
        return $http.post('/project/create', data);
    }

    return {
      getProjects : getProjects,
      createProject : createProject
    };
}]);
