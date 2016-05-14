/**
 * Created by DianaCosma on 21-Mar-16.
 */
(function (ng, console, _,  Student, Teacher) {
    'use strict';

    ng.module('adminHome')
        .controller('adminHome', ['$scope', '$location', function ($scope, $location) {
            $scope.goToLogin = function(){
                $location.path('/login');
                $root.userToLogin = null;
            };

            $scope.teacherToAdd = new Teacher();

            $scope.launchDatePicker = function() {
                $('#datetimepicker').datetimepicker();
            };

            $scope.existingStudents = [
                new Student('diana','diana'),
                new Student('dana', 'dana')
            ];

            $scope.existingTeachers = [
                new Teacher(1, 'tzutzu','tzutzu', 'Dan', 'Suciu', '01-01-1980', '1800101number', 'Cluj', '07something', true),
                new Teacher(2, 'forest', 'forest', 'Adrian', 'Sterca', '01-01-1980', '1800101number', 'Cluj', '07something', true),
                new Teacher(3, 'dadi', 'dadi', 'Adrian', 'Darabant', '01-01-1980', '1800101number', 'Cluj', '07something', false),
                new Teacher(4, 'radu', 'radu', 'Radu', 'Dragos', '01-01-1980', '1800101number', 'Cluj', '07something', false)
            ];

            $scope.existingDepartmentChiefs = [];



            $scope.editChief = function(newChief)
            {
                _.update($scope.existingDepartmentChiefs, {id: newChief.username});
            };

            $scope.deleteChief = function(chief)
            {
                console.log(chief);
                var idx = $scope.existingDepartmentChiefs.indexOf(chief);
                $scope.existingDepartmentChiefs.splice(idx, 1);
                $('#deleteConfirmModal'+ chief.ssn).modal('close');
            };

            $scope.deleteTeacher = function(teacher)
            {
                var idx = $scope.existingTeachers.indexOf(teacher);
                $scope.existingTeachers.splice(idx, 1);
                $('#deleteConfirmModal'+ user.username).modal('close');
            };

            $scope.deleteStudent = function(student)
            {
                var idx = $scope.existingStudents.indexOf(student);
                $scope.existingStudents.splice(idx, 1);
                $('#deleteConfirmModal'+ user.username).modal('close');
            };

            $scope.closeModal = function(user)
            {
                $('#deleteConfirmModal'+ user.username).modal('close');
            };

            $scope.today = function() {
                $scope.dt = new Date();
            };
            $scope.today();

            $scope.clear = function() {
                $scope.dt = null;
            };

            $scope.inlineOptions = {
                customClass: getDayClass,
                minDate: new Date(),
                showWeeks: true
            };

            $scope.dateOptions = {
                dateDisabled: disabled,
                formatYear: 'yy',
                maxDate: new Date(2020, 5, 22),
                minDate: new Date(),
                startingDay: 1
            };

            // Disable weekend selection
            function disabled(data) {
                var date = data.date,
                    mode = data.mode;
                return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
            }

            $scope.toggleMin = function() {
                $scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
                $scope.dateOptions.minDate = $scope.inlineOptions.minDate;
            };

            $scope.toggleMin();

            $scope.open1 = function() {
                $scope.popup1.opened = true;
            };

            $scope.open2 = function() {
                $scope.popup2.opened = true;
            };

            $scope.setDate = function(year, month, day) {
                $scope.dt = new Date(year, month, day);
            };

            $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
            $scope.format = $scope.formats[0];
            $scope.altInputFormats = ['M!/d!/yyyy'];

            $scope.popup1 = {
                opened: false
            };

            $scope.popup2 = {
                opened: false
            };

            var tomorrow = new Date();
            tomorrow.setDate(tomorrow.getDate() + 1);
            var afterTomorrow = new Date(tomorrow);
            afterTomorrow.setDate(tomorrow.getDate() + 1);
            $scope.events = [
                {
                    date: tomorrow,
                    status: 'full'
                },
                {
                    date: afterTomorrow,
                    status: 'partially'
                }
            ];

            function getDayClass(data) {
                var date = data.date,
                    mode = data.mode;
                if (mode === 'day') {
                    var dayToCheck = new Date(date).setHours(0, 0, 0, 0);

                    for (var i = 0; i < $scope.events.length; i++) {
                        var currentDay = new Date($scope.events[i].date).setHours(0, 0, 0, 0);

                        if (dayToCheck === currentDay) {
                            return $scope.events[i].status;
                        }
                    }
                }
                return '';
            };

            $scope.init = function()
            {
                $scope.getChiefs();
            }



        }]);
})(this.angular, this.console, this._, this.Model.Student, this.Model.Teacher);