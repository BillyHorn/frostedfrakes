<<<<<<< HEAD
angular.module('app').controller('registrationCtrl',	['$scope','$state','registrationFactory',
						function($scope, $state, registrationFactory) {
=======
angular.module('app').controller('registrationCtrl',['$scope','$state','registrationFactory',
function($scope, $state, registrationFactory) {
>>>>>>> sprint1

	$scope.registration = function() {

<<<<<<< HEAD
							$scope.registration = function() {
								$scope.register.role = "dev";
								$scope.register.isactive = true;
								console.log($scope.register);
								console.log("scope.register ");
								if ($scope.register.password == $scope.register.verifypassword) {
									registrationFactory
											.registerCheck($scope.register)
											.then(
													function(sucess) {
														console.log(sucess);
														var message = "";
														if (sucess.data == '') {
															console.log("duplicate")
															$scope.message = "User Name Exists! Please try with different username";
														} else {
															$scope.message = "Regestration Sucess";
														}
													},
													function(error) {
														console.log(error);
													});
								}
								else{
									$scope.message = "Password Verification Failed ";
								}
							};
						}])
=======
		$scope.register.role = "dev";
		$scope.register.isactive = true;

		if ($scope.register.password == $scope.register.verifypassword) {
			$scope.value = true;
			registrationFactory
				.registerCheck($scope.register)
				.then(
					function(sucess) {
						var message = "";
						if (sucess.data == '') {
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
}]);
>>>>>>> sprint1
