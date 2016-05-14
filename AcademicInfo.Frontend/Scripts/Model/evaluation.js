(function () {
    'use strict';

    function Evaluation() {
        this.id = -1;
        this.type = '';
    }

    function Evaluation(id, type) {
        this.id = id;
        this.type = type;
    }

    Evaluation.fromDto = function (dto) {
        var ev = new AccessRule();
        ev.id = dto.getId();
        ev.type = dto.getType();
        return ev;
    };

    //AccessRule.prototype.toDto = function () {
    //    return {
    //        Id: this.id,
    //        Name: this.name,
    //        DateAdded: this.dateAdded
    //    };
    //};

    this.Model = this.Model || {};
    this.Model.Evaluation = Evaluation;

}).call(this);