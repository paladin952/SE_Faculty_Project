/**
 * Created by DianaCosma on 21-Mar-16.
 */
(function (ng) {
    'use strict';

    ng.module('teacherHome', ['ng', 'ngRoute'])
        .config(['$routeProvider', function ($route) {
            $route.when('/teacherHome', { templateUrl: 'Scripts/Home/TeacherHome/teacher-home.tmpl.html', controller: 'teacherHome' });
        }]);

})(angular);