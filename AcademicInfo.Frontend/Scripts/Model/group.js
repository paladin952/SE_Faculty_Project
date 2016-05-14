(function () {
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
        group.id = dto.getId();
        group.name = dto.getStudents();
        group.dateAdded = dto.getCurrentSemester();
        return group;
    };

    //AccessRule.prototype.toDto = function () {
    //    return {
    //        Id: this.id,
    //        Name: this.name,
    //        DateAdded: this.dateAdded
    //    };
    //};

    this.Model = this.Model || {};
    this.Model.Group = Group;

}).call(this, this.Model.Student);