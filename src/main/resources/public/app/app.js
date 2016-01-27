angular.module('app', ['ui.router']);

angular.module('app').config(function($stateProvider){

    $urlRouterProvider.otherwise('/home');

    $stateProvider

        .state('home', {
            url: '/',
            templateUrl: '/partials/home/home.html',
            controller: 'homeCtrl'
        });

});
