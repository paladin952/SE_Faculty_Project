(function (ng, console, _,  Course, Student, User, Person) {
    'use strict';

    ng.module('teacherHome')
        .controller('teacherHome', ['$rootScope', '$scope', '$http', '$location', function ($root, $s, $http, $location) {
            $root.acceptedCourses=[];
            $root.proposedCourses=[];
            $s.existingStudents=[];
            $s.courseToAdd = new Course();

            $s.goToLogin = function(){
                $location.path('/login');
                $root.userToLogin = null;
            };

            $s.existingCourses = [
                //new Course('sdi', 'SDI', 5, 'practical', 'activities', 4),
                //new Course('se', 'SE', 5, 'written', 'activities', 4),
                //new Course('ai', 'AI', 5, 'written', 'activities', 4)
            ];

            $s.acceptedCourses = [];

            $http.get('http://localhost:9001/student/all')
                .then(
                    function(response) {
                        console.log("Students");
                        console.log(response.data);
                        $s.existingStudents= _.map(response.data, Student.fromDto);
                        //$s.selectedStdent = $s.existingStudents[0];
                    },
                    function errorCallback(response) {
                        console.error(response);
                    });

            $s.existingStudents=[
                    //new Student(1, new Person(new User ('user1', 'pass1'), 'fname1', 'lanme1', '15/02/2000', '2951203245030','addr1', '0740000000' )),
                    //new Student(2, new Person(new User ('user2', 'pass2'), 'fname2', 'lanme2', '15/02/2000', '2951203245030','addr2', '0740000000' )),
            ];

            $http.get('http://localhost:9001/courses/all')
                .then(
                    function(response) {
                        console.log("courses");
                        console.log(response.data);
                        $s.availableStudents= _.map(response.data, Student.fromDto);
                        $s.selectedStdent = $s.availableStudents[0];
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
                console.log($root.acceptedCourses);
            };

            //$s.availableStudents = [
            //    new Student(1, new Person(new User ('user1', 'pass1'), 'fname1', 'lanme1', '15/02/2000', '2951203245030','addr1', '0740000000' )),
            //    new Student(2, new Person(new User ('user2', 'pass2'), 'fname2', 'lanme2', '15/02/2000', '2951203245030','addr2', '0740000000' )),
            //    new Student(3, new Person(new User ('user3', 'pass3'), 'fname3', 'lanme3', '15/02/2000', '2951203245030','addr3', '0740000000' )),
            //    new Student(4, new Person(new User ('user4', 'pass4'), 'fname4', 'lanme4', '15/02/2000', '2951203245030','addr4', '0740000000' )),
            //    new Student(5, new Person(new User ('user5', 'pass5'), 'fname5', 'lanme5', '15/02/2000', '2951203245030','addr5', '0740000000' )),
            //    new Student(6, new Person(new User ('user6', 'pass6'), 'fname6', 'lanme6', '15/02/2000', '2951203245030','addr6', '0740000000' )),
            //    new Student(7, new Person(new User ('user7', 'pass7'), 'fname7', 'lanme7', '15/02/2000', '2951203245030','addr7', '0740000000' )),
            //    new Student(8, new Person(new User ('user8', 'pass8'), 'fname8', 'lanme8', '15/02/2000', '2951203245030','addr8', '0740000000' ))
            //];

            $s.goNext = function(){

            };

        }]);

})(this.angular,  this.console, this._, this.Model.Course, this.Model.Student, this.Model.User, this.Model.Person);