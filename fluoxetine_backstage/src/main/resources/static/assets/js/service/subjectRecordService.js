app.service('subjectRecordService',function ($http) {

    this.search = function (entity,page,size) {
      return $http.post('/subjectRecord/search?page='+page+'&size='+size,entity);
    };

    this.findOne = function (id) {
      return $http.get('/subjectRecord/findOne?id='+id);
    };

    this.delete = function (ids) {
      return $http.get('/subjectRecord/delete?ids='+ids);
    };

    this.getRecordNum = function () {
        return $http.get('/subjectRecord/recordnum');
    };

});