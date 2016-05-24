(function () {
    'use strict';

    function Teacher() {
        this.id = -1;
        this.personVO = new Person();
        this.department = new Department();
        this.wage = 0;
        this.chief = false;
    }

    function Teacher(id, personVO, department, isChief, wage) {
        this.id= id;
        this.personVO = personVO;
        this.department = department;
        this.wage = wage;
        this.chief = isChief;
    }

    Teacher.fromDto = function (dto) {
        var teacher = new Teacher();
        teacher.id = dto.id;
        teacher.personVO = dto.personVO;
        teacher.department = dto.departmentVO;
        teacher.wage = dto.wage;
        teacher.chief = dto.chief;
        return teacher;
    };

    Teacher.prototype.toDto = function () {
        return {
            "departmentVO": this.department,
            "wage": this.wage,
            "personVO": this.personVO,
            "chief": this.chief
        };
    };

    this.Model = this.Model || {};
    this.Model.Teacher = Teacher;

}).call(this, this.Model.Person);