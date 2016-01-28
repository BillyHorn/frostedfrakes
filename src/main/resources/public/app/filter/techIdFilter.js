angular.module('app').filter('techIdFilter', function(){
    return function(id, techId){
        console.log(id + " " + techId);
        return ((techId !== id));
    };
});
