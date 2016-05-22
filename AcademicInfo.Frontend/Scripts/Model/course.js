(function () {
    'use strict';

    function Course() {
        this.id = '';
        this.degree =null;
        this.name = '';
        this.credits = '';
        this.assignedSemester = '';
    }

    function Course(id, name, degree, credits, assignedSemester) {
        this.id = id;
        this.name = name;
        this.degree = degree;
        this.credits = credits;
        this.assignedSemester = assignedSemester;
    }

    Course.fromDto = function (dto) {
        var course = new Course();
        course.id = dto.id;
        course.degree = dto.degreeVO;
        course.name = dto.name;
        course.credits = dto.credits;
        course.assignedSemester = dto.assignedSemester;
        return course;
    };

    Course.prototype.toDto = function () {
        return {
            "id": this.id,
            "degreeVO": this.degree,
            "name": this.name,
            "credits": this.credits,
            "assignedSemester": this.assignedSemester
        };
    };

    this.Model = this.Model || {};
    this.Model.Course = Course;

}).call(this, this.Model.Degree);
