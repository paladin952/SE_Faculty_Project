(function () {
    'use strict';

    function User() {
        this.id = '';
        this.username = '';
        this.password = '';
    }

    function User(username, password) {
        this.username = username;
        this.password = password;
    }

    User.fromDto = function (dto) {
        var user = new User();
        user.id = dto.getId();
        user.username = dto.getUsername();
        user.password = dto.getPassword();
        return user;
    };

    User.prototype.toDto = function () {
        return {
            "id": this.id,
            "username": this.username,
            "password": this.password
        };
    };

    this.Model = this.Model || {};
    this.Model.User = User;

}).call(this);
