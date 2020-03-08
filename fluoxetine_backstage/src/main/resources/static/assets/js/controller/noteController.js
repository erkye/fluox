app.controller('noteController',function ($scope,$controller,noteService,noteTypeService) {

    //继承
    $controller('baseController',{$scope:$scope});

    $scope.searchEntity={};
    $scope.search = function (page,size) {
      noteService.search($scope.searchEntity,page,size).success(
          function (response) {
              $scope.notelist = response.rows;
              $scope.paginationConf.totalItems = response.total;
          }
      );

    };

    //查找所有分类
    $scope.findNoteType = function () {
        noteTypeService.findAll().success(
            function (response) {
                $scope.typelist = response;
            }
        );
    };

    var tipModal = angular.element(document.getElementById("tipModal"));
    var detailModal = angular.element(document.getElementById("detailModal"));
    var talkModal = angular.element(document.getElementById("talkModal"));

    $scope.updateStatus = function (status) {

        var result = true;
      if (status == 0){
          result = confirm("是否确认删除？");
      }
      if($scope.selectIds.length==0){
          return ;
      }

        if(result){
            noteService.updateStatus($scope.selectIds,status).success(
                function (response) {
                    $scope.message = response.message;
                    if(response.success){
                        $scope.reLoadList();
                        $scope.selectIds = [];
                    }
                    tipModal.modal('show');
                }
            );
        }

    };


    $scope.updateRecomm = function (status) {
        if ($scope.selectIds.length==0){
            return ;
        }

        if(confirm("是否确认执行操作？")){
            noteService.updateRecomm($scope.selectIds,status).success(
                function (response) {
                    $scope.message = response.message;
                    if(response.success){
                        $scope.reLoadList();
                        $scope.selectIds = [];
                    }
                    tipModal.modal('show');
                }
            );


        }
    };

    $scope.findOne = function (id) {
        noteService.findOne(id).success(
            function (response) {
                $scope.entity = response;
                detailModal.modal('show');
            }
        );
    };


    $scope.isRecomm = function () {
        if($scope.entity.recomm == 1){
            return true;
        }else{
            return false;
        }
    };

    //查找评论
    $scope.findTalk = function (nodeId) {
        $scope.reloadtalk(nodeId);
        talkModal.modal('show');
    };

    $scope.reloadtalk =function(nodeId){
        noteService.findTalk(nodeId).success(
            function (response) {
                $scope.talklist = response;
            }
        );
    };

    $scope.deleteTalk = function (id) {
        if (confirm("是否确认删除评论？")){
            noteService.deleteTalk(id).success(
                function (response) {
                    $scope.message = response.message;
                    if (response.success){
                        $scope.reloadtalk($scope.entity.id);
                    }
                    tipModal.modal('show');
                }
            );
        }
    }

});