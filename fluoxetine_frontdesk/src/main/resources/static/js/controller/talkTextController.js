app.controller('talkTextController',function ($scope,$location,$controller,noteService,noteTalkService) {

    $controller('baseController',{$scope:$scope});

    var id = $location.search()['id'];

    var myModal = angular.element(document.getElementById('myModal'));

    var submitbutton = angular.element(document.getElementById('submitbutton'));

    $scope.entity={};

    $scope.searchEntity = {nodeId:id};
    //页面加载函数
    $scope.initPage = function () {

        noteService.findOne(id).success(
            function (response) {
                $scope.note = response;
            }
        );


        //$scope.reLoadList();
    };

    $scope.talklist = [];
    $scope.search = function (page,size) {

        noteTalkService.search($scope.searchEntity,page,size).success(
            function (response) {
                $scope.talklist = response.rows;
                $scope.paginationConf.totalItems = response.total;
            }
        );
    };

    $scope.add = function () {
        //禁用按钮
        submitbutton.attr('disabled',true);

        $scope.entity.content = editor.txt.text();
        
        if ($scope.entity.content == null || $scope.entity.content.length == 0){
            //启用按钮
            submitbutton.attr('disabled',false);
            return ;
        } 
        if ($scope.entity.content.length<1 || $scope.entity.content.length>250){
            $scope.message = "字数请保持250个字内"+$scope.entity.content;
            myModal.modal('show');
            //启用按钮
            submitbutton.attr('disabled',false);
            return ;
        }

        noteTalkService.add($scope.entity.content,id).success(
            function (response) {
                if (response.success == null){
                    window.location.href = '/login.html';
                }
                if (response.success){
                    $scope.reLoadList();
                    $scope.entity={};
                    editor.txt.html('');
                } else {
                    $scope.message = response.message;
                    myModal.modal('show');
                }
            }
        );
        //启用按钮
        submitbutton.attr('disabled',false);

    }
});