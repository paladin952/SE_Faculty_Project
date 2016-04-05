package com.se.database.dao.model.academic.grants;

import java.io.Serializable;

/**
 * Created by Catalin on 03-Apr-16.
 */
public class StudentGrant implements Serializable {

    public int groupId;

    public int studentId;

    public StudentGrant(int studentId, int groupId) {
        this.studentId = studentId;
        this.groupId = groupId;
    }

    public int getGroupId() {
        return groupId;
    }

    public int getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "StudentGrant{" +
                "groupId=" + groupId +
                ", studentId=" + studentId +
                '}';
    }
}
