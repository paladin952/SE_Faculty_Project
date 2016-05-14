(function () {
    'use strict';

    function Faculty() {
        this.name = null;
        this.degrees = [];
    }

    function Faculty(name, degrees) {
        this.name = name;
        this.degrees = degrees;
    }

    Faculty.fromDto = function (dto) {
        var faculty = new Faculty();
        faculty.name = dto.getName();
        faculty.dateAdded = dto.getDegrees();
        return faculty;
    };

    //AccessRule.prototype.toDto = function () {
    //    return {
    //        Id: this.id,
    //        Name: this.name,
    //        DateAdded: this.dateAdded
    //    };
    //};

    this.Model = this.Model || {};
    this.Model.Faculty = Faculty;

}).call(this, this.Model.Degree);