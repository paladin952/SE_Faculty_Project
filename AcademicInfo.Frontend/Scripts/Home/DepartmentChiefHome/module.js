/**
 * Created by DianaCosma on 21-Mar-16.
 */
(function (ng) {
    'use strict';

    ng.module('departmentChiefHome', ['ng', 'ngRoute'])
        .config(['$routeProvider', function ($route) {
            $route.when('/departmentChiefHome', { templateUrl: 'Scripts/Home/DepartmentChiefHome/departmentChief-home.tmpl.html', controller: 'departmentChiefHome' });
        }]);

})(angular);