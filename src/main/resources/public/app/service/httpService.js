angular.module('app').service('httpService', ['$http', function($http){

<<<<<<< HEAD
  function getReport(reportid) {
    return $http.get('/report/' + reportid);
  }

  function getProjects(){
    return $http.get('/project/get');
  }

  function createProject(data){
    return $http.post('/project/create', data);

  }

  function getProjects() {
    return $http.get('/project/get');
  }

  function createReport(data){
    return $http.post('/report/create', data);
  }

  function putReport(data){
    return $http.put('/report', data);
  }


  function login(loginData){
    return $http.post("/loginPage", loginData);
  }

  function getUsers(){
    return $http.get('/users');
  }
  return {
    getUsers : getUsers,
    getReport : getReport,
    getProjects : getProjects,
    createProject : createProject,
    createReport: createReport,
    putReport: putReport,
    login: login,
  };
=======

    // Gets all users from the database
    function getUsers(){
        return $http.get('/users');
    }

    // Gets all projects from the database
    function getProjects(){
    	return $http.get('/project/get');
    }

    // Creates a new project in the database
    function createProject(data){
        return $http.post('/project/create', data);
    }

    // Creates a new report in the database
    function createReport(data){
    	return $http.post('/report/create', data);
    }

    function login(loginData){
    		return $http.post("/loginPage", loginData);
    }

    //Requests the current users information
    function currentUser(){
        return $http.get('/security/current');
    }

    // The list of all available functions
    return {
        getUsers : getUsers,
        createProject : createProject,
        getProjects: getProjects,
        createReport: createReport,
        login: login,
        currentUser : currentUser
    };


>>>>>>> sprint1
}]);
