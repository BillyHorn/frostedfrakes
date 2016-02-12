angular.module('app').controller('totpAuthCtrl', ['$scope', 'devHttp', 'currentUser', 'loginService', '$state', function($scope, devHttp, currentUser, loginService, $state ){

	$scope.totp = function(){
		console.log("anything");
		devHttp.totpCode($scope.totpCode).then(function(response){
	    	window.location.href="/";
	    }, function(response){
			$scope.error=" Invalid code / Code timed out.";
			$scope.totpCode="";
	    });
	};

	$scope.logout = function() {
		$state.go("logout");
	};

	window.onbeforeunload = function(event){
		if (currentUser.getUser() === undefined) {
            loginService.currentDev().then(function(response){
                currentUser.setUser(response.data);
                if(currentUser.getUser().isvalid === false) {
                    window.location.href="/logout";
                }
            });
        }
        else if (currentUser.getUser().isvalid === false) {
            window.location.href="/logout";
        }
        return;
	};

	$scope.$on('$destroy', function() {
	    delete window.onbeforeunload;
	});


	// $rootScope.$on('$locationChangeStart', function(event){
	// 	console.log($location);
	//     event.preventDefault();
	// 	//currentUser.validateUser();
	//     // transitionTo() promise will be rejected with
	//     // a 'transition prevented' error
	// });


 }]);
