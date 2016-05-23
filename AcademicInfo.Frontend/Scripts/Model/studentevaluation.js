(function () {
    'use strict';

    function StudentEvaluation() {
        this.id = -1;
        this.evaluation = null;
        this.grade = 1;
        this.absent = false;
        this.student = null;
    }

    function StudentEvaluation(id, evaluation, grade, absent, student) {
        this.id = id;
        this.evaluation = evaluation;
        this.grade = grade;
        this.absent = absent;
        this.student = student;
    }

    StudentEvaluation.fromDto = function (dto) {
        var ev = new StudentEvaluation();
        ev.id = dto.id;
        ev.evaluation = dto.evaluationVO;
        ev.grade = dto.grade;
        ev.absent = dto.absent;
        ev.student = dto.studentVO;
        return ev;
    };

    StudentEvaluation.prototype.toDto = function () {
        return {
            "id": this.id,
            "evaluationVO": this.evaluation,
            "grade": this.grade,
            "absent": this.absent,
            "studentVO": this.student
        };
    };

    this.Model = this.Model || {};
    this.Model.StudentEvaluation = StudentEvaluation;

}).call(this, this.Model.Evaluation, this.Model.Student);