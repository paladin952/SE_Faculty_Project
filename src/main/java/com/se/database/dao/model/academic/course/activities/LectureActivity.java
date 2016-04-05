package com.se.database.dao.model.academic.course.activities;

/**
 * Created by Catalin on 03-Apr-16.
 */
public class LectureActivity extends ActivityVO {

    public LectureActivity(int hoursPerWeek) {
        super(hoursPerWeek);
    }

    @Override
    public String toString() {
        return "LectureActivity{" +
                "hoursPerWeek=" + getHoursPerWeek() +
                "}";
    }
}
