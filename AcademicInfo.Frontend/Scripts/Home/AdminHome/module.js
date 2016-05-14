/**
 * Created by DianaCosma on 21-Mar-16.
 */
(function (ng) {
    'use strict';

    ng.module('adminHome', ['ng', 'ngRoute'])
        .config(['$routeProvider', function ($route) {
            $route.when('/adminHome', { templateUrl: 'Scripts/Home/AdminHome/admin-home.tmpl.html', controller: 'adminHome' });
        }]);

})(angular);