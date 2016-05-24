(function () {
    'use strict';

    function Student() {
        this.id = -1;
        this.personVO = null;
        this.group = null;
        this.extended = false;
        this.status = '';
    }


    function Student(id, personVO, group, extended, status) {
        this.id = id;
        this.personVO = personVO;
        this.group = group;
        this.extended = extended;
        this.status = status;
    }

    Student.fromDto = function (dto) {
        var student = new Student();
        student.id = dto.id;
        student.personVO = dto.personVO;
        student.group = dto.group;
        student.extended = dto.extended;
        student.status = dto.status;
        return student;
    };

    Student.prototype.toDto = function () {
        return {
            "personVO": this.personVO,
            "group": this.group,
            "extended": this.extended,
            "status": this.status
        };
    };

    this.Model = this.Model || {};
    this.Model.Student = Student;

}).call(this, this.Model.Person, this.Model.Group);