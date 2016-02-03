angular.module('app', ['ui.router', 'ui.bootstrap']);

angular.module('app').config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){

  // redirect from the base myreports state so that only child-states exist
  $urlRouterProvider.when('/my-reports', '/my-reports/saved');

  // and anything other than a state can send you back to home.
  $urlRouterProvider.otherwise('/home');

  // states for each necessary route
  $stateProvider

  .state('home', {
    url: '/home',
    templateUrl: 'views/partials/home.html',
    controller: 'homeCtrl'
  })

  .state('registration', {
    url: '/registration',
    templateUrl: 'views/partials/registration.html',
    controller: "registrationCtrl"
  })

    .state('logout', {
    url: '/logout',
    controller: function($scope, $route) {
      $route.reload();
    }
  })

  .state('create-report', {
    url: '/create-report',
    templateUrl: 'views/partials/create-report.html',
    controller: 'createReportCtrl'
  })

  .state('create-project', {
    url: '/create-project',
    templateUrl: 'views/partials/create-project.html',
    controller: "createProjectCtrl"
  })

  .state('my-reports', {
    url: '/my-reports',
    templateUrl: 'views/partials/my-reports/my-reports.html',
    controller: "myReportsCtrl"
  })

      // sub-routes
      .state('my-reports.saved', {
        url: '/saved',
        templateUrl: 'views/partials/my-reports/view-reports.html',
        controller: 'myReportsCtrl'
      })

      .state('my-reports.submitted', {
        url: '/submitted',
        templateUrl: 'views/partials/my-reports/view-reports.html',
        controller: 'myReportsCtrl'
      })

      .state('my-reports.approved', {
        url: '/approved',
        templateUrl: 'views/partials/my-reports/view-reports.html',
        controller: 'myReportsCtrl'
      })

      .state('my-reports.rejected', {
        url: '/rejected',
        templateUrl: 'views/partials/my-reports/view-reports.html',
        controller: 'myReportsCtrl'
      })

      .state('my-reports.submitted-to-me', {
        url: '/submitted-to-me',
        templateUrl: 'views/partials/my-reports/submitted-to-me.html',
        controller: 'submittedToMeCtrl'
      });

}]);
