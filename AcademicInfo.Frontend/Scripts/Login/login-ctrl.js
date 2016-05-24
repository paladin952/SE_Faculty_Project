/**
 * Created by DianaCosma on 21-Mar-16.
 */
(function (ng,  console, _,  Student, Teacher, Admin, User) {
    'use strict';

    ng.module('login')
        .controller('loginCtrl', ['$rootScope', '$scope', '$http', '$location', '$route', '$remember', function ($root, $s, $http, $location, $route, $remember) {

            $('#loginModal').modal('show');

            $s.currentWantedPage = '';

            $s.showLoginFailedModal = function () {
                $('#loginFailedModal').modal('show');
            };

            $s.showLoginSuccededModal = function () {
                $('#loginSuccededModal').modal('show');
            };

            $s.showLoginModal = function () {
                $route.reload();
            };

            $root.userToLogin = new User();

            $s.validateLogin = function () {
                $http.post('http://localhost:9001/login/', $root.userToLogin.toDto())
                    .success(function (user) {
                        console.log(user);
                        if (user) {
                            console.log("logged in as: ");
                            console.log($root.userToLogin);
                            $root.userToLogin= user;
                            $s.redirectLogin();
                        }
                        else {
                            $s.showLoginFailedModal();
                        }
                    })
                    .error(function () {
                        console.log("Error on login");
                        $s.showLoginFailedModal();

                    });
            };

            $s.redirectLogin = function() {
                console.log("Redirect to: ");
                console.log($root.userToLogin);
                if ($root.userToLogin.userType === 'STUDENT'){
                    $location.path('/studentHome');
                }
                else if($root.userToLogin.userType === 'TEACHER'){
                    $location.path('/teacherHome');
                }
                else if($root.userToLogin.userType === 'TEACHER_CHIEF'){
                    $location.path('/departmentChiefHome');
                }
                else if($root.userToLogin.userType === 'ADMIN') {
                    $location.path('/adminHome');
                }
            };

}]);

})(this.angular, this.console, this._, this.Model.Student, this.Model.Teacher, this.Model.Admin, this.Model.User);
