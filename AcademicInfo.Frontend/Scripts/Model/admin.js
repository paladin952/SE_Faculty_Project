(function () {
    'use strict';

    function Admin() {
        this.person = null;
    }

    function Admin(person) {
        this.person = person;
    }

    Admin.fromDto = function (dto) {
        var admin = new Admin();
        admin.person = dto.personVO;
        return admin;
    };

    Admin.prototype.toDto = function () {
        return {
            "personVO": this.person
        };
    };

    this.Model = this.Model || {};
    this.Model.Admin = Admin;

}).call(this);