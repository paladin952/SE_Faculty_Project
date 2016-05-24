/**
 * Created by DianaCosma on 21-Mar-16.
 */
(function (ng) {
    'use strict';

    ng.module('studentHome', ['ng', 'ngRoute'])
        .config(['$routeProvider', function ($route) {
            $route.when('/studentHome', { templateUrl: 'Scripts/Home/StudentHome/student-home.tmpl.html', controller: 'studentHome' });
        }]);

})(angular);