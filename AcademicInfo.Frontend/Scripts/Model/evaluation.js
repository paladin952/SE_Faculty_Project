(function () {
    'use strict';

    function Evaluation() {
        this.id = -1;
        this.type = '';
        this.courseVO = null;
    }

    function Evaluation(id, type, course) {
        this.id = id;
        this.type = type;
        this.courseVO = course;
    }

    Evaluation.fromDto = function (dto) {
        var ev = new Evaluation();
        ev.id = dto.id;
        ev.type = dto.type;
        ev.courseVO = dto.courseVO;
        return ev;
    };

    Evaluation.prototype.toDto = function () {
        return {
            "id": this.id,
            "type": this.type,
            "courseVO": this.courseVO
        };
    };

    this.Model = this.Model || {};
    this.Model.Evaluation = Evaluation;

}).call(this, this.Model.Course);