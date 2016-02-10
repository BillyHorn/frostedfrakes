angular.module('app', ['ui.router', 'ui.bootstrap']);

angular.module('app').config(['$compileProvider', function ($compileProvider) {
    $compileProvider.imgSrcSanitizationWhitelist(/^\s*(https?|local|data):/);
}]);
