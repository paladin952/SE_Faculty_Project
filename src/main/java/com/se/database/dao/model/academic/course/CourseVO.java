package com.se.database.dao.model.academic.course;

import com.se.database.dao.model.academic.course.activities.ActivityVO;
import com.se.database.dao.model.academic.faculty.DegreeVO;
import com.se.util.enums.EvaluationTypeEnum;

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
    private DegreeVO degreeVO;

    @Column(name = "Name")
    private String name;

    @Column(name = "Credits")
    private int credits;

    @Column(name = "AssignedSemester")
    private int assignedSemester;

    public CourseVO() {
    }

    public CourseVO(String id, String name, int credits, int assignedSemester) {
        this.id = id;
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

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getAssignedSemester() {
        return assignedSemester;
    }

    public void setAssignedSemester(int assignedSemester) {
        this.assignedSemester = assignedSemester;
    }

    public DegreeVO getDegreeVO() {
        return degreeVO;
    }

    public void setDegreeVO(DegreeVO degreeVO) {
        this.degreeVO = degreeVO;
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
