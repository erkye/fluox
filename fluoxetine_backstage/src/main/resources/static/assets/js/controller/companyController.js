app.controller('companyController',function ($scope,$controller,companyService) {

    $controller('baseController',{$scope:$scope});

    $scope.searchEntity = {};
    $scope.search = function (page,size) {
      companyService.search($scope.searchEntity,page,size).success(
          function (response) {
              $scope.companylist = response.rows;
              $scope.paginationConf.totalItems = response.total;
          }
      );
    };

    var tipModal = angular.element(document.getElementById("tipModal"));
    var myModal = angular.element(document.getElementById("myModal"));

    $scope.save = function () {

        var object = null;
        if ($scope.entity.id == null||$scope.entity.id.length==0){
            object = companyService.add($scope.entity);
        } else {
            object = companyService.update($scope.entity);
        }

        object.success(
            function (response) {
                $scope.message = response.message;
                if (response.success){
                    $scope.reLoadList();
                }
                tipModal.modal('show');
            }
        );
    };

    $scope.findOne = function (id) {
        companyService.findOne(id).success(
            function (response) {
                $scope.entity = response;
                myModal.modal('show');
            }
        );
    };

    $scope.delete = function () {
        if ($scope.selectIds.length==0){
            return ;
        }
        if(confirm("是否确认删除吗？")){
            companyService.delete($scope.selectIds).success(
                function (response) {
                    $scope.message = response.message;
                    if (response.success){
                        $scope.reLoadList();
                        $scope.selectIds=[];
                    }
                    tipModal.modal('show');
                }
            );
        }
    }


});