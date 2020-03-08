app.controller('contentUsController',function ($scope,contentUsService) {
   
    $scope.entity = {};

    var myModal = angular.element(document.getElementById('myModal'));
    
    $scope.add = function () {
        
        if ($scope.entity.name == null || $scope.entity.name.length ==0){
            $scope.message = "请填写称呼";
            myModal.modal('show');
            return ;
        }
        if ($scope.entity.email == null || $scope.entity.email.length ==0){
            $scope.message = "请填写邮箱";
            myModal.modal('show');
            return ;
        }
        if ($scope.entity.content == null || $scope.entity.content.length==0){
            $scope.message = "请填写内容";
            myModal.modal('show');
            return ;
        }
        if ($scope.entity.content.length > 250){
            $scope.message = "内容最多250个字";
            myModal.modal('show');
            return ;
        }
        contentUsService.add($scope.entity).success(
            function (response) {
                $scope.message = response.message;
                if (response.success){
                    $scope.entity={};
                }
                myModal.modal('show');
            }
        );

    }
    
});