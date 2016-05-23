(function () {
    'use strict';

    function StudentOptionalCourse() {
        this.id = -1;
        this.course = null;
        this.student = null;
    }

    function StudentOptionalCourse(student, course) {
        this.course = course;
        this.student = student;
    }

    StudentOptionalCourse.fromDto = function (dto) {
        var soc = new StudentOptionalCourse();
        soc.course = dto.courseVO;
        soc.student = dto.studentVO;
        return soc;
    };

    StudentOptionalCourse.prototype.toDto = function () {
        return {
            "courseVO": this.course,
            "studentVO": this.student
        };
    };

    this.Model = this.Model || {};
    this.Model.StudentOptionalCourse = StudentOptionalCourse;

}).call(this, this.Model.StudentOptionalCourse);
