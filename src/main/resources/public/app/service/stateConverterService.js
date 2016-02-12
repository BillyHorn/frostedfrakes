/**
 * service for converting between string and number report states
 * if parameter is number return corresponding string and vis versa
 *  1 - saved
 *  2 - submitted
 *  3 - rejected
 *  4 - approved
 */

angular.module('app').service('stateConverterService', ['savedState','submittedState','rejectedState','approvedState','createdState','unsubmittedState',
 function(savedState, submittedState, rejectedState, approvedState, createdState, unsubmittedState){

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
    if(number == createdState) {
      return "created";
    }
    if(number == unsubmittedState) {
      return "unsubmitted";
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
    if(string == "created") {
      return createdState;
    }
    if(string == "unsubmitted") {
      return unsubmittedState;
    }
  }

  return {
    getString : getString,
    getNumber : getNumber
  }
}]);
