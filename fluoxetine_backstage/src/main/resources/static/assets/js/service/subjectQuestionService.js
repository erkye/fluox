app.service('subjectQuestionService',function ($http) {

    //模糊查询+分页+查找
    this.search = function (entity,page,size) {
      return $http.post('/subjectQuestion/search?page='+page+'&size='+size,entity);
    };

    //添加
    this.add = function (entity) {
        return $http.post('/subjectQuestion/add',entity);
    };

    //删除
    this.delete = function (ids) {
      return $http.get('/subjectQuestion/delete?ids='+ids);
    };

    //查找
    this.findOne = function (id) {
        return $http.get('/subjectQuestion/findOne?id='+id);
    };

    //修改
    this.update = function (entity) {
        return $http.post('/subjectQuestion/update',entity);
    }

});