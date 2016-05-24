(function () {
    'use strict';

    function OptionalCourse() {
        this.groupNo = '';
        this.course = '';
    }

    function OptionalCourse(groupNumber, course) {
        this.groupNo = groupNumber;
        this.course = course;
    }

    OptionalCourse.fromDto = function (dto) {
        var oc = new OptionalCourse();
        oc.groupNo = dto.groupNumber;
        oc.course = dto.course;
        return oc;
    };

    OptionalCourse.prototype.toDto = function () {
        return {
            "id": this.id,
            "groupNo": this.groupNo,
            "course": this.this.course
        };
    };

    this.Model = this.Model || {};
    this.Model.OptionalCourse = OptionalCourse;

}).call(this, this.Model.Course);
