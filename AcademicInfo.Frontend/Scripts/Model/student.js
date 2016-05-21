(function () {
    'use strict';

    function Student() {
        this.id = -1;
        this.personVO = null;
        this.group = null;
        this.isExtended = false;
        this.status = '';
    }

    function Student(id, person, group, extended, status) {
        this.id = id;
        this.personVO = person;
        this.group = group;
        this.isExtended = extended;
        this.status = status;
    }

    Student.fromDto = function (dto) {
        var student = new Student();
        student.id = dto.id;
        student.personVO = dto.personVO;
        student.group = dto.group;
        student.isExtended = dto.isExtended;
        student.status = dto.status;
        return student;
    };

    Student.prototype.toDto = function () {
        return {
            "id": this.id,
            "personVO": this.personVO,
            "group": this.group,
            "isExtended": this.isExtended,
            "status": this.status
        };
    };

    this.Model = this.Model || {};
    this.Model.Student = Student;

}).call(this, this.Model.Person, this.Model.Group);