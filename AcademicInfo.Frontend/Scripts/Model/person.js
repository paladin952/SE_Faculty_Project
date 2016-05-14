(function () {
    'use strict';

    function Person() {
        this.user = null;
        this.firstName = '';
        this.lastName = '';
        this.dob = '';
        this.ssn = '';
        this.address = '';
        this.phone = '';
    }

    function Person(user, first, last, dob, ssn, address, phone) {
        this.user = user;
        this.firstName = first;
        this.lastName = last;
        this.dob = dob;
        this.ssn = ssn;
        this.address = address;
        this.phone = phone;
    }

    S.fromDto = function (dto) {
        var person = new Person();
        person.user = dto.getUser();
        person.firstName = dto.getFirstName();
        person.lastName = dto.getLastName();
        person.dob = dto.getDob();
        person.ssn = dto.getSsn();
        person.address = dto.getAddress();
        this.phone = dto.getPhone();
        return person;
    };

    //AccessRule.prototype.toDto = function () {
    //    return {
    //        Id: this.id,
    //        Name: this.name,
    //        DateAdded: this.dateAdded
    //    };
    //};

    this.Model = this.Model || {};
    this.Model.Person = Person;

}).call(this, this.Model.User);
