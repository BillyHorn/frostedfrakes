
angular.module('app', ['ui.router']);

angular.module('app').config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){


    $urlRouterProvider.otherwise('/home');

    $stateProvider

        .state('home', {
            url: '/home',
            templateUrl: 'views/partials/home.html',
            controller: 'homeCtrl',
            // resolve: {
            //     userRole: ['currentUser','httpService', function(currentUser, httpService){
            //         httpService.currentUser().then(function(response){
            //             currentUser.setUser(response.data);
            //         });
            //         return currentUser.getUser();
            //     }]
            // }
        })

        .state('createProject', {
            url: '/createProject',
            templateUrl: 'views/partials/createProject.html',
            controller: "createProjectCtrl"
        })

        .state('registration', {
            url: '/registration',
            templateUrl: 'views/partials/registration.html',
            controller: "registrationCtrl"
        })

        .state('createReport', {
    		url: '/createReport',
    		templateUrl: 'views/partials/createReport.html',
    		controller: "createReportCtrl"
    	})

        .state('logout', {
    		url: '/logout',
    		controller: function($scope, $route) {
    			$route.reload();
    		}
    	});

}]);
