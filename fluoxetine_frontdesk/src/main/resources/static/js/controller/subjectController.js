app.controller('subjectController',function ($scope,$location,subjectService,subjectRecordService) {


    //页面加载触发函数
    $scope.initPage = function () {
        //获取地址栏传入的题目集id
        var subjectId = $location.search()['id'];

        if (subjectId!=null){
            subjectService.findBySubjectId(subjectId).success(
                function (response) {
                    $scope.questionlist = response;
                }
            );
        }

    };

    //做题提交
    $scope.entity = {detail:[]};

    //做题更新数组
    $scope.updateCheck = function (questionId,value){
         var index = findList(questionId);
        if (index>=0){
            //已经有了，更新
            $scope.entity.detail[index].value = value;
        } else {
            //没有 添加
            $scope.entity.detail.push({'id':questionId,'value':value});
        }


    };

    var findList = function (questionId) {

        for (var i=0;i<$scope.entity.detail.length;i++){
            if ($scope.entity.detail[i].id == questionId){
                return i;
            }
        }
        return -1;

    };

    //提交测试
    $scope.add = function () {

        $scope.entity.score = countGrade();
        if ($scope.entity.score==-1){
            return ;
        }
        $scope.entity.subjectId = $location.search()['id'];
        $scope.entity.detail = JSON.stringify($scope.entity.detail);
        subjectRecordService.addRecord($scope.entity).success(
            function (response) {
                console.log(response.message);
            }
        );
        $scope.entity.detail = JSON.parse($scope.entity.detail);
    };

    var tipModal = angular.element(document.getElementById("tipModal"));

    //计算分数
    var countGrade = function () {

        var grade = 0;

      if ($scope.entity.detail.length < $scope.questionlist.length){
          $scope.message = "您还有没做做的题哦！";
      } else {
          for (var i =0;i<$scope.entity.detail.length;i++){
              grade+=$scope.entity.detail[i].value;
          }

          grade = parseInt(grade*1.25);

          var tip = '';

          if (grade<53){
              tip = "一切正常哦~请继续保持！";
          } else if (grade>=53&&grade<=62){
              tip = "您有轻度的抑郁症，最近压力一定比较大吧，不要紧张，出去走走吧，" +
                  "好好感受美丽的世界，生活不只有工作，还有梦和远方哦！如果还感到不适，" +
                  "请去专业医院看一下吧！祝您身心愉快哦~"
          } else if (grade>=63&&grade<=72){
              tip = "您已经患有中度的抑郁症，建议您去找专业的心理医师寻求帮助，" +
                  "请记住，生活不只有这冰冷的测试题，还有背后默默关心你的我们！祝您身心健康~"
          } else if (grade >= 73){
              tip = "您已经患有重度抑郁症，请您抓紧去专业的医院进行检查，相信在专业的心理医师的帮助下，" +
                  "您一定会早日康复，祝您身心愉快哦~";
          }


          $scope.message = "您的测试分数为："+ grade + "分，"+tip + "(本测试仅供您参考，" +
              "需要更加严谨的结果，请移步专业的医院)";

      }
        tipModal.modal('show');

      return grade;
    };


});