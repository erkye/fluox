app.controller('homeInforController',function ($scope,userHomeService) {

    $scope.entity = {};

    var showModal = angular.element(document.getElementById('showModal'));

    $scope.initPage = function () {

        userHomeService.getUser().success(
            function (response) {
                $scope.ranklist = [];
                //当前登录的用户 页面展示
                $scope.loginuser = response;
                //用于修改的 深克隆
                $scope.entity = JSON.parse(JSON.stringify(response));

                for (var i=1;i<=$scope.loginuser.userRank;i++){
                    $scope.ranklist.push(i);
                }
            }
        );
    };

    $scope.save = function () {

        userHomeService.updateUser($scope.entity).success(
            function (response) {
                $scope.message = response.message;
                if (response.success) {
                    $scope.initPage();
                }
                showModal.modal('show');

            }
        );
    };
    

});