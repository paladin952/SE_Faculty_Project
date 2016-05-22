(function () {
    'use strict';

    function Evaluation() {
        this.id = -1;
        this.type = '';
        this.course = null;
    }

    function Evaluation(id, type, course) {
        this.id = id;
        this.type = type;
        this.course = course;
    }

    Evaluation.fromDto = function (dto) {
        var ev = new Evaluation();
        ev.id = dto.id;
        ev.type = dto.type;
        ev.course = dto.courseVO;
        return ev;
    };

    Evaluation.prototype.toDto = function () {
        return {
            "id": this.id,
            "type": this.type,
            "courseVO": this.course
        };
    };

    this.Model = this.Model || {};
    this.Model.Evaluation = Evaluation;

}).call(thi, this.Model.Course);