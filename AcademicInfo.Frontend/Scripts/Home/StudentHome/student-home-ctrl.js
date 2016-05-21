(function (ng, console, _,  Course, OptionalCourse) {
    'use strict';

    ng.module('studentHome')
        .controller('studentHome', ['$rootScope','$scope', '$location', function ($root, $s, $location) {

            $root.studentGrades = [];

            $s.goToLogin = function(){
                $location.path('/login');
                $root.userToLogin = null;
            };

            $http.get('http://localhost:9001/student/all')
                .then(
                    function(response) {
                        $root.studentGrades= _.map(response.data, Student.fromDto);
                        console.log($scope.existingStudents);
                    },
                    function errorCallback(response) {
                        console.error(response);
                    });

            $s.mandatoryCourses =[
                new Course('sdi', 'SDI', 5, 'practical', 'activities', 4),
                new Course('se', 'SE', 5, 'written', 'activities', 4),
                new Course('ai', 'AI', 5, 'written', 'activities', 4)
            ];

            $s.optionalCourses = [
                new OptionalCourse(1, new Course('opt1', 'OPT1', 5, 'practical', 'activities', 4)),
                new OptionalCourse(1, new Course('opt2', 'OPT2', 5, 'practical', 'activities', 4)),
                new OptionalCourse(2, new Course('opt3', 'OPT3', 5, 'practical', 'activities', 4))
            ];

            $s.addCourse = function(course) {
                var idx = $s.optionalCourses.indexOf(course);
                $("#addOptionalCourse" + course.course.name + "Button").removeClass("btn-info").addClass("btn-success");
                $("#addOptionalCourse" + course.course.name + "Span").removeClass("glyphicon-plus").addClass("glyphicon-alert");
                $s.mandatoryCourses.push(course.course);
                $s.optionalCourses.splice(idx, 1);
            };
        }]);

})(this.angular,  this.console, this._, this.Model.Course, this.Model.OptionalCourse);