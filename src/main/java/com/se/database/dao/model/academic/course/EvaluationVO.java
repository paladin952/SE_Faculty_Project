package com.se.database.dao.model.academic.course;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Catalin on 03-Apr-16.
 */
@Entity
@Table(name = "evaluation")
public class EvaluationVO implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "EvaluationID")
    private int id;

    @Column(name = "EvaluationType")
    private int type;

//    @ManyToOne
//    @JoinColumn(name = "CourseID")
//    private CourseVO courseVO;

    public EvaluationVO() {
    }

    public EvaluationVO(int type) {
        this.type = type;
        //this.courseVO = courseVO;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public EvaluationVO setType(int type) {
        this.type = type;

        return this;
    }

//    public CourseVO getCourseVO() {
//        return courseVO;
//    }
//
//    public void setCourseVO(CourseVO courseVO) {
//        this.courseVO = courseVO;
//    }

    @Override
    public String toString() {
        return "EvaluationVO { " +
                "id = " + id +
                ", type = " + type +
                //", course = " + courseVO +
                " }";
    }
}
