(function () {
    'use strict';

    function Course() {
        this.abstractName = '';
        this.name = '';
        this.credits = '';
        this.evaluationType = '';
        this.activities = '';
        this.assignedSemester = '';
    }

    function Course(abstractName, name, credits, evaluationType, activities, assignedSemester) {
        this.abstractName = abstractName;
        this.name = name;
        this.credits = credits;
        this.evaluationType = evaluationType;
        this.activities = activities;
        this.assignedSemester = assignedSemester;
    }

    S.fromDto = function (dto) {
        var course = new AccessRule();
        course.abstractName = dto.getAbstractName();
        course.name = dto.getName();
        course.credits = dto.getCredits();
        course.evaluationType = dto.getEvaluationType();
        course.activities = dto.getActivies();
        course.assignedSemester = dto.getAssignedSemester();
        return course;
    };

    //AccessRule.prototype.toDto = function () {
    //    return {
    //        Id: this.id,
    //        Name: this.name,
    //        DateAdded: this.dateAdded
    //    };
    //};

    this.Model = this.Model || {};
    this.Model.Course = Course;

}).call(this);
