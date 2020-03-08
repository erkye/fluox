app.service('subjectService',function ($http) {

    this.findBySubjectId = function (subjectId) {
      return $http.get('/subject/findBySubjectId?subjectId='+subjectId);
    };
});