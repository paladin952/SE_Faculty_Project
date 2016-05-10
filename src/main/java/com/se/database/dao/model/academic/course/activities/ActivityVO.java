package com.se.database.dao.model.academic.course.activities;

import com.se.database.dao.model.academic.course.CourseVO;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Catalin on 03-Apr-16.
 */
@Entity
@Table(name = "activity")
public class ActivityVO implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "ActivityID")
    private int activityId;

    @Column(name = "ActivityType")
    private int activityType;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CourseID")
    private CourseVO courseVo;

    public ActivityVO() {
    }

    public ActivityVO(int activityType, CourseVO courseVo) {
        this.activityType = activityType;
        this.courseVo = courseVo;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getActivityType() {
        return activityType;
    }

    public void setActivityType(int activityType) {
        this.activityType = activityType;
    }

    public CourseVO getCourseVo() {
        return courseVo;
    }

    public void setCourseVo(CourseVO courseVo) {
        this.courseVo = courseVo;
    }

    @Override
    public String toString() {
        return "ActivityVO{" +
                "activityId=" + activityId +
                ", activityType=" + activityType +
                ", courseId='" + courseVo + '\'' +
                '}';
    }
/*
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
    */
}
