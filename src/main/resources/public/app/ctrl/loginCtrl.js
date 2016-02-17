/**
 * this controller pulls relevant data from login.html and parses together
 * a string to be submitted for authentication, on success the user is
 * taken to the home page
 */

angular.module('app').controller('loginCtrl', ['$scope', '$state', 'loginService',
function($scope, $state, loginService) {

   $scope.login = function(){
     $scope.userLogin = 'username=' + $scope.username + '&password=' + $scope.password;

     loginService.login($scope.userLogin)
        .then(function(acceptResponse){
          console.log("hello");
        },function(response){
          console.log("ERROR MESSAGE: " + response);
     });
   };
 }]);
