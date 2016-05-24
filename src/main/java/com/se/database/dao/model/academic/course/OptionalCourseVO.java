package com.se.database.dao.model.academic.course;

import com.se.database.dao.model.academic.course.activities.ActivityVO;
import com.se.util.enums.EvaluationTypeEnum;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Catalin on 03-Apr-16.
 */
@Entity
@Table(name = "optionalcourse")
public class OptionalCourseVO {

    @Id
    @GeneratedValue
    @Column(name = "OptionalCourseID")
    private int id;

    @Column(name = "GroupNo")
    private int groupNo;

    @OneToOne
    @JoinColumn(name = "CourseID")
    private CourseVO course;

    public OptionalCourseVO() {
    }

    public OptionalCourseVO(int groupNo) {
        this.groupNo = groupNo;
    }

    public OptionalCourseVO(int groupNo, CourseVO course) {
        this.groupNo = groupNo;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CourseVO getCourse() {
        return course;
    }

    public OptionalCourseVO setCourse(CourseVO course) {
        this.course = course;
        return this;
    }

    public int getGroupNo() {
        return groupNo;
    }

    public OptionalCourseVO setGroupNo(int groupNo) {
        this.groupNo = groupNo;

        return this;
    }

    @Override
    public String toString() {
        return "OptionalCourseVO{" +
                "groupNo=" + groupNo +
                ", course=" + course +
                '}';
    }
}
