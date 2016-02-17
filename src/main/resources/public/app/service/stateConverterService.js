/**
 * service for converting between string and number report states
 * if parameter is number return corresponding string and vis versa
 *  1 - saved
 *  2 - submitted
 *  3 - rejected
 *  4 - approved
 */

angular.module('app').service('stateConverterService', ['savedState','submittedState','rejectedState','approvedState', 'unsubmittedState', 'createdState',
 function(savedState, submittedState, rejectedState, approvedState, unsubmittedState, createdState){

  function getString(number) {
    if(number == savedState) {
      return "saved";
    }
    else if(number == submittedState) {
      return "submitted";
    }
    else if(number == rejectedState) {
      return "rejected";
    }
    else if(number == approvedState) {
      return "approved";
    }
    else if(number == createdState) {
      return "created";
    }
    else if(number == unsubmittedState) {
      return "unsubmitted";
    }
  }

  function getNumber(string) {
    if(string == "saved") {
      return savedState;
    }
    else if(string == "submitted") {
      return submittedState;
    }
    else if(string == "rejected") {
      return rejectedState;
    }
    else if(string == "approved") {
      return approvedState;
    }
    else if(string == "created") {
      return createdState;
    }
    else if(string == "unsubmitted") {
      return unsubmittedState;
    }
  }

  return {
    getString : getString,
    getNumber : getNumber
  }
}]);
