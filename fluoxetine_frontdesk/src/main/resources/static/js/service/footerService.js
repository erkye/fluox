app.service('footerService',function ($http) {

    //查找合作厂商
    this.findCompanyList = function () {
      return $http.get('/company/findAll');
    };

    //友情链接
    this.findLinkList = function () {
      return $http.get('/link/findAll');
    };
});