app.controller('footerController',function ($scope,footerService) {


    $scope.init = function () {
        //加载合作厂商
        footerService.findCompanyList().success(
            function (response) {
                $scope.companylist = response;
            }
        );

        //加载友情链接
        footerService.findLinkList().success(
            function (response) {
                $scope.linklist = response;
            }
        );
    };


});