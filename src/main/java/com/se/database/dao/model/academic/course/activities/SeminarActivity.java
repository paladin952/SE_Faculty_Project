package com.se.database.dao.model.academic.course.activities;

/**
 * Created by Catalin on 03-Apr-16.
 */
public class SeminarActivity extends ActivityVO {

    public SeminarActivity(int hoursPerWeek) {
        super(hoursPerWeek);
    }

    @Override
    public String toString() {
        return "SeminarActivity{" +
                "hoursPerWeek=" + getHoursPerWeek() +
                "}";
    }
}
