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
    private String id;

    @ManyToOne
    @Column(name = "DegreeID")
    private DegreeVO degreeVO;

    @Column(name = "Name")
    private String name;

    @Column(name = "Credits")
    private int credits;

    private List<ActivityVO> activities;

    @Column(name = "AssignedSemester")
    private int assignedSemester;

    public CourseVO() {
    }

    public CourseVO(String id, String name, int credits, List<ActivityVO> activities, int assignedSemester) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.activities = activities;
        this.assignedSemester = assignedSemester;
    }

    public String getId() {
        return id;
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
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", activities=" + activities +
                ", assignedSemester=" + assignedSemester +
                '}';
    }
}
