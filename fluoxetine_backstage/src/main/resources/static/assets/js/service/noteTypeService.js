app.service('noteTypeService',function ($http) {

    this.search = function (entity,page,size) {
      return $http.post('/nodeType/search?page='+page+'&size='+size,entity);
    };

    this.add = function (entity) {
        return $http.post('/nodeType/add',entity);
    };

    this.findOne = function (id) {
      return $http.get('/nodeType/findOne?id='+id);
    };

    this.update = function (entity) {
        return $http.post('/nodeType/update',entity);
    };

    this.delete = function (ids) {
      return  $http.get('/nodeType/delete?ids='+ids);
    };

    this.findAll = function () {
        return $http.get('/nodeType/findAll');
    }

});