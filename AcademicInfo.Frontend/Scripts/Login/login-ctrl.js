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
                $http.post('/api/Login/', $root.userToLogin.toDto())
                    .success(function (user) {
                        if (user) {
                            console.log("logged in as " + user);
                            $s.redirectLogin(user);
                        }
                        else {
                            $s.showLoginFailedModal();
                        }
                    })
                    .error(function () {
                        $s.showLoginFailedModal();
                        console.error(err);
                    });
            };

            $s.redirectLogin = function(user) {
                console.log($root.userToLogin);
                if (user === 'student'){
                    $location.path('/studentHome');
                }
                else if(user === 'teacher'){
                    $location.path('/teacherHome');
                }
                else if(user === 'chief'){
                    $location.path('/departmentChiefHome');
                }
                else if(user === 'admin') {
                    $location.path('/adminHome');
                }
            };

}]);

})(this.angular, this.console, this._, this.Model.Student, this.Model.Teacher, this.Model.Admin, this.Model.User);
