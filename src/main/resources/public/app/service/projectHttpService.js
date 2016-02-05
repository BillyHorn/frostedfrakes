angular.module('app').service('projectHttp',['$http','currentUser',
  function($http, currentUser){

    // local var to hold end point name
    var projectEndPoint = "/project";

    // Gets all projects from the database for the user logged in
    function getProjects(){
      return $http.get(projectEndPoint + '/' + currentUser.getUser().email);
    }

    // Creates a new project in the database
    function createProject(data){
        return $http.post(projectEndPoint, data);
    }

    return {
      getProjects : getProjects,
      createProject : createProject
    };
}]);
