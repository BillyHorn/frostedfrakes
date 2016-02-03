/**
 * takes an array of existing projects, and a project id and returns the index of the id in the array
 */
 angular.module('app').service('projectFinderService', function(){
   function getIndex(projects, id) {
     for(var i = 0; i < projects.length; i++) {
       if(projects[i].projectId == id)
       {

         return i;
       }
     }
   }
   return {
     getIndex : getIndex
   }
 })
