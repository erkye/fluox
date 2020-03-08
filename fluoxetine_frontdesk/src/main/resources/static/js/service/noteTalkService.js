app.service('noteTalkService',function ($http) {

    //查找
    this.search = function (entity,page,size) {
        return $http.post('/notetalk/search?page='+page+'&size='+size,entity);
    };

    //增加评论
    this.add = function (content,nodeId) {
        return $http.get('/notetalk/add?content='+content+'&nodeId='+nodeId);
    };
});