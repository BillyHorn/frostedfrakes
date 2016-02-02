angular.module('app').controller('homeCtrl', ['$scope', 'currentUser', function($scope, currentUser) {



    $scope.admin = function() {
        
        $scope.currentUser = currentUser.getUser();

        console.log($scope.currentUser.role);

        if ($scope.currentUser.role === 'admin'){
            return true;
        } else {
            return false;
        }
    };


}]);
