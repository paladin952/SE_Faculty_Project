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

            $s.existingStudents = [
                new Student('diana','diana'),
                new Student('dana', 'dana')
            ];

            $s.existingTeachers = [
                new Teacher(3, new User('dadi', 'dadi'), 'Adrian', 'Darabant', '01-01-1980', '1800101number', 'Cluj', '07something', false),
                new Teacher(4, new User('radu', 'radu'), 'Radu', 'Dragos', '01-01-1980', '1800101number', 'Cluj', '07something', false)
            ];

            $s.existingDepartmentChiefs = [
                new Teacher(1, new User('tzutzu','tzutzu'), 'Dan', 'Suciu', '01-01-1980', '1800101number', 'Cluj', '07something', true),
                new Teacher(2, new User('forest', 'forest'), 'Adrian', 'Sterca', '01-01-1980', '1800101number', 'Cluj', '07something', true)
            ];

            $s.existingAdmins = [
                new Admin('admin1','admin1'),
                new Admin('admin2', 'admin2')
            ];

            $s.existingUsers =[
                new Student('diana','diana'),
                new Student('dana', 'dana'),
                new Teacher(3, new User('dadi', 'dadi'), 'Adrian', 'Darabant', '01-01-1980', '1800101number', 'Cluj', '07something', false),
                new Teacher(4, new User('radu', 'radu'), 'Radu', 'Dragos', '01-01-1980', '1800101number', 'Cluj', '07something', false),
                new Teacher(1, new User('tzutzu','tzutzu'), 'Dan', 'Suciu', '01-01-1980', '1800101number', 'Cluj', '07something', true),
                new Teacher(2, new User('forest', 'forest'), 'Adrian', 'Sterca', '01-01-1980', '1800101number', 'Cluj', '07something', true),
                new Admin('admin1','admin1'),
                new Admin('admin2', 'admin2')
            ];

            $s.containsObject = function(obj, list) {
                var i;
                for (i = 0; i < list.length; i++) {
                    if (angular.equals(list[i], obj)) {
                        return true;
                    }
                }
                return false;
            };

            $s.redirectLogin = function() {
                console.log($root.userToLogin);
                if ($s.containsObject($root.userToLogin, $s.existingStudents)){
                    $location.path('/studentHome');
                }
                else if($s.containsObject($root.userToLogin, $s.existingTeachers)){
                    $location.path('/teacherHome');
                }
                else if($s.containsObject($root.userToLogin, $s.existingDepartmentChiefs)){
                    $location.path('/departmentChiefHome');
                }
                else if($s.containsObject($root.userToLogin, $s.existingAdmins)) {
                    $location.path('/adminHome');
                }
                else {
                    $s.showLoginFailedModal();
                }

                for( var user in $s.existingUsers)
                {
                    if ($root.userToLogin.isEqual(user.user))
                        return;
                }
            };

            $s.remember = false;
            if ($remember('username') && $remember('password') ) {
                $s.remember = true;
                $s.username = $remember('username');
                $s.password = $remember('password');
            }
            $s.rememberMe = function() {
                if ($s.remember) {
                    $remember('username', $s.username);
                    $remember('password', $s.password);
                } else {
                    $remember('username', '');
                    $remember('password', '');
                }
            };


            $s.validateLogin = function () {
                //$http.post('/api/Login/', $root.userToLogin.toDto())
                //    .success(function (loggedIn) {
                //        if (loggedIn) {
                //            console.log("logged in is " + loggedIn);
                //            $s.showLoginSuccededModal();
                //            $('#loginSuccededModal').modal('hide');
                //            $location.path('/home');
                //        }
                //        else {
                //            $s.showLoginFailedModal();
                //        }
                //    })
                //    .error(function () {
                //        $s.showLoginFailedModal();
                //        alert(err);
                //        console.error(err);
                //    });
            };
}]);

})(this.angular, this.console, this._, this.Model.Student, this.Model.Teacher, this.Model.Admin, this.Model.User);
