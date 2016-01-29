angular.module('app', ['ui.router', 'mgcrea.ngStrap']);


angular.module('app').config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){


  $urlRouterProvider.otherwise('/home');

  $stateProvider

  .state('home', {
    url: '/home',
    templateUrl: 'views/partials/home.html',
    controller: 'homeCtrl'
  })

  .state('create-report', {
    url: '/create',
    templateUrl: 'views/partials/report/create-report.html',
    controller: 'createReportCtrl'
  })

  .state('createProject', {
    url: '/createProject',
    templateUrl: 'views/partials/createProject.html',
    controller: "createProjectCtrl"
  })

  .state('myReports', {
    url: '/myReports',
    templateUrl: 'views/partials/myReports/myReports.html',
    controller: "myReportsCtrl"
  })
      // sub-routes
      .state('myReports.saved', {
        url: '/saved',
        templateUrl: 'views/partials/myReports/viewReports.html',
        controller: 'myReportsCtrl'
      })

      .state('myReports.submitted', {
        url: '/submitted',
        templateUrl: 'views/partials/myReports/viewReports.html',
        controller: 'myReportsCtrl'
      })

      .state('myReports.approved', {
        url: '/approved',
        templateUrl: 'views/partials/myReports/viewReports.html',
        controller: 'myReportsCtrl'
      })

      .state('myReports.rejected', {
        url: '/rejected',
        templateUrl: 'views/partials/myReports/viewReports.html',
        controller: 'myReportsCtrl'
      });

}]);
