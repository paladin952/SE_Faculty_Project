(function (ng, console, _,  Student, Teacher, User, Person, Department, Group) {
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
            $scope.existingDepartments = [];
            $scope.existingGroups = [];



            $http.get('http://localhost:9001/student/all')
            .then(
                function(response) {
                    $scope.existingStudents= _.map(response.data, Student.fromDto);
                    $scope.isLoadingData = false;
                    console.log($scope.existingStudents);
                },
                function errorCallback(response) {
                    console.error(response);
                    $scope.isLoadingData = false;
                });

            $http.get('http://localhost:9001/studentgroup/all')
                .then(
                    function(response) {
                        $scope.existingGroups= _.map(response.data, Group.fromDto);
                        $scope.isLoadingData = false;
                        console.log($scope.existingGroups);
                    },
                    function errorCallback(response) {
                        console.error(response);
                        $scope.isLoadingData = false;
                    });

            $http.get('http://localhost:9001/department/all')
                .then(
                    function(response) {
                        $scope.existingDepartments= _.map(response.data, Department.fromDto);
                    },
                    function errorCallback(response) {
                        console.error(response);
                        $scope.isLoadingData = false;
                    });

            $http.get('http://localhost:9001/professor/all')
                .then(
                    function(teachersFromServer) {
                        $scope.existingTeachers = _.map(teachersFromServer.data, Teacher.fromDto);
                        console.log("Teachers=");
                        console.log($scope.existingTeachers);
                        for (var i in $scope.existingTeachers)
                        {
                            if ($scope.existingTeachers[i].chief){
                                $scope.existingDepartmentChiefs.push($scope.existingTeachers[i]);
                            }
                        }
                        $scope.isLoadingData = false;
                    },
                    function errorCallback(err) {
                        console.error(err);
                        $scope.isLoadingData = false;
                    });

            $scope.addChief = function () {
                console.log("add chief");
                console.log($scope.chiefToAdd.toDto());
                $scope.chiefToAdd.chief = true;
                $http.put('http://localhost:9001/professor/add', $scope.chiefToAdd.toDto())
                    .success(function (chief) {
                        $scope.existingDepartmentChiefs.push(Teacher.fromDto(chief));
                        $scope.existingTeachers.push(Teacher.fromDto(chief));
                        $scope.chiefToAdd = new Teacher();
                    })
                    .error(function (err) {
                        console.error(err);
                    });
            };

            $scope.addTeacher = function () {
                console.log("add teacher");
                console.log($scope.teacherToAdd);
                $scope.teacherToAdd.chief = false;
                $http.put('http://localhost:9001/professor/add', $scope.teacherToAdd.toDto())
                    .success(function (chief) {
                        $scope.existingTeachers.push(Teacher.fromDto(chief));
                        $scope.teacherToAdd = new Teacher();
                    })
                    .error(function (err) {
                        console.error(err);
                    });
            };

            $scope.addStudent = function () {
                $http.put('http://localhost:9001/student/add', $scope.studentToAdd.toDto())
                    .success(function (chief) {
                        $scope.existingStudents.push(Student.fromDto(chief));
                        $scope.studentToAdd = new Teacher();
                    })
                    .error(function (err) {
                        console.error(err);
                    });
            };

            $scope.updateChief = function (chief) {
                $http.put('http://localhost:9001/professor/add', chief.toDto())
                    .success(function () {
                    })
                    .error(function (err) {
                        console.error(err);
                    });
            };

            $scope.updateTeacher = function (teacher) {
                $http.put('http://localhost:9001/professor/add', teacher.toDto())
                    .success(function () {
                    })
                    .error(function (err) {
                        console.error(err);
                    });
            };

            $scope.updateStudent = function (student) {
                console.log(student);
                $http.put('http://localhost:9001/student/add', student.toDto())
                    .success(function () {
                    })
                    .error(function (err) {
                        console.error(err);
                    });
            };

            $scope.deleteChief = function(chief)
            {
                $http.delete('http://localhost:9001/professor/' + chief.id)
                    .success(function () {
                        _.remove($scope.existingDepartmentChiefs, { id: chief.id });
                        _.remove($scope.existingTeachers, { id: chief.id });
                        console.log("Successfuly deleted");
                    })
                    .error(function (err) {
                        console.log("Error deleted");
                        console.error(err);
                    });
            };

            $scope.deleteTeacher = function(teacher)
            {
                $http.delete('http://localhost:9001/professor/' + teacher.id)
                    .success(function () {
                        _.remove($scope.existingTeachers, { id: teacher.id });
                        _.remove($scope.existingDepartmentChiefs, { id: teacher.id });
                    })
                    .error(function (err) {
                        console.error(err);
                    });
            };

            $scope.deleteStudent = function(student)
            {
                $http.delete('http://localhost:9001/student/' + student.id)
                    .success(function () {
                        _.remove($scope.existingStudents, { id: student.id });
                    })
                    .error(function (err) {
                        console.error(err);
                    });
            };

        }]);
})(this.angular, this.console, this._, this.Model.Student, this.Model.Teacher, this.Model.User, this.Model.Person, this.Model.Department, this.Model.Group);