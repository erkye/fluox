app.service('userService',function ($http) {

    this.sendCode = function (phone) {
        return $http.get('/user/sendCode?phone='+phone);
    };

    this.regUser = function (entity,code) {
        return $http.post('/user/regUser?code='+code,entity);
    };
    
    this.fpwsendcode = function (phone) {
        return $http.get('/user/fpwsendcode?phone='+phone);
    };

    this.findUser = function (phone,code) {
        return $http.get('/user/findUserByPhone?phone='+phone+'&code='+code);
    };

    this.update = function (entity,code) {
        return $http.post('/user/updateuser?code='+code,entity);
    }
});