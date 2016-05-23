(function (ng, console, _,  Course, OptionalCourse, StudentEvaluation, StudentOptionalCourse, Enrolled) {
    'use strict';

    ng.module('studentHome')
        .controller('studentHome', ['$rootScope','$scope','$http', '$location', function ($root, $s, $http, $location) {

            $s.studentEvaluations = [];
            $s.mandatoryCourses =[];
            $s.optionalCourses = [];
            $s.evalForLoggedUser = [];

            $s.goToLogin = function(){
                $location.path('/login');
                $root.userToLogin = null;
            };


            $http.get('http://localhost:9001/student/get/' + $root.userToLogin.username)
                .then(
                    function(res2) {

                        $http.get('http://localhost:9001/studentevaluation/get/' + res2.data.id)
                            .then(
                                function(response) {
                                    console.log("response");
                                    console.log(response);
                                    $s.evalForLoggedUser= _.map(response.data, StudentEvaluation.fromDto);
                                    //$s.evalForLoggedUser = $s.studentEvaluations;
                                    //for (var ev in $s.studentEvaluations)
                                    //{
                                    //    var user = $s.studentEvaluations[ev].student.personVO.userVO;
                                    //    if(user.username === $root.userToLogin.username && user.password === $root.userToLogin.password){
                                    //        $s.evalForLoggedUser.push($s.studentEvaluations[ev]);
                                    //
                                    //    }
                                    //}
                                },
                                function errorCallback(response) {
                                    console.error(response);
                                });
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

                console.log("course=");
                console.log(course);
                $http.put('http://localhost:9001/course/add', course.course)
                    .success(function (course) {
                        $s.mandatoryCourses.push(course.course);
                    })
                    .error(function (err) {
                        console.error(err);
                    });
                console.log("course=");
                console.log(course);
                $http.delete('http://localhost:9001/optionalcourse/' + course.id)
                    .success(function () {
                        $s.optionalCourses.splice(idx, 1);
                    })
                    .error(function (err) {
                        console.error(err);
                    });
            };

            $s.saveContract = function(){
                $http.put('http://localhost:9001/course/add', $s.course.toDto())
                    .success(function (course) {
                        $s.mandatoryCourses.push(course.course);
                    })
                    .error(function (err) {
                        console.error(err);
                    });
                $http.delete('http://localhost:9001/optionalcourse/' + course.id)
                    .success(function () {
                        $s.optionalCourses.splice(idx, 1);
                    })
                    .error(function (err) {
                        console.error(err);
                    });
            }


        }]);

})(this.angular, this.console, this._, this.Model.Course, this.Model.OptionalCourse, this.Model.StudentEvaluation, this.Model.StudentOptionalCourse, this.Model.Enrolled);