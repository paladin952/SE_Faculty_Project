(function (ng, console, _,  Student, Teacher, User, Person) {
    'use strict';

    ng.module('adminHome')
        .controller('adminHome', ['$scope', '$http', '$location', function ($scope, $http, $location) {
            $scope.goToLogin = function(){
                $location.path('/login');
                $root.userToLogin = null;
            };
            $scope.isLoadingData = true;
            $scope.teacherToAdd = new Teacher();
            $scope.chiefToAdd = new Teacher();
            $scope.studentToAdd  = new Student();
            $scope.existingStudents = [];
            $scope.existingTeachers = [];
            $scope.existingDepartmentChiefs = [];

            $http.get('/api/Students')
                .success(function (studentsFromServer) {
                    $scope.existingStudents= _.map(studentsFromServer, Student.fromDto);
                    $scope.isLoadingData = false;
                })
                .error(function (err) {
                    console.error(err);
                    $scope.isLoadingData = false;
                });

            $http.get('/api/Teachers')
                .success(function (teachersFromServer) {
                    $scope.existingTeachers = _.map(teachersFromServer, Teacher.fromDto);
                    for (var teacher in $scope.existingTeachers)
                    {
                        if (teacher.ischief){
                            $scope.existingDepartmentChiefs.push(teacher);
                        }
                    }
                    $scope.isLoadingData = false;
                })
                .error(function (err) {
                    console.error(err);
                    $scope.isLoadingData = false;
                });

            $scope.addChief = function () {
                $http.post('/api/Teachers/', $scope.chiefToAdd.toDto())
                    .success(function (chief) {
                        $scope.existingDepartmentChiefs.push(Teacher.fromDto(chief));
                        $scope.existingTeachers.push(Teacher.fromDto(chief));
                        $scope.chiefToAdd = new Teacher();
                    })
                    .error(function () {
                        alert(err);
                        console.error(err);
                    });
            };

            $scope.addTeacher = function () {
                $http.post('/api/Teachers/', $scope.teacherToAdd.toDto())
                    .success(function (chief) {
                        $scope.existingTeachers.push(Teacher.fromDto(chief));
                        $scope.teacherToAdd = new Teacher();
                    })
                    .error(function () {
                        alert(err);
                        console.error(err);
                    });
            };

            $scope.addStudent = function () {
                $http.post('/api/Students/', $scope.studentToAdd.toDto())
                    .success(function (chief) {
                        $scope.existingStudents.push(Student.fromDto(chief));
                        $scope.studentToAdd = new Teacher();
                    })
                    .error(function () {
                        alert(err);
                        console.error(err);
                    });
            };

            $scope.updateChief = function (chief) {
                $http.put('/api/Teachers/', chief.toDto())
                    .success(function () {
                    })
                    .error(function () {
                        alert(err);
                        console.error(err);
                    });
            };

            $scope.updateTeacher = function (teacher) {
                $http.put('/api/Teachers/', teacher.toDto())
                    .success(function () {
                    })
                    .error(function () {
                        alert(err);
                        console.error(err);
                    });
            };

            $scope.updateStudent = function (student) {
                $http.put('/api/Students/', student.toDto())
                    .success(function () {
                    })
                    .error(function () {
                        alert(err);
                        console.error(err);
                    });
            };

            $scope.deleteChief = function(chief)
            {
                $http.delete('/api/Teachers/' + chief.id)
                    .success(function () {
                        _.remove($s.exis, { id: chief.id });
                    })
                    .error(function (err) {
                        alert(err);
                        console.error(err);
                    });
            };

            $scope.deleteTeacher = function(teacher)
            {
                $http.delete('/api/Teachers/' + teacher.id)
                    .success(function () {
                        _.remove($s.exis, { id: teacher.id });
                    })
                    .error(function (err) {
                        alert(err);
                        console.error(err);
                    });
            };

            $scope.deleteStudent = function(student)
            {
                $http.delete('/api/Students/' + student.id)
                    .success(function () {
                        _.remove($s.exis, { id: student.id });
                    })
                    .error(function (err) {
                        alert(err);
                        console.error(err);
                    });
            };

            $scope.init = function() {
            }


        }]);
})(this.angular, this.console, this._, this.Model.Student, this.Model.Teacher, this.Model.User, this.Model.Person);