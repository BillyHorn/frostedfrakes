angular.module('app').service('currentUser', ['loginService', '$q', function(loginService, $q){
    var user = null;

    function getUser(){
        return this.user;
    }

    function setUser(user){
        this.user = user;
    }

    function validateUser(){
        if (this.user === undefined) {
            loginService.currentDev().then(function(response){
                this.user = response.data;
                if(this.user.isvalid === false) {
                    window.location.href="/logout";
                }
            });
        }
        else if (this.user.isvalid === false) {
            window.location.href="/logout";
        }
        return $q.defer();

    }

    return {
        getUser : getUser,
        setUser : setUser,
        validateUser : validateUser
    };


}]);
