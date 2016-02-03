angular.module('app').run(function($rootScope) {
  $rootScope.$on('$stateChangeError', function(event, toState, toParams, fromState, fromParams, error){
    console.log("STATE CHANGE ERROR");
    console.log(error);
  });
});
