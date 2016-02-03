angular.module('app').controller('homeCtrl', ['$scope', 'currentUser', function($scope, currentUser) {

    $scope.admin = function() {
        $scope.currentUser = currentUser.getUser();
        if ($scope.currentUser.role === 'admin'){
            return true;
        } else {
            return false;
        }
    };

}]);
