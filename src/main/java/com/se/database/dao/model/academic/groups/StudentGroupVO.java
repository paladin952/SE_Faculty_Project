package com.se.database.dao.model.academic.groups;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.se.database.dao.model.users.StudentVO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "studentgroup")
public class StudentGroupVO implements Serializable {

    @Id
    @Column(name = "StudentGroupID")
    private int id;

    @Column(name = "CurrentSemester")
    private int currentSemester;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "group")
    private List<StudentVO> students;

    public StudentGroupVO() {
    }

    public StudentGroupVO(int groupId, int currentSemester, List<StudentVO> students){
        this.id = id;
        this.currentSemester = currentSemester;
        this.students = students;
    }

    public StudentGroupVO(int groupId, int currentSemester) {

        this.id = groupId;
        this.currentSemester = currentSemester;
    }

    public StudentGroupVO(int groupId, List<StudentVO> students, int currentSemester) {

        this.id = groupId;
        this.students = students;
        this.currentSemester = currentSemester;
    }

    public int getId() {
        return id;
    }

    public void setId(int groupId) {
        this.id = groupId;
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
                "scholarshipId=" + id +
                ", students=" + students +
                ", currentSemester=" + currentSemester +
                '}';
    }
}
