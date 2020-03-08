app.service('connectUsService',function ($http) {

    this.search = function (entity,page,size) {
        return $http.post('/connectUs/search?page='+page+'&size='+size,entity);
    };

    this.updateStatus = function (ids,status) {
        return $http.get('/connectUs/updateStatus?ids='+ids+'&status='+status);
    };

    this.findOne = function (id) {
        return $http.get('/connectUs/findOne?id='+id);
    }
});