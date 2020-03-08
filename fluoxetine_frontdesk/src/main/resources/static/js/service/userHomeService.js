app.service('userHomeService',function ($http) {

    this.getUser = function () {
        return $http.get('/userhome/getuser');
    };

    this.updateUser = function (entity) {
      return $http.post('/userhome/updateuser',entity);
    };

    this.findNote = function (page,size) {
       return $http.get('/userhome/findNote?page='+page+'&size='+size);
    };

    this.deleteNote = function (id) {
        return $http.get('/userhome/deleteNote?id='+id);
    };

});