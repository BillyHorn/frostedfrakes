angular.module('app', ['ui.router']);


angular.module('app').config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){


    $urlRouterProvider.otherwise('/home');

    $stateProvider

        .state('home', {
            url: '/home',
            templateUrl: 'views/partials/home.html',
            controller: 'homeCtrl'
        });

}]);
