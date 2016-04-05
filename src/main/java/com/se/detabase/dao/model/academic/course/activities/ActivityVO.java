package com.se.detabase.dao.model.academic.course.activities;

import java.io.Serializable;

/**
 * Created by Catalin on 03-Apr-16.
 */
public class ActivityVO implements Serializable{

    private int hoursPerWeek;

    public ActivityVO(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public String toString() {
        return "ActivityVO{" +
                "hoursPerWeek=" + hoursPerWeek +
                '}';
    }
}
