(function () {
    'use strict';

    function User() {
        this.username = '';
        this.password = '';
    }

    function User(username, password) {
        this.username = username;
        this.password = password;
    }

    S.fromDto = function (dto) {
        var user = new User();
        user.username = dto.getUsername();
        user.password = dto.getPassword();
        return user;
    };
    //User.prototype.toDto = function () {
    //    return {

    //    };
    //};

    this.Model = this.Model || {};
    this.Model.User = User;

}).call(this);
