angular.module('app').controller('createProjectCtrl', ['$scope', 'httpService', '$state', function($scope, httpService, $state) {
    $scope.project = {};
	$scope.project.devsToConvert = [];
    $scope.userHolders = [];

    httpService.getUsers().then(function(response){
        console.log(response);
        $scope.users = response.data;
        //$scope.project.users.unshift({email : "Select a User"});
    });

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
