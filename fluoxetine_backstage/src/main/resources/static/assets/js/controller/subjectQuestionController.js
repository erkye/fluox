app.controller('subjectQuestionController',function ($scope,$controller,subjectQuestionService,subjectSetService) {

    //继承
    $controller('baseController',{$scope:$scope});

    $scope.searchEntity = {};

    $scope.search = function (page,size) {
      subjectQuestionService.search($scope.searchEntity,page,size).success(
          function (response) {
              $scope.questionlist = response.rows;
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

    //保存
    $scope.save = function () {
        var object = null;
        if($scope.entity.id!=null){
            object = subjectQuestionService.update($scope.entity);
        }else {
            object = subjectQuestionService.add($scope.entity);
        }

        object.success(
            function (response) {
                $scope.message = response.message;
                if(response.success){
                   $scope.reLoadList();
                }
                tipModal.modal('show');
            }
        );

    };


    $scope.delete = function () {
        if(confirm("确认删除所选题目吗？")){
            subjectQuestionService.delete($scope.selectIds).success(
                function (response) {
                    $scope.message = response.message;
                    if(response.success){
                        $scope.reLoadList();
                        $scope.selectIds=[];
                    }
                    tipModal.modal('show');
                }
            );
        }
    };
    
    $scope.findOne = function (id) {
        subjectQuestionService.findOne(id).success(
            function (response) {
                $scope.entity = response;
                myModal.modal('show');
            }
        );
    }


});