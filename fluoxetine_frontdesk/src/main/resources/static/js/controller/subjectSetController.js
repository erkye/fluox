app.controller('subjectSetController',function ($scope,subjectSetService) {

    //获取所有的题目集
    $scope.findAll = function () {
      subjectSetService.findAll().success(
          function (response) {
              $scope.subjectsetlist = response;
          }
      );
    };


});