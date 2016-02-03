angular.module('app').controller('navCtrl', ['$scope', 'currentUser', 'httpService', '$state', function($scope, currentUser, httpService, $state) {

    httpService.currentUser().then(function(response){
        currentUser.setUser(response.data);
    });

    $scope.logout = function() {
        currentUser.setUser({});
        $state.go("logout");
    };



}]);
