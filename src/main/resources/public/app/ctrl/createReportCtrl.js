angular.module('app').controller('createReportCtrl', ['$scope', function($scope) {
    $scope.nameExists = function(name) {
        return false;
    };
}]);
