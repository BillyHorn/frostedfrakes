angular.module('app').controller('registrationCtrl',['$scope','$state','registrationFactory',
function($scope, $state, registrationFactory) {

	console.log("registrationFactory");

	$scope.registration = function() {
		
		$scope.register.role = "dev";
		$scope.register.isactive = true;
		console.log($scope.register);
		console.log("scope.register ");
		
		if ($scope.register.password == $scope.register.verifypassword) {
			$scope.value = true;
			registrationFactory
				.registerCheck($scope.register)
				.then(
					function(sucess) {
						console.log(sucess);
						var message = "";
						if (sucess.data == '') {
							console.log("duplicate")
							$scope.alert = "alert alert-warning";
							$scope.type = "Warning: ";
							$scope.message = "Username Already Exists!";
						} else {
							$scope.value = true;
							$scope.type = "Success: ";
							$scope.alert = "alert alert-success";
							$scope.message = "Regestration Success!";
						}
					},
					function(error) {
						console.log(error);
					});
		}
		else{
			$scope.value = true;
			$scope.type = "Error: ";
			$scope.alert = "alert alert-danger";
			$scope.message = "Passwords Don't Match!";
		}
	};
}])