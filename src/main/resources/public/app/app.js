angular.module('app', ['ui.router']);

<<<<<<< HEAD
angular.module('app').config(['$stateProvider', '$urlRouterProvider',
function($stateProvider, $urlRouterProvider){

    $urlRouterProvider.otherwise('/loginPage');
=======

angular.module('app').config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){


    $urlRouterProvider.otherwise('/home');
>>>>>>> sprint1

    $stateProvider

        .state('home', {
            url: '/home',
            templateUrl: 'views/partials/home.html',
<<<<<<< HEAD
            controller: 'homeCtrl',
            resolve:{
            	login: function(logoutService){
            		logoutService.logoutStatus(true);
            		return logoutService.getLogoutStatus();
            	},
            }
        }).state('loginPage',{
        	url: '/loginPage',
        	templateUrl: 'views/partials/login.html',
        	controller: 'loginCtrl',
        	resolve:{
            	login: function(logoutService){
            		console.log("login page");
            		logoutService.logoutStatus(false);
            		console.log(logoutService.getLogoutStatus());
            		return logoutService.getLogoutStatus();
            	},
            }
=======
            controller: 'homeCtrl'
        })

        .state('createProject', {
            url: '/createProject',
            templateUrl: 'views/partials/createProject.html',
            controller: "createProjectCtrl"
>>>>>>> sprint1
        });

}]);
