angular
		.module('app')
		.controller(
				'registrationCtrl',
				[
						'$scope',
						'$state',
						'registrationFactory',
						function($scope, $state, registrationFactory) {

							console.log("registrationFactory");

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
														if (sucess.data === '') {
															console.log("duplicate");
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




						}]);
