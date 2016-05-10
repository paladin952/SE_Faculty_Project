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

    @Column(name = "GroupNo")
    private int groupNo;

    @Id
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

    public OptionalCourseVO(CourseVO course, int assignedSemester, int groupNo) {
        this.groupNo = groupNo;
        this.course = course;
    }

    public CourseVO getCourse() {
        return course;
    }

    public void setCourse(CourseVO course) {
        this.course = course;
    }

    public int getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(int groupNo) {
        this.groupNo = groupNo;
    }

    @Override
    public String toString() {
        return "OptionalCourseVO{" +
                "groupNo=" + groupNo +
                ", course=" + course +
                '}';
    }
}
