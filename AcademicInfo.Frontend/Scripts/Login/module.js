/**
 * Created by DianaCosma on 21-Mar-16.
 */
(function (ng) {
    'use strict';

    ng.module('login', ['ng', 'ngRoute'])
        .config(['$routeProvider', function ($route) {
            $route.when('/login', { templateUrl: 'Scripts/Login/login.tmpl.html', controller: 'loginCtrl' });
        }]);

})(angular);
