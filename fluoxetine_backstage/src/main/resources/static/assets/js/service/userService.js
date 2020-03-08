app.service('userService',function ($http) {

    this.search = function (entity,page,size) {
      return $http.post('/user/search?page='+page+'&size='+size,entity);
    };

    this.updateStatus = function (ids,status) {
      return $http.get('/user/updateStatus?ids='+ids+'&status='+status);
    };

    this.findOne = function (id) {
        return $http.get('/user/findOne?id='+id);
    };

    this.update = function (entity) {
        return $http.post('/user/update',entity);
    };

    this.getUserNum = function (userType) {
        if (userType==null||userType==''){
            return $http.get('/user/usernum');
        }
      return $http.get('/user/usernum?userType='+userType);
    };
});