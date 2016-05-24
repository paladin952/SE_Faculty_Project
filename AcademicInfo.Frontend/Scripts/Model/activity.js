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
        activity.hoursPerWeek = dto.hoursPereek;
        return activity;
    };

    Activity.prototype.toDto = function () {
        return {
            "hoursPerWeek": this.hoursPerWeek
        };
    };

    this.Model = this.Model || {};
    this.Model.Activity = Activity;

}).call(this);