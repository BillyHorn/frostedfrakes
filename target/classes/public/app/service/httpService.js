angular.module('app').service('httpService', ['$http', 'currentUser', function($http, currentUser){


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
    return $http.get('/project/get/' + currentUser.getUser().email);
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
  //Requests the current users information
  function currentDev(){
      return $http.get('/security/current');
  }

  function getLineItems(reportid) {
    return $http.get('/lineitems/' + reportid);
  }

  function putLineItem(lineItem) {
    return $http.put('/lineitems', lineItem);
  }

  function getCategories(){
    return $http.get('/categories');
  }
  return {
    getUsers : getUsers,
    getReport : getReport,
    getProjects : getProjects,
    createProject : createProject,
    createReport: createReport,
    putReport: putReport,
    login: login,
    currentUser : currentDev,
    getLineItems : getLineItems,
    putLineItem : putLineItem,
    getCategories : getCategories
  };
}]);
