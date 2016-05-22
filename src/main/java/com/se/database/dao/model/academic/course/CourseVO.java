package com.se.database.dao.model.academic.course;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.se.database.dao.model.academic.course.activities.ActivityVO;
import com.se.database.dao.model.academic.faculty.DegreeVO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "course")
public class CourseVO implements Serializable {

    @Id
    @Column(name = "CourseID")
    private String id;

    @ManyToOne
    @JoinColumn(name = "DegreeID")
    private DegreeVO degree;

    @Column(name = "Name")
    private String name;

    @Column(name = "Credits")
    private int credits;

    @Column(name = "AssignedSemester")
    private int assignedSemester;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course")
    private List<ActivityVO> activities;

    public CourseVO() {
    }

    public CourseVO(String id, String name, int credits, int assignedSemester) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.assignedSemester = assignedSemester;
    }

    public CourseVO(String id, DegreeVO degree, String name, int credits, int assignedSemester) {
        this.id = id;
        this.degree = degree;
        this.name = name;
        this.credits = credits;
        this.assignedSemester = assignedSemester;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CourseVO setName(String name) {
        this.name = name;

        return this;
    }

    public int getCredits() {
        return credits;
    }

    public CourseVO setCredits(int credits) {
        this.credits = credits;

        return this;
    }

    public int getAssignedSemester() {
        return assignedSemester;
    }

    public CourseVO setAssignedSemester(int assignedSemester) {
        this.assignedSemester = assignedSemester;

        return this;
    }

    public DegreeVO getDegree() {
        return degree;
    }

    public CourseVO setDegree(DegreeVO degreeVO) {
        this.degree = degreeVO;

        return this;
    }

    public List<ActivityVO> getActivities() {
        return activities;
    }

    public CourseVO setActivities(List<ActivityVO> activities) {
        this.activities = activities;

        return this;
    }

    @Override
    public String toString() {
        return "CourseVO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", assignedSemester=" + assignedSemester +
                '}';
    }
}
