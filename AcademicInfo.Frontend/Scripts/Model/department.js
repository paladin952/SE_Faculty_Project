(function (_, Teacher) {
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
        department.teachers = dto._.map(dto.professors, function (dto) {
            return Model.Teacher.fromDto(dto);
        });
        return department;
    };

    Department.prototype.toDto = function () {
        return {
            "id": this.id,
            "name": this.name,
            "professors": _.map(this.teachers, function (teach) { return teach.toDto(); })
        };
    };

    this.Model = this.Model || {};
    this.Model.Department = Department;

}).call(this,this._, this.Model.Teacher);