app.controller('userController',function ($scope,$controller,userService) {

    $controller('baseController',{$scope:$scope});

    $scope.searchEntity = {};
    $scope.search = function (page,size) {
      userService.search($scope.searchEntity,page,size).success(
          function (response) {
              $scope.userlist = response.rows;
              $scope.paginationConf.totalItems = response.total;
          }
      );
    };

    var tipModal = angular.element(document.getElementById('tipModal'));
    var myModal = angular.element(document.getElementById('myModal'));

    $scope.updateStatus = function (status) {
        if ($scope.selectIds==null || $scope.selectIds.length==0){
            return ;
        }
        if(confirm("确认进行当前操作吗？")){
            userService.updateStatus($scope.selectIds,status).success(
                function (response) {
                    $scope.message = response.message;
                    if (response.success){
                        $scope.reLoadList();
                        $scope.selectIds =[];
                    }
                    tipModal.modal('show');
                }
            );
        }
    };

    $scope.findOne = function (id) {
      userService.findOne(id).success(
          function (response) {
              $scope.entity = response;
              myModal.modal('show');
          }
      );
    };

    $scope.save = function () {
        userService.update($scope.entity).success(
            function (response) {
                $scope.message = response.message;
                if (response.success){
                    $scope.reLoadList();
                }
                tipModal.modal('show');
            }
        );
    }

});