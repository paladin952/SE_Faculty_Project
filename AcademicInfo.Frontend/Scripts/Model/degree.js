(function () {
    'use strict';

    function Degree() {
        this.id = -1;
        this.field = '';
        this.type = 3;
        this.duration = '';
        this.faculty = null;
    }

    function Degree(field, type, languages, duration) {
        this.field = field;
        this.type = type;
        this.languages = languages;
        this.duration = duration;
    }

    Degree.fromDto = function (dto) {
        var degree = new Degree();
        degree.id = dto.id;
        degree.field = dto.field;
        degree.type = dto.type;
        degree.duration = dto.duration;
        degree.faculty = dto.faculty;
        return degree;
    };

    Degree.prototype.toDto = function () {
        return {
            "id": this.id,
            "field": this.field,
            "type": this.type,
            "duration": this.duration,
            "faculty": this.faculty
        };
    };

    this.Model = this.Model || {};
    this.Model.Degree = Degree;

}).call(this, this.Model.Course);