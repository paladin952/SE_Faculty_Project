(function () {
    'use strict';

    function Admin() {
        this.personVO = null;
    }

    function Admin(person) {
        this.personVO = person;
    }

    Admin.fromDto = function (dto) {
        var admin = new Admin();
        admin.personVO = dto.personVO;
        return admin;
    };

    Admin.prototype.toDto = function () {
        return {
            "personVO": this.personVO
        };
    };

    this.Model = this.Model || {};
    this.Model.Admin = Admin;

}).call(this);