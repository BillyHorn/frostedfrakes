angular.module('app').run(function($rootScope) {
  $rootScope.$on('$stateChangeError', console.log.bind(console));
});
