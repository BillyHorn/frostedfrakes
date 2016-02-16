angular.module('app').controller('navCtrl', ['$scope', 'currentUser', 'loginService', '$state', function($scope, currentUser, loginService, $state) {

    loginService.currentDev().then(function(response){
        currentUser.setUser(response.data);
        $scope.currentUser = response.data;
    });
    $scope.currentUser = {};
    $scope.currentUser.role="user";

    $scope.logout = function() {
        currentUser.setUser({});
        $state.go("logout");
    };

    $scope.admin = function() {
        if ($scope.currentUser.role === 'admin'){
            return true;
        } else {
            return false;
        }
    };
}]);
