(function () {
    'use strict';

    function Person() {
        this.user = new User();
        this.firstName = '';
        this.lastName = '';
        this.dob = '';
        this.ssn = '';
        this.address = '';
        this.phoneNo = '';
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

    Person.fromDto = function (dto) {
        var person = new Person();
        person.user = dto.userVO;
        person.firstName = dto.firstName;
        person.lastName = dto.lastName;
        person.dob = dto.dob;
        person.ssn = dto.ssn;
        person.address = dto.address;
        this.phoneNo = dto.phoneNo;
        return person;
    };

    Person.prototype.toDto = function () {
        return {
            "id": "-1",
            "firstName": this.firstName,
            "lastName": this.lastName,
            "dob": this.dob,
            "ssn": this.ssn,
            "address": this.address,
            "phoneNo": this.phoneNo,
            "userVO": this.user
        };
    };

    this.Model = this.Model || {};
    this.Model.Person = Person;

}).call(this, this.Model.User);
