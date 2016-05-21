(function () {
    'use strict';

    function StudentEvaluation() {
        this.id = -1;
        this.evaluationVO = null;
        this.grade = 1;
        this.absent = false;
        this.studentVO = null;
    }

    function StudentEvaluation(id) {
        this.id = id;
        this.evaluationVO = null;
        this.grade = 1;
        this.absent = false;
        this.studentVO = null;
    }

    StudentEvaluation.fromDto = function (dto) {
        var ev = new StudentEvaluation();
        ev.id = dto.id;
        ev.evaluationVO = dto.evaluationVO;
        ev.grade = dto.grade;
        ev.absent = dto.absent;
        ev.studentVO = dto.studentVO;
        return ev;
    };

    StudentEvaluation.prototype.toDto = function () {
        return {
            "id": this.id,
            "evaluationVO": this.evaluationVO,
            "grade": this.grade,
            "absent": this.absent,
            "studentVO": this.studentVO,
        };
    };

    this.Model = this.Model || {};
    this.Model.StudentEvaluation = StudentEvaluation;

}).call(this, this.Model.Evaluation, this.Model.Student);