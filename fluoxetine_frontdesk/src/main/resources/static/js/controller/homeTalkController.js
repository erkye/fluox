app.controller('homeTalkController',function ($scope,$controller,userHomeService) {

    $controller('baseController',{$scope:$scope});

    var tipModal = angular.element(document.getElementById('tipModal'));

    $scope.search = function (page,size) {

        userHomeService.findNote(page,size).success(
            function (response) {
                $scope.notelist = response.rows;
                $scope.paginationConf.totalItems = response.total;
            }
        );
    };

    $scope.deleteNote = function (id) {
        if (confirm("确认删除吗？")){
            userHomeService.deleteNote(id).success(
                function (response) {
                    $scope.message = response.message;
                    if (response.success){
                        $scope.reLoadList();
                    }
                    tipModal.modal('show');
                }
            );
        }

    }
});