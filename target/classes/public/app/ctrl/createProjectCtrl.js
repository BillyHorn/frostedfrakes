<<<<<<< HEAD
angular.module('app').controller('createProjectCtrl', ['$scope', function($scope) {
    $scope.assignedUsers = [];
    
=======
angular.module('app').controller('createProjectCtrl', ['$scope', 'httpService', '$state', function($scope, httpService, $state) {
    $scope.project.assignedUsers = [];
    $scope.userHolders = [];

    httpService.getUsers().then(function(response){
        console.log(response);
        $scope.project.users = response.data;
    });

    $scope.addUser = function(){
        $scope.project.assignedUsers.push($scope.userList);
        for (i=0; i<$scope.project.users.length; i++) {
            if ($scope.userList.devid !== $scope.project.users[i].devid){
                $scope.userHolders.push($scope.project.users[i]);
            }
        }
        $scope.project.users = $scope.userHolders;
        $scope.userHolders = [];
    };

    $scope.createProject = function(){
        httpService.createProject($scope.project).then(function(){
            $state.go('home');
        }, function(response){
            console.log(response);
        });
    };

>>>>>>> c55cd04e45f9d2ad9c1a9c5ee0caaec9ab7dfd1a
}]);
