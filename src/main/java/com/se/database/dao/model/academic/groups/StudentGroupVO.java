package com.se.database.dao.model.academic.groups;

import com.se.database.dao.model.users.StudentVO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "studentgroup")
public class StudentGroupVO implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "StudentGroupId")
    private int groupId;

    @Column(name = "CurrentSemester")
    private int currentSemester;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "group")
    private List<StudentVO> students;

    public StudentGroupVO() {
    }

    public StudentGroupVO(int groupId, int currentSemester) {

        this.groupId = groupId;
        this.currentSemester = currentSemester;
    }

    public StudentGroupVO(int groupId, List<StudentVO> students, int currentSemester) {

        this.groupId = groupId;
        this.students = students;
        this.currentSemester = currentSemester;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public List<StudentVO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentVO> students) {
        this.students = students;
    }

    public int getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(int currentSemester) {
        this.currentSemester = currentSemester;
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "groupId=" + groupId +
                ", students=" + students +
                ", currentSemester=" + currentSemester +
                '}';
    }
}
