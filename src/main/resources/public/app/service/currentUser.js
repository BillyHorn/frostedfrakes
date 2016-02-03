angular.module('app').service('currentUser', function(){
    var user = {};

    function getUser(){
        return this.user;
    }

    function setUser(user){
        this.user = user;
    }

    return {
        getUser : getUser,
        setUser : setUser
    };


});
