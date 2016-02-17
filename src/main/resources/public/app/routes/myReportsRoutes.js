angular.module('app').config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){

  $stateProvider

  .state('my-reports', {
    url: '/my-reports',
    templateUrl: 'views/partials/my-reports/my-reports.html',
    controller: "myReportsCtrl",
    resolve :{
        checkUser: ['currentUser', 'loginService', function(currentUser, loginService){
                return loginService.currentDev().then(function(response){
                    if (currentUser.getUser() === undefined) {
                        currentUser.setUser(response.data);
                        if(currentUser.getUser().isvalid === false) {
                            window.location.href="/logout";
                        }
                    }
                    else if (currentUser.getUser().isvalid === false) {
                        window.location.href="/logout";
                    }
                    else {
                        return currentUser.getUser();
                    }
                });
            }]
    }
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
      })
      
      .state('my-reports.previouslyReviewed', {
          url: '/previouslyReviewed',
          templateUrl: 'views/partials/my-reports/previouslyReviewed.html',
          controller: 'previouslyReviewedCtrl'
        });
}]);
