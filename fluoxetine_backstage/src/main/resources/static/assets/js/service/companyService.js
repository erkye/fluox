app.service('companyService',function ($http) {

    this.search = function (entity,page,size) {
      return $http.post('/company/search?page='+page+'&size='+size,entity);
    };

    this.add = function (entity) {
      return $http.post('/company/add',entity);
    };

    this.findOne = function (id) {
        return $http.get('/company/findOne?id='+id);
    };

    this.update = function (entity) {
        return $http.post('/company/update',entity);
    };

    this.delete = function (ids) {
        return $http.get('/company/delete?ids='+ids);
    }
});