(function (_, Teacher) {
    'use strict';

    function Department() {
        this.id = -1;
        this.name = '';
    }

    function Department(id, name) {
        this.id = id;
        this.name = name;
    }

    Department.fromDto = function (dto) {
        var department = new Department();
        department.id = dto.id;
        department.name = dto.name;
        return department;
    };

    Department.prototype.toDto = function () {
        return {
            "id": this.id,
            "name": this.name
        };
    };

    this.Model = this.Model || {};
    this.Model.Department = Department;

}).call(this,this._, this.Model.Teacher);