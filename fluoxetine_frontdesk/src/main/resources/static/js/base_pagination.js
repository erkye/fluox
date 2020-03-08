//引入分页插件依赖
var app = angular.module("fluoxetine",['pagination']);

app.filter('trustHtml',['$sce',function ($sce) {
    return function (data) {
        return $sce.trustAsHtml(data);
    }
}]);