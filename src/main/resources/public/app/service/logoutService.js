angular.module('app').service('logoutService', function(){

	var logoutLink;
	
	function logoutState(state){
		logoutLink = state;
	}
	
	function getLogout(){
		return logoutLink;
	}
	
	return {
		logoutStatus: logoutState,
		getLogoutStatus: getLogout
	};
	
});