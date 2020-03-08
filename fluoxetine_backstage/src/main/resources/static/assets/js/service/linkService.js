app.service('linkService',function ($http) {

    this.search = function (entity,page,size) {
        return $http.post('/link/search?page='+page+'&size='+size,entity);
    };

    this.add = function (entity) {
        return $http.post('/link/add',entity);
    };

    this.delete = function (ids) {
        return $http.get('/link/delete?ids='+ids);
    };

    this.findOne = function (id) {
      return $http.get('/link/findOne?id='+id);
    };

    this.update = function (entity) {
      return $http.post('/link/update',entity);
    };
});