app.controller('baseController',function ($scope) {

    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,//当前页
        totalItems: 10,//总记录数
        itemsPerPage: 10,//每页记录数
        perPageOptions: [10, 20, 30, 40, 50],//可指定每页记录数
        onChange: function(){//切换分页是自动触发的方法
            $scope.reLoadList();
        }
    };

    //刷新方法
    $scope.reLoadList = function(){
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    } ;

    //用户选中的id集合
    $scope.selectIds = [];

    $scope.updateIdsSelection = function ($event,id) {
        //$event.target 获取input元素
        if($event.target.checked){//当前元素没有被选中
            $scope.selectIds.push(id);
        }else {
            var index = $scope.selectIds.indexOf(id);//获取当前元素的索引
            $scope.selectIds.splice(index,1);//删除  参数1：删除开始索引  参数2：删除的个数
        }
    };

    $scope.jsonToString = function (jsonString,key) {
        var json = JSON.parse(jsonString);
        var value = "";

        for(var i=0;i<json.length;i++){
            if (i>0){
                value+=",";
            }
            value+=json[i][key];
        }
        return value;
    }
});