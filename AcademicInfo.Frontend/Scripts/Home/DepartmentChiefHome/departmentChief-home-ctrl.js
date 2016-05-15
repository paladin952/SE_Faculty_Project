(function (ng, console, _,  Course) {
    'use strict';

    ng.module('departmentChiefHome')
        .controller('departmentChiefHome', ['$rootScope', '$scope', '$location', function ($root, $s, $location) {
            $root.acceptedCourses=[];
            $s.isLoadingData = true;
            $s.goToLogin = function(){
                $location.path('/login');
                $root.userToLogin = null;
            };

            $s.existingCourses = [];

            $s.existingCourses.concat($root.proposedCourses);

            $s.acceptedCourses = [];

            $http.get('/api/Courses')
                .success(function (coursesFromServer) {
                    $s.existingCourses = _.map(coursesFromServer, Course.fromDto);
                    $s.isLoadingData = false;
                })
                .error(function (err) {
                    console.error(err);
                    $s.isLoadingData = false;
                });

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