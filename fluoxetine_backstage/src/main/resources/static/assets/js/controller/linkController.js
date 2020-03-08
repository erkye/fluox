app.controller('linkController',function ($scope,$controller,linkService) {

    $controller('baseController',{$scope:$scope});


    $scope.searchEntity = {};
    $scope.search = function (page,size) {
      linkService.search($scope.searchEntity,page,size).success(
          function (response) {
              $scope.linklist = response.rows;
              $scope.paginationConf.totalItems = response.total;
          }
      );
    };

    var tipModal = angular.element(document.getElementById("tipModal"));
    var myModal = angular.element(document.getElementById("myModal"));

    $scope.save = function () {
        var object = null;
        if ($scope.entity.id != null&& $scope.entity.id.length != 0){
            object = linkService.update($scope.entity);
        }else {
            object = linkService.add($scope.entity);
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


    $scope.delete = function () {
        if ($scope.selectIds.length==0){
            return ;
        }
        if (confirm("确认删除吗？")){
            linkService.delete($scope.selectIds).success(
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
    };


    $scope.findOne = function (id) {
        linkService.findOne(id).success(
            function (response) {
                $scope.entity = response;
                myModal.modal('show');
            }
        );
    };



});