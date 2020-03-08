app.controller('subjectSetController',function ($scope,$controller,subjectSetService) {

    //继承父控制器
    $controller('baseController',{$scope:$scope});


    //查找所有
    $scope.findAll = function () {

        subjectSetService.findAll().success(
            function (response) {
                $scope.subjectsetlist = response;
            }
        );
        
    };


    //分页查询+模糊查询
    $scope.searchEntity = {};

    $scope.search = function (page,size) {
        subjectSetService.search(page,size,$scope.searchEntity).success(
            function (response) {
                $scope.subjectsetlist =response.rows;
                $scope.paginationConf.totalItems = response.total;
            }
        );
    };

    //获取提示模态框的jquery对象
    var tipModal = angular.element(document.getElementById('tipModal'));
    var myModal = angular.element(document.getElementById('myModal'));

    $scope.save = function () {
        var object = null;
        if($scope.entity.id == null){
            object = subjectSetService.add($scope.entity);
        }else{
            object = subjectSetService.update($scope.entity);
        }

        if($scope.entity.name != null && $scope.entity.name.length>0){
            object.success(
                function (response) {
                    if(response.success){
                        $scope.message = response.message;
                        tipModal.modal('show');
                        $scope.reLoadList();
                    }else{
                        $scope.message = response.message;
                        tipModal.modal("show");
                    }
                }
            );
        }
    };


    //查找
    $scope.findOne = function (id) {
        subjectSetService.findOne(id).success(
          function (response) {
              $scope.entity = response;
              myModal.modal('show');
          }
      );
    };
    
    //判断是否被选中
    $scope.checkStatus = function () {

        if($scope.entity.status == 1){
            return true;
        }else{
            return false;
        }
    };

    $scope.delete = function () {
      if(confirm("是否确认删除？")){
          subjectSetService.delete($scope.selectIds).success(
              function (response) {
                  if(response.success){
                      $scope.message = response.message;
                      tipModal.modal('show');
                      $scope.selectIds=[];
                      $scope.reLoadList();
                  }else{
                      $scope.message = response.message;
                      tipModal.modal('show');
                  }
              }
          );
      }
    };


});