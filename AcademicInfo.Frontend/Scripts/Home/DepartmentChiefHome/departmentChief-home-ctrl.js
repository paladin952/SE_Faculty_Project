/**
 * Created by DianaCosma on 21-Mar-16.
 */
(function (ng, console, _,  Course) {
    'use strict';

    ng.module('departmentChiefHome')
        .controller('departmentChiefHome', ['$rootScope', '$scope', '$location', function ($root, $s, $location) {
            $root.acceptedCourses=[];

            $s.goToLogin = function(){
                $location.path('/login');
                $root.userToLogin = null;
            };

            $s.existingCourses = [
                new Course('sdi', 'SDI', 5, 'practical', 'activities', 4),
                new Course('se', 'SE', 5, 'written', 'activities', 4),
                new Course('ai', 'AI', 5, 'written', 'activities', 4)
            ];

            $s.existingCourses.concat($root.proposedCourses);

            $s.acceptedCourses = [];

            $s.acceptCourse = function(course){
                var idx = $s.existingCourses.indexOf(course);
                $("#acceptButton" + course.name).removeClass("btn-info").addClass("btn-success");
                $s.acceptedCourses.push(course);
                //$('#deleteConfirmModal'+ user.username).modal('close');
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

})(this.angular, this.console, this._, this.Model.Course);