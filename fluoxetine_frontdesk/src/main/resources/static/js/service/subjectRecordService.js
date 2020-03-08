app.service('subjectRecordService',function ($http) {

    //添加记录
    this.addRecord = function (entity) {
      return $http.post('/subjectrecord/add',entity);
    };
});