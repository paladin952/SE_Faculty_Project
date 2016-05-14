/**
 * Created by DianaCosma on 21-Mar-16.
 */

(function (ng) {
    'use strict';
    ng.module('AcademicInfoApp', ['ng', 'ngRoute', 'login', 'studentHome', 'teacherHome', 'adminHome', 'departmentChiefHome'])
        .config(['$locationProvider', '$routeProvider', function ($loc, $rp) {
            $rp.otherwise({ redirectTo: '/login' });
        }]);
}).call(this, this.angular);

