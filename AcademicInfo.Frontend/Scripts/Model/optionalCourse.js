(function () {
    'use strict';

    function OptionalCourse() {
        this.groupNumber = '';
        this.course = '';
    }

    function OptionalCourse(groupNumber, course) {
        this.groupNumber = groupNumber;
        this.course = course;
    }

    OptionalCourse.fromDto = function (dto) {
        var oc = new OptionalCourse();
        oc.groupNumber = dto.groupNumber;
        oc.course = dto.course;
        return oc;
    };

    OptionalCourse.prototype.toDto = function () {
        return {
            "id": this.id,
            "groupNumber": this.groupNumber,
            "course": this.this.course
        };
    };

    this.Model = this.Model || {};
    this.Model.OptionalCourse = OptionalCourse;

}).call(this, this.Model.Course);
