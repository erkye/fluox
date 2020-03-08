app.controller('indexController',function ($scope,userService,subjectRecordService) {

    $scope.allUserNum = '0';
    $scope.allVolunteerNum = '0';
    $scope.allTestRecordNum = '0';

    $scope.init = function () {
        userService.getUserNum().success(
            function (response) {
                $scope.allUserNum = response.usernum;
            }
        );
        userService.getUserNum(1).success(
            function (response) {
                $scope.allVolunteerNum = response.usernum;
            }
        );
        subjectRecordService.getRecordNum().success(
            function (response) {
                $scope.allTestRecordNum = response.recordnum;
            }
        );
    }
});
