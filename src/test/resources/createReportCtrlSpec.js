// 'savedState','$scope', 'reportHttp','projectHttp', '$state', 'currentUser',
'use.strict';

describe("createReportCtrlSpec", function() {
  var savedState, $scope, reportHttp, projectHttp, $state, currentUser, $createReportCtrl;

  beforeEach(module('app'));

  beforeEach(inject(function(_savedState_, _$scope_, _reportHttp_, _projectHttp_, _$state_, _currentUser_, _$controller){
    savedState = _savedState_;
    $scope = _$scope_;
    reportHttp = _reportHttp_;
    projectHttp = _projectHttp_;
    $state = _$state_;
    currentUser = _currentUser_;
    $controller = _$controller_;

    $controller('createReportCtrl', {'savedState' : savedState, '$scope' : $scope, 'reportHttp' : reportHttp, 'projectHttp' : projectHttp, '$state' : $state, 'currentUser' : currentUser });
  }));

  it('savedState should be 1', function() {
    expect(savedState == 1);
  });
});
