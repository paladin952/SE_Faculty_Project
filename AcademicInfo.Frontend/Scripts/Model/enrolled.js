(function () {
    'use strict';

    function Enrolled() {
        this.id = -1;
        this.course = null;
        this.student = null;
    }

    function Enrolled(id, student, course) {
        this.id = id;
        this.course = course;
        this.student = student;
    }

    Enrolled.fromDto = function (dto) {
        var en = new Enrolled();
        en.id = dto.id;
        en.course = dto.courseVO;
        en.student = dto.studentVO;
        return en;
    };

    Enrolled.prototype.toDto = function () {
        return {
            "id": this.id,
            "courseVO": this.course,
            "studentVO": this.student
        };
    };

    this.Model = this.Model || {};
    this.Model.Enrolled = Enrolled;

}).call(this, this.Model.Enrolled);
