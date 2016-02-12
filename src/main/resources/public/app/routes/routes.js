angular.module('app').config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){

  // redirect from the base myreports state so that only child-states exist
  $urlRouterProvider.when('/my-reports', '/my-reports/saved');


  // and anything other than a state can send you back to home.
  //$urlRouterProvider.otherwise('/home');

  $urlRouterProvider.otherwise(function($injector, $location){
     var $state = $injector.get("$state");
     var currentUser = $injector.get("currentUser");
     if ($location.absUrl() !== "http://localhost:8080/totpAuthentication"){
         $state.go("home");
     }
     else if ($location.absUrl() === "http://localhost:8080/" && currentUser.getUser() === undefined){
         console.log(currentUser.getUser());
         console.log($location.absUrl());
         window.location.href="/logout";
     }
     else {
         $state.go("totpAuthentication");
     }
  });

  // states for each necessary route
  $stateProvider

  .state('home', {
    url: '/home',
    templateUrl: 'views/partials/home.html',
    controller: 'homeCtrl'
  })

  .state('totpAuthentication', {
    url:"/totpAuthentication",
    templateUrl: 'views/partials/totpPartial.html',
    controller: 'totpAuthCtrl'
  })

  .state('registration', {
    url: '/registration',
    templateUrl: 'views/partials/registration.html',
    controller: "registrationCtrl"
  })

    .state('logout', {
    url: '/logout',
    controller: function() {
        window.location.href="/logout";
    }
  })

  .state('create-report', {
    url: '/create-report',
    templateUrl: 'views/partials/create-report.html',
    controller: 'createReportCtrl'
  })

  .state('viewReport', {
    url: '/viewReport/:reportid',
    templateUrl: 'views/partials/viewReport.html',
    controller: "viewReportCtrl", // TODO going to want resolve to do get request @mKness
    resolve: {
      getProjects: ['projectHttp',function(projectHttp) {
        return projectHttp.getProjects();
      }],
      getReport: ['reportHttp','$stateParams',function(reportHttp,$stateParams) {
        return reportHttp.getReport($stateParams.reportid);
      }],
      getLineItems: ['lineItemsHttp','$stateParams', function(lineItemsHttp,$stateParams){
        return lineItemsHttp.getLineItems($stateParams.reportid);
      }],
      getCategories: ['categoriesHttp', function(categoriesHttp){
        return categoriesHttp.getCategories();
      }]
    }
  })

  .state('create-project', {
    url: '/create-project',
    templateUrl: 'views/partials/create-project.html',
    controller: "createProjectCtrl"
});
}]);
