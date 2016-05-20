(function () {
    'use strict';

    function User() {
        this.id = '';
        this.username = '';
        this.password = '';
        this.userType = '';
    }

    function User(username, password) {
        this.username = username;
        this.password = password;
    }

    User.fromDto = function (dto) {
        var user = new User();
        user.id = dto.id;
        user.username =  dto.username;
        user.password =  dto.password;
        user.userType =  dto.userType;
        return user;
    };

    User.prototype.toDto = function () {
        return {
            "id": this.id,
            "username": this.username,
            "password": this.password,
            "userType": this.userType
        };
    };

    this.Model = this.Model || {};
    this.Model.User = User;

}).call(this);
