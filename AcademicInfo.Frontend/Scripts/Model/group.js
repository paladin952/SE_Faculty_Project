(function (_, Student) {
    'use strict';

    function Group() {
        this.id = -1;
        this.students = [];
        this.currentSemester = -1;
    }

    function Group(id, students, sem) {
        this.id = id;
        this.students = students;
        this.currentSemester = sem;
    }

    Group.fromDto = function (dto) {
        var group = new Group();
        group.id = dto.id;
        group.students = _.map(dto.students, function (dto) {
            return Model.Student.fromDto(dto);
        });
        group.currentSemester = dto.currentSemester;
        return group;
    };

    Group.prototype.toDto = function () {
        return {
            "id": this.id,
            "students": _.map(this.students, function (stud) { return stud.toDto(); }),
            "currentSemester": this.currentSemester
        };
    };

    this.Model = this.Model || {};
    this.Model.Group = Group;

}).call(this, this._, this.Model.Student);