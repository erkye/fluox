app.controller('talkController',function ($scope,$controller,noteService,noteTypeService) {

    $controller('baseController',{$scope:$scope});

    $scope.initPage = function () {

        //获取帖子分类
        noteTypeService.findAll().success(
            function (response) {
                $scope.notetypelist = response;
            }
        );
    };

    $scope.searchEntity = {};
    $scope.search = function (page,size) {
        noteService.search($scope.searchEntity,page,size).success(
            function (response) {
                $scope.notelist = response.rows;
                $scope.paginationConf.totalItems = response.total;
            }
        );
    }
});