package com.se.detabase.dao.model.academic.course.activities;

/**
 * Created by Catalin on 03-Apr-16.
 */
public class LaboratoryActivity extends ActivityVO {

    public LaboratoryActivity(int hoursPerWeek) {
        super(hoursPerWeek);
    }

    @Override
    public String toString() {
        return "LaboratoryActivity{" +
                "hoursPerWeek=" + getHoursPerWeek() +
                "}";
    }
}
