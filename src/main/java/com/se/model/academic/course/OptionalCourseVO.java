package com.se.model.academic.course;

import com.se.model.academic.course.activities.ActivityVO;
import com.se.util.enums.EvaluationTypeEnum;

import java.util.List;

/**
 * Created by Catalin on 03-Apr-16.
 */
public class OptionalCourseVO extends CourseVO {

    private int groupNo;

    public OptionalCourseVO(String abstractName, String name, int credits, EvaluationTypeEnum evaluationType, List<ActivityVO> activities, int assignedSemester, int groupNo) {
        super(abstractName, name, credits, evaluationType, activities, assignedSemester);
        this.groupNo = groupNo;
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
                "abstractName='" + getAbstractName() + '\'' +
                ", name='" + getName() + '\'' +
                ", credits=" + getCredits() +
                ", evaluationType=" + getEvaluationType() +
                ", activities=" + getActivities() +
                ", assignedSemester=" + getAssignedSemester() +
                ", groupNO=" + groupNo +
                '}';
    }
}
