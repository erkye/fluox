app.service('noteTypeService',function ($http) {

    //查找帖子分类
    this.findAll = function () {
      return $http.get('/notetype/findAll');
    };
});