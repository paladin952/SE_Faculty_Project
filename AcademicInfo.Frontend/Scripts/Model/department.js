(function () {
    'use strict';

    function Department() {
        this.id = -1;
        this.name = '';
        this.teachers = [];
    }

    function Department(name, teachers) {
        this.name = name;
        this.teachers = teachers;
    }

    Department.fromDto = function (dto) {
        var department = new Department();
        department.id = dto.id;
        department.name = dto.name;
        //department.teachers = dto.getTeachers();
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

}).call(this, this.Model.Teacher);