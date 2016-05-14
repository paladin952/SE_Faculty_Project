(function () {
    'use strict';

    function Teacher() {
        this.id = -1;
        this.person = null;
        this.department = null;
        this.wage = 0;
        this.isChief = false;
    }

    function Teacher(id, person, department, isChief, wage) {
        this.id= id;
        this.person = person;
        this.department = department;
        this.wage = wage;
        this.isChief = isChief;
    }

    Teacher.fromDto = function (dto) {
        var teacher = new Teacher();
        teacher.id= dto.getId();
        teacher.person= dto.getPerson();
        teacher.department= dto.getDepartment();
        teacher.wage= dto.getWage();
        teacher.isChief= dto.getIsChief();
        return teacher;
    };

    //AccessRule.prototype.toDto = function () {
    //    return {
    //        Id: this.id,
    //        Name: this.name,
    //        DateAdded: this.dateAdded
    //    };
    //};

    this.Model = this.Model || {};
    this.Model.Teacher = Teacher;

}).call(this, this.Model.Person);