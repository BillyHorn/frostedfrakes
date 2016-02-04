angular.module('app').controller('createProjectCtrl', ['$scope', 'httpService', '$state', function($scope, httpService, $state) {


    $scope.project = {};
	$scope.project.devsToConvert = [];

    $scope.userHolders = [];

    // Gets a list of all users from the database.
    httpService.getUsers().then(function(response){
        $scope.users = response.data;
    });

    // Adds a dev from the list of users to the list of assigned users
    $scope.addUser = function(){
        $scope.project.devsToConvert.push($scope.userToAdd);
        console.log($scope.userToAdd);
        for (i=0; i<$scope.users.length; i++) {
            if ($scope.userToAdd.devId !== $scope.users[i].devId){
                $scope.userHolders.push($scope.users[i]);
            }
        }
        $scope.users = $scope.userHolders;
        $scope.userHolders = [];
    };

    // Creates a new project by sending $scope.project to the httpService
    $scope.createProject = function(){
        console.log($scope.project);
        httpService.createProject($scope.project).then(function(){
            $state.go('home');
        }, function(response){
            console.log(response);
        });
    };

    // Filters our the current selected techlead user from the list of available
    // users
    $scope.filterId = function($user){
        if ($scope.project.techLeadId === undefined) {
            return true;
        }
        return $scope.project.techLeadId.devId !== $user.devId;
    };

    $scope.notAdmin = function($user) {
        if ($user.role == 'admin'){
            return false;
        }
        else {
            return true;
        }
    };

}]);
