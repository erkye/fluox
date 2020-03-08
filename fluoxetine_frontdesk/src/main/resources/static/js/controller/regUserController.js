app.controller('regUserController',function ($scope,$window,userService) {


    var myModal = angular.element(document.getElementById('myModal'));

    var button = angular.element(document.getElementById('codeButton'));

    $scope.entity = {password:''};


    $scope.resendtime = 60;

    $scope.buttontext = "获取验证码";
    //发送验证码
    $scope.sendCode = function () {
      
        if ($scope.entity.phone==null||$scope.entity.phone.length==0){
            $scope.message = "请输入手机号码!";
            myModal.modal('show');
            return ;
        }
        userService.sendCode($scope.entity.phone).success(
            function (response) {
                $scope.message = response.message;
                if (response.success){
                    //发送成功
                    reSend();
                }
                myModal.modal('show');
            }
        );

    };

    //重新发送的
    var reSend = function(){


        //按钮设置为不可用
        button.attr('disabled',true);
        var time1 = window.setInterval(function(){
            if ($scope.resendtime==0){
                button.attr('disabled',false);
                $scope.resendtime = 60;
                //倒计时完成
                $scope.buttontext = "获取验证码";
                $scope.$digest();
                window.clearInterval(time1);
            } else{
                $scope.resendtime--;
                //实时更新
                $scope.buttontext = '重新发送('+$scope.resendtime+'s)';
                $scope.$digest();
            }
        },1000);

    };

    $scope.repassword ="";

    //注册
    $scope.regUser = function () {

        if ($scope.entity.password==null||$scope.entity.password.length==0){
            $scope.message ="请输入密码";
            myModal.modal('show');
            return ;
        }
        if ($scope.repassword==null||$scope.repassword.length==0){
            $scope.message = "请输入确认密码";
            myModal.modal('show');
            return ;
        }
        if ($scope.entity.password.length<8||$scope.entity.password.length>16){
            $scope.message = "密码位数有误！（8~16位）";
            myModal.modal('show');
            return ;
        }

        //验证两次密码是否一致
        if ($scope.entity.password != $scope.repassword){
            $scope.message = "两次密码不一致!";
            myModal.modal('show');
            return ;
        }
        userService.regUser($scope.entity,$scope.code).success(
            function (response) {
                $scope.message = response.message;
                if (response.success){
                    $window.location.href="/login.html";
                }else {
                    myModal.modal('show');
                }

            }
        );
    };

});