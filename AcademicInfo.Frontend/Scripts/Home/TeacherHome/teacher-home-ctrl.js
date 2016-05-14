(function (ng, console, _,  Course) {
    'use strict';

    ng.module('teacherHome')
        .controller('teacherHome', ['$rootScope', '$scope', '$location', function ($root, $s, $location) {
            $root.acceptedCourses=[];
            $root.proposedCourses=[];
            $s.courseToAdd = new Course();

            $s.goToLogin = function(){
                $location.path('/login');
                $root.userToLogin = null;
            };

            $s.existingCourses = [
                new Course('sdi', 'SDI', 5, 'practical', 'activities', 4),
                new Course('se', 'SE', 5, 'written', 'activities', 4),
                new Course('ai', 'AI', 5, 'written', 'activities', 4)
            ];

            $s.acceptedCourses = [];

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
            }




        }]);

})(this.angular,  this.console, this._, this.Model.Course);