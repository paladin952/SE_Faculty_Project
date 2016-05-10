package com.se.database.dao.model.academic.course;

import com.se.database.dao.model.academic.course.activities.ActivityVO;
import com.se.database.dao.model.academic.faculty.DegreeVO;
import com.se.util.enums.EvaluationTypeEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Catalin on 03-Apr-16.
 */
@Entity
@Table(name = "course")
public class CourseVO implements Serializable {
    @Id
    @Column(name = "CourseID")
    private String courseID;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "DegreeID")
    private DegreeVO degree;

    @Column(name = "Name")
    private String name;

    @Column(name = "Credits")
    private int credits;

    @Column(name = "EvaluationType")
    private int evaluationType;

    @Column(name = "AssignedSemester")
    private int assignedSemester;

    public CourseVO() {
    }

    public CourseVO(String courseID, DegreeVO degree, String name, int credits, int evaluationType, int assignedSemester) {
        this.courseID = courseID;
        this.degree =degree;
        this.name = name;
        this.credits = credits;
        this.evaluationType = evaluationType;
        this.assignedSemester = assignedSemester;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public DegreeVO getDegreeID() {
        return degree;
    }

    public void setDegreeID(DegreeVO degreeID) {
        this.degree = degreeID;
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

    public int getEvaluationType() {
        return evaluationType;
    }

    public void setEvaluationType(int evaluationType) {
        this.evaluationType = evaluationType;
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
                "courseID='" + courseID + '\'' +
                ", degree=" + degree +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", evaluationType=" + evaluationType +
                ", assignedSemester=" + assignedSemester +
                '}';
    }
    /*
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
    */
}
