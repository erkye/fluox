app.service('contentUsService',function ($http) {

    this.add = function (entity) {
        return $http.post('/content/add',entity);
    }
});