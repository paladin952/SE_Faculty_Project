(function () {
    'use strict';

    function Course() {
        this.id = '';
        this.degreeVO =null;
        this.name = '';
        this.credits = '';
        this.assignedSemester = '';
    }

    function Course(abstractName, name, credits, assignedSemester) {
        this.id = abstractName;
        this.name = name;
        this.credits = credits;
        this.assignedSemester = assignedSemester;
    }

    Course.fromDto = function (dto) {
        var course = new Course();
        course.id = dto.id;
        course.degreeVO = dto.degreeVO;
        course.name = dto.name;
        course.credits = dto.credits;
        course.assignedSemester = dto.assignedSemester;
        return course;
    };

    Course.prototype.toDto = function () {
        return {
            "id": this.id,
            "degreeVO": this.degreeVO,
            "name": this.name,
            "credits": this.dateAdded,
            "assignedSemester": this.assignedSemester
        };
    };

    this.Model = this.Model || {};
    this.Model.Course = Course;

}).call(this);
