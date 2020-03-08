app.controller('connectUsController',function ($scope,$controller,connectUsService) {


    $controller('baseController',{$scope:$scope});

    $scope.searchEntity = {};
    $scope.search = function (page,size) {
      connectUsService.search($scope.searchEntity,page,size).success(
          function (response) {
              $scope.connectuslist = response.rows;
              $scope.paginationConf.totalItems = response.total;
          }
      );
    };

    var tipModal = angular.element(document.getElementById('tipModal'));
    var myModal = angular.element(document.getElementById('myModal'));

    $scope.updateStatus = function (ids,status) {
        if (ids == null || ids.length ==0){
            return ;
        }
        connectUsService.updateStatus(ids,status).success(
            function (response) {
                $scope.message = response.message;
                if (response.success){
                    $scope.reLoadList();
                    $scope.selectIds=[];
                }
                if (status == 2){

                    tipModal.modal('show');
                }
            }
        );
    };

    $scope.findOne = function (id) {
      connectUsService.findOne(id).success(
          function (response) {
              $scope.entity = response;
              myModal.modal('show');
          }
      );
    };
});