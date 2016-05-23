(function (ng, console, _,  Course, Student, User, Person, StudentEvaluation) {
    'use strict';

    ng.module('teacherHome')
        .controller('teacherHome', ['$rootScope', '$scope', '$http', '$location', function ($root, $s, $http, $location) {
            $root.acceptedCourses=[];
            $root.proposedCourses=[];
            $s.existingStudents=[];
            $s.existingCourses = [];
            $s.existingStudents=[];
            $s.acceptedCourses = [];
            $s.existingEvaluation = [];
            $s.courseToAdd = new Course();
            $s.studEval = new StudentEvaluation();


            $s.goToLogin = function(){
                $location.path('/login');
                $root.userToLogin = null;
            };

            $http.get('http://localhost:9001/student/all')
                .then(
                    function(response) {
                        $s.existingStudents= _.map(response.data, Student.fromDto);
                    },
                    function errorCallback(response) {
                        console.error(response);
                    });

            $http.get('http://localhost:9001/course/all')
                .then(
                    function(response) {
                        $s.existingCourses= _.map(response.data, Course.fromDto);
                    },
                    function errorCallback(response) {
                        console.error(response);
                    });

            $s.proposeNewCourse = function(){
                console.log($s.courseToAdd);
                $root.proposedCourses.push($s.courseToAdd);
                console.log($root.proposedCourses);
            };

            $s.deleteAcceptedCourse = function(ac) {
                var idx = $s.acceptedCourses.indexOf(ac);
                $s.acceptedCourses.splice(idx, 1);
                $("#acceptButton" + ac.name).removeClass("btn-success").addClass("btn-info");
            };

            $s.saveCourseList = function() {
                $root.acceptedCourses = $s.acceptedCourses;
                $("#saveButton").removeClass("btn-info").addClass("btn-danger");
                $("#saveSpan").removeClass("glyphicon-floppy-save").addClass("glyphicon-check");
            };

            $s.assign = function(){
                $http.put('http://localhost:9001/studentevaluation/add', $s.studEval.toDto())
                    .success(function (chief) {
                        alert("Successfully added!");
                    })
                    .error(function (err) {
                        alert(err);
                        console.error(err);
                    });
            };

        }]);

})(this.angular,  this.console, this._, this.Model.Course, this.Model.Student, this.Model.User, this.Model.Person, this.Model.StudentEvaluation);