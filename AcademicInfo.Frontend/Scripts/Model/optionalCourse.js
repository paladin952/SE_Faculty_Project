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
        oc.groupNumber = dto.getGroupNumber();
        oc.course = dto.getCourse();
        return oc;
    };

    //AccessRule.prototype.toDto = function () {
    //    return {
    //        Id: this.id,
    //        Name: this.name,
    //        DateAdded: this.dateAdded
    //    };
    //};

    this.Model = this.Model || {};
    this.Model.OptionalCourse = OptionalCourse;

}).call(this, this.Model.Course);
