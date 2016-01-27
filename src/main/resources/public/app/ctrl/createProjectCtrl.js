angular.module('app').controller('createProjectCtrl', ['$scope', 'httpService', function($scope, httpService) {
    $scope.assignedUsers = [];
    $scope.userHolders = [];

    httpService.getUsers().then(function(response){
        console.log(response);
        $scope.users = response.data;
    });

    $scope.addUser = function(){
        $scope.assignedUsers.push($scope.userList);
        for (i=0; i<$scope.users.length; i++) {
            if ($scope.userList.id !== $scope.users[i].id){
                $scope.userHolders.push($scope.users[i]);
            }
        }
        $scope.users = $scope.userHolders;
        $scope.userHolders = [];
    };

}]);
