package com.se.model.academic.course;

import com.se.model.academic.course.activities.ActivityVO;
import com.se.util.enums.EvaluationTypeEnum;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Catalin on 03-Apr-16.
 */
public class CourseVO implements Serializable {

    private String abstractName;

    private String name;

    private int credits;

    private EvaluationTypeEnum evaluationType;

    private List<ActivityVO> activities;

    private int assignedSemester;

    public CourseVO() {
    }

    public CourseVO(String abstractName, String name, int credits, EvaluationTypeEnum evaluationType, List<ActivityVO> activities, int assignedSemester) {
        this.abstractName = abstractName;
        this.name = name;
        this.credits = credits;
        this.evaluationType = evaluationType;
        this.activities = activities;
        this.assignedSemester = assignedSemester;
    }

    public String getAbstractName() {
        return abstractName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public EvaluationTypeEnum getEvaluationType() {
        return evaluationType;
    }

    public void setEvaluationType(EvaluationTypeEnum evaluationType) {
        this.evaluationType = evaluationType;
    }

    public List<ActivityVO> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityVO> activities) {
        this.activities = activities;
    }

    public int getAssignedSemester() {
        return assignedSemester;
    }

    public void setAssignedSemester(int assignedSemester) {
        this.assignedSemester = assignedSemester;
    }

    @Override
    public String toString() {
        return "CourseVO{" +
                "abstractName='" + abstractName + '\'' +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", evaluationType=" + evaluationType +
                ", activities=" + activities +
                ", assignedSemester=" + assignedSemester +
                '}';
    }
}
