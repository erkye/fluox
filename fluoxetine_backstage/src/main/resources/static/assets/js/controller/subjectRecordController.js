app.controller('subjectRecordController',function ($scope,$controller,subjectRecordService,subjectSetService) {

    //继承
    $controller('baseController',{$scope:$scope});


    $scope.searchEntity={};
    //搜索
    $scope.search = function (page,size) {

        subjectRecordService.search($scope.searchEntity,page,size).success(
            function (response) {
                $scope.recordslist = response.rows;
                $scope.paginationConf.totalItems = response.total;
            }
        );

    };

    //查询搜索的题目集
    $scope.findSet = function () {
        subjectSetService.findAll().success(
            function (response) {
                $scope.questionsetlist = response;
            }
        );
    };

    //查找所属题目集的名称
    $scope.backSet = function (id) {

        for(var i=0; i<$scope.questionsetlist.length;i++){
            if($scope.questionsetlist[i].id == id){
                return $scope.questionsetlist[i].name;
            }
        }
    };
    var tipModal = angular.element(document.getElementById("tipModal"));
    var myModal = angular.element(document.getElementById("myModal"));
    //查找
    $scope.findOne = function (id) {
      subjectRecordService.findOne(id).success(
          function (response) {
              $scope.entity = response;
              //转换为json对象
              $scope.entity.detail = JSON.parse($scope.entity.detail);

              myModal.modal('show');
          }
      );  
    };

    $scope.delete = function () {
        if($scope.selectIds==null||$scope.selectIds.length==0){
            return;
        }
        if(confirm("确认删除吗？")){

            subjectRecordService.delete($scope.selectIds).success(
               function (response) {
                   $scope.message = response.message;
                   if(response.success){
                       $scope.selectIds =[];
                       $scope.reLoadList();
                   }
                   tipModal.modal('show');
               }
            );
        }
    }

});