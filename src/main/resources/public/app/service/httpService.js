angular.module('app').service('httpService', ['$http', 'currentUser', function($http, currentUser){


    // Gets all users from the database
    function getUsers(){
        return $http.get('/users');
    }

    // Gets all projects from the database
    function getProjects(){
    	return $http.get('/project/get/' + currentUser.getUser().email);
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
    
    function pendingReports(devId){
    	return $http.get("/pendingReports/" + devId);
    }

    //Requests the current users information
    function currentDev(){
        return $http.get('/security/current');
    }
    
    //Change state of report in backend to accepted (4)
    function approveReport(report) {
    	report.state = 4;
    	return $http.put('/report/update', report);
    }
    
    //Change state of report in backend to rejected (3)
    function rejectReport(report) {
    	report.state = 3;
    	return $http.put('/report/update', report);
    }

    // The list of all available functions
    return {
        getUsers : getUsers,
        createProject : createProject,
        getProjects: getProjects,
        createReport: createReport,
        login: login,
        pendingReports : pendingReports,
        currentUser : currentDev,
        approveReport : approveReport,
        rejectReport : rejectReport
    };


}]);
