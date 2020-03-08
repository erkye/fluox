app.service('noteService',function ($http) {

    //发布
    this.add = function (entity) {
        return $http.post('/note/add',entity);
    };

    //查找
    this.search = function (entity,page,size) {
        return $http.post('/note/search?page='+page+'&size='+size,entity);
    };

    //查找一个
    this.findOne = function (id) {
        return $http.get('/note/findOne?id='+id);
    };

    //修改
    this.update = function (entity) {
        return $http.post('/note/update',entity);
    };
});