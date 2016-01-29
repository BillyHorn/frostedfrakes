angular.module('app').controller('createProjectCtrl', ['$scope', 'httpService', '$state', function($scope, httpService, $state) {
   
	$scope.project = {};
	$scope.project.assignedUsers = [];
    $scope.userHolders = [];

    httpService.getUsers().then(function(response){
        console.log(response);
        $scope.project.users = response.data;
        $scope.project.users.unshift({email : "Select a User"});
        //$scope.project.techLeadId = $scope.project.users[0];
        //$scope.project.userToAdd = $scope.project.users[0];
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

    $scope.addTech = function() {
        console.log("This is my tech lead: " + $scope.techlead.email);
        $scope.project.techLeadId = $scope.techlead;
    };

    $scope.createProject = function(){
        console.log($scope.project);
        httpService.createProject($scope.project).then(function(){
            $state.go('home');
        }, function(response){
            console.log(response);
        });
    };

    $scope.filterId = function($user){
        if ($scope.project.techLeadId === undefined) {
            return true;
        }
        return $scope.project.techLeadId.devId !== $user.devId;
    };

}]);
