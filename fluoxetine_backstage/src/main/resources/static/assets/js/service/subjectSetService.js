app.service('subjectSetService',function ($http) {


    this.findAll = function () {
      return $http.get('/subjectSet/findAll');
    };

    //搜索
    this.search = function (page,size,entity) {
        return $http.post('/subjectSet/search?page='+page+'&size='+size,entity);
    };

    //添加
    this.add =function (entity) {
        return $http.post('/subjectSet/add',entity);
    };

    //查找
    this.findOne = function (id) {
        return $http.get('/subjectSet/findOne?id='+id);
    };

    //修改
    this.update = function (entity) {
        return $http.post('/subjectSet/update',entity);
    };

    //删除
    this.delete = function (ids) {
        return $http.get('/subjectSet/delete?ids='+ids);
    }


});