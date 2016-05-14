(function () {
    'use strict';

    function Admin() {
        this.person = null;
    }

    function Admin(person) {
        this.person = person;
    }

    S.fromDto = function (dto) {
        var admin = new Admin();
        admin.person = dto.getPerson();
        return admin;
    };

    //AccessRule.prototype.toDto = function () {
    //    return {
    //        Id: this.id,
    //        Name: this.name,
    //        DateAdded: this.dateAdded
    //    };
    //};

    this.Model = this.Model || {};
    this.Model.Admin = Admin;

}).call(this);