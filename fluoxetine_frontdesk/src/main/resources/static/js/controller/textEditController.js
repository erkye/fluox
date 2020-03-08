app.controller('textEditController',function ($scope,$location,noteTypeService,noteService) {

    $scope.entity = {title:'',introd:'',content:''};
    $scope.initPage = function () {

      noteTypeService.findAll().success(
          function (response) {
              //帖子分类
              $scope.typelist = response;
          }
      );

      var id = $location.search()['id'];
      if (id!=null){
        noteService.findOne(id).success(
            function (response) {
                $scope.entity = response;
                editor.txt.html($scope.entity.content);
            }
        );
      }

    };
    var tipModal = angular.element(document.getElementById("tipModal"));
    var submitbutton = angular.element(document.getElementById('submitbutton'));




   //发表文章
    $scope.add = function () {
        //禁用按钮
        submitbutton.attr('disabled',true);


         $scope.entity.content = editor.txt.html();

         if ($scope.entity.typeId == null || $scope.entity.typeId.length==0){
             alert("您还没有选择分类！");
             //启用按钮
             submitbutton.attr('disabled',false);
             return ;
         }

         if ($scope.entity.title == null || $scope.entity.title.length==0){
             alert("您还没有输入标题！");
             //启用按钮
             submitbutton.attr('disabled',false);
             return ;
         }
         if ($scope.entity.title.length>20){
             alert("您输入的标题过长，最长20个字！");
             //启用按钮
             submitbutton.attr('disabled',false);
             return ;
         }
         if ($scope.entity.title.length<5){
             alert("您输入的标题过短，最短5个字！");
             //启用按钮
             submitbutton.attr('disabled',false);
             return ;
         }
         if ($scope.entity.img == null || $scope.entity.img.length==0){
             alert("您还没有输入帖子封面的url！");
             //启用按钮
             submitbutton.attr('disabled',false);
             return ;
         }
         if ($scope.entity.introd == null || $scope.entity.introd.length==0){
             alert("您还没有输入简介！");
             //启用按钮
             submitbutton.attr('disabled',false);
             return ;
         }
        if ($scope.entity.introd.length>80){
            alert("您还输入简介太长了，那还是简介嘛！");
            //启用按钮
            submitbutton.attr('disabled',false);
            return ;
        }
        if (editor.txt.text().length<30){
            alert("内容最少30个字哦！");
            //启用按钮
            submitbutton.attr('disabled',false);
            return ;
        }
        if (editor.txt.text().length>5000){
            alert("内容最多5000个字哦！");
            //启用按钮
            submitbutton.attr('disabled',false);
            return ;
        }



        var object = null;
        if($scope.entity.id == null){
            object = noteService.add($scope.entity);
        }else{
            object = noteService.update($scope.entity);
        }


        //全部验证完毕
        object.success(
            function (response) {
                $scope.message = response.message;
                if (response.success){
                    $scope.entity={};
                    editor.txt.html('');
                    window.location.href="home-talk.html";
                }
                tipModal.modal('show');
            }
        );

        //启用按钮
        submitbutton.attr('disabled',false);
    };
});