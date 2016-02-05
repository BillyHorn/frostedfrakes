/**
 * service for converting between string and number report states
 * if parameter is number return corresponding string and vis versa
 *  1 - saved
 *  2 - submitted
 *  3 - rejected
 *  4 - approved
 */

angular.module('app').service('stateConverterService', ['savedState','submittedState','rejectedState','approvedState',
 function(savedState, submittedState, rejectedState, approvedState){

  function getString(number) {
    if(number == savedState) {
      return "saved";
    }
    if(number == submittedState) {
      return "submitted";
    }
    if(number == rejectedState) {
      return "rejected";
    }
    if(number == approvedState) {
      return "approved";
    }
  }

  function getNumber(string) {
    if(string == "saved") {
      return savedState;
    }
    if(string == "submitted") {
      return submittedState;
    }
    if(string == "rejected") {
      return rejectedState;
    }
    if(string == "approved") {
      return approvedState;
    }
  }

  return {
    getString : getString,
    getNumber : getNumber
  }
}]);
