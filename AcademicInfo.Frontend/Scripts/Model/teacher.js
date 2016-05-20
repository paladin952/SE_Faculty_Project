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
        teacher.id= dto.id;
        teacher.person= dto.personVO;
        teacher.department= dto.departmentVO;
        teacher.wage= dto.wage;
        teacher.isChief= dto.chief;
        return teacher;
    };

    Teacher.prototype.toDto = function () {
        return {
            "id": this.id,
            "person": this.person,
            "department": this.department,
            "wage": this.wage,
            "isChief": this.isChief

        };
    };

    this.Model = this.Model || {};
    this.Model.Teacher = Teacher;

}).call(this, this.Model.Person);