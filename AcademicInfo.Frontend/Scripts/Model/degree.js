(function () {
    'use strict';

    function Degree() {
        this.field = '';
        this.type = '';
        this.languages = [];
        this.duration = -1;
        this.courses = [];
    }

    function Degree(field, type, languages, duration, courses) {
        this.field = field;
        this.type = type;
        this.languages = languages;
        this.duration = duration;
        this.courses = courses;
    }

    Degree.fromDto = function (dto) {
        var degree = new Degree();
        degree.field = dto.getField();
        degree.type = dto.getType();
        degree.languages = dto.getLanguages();
        degree.duration = dto.getDuration();
        degree.courses = dto.getCourses();
        return degree;
    };

    //AccessRule.prototype.toDto = function () {
    //    return {
    //        Id: this.id,
    //        Name: this.name,
    //        DateAdded: this.dateAdded
    //    };
    //};

    this.Model = this.Model || {};
    this.Model.Degree = Degree;

}).call(this, this.Model.Course);