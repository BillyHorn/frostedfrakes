angular.module('app').directive('fdInput', [function () {
  return {
    restrict: 'A',
    link: function (scope, element, attrs) {
      element.on('change', function  (evt) {
        var files = evt.target.files;
        console.log(files[0].name);
        console.log(files[0].size);
      });
    }
  };
}]);
