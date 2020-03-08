app.service('noteService',function ($http) {

    this.search = function (entity,page,size) {
      return $http.post('/note/search?page='+page+'&size='+size,entity);
    };

    //修改状态
    this.updateStatus = function (ids,status) {
      return $http.get('/note/updateStatus?ids='+ids+'&status='+status);
    };

    this.updateRecomm = function (ids,status) {
      return $http.get('/note/updateRecomm?ids='+ids+'&status='+status);
    };

    this.findOne = function (id) {
      return $http.get('/note/findOne?id='+id);
    };

    //查找评论
    this.findTalk = function (noteId) {
        return $http.get('/note/findTalk?noteId='+noteId);
    };

    //删除评论
    this.deleteTalk = function (id) {
      return $http.get('/note/deleteTalk?id='+id);
    };
});