package com.se.database.dao.model.academic.course.activities;

import com.se.database.dao.model.academic.course.CourseVO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "activity")
public class ActivityVO implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "ActivityID")
    private int id;

    @Column(name = "HoursPerWeek")
    private int hours_per_week;

    @Column(name = "ActivityType")
    private int activity_type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CourseID")
    private CourseVO course;

    public ActivityVO() {
    }

    public ActivityVO(int hours_per_week, int activity_type, CourseVO course) {
        this.hours_per_week = hours_per_week;
        this.activity_type = activity_type;
        this.course = course;
    }

    public int getHours_per_week() {
        return hours_per_week;
    }

    public ActivityVO setHours_per_week(int hours_per_week) {
        this.hours_per_week = hours_per_week;

        return this;
    }

    public int getActivity_type() {
        return activity_type;
    }

    public ActivityVO setActivity_type(int activity_type) {
        this.activity_type = activity_type;

        return this;
    }

    public CourseVO getCourse() {
        return course;
    }

    public ActivityVO setCourse(CourseVO course) {
        this.course = course;

        return this;
    }

    public int getID() {
        return id;
    }
}
