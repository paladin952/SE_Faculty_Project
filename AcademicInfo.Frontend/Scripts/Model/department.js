(function () {
    'use strict';

    function Department() {
        this.name = '';
        this.teachers = [];
    }

    function Department(name, teachers) {
        this.name = name;
        this.teachers = teachers;
    }

    S.fromDto = function (dto) {
        var department = new Department();
        department.name = dto.getName();
        department.teachers = dto.getTeachers();
        return department;
    };

    //AccessRule.prototype.toDto = function () {
    //    return {
    //        Id: this.id,
    //        Name: this.name,
    //        DateAdded: this.dateAdded
    //    };
    //};

    this.Model = this.Model || {};
    this.Model.Department = Department;

}).call(this, this.Model.Teacher);