(function () {
    'use strict';

    function Activity() {
        this.hoursPerWeek = null;
    }

    function Activity(hours) {
        this.hoursPerWeek = hours;
    }

    Activity.fromDto = function (dto) {
        var activity = new Activity();
        activity.hoursPerWeek = dto.getHoursPerWeek();
        return activity;
    };

    //AccessRule.prototype.toDto = function () {
    //    return {
    //        Id: this.id,
    //        Name: this.name,
    //        DateAdded: this.dateAdded
    //    };
    //};

    this.Model = this.Model || {};
    this.Model.Activity = Activity;

}).call(this);