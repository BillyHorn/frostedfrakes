angular.module('app', ['ui.router']);

angular.module('app').config(['$stateProvider', '$urlRouterProvider',
function($stateProvider, $urlRouterProvider){

    $urlRouterProvider.otherwise('/loginPage');

    $stateProvider

        .state('home', {
            url: '/home',
            templateUrl: 'views/partials/home.html',
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
        });

}]);
