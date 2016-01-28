angular.module('app').controller('createProjectCtrl', ['$scope', 'httpService', '$state', function($scope, httpService, $state) {
    $scope.project = {};
	$scope.project.assignedUsers = [];
    $scope.userHolders = [];

    httpService.getUsers().then(function(response){
        console.log(response);
        $scope.project.users = response.data;
    });

    $scope.addUser = function(){
        $scope.project.assignedUsers.push($scope.userToAdd);
        console.log($scope.userToAdd);
        for (i=0; i<$scope.project.users.length; i++) {
            if ($scope.userToAdd.devId !== $scope.project.users[i].devId){
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

}]);
