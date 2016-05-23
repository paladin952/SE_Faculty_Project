(function (ng, console, _,  Course, OptionalCourse, StudentEvaluation) {
    'use strict';

    ng.module('studentHome')
        .controller('studentHome', ['$rootScope','$scope','$http', '$location', function ($root, $s, $http, $location) {

            $s.studentEvaluations = [];
            $s.mandatoryCourses =[];
            $s.optionalCourses = [];

            $s.goToLogin = function(){
                $location.path('/login');
                $root.userToLogin = null;
            };

            $http.get('http://localhost:9001/studentevaluation/all')
                .then(
                    function(response) {
                        $s.studentEvaluations= _.map(response.data, StudentEvaluation.fromDto);
                    },
                    function errorCallback(response) {
                        console.error(response);
                    });

            $http.get('http://localhost:9001/optionalcourse/all')
                .then(
                    function(response) {
                        $s.optionalCourses= _.map(response.data, OptionalCourse.fromDto);
                    },
                    function errorCallback(response) {
                        console.error(response);
                    });

            $http.get('http://localhost:9001/course/all')
                .then(
                    function(response) {
                        $s.mandatoryCourses= _.map(response.data, Course.fromDto);
                    },
                    function errorCallback(response) {
                        console.error(response);
                    });


            $s.addCourse = function(course) {
                var idx = $s.optionalCourses.indexOf(course);
                $("#addOptionalCourse" + course.course.name + "Button").removeClass("btn-info").addClass("btn-success");
                $("#addOptionalCourse" + course.course.name + "Span").removeClass("glyphicon-plus").addClass("glyphicon-alert");
                $s.mandatoryCourses.push(course.course);
                $s.optionalCourses.splice(idx, 1);
                $http.put('http://localhost:9001/course/add', $s.course.toDto())
                    .success(function (course) {
                        $s.mandatoryCourses.push(course.course);
                    })
                    .error(function (err) {
                        alert(err);
                        console.error(err);
                    });
                $http.delete('http://localhost:9001/optionalcourse/' + course.id)
                    .success(function () {
                        $s.optionalCourses.splice(idx, 1);
                    })
                    .error(function (err) {
                        alert(err);
                        console.error(err);
                    });
            };


        }]);

})(this.angular, this.console, this._, this.Model.Course, this.Model.OptionalCourse, this.Model.StudentEvaluation);