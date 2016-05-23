(function (_, Student) {
    'use strict';

    function Group() {
        this.id = -1;
        this.currentSemester = -1;
    }

    function Group(id, sem) {
        this.id = id;
        this.currentSemester = sem;
    }

    Group.fromDto = function (dto) {
        var group = new Group();
        group.id = dto.id;
        group.currentSemester = dto.currentSemester;
        return group;
    };

    Group.prototype.toDto = function () {
        return {
            "id": this.id,
            "currentSemester": this.currentSemester
        };
    };

    this.Model = this.Model || {};
    this.Model.Group = Group;

}).call(this, this._);