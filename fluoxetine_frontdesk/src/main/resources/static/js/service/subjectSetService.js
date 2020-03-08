app.service('subjectSetService',function ($http) {

    this.findAll = function () {
      return $http.get('/subjectset/findAll');
    };
});