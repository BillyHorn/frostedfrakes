/**
 * service for converting between string and number report states
 * if parameter is number return corresponding string and vis versa
 *  1 - saved
 *  2 - submitted
 *  3 - rejected
 *  4 - approved
 */

angular.module('app').service('stateConverterService', function(){

  function getString(number) {
    if(number == 1) {
      return "saved";
    }
    if(number == 2) {
      return "submitted";
    }
    if(number == 3) {
      return "rejected";
    }
    if(number == 4) {
      return "approved";
    }
  }

  function getNumber(string) {
    if(string == "saved") {
      return 1;
    }
    if(string == "submitted") {
      return 2;
    }
    if(string == "rejected") {
      return 3;
    }
    if(string == "approved") {
      return 4;
    }
  }

  return {
    getString : getString,
    getNumber : getNumber
  }
});
