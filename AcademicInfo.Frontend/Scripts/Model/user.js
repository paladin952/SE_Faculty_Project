(function () {
    'use strict';

    function User() {
        this.username = '';
        this.password = '';
        this.userType = '';
    }

    function User(username, password) {
        this.username = username;
        this.password = password;
    }

    User.fromDto = function (dto) {
        user.username =  dto.username;
        user.password =  dto.password;
        user.userType =  dto.userType;
        return user;
    };

    User.prototype.toDto = function () {
        return {
            "id": "-1",
            "username": this.username,
            "password": this.password,
            "userType": this.userType
        };
    };

    this.Model = this.Model || {};
    this.Model.User = User;

}).call(this);
