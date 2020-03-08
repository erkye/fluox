app.controller('findpasswordController',function ($scope,userService) {

    $scope.entity = {};

    var findModal = angular.element(document.getElementById('findModal'));
    var tipModal = angular.element(document.getElementById('tipModal'));
    var button = angular.element(document.getElementById('codebutton'));

    $scope.resendtime = 60;

    $scope.buttontext = "获取验证码";
    //发送验证码
    $scope.sendCode = function () {

        if ($scope.phone==null||$scope.phone.length==0){
            $scope.message = "请输入手机号码!";
            tipModal.modal('show');
            return ;
        }
        userService.fpwsendcode($scope.phone).success(
            function (response) {
                $scope.message = response.message;
                if (response.success){
                    //发送成功
                    reSend();
                }
                tipModal.modal('show');
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

    $scope.findUser = function () {

        if ($scope.phone!=null&&$scope.phone.length>0){
            if ($scope.code!=null&&$scope.code.length>0){
                userService.findUser($scope.phone,$scope.code).success(
                    function (response) {
                        $scope.entity = response;
                        if ($scope.entity.username!=null){
                            findModal.modal('show');
                        }else{
                            $scope.message = '验证码有误！';
                            tipModal.modal('show');
                        }

                    }
                );

            } else {
                $scope.message = '请输入验证码';
                tipModal.modal('show');
            }

        } else{
            $scope.message = '请输入手机号码';
            tipModal.modal('show');
        }
    };


    $scope.updateUser = function () {
        if ($scope.entity.password==null||$scope.entity.password.length==0){
            $scope.message ="请输入新密码";
            tipModal.modal('show');
            return ;
        }
        if ($scope.password==null||$scope.password.length==0){
            $scope.message = "请输入确认密码";
            tipModal.modal('show');
            return ;
        }
        if ($scope.entity.password.length<8||$scope.entity.password.length>16){
            $scope.message = "密码位数有误！（8~16位）";
            tipModal.modal('show');
            return ;
        }
        if ($scope.password != $scope.entity.password){
            $scope.message = "两次密码不一致！";
            tipModal.modal('show');
            return ;
        }

        $scope.entity.phone = $scope.phone;

        userService.update($scope.entity,$scope.code).success(
            function (response) {
                $scope.message = response.message;
                if (response.success){
                    window.location.href='/login.html';
                }
                $scope.password='';
                tipModal.modal('show');
            }
        );
    }

});