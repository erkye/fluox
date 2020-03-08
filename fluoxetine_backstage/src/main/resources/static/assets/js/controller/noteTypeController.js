app.controller('noteTypeController',function ($scope,$controller,noteTypeService) {

    //继承
    $controller('baseController',{$scope:$scope});


    $scope.searchEntity = {};
    $scope.search = function (page,size) {
       noteTypeService.search($scope.searchEntity,page,size).success(
           function (response) {
               $scope.notetypelist = response.rows;
               $scope.paginationConf.totalItems = response.total;
           }
       );
    };

    var tipModal = angular.element(document.getElementById("tipModal"));
    var myModal = angular.element(document.getElementById("myModal"));

    $scope.save = function () {
        var object = null;
        if ($scope.entity.id == null||$scope.entity.id.length==0){
            object = noteTypeService.add($scope.entity);
        } else{
            object = noteTypeService.update($scope.entity);
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
      noteTypeService.findOne(id).success(
          function (response) {
              $scope.entity = response;
              myModal.modal('show');
          }
      );
    };

    $scope.entity={'userVisual':1};
    $scope.checkStatus = function () {
        if ($scope.entity.userVisual == 1){
            return true;
        } else {
            return false;
        }
    };

    $scope.delete = function () {
        if ($scope.selectIds.length==0){
            return ;
        }
        if(confirm("确认删除吗？")){
            noteTypeService.delete($scope.selectIds).success(
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