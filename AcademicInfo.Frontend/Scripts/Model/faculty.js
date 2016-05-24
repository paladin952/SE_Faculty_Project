(function () {
    'use strict';

    function Faculty() {
        this.id = -1;
        this.name = null;
    }

    function Faculty(id, name) {
        this.name = name;
        this.id = id;
    }

    Faculty.fromDto = function (dto) {
        var faculty = new Faculty();
        faculty.name = dto.name;
        faculty.id = dto.id;
        return faculty;
    };

    Faculty.prototype.toDto = function () {
        return {
            "id": this.id,
            "name": this.name
        };
    };

    this.Model = this.Model || {};
    this.Model.Faculty = Faculty;

}).call(this, this.Model.Degree);