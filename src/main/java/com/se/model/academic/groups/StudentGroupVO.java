package com.se.model.academic.groups;

import java.io.Serializable;

/**
 * Created by Catalin on 03-Apr-16.
 */
public class StudentGroupVO implements Serializable {

    private int number;

    private List<StudentVO> students;

    private int currentSemester;

    public StudentGroupVO() {
    }

    public StudentGroupVO(int number, List<StudentVO> students, int currentSemester) {

        this.number = number;
        this.students = students;
        this.currentSemester = currentSemester;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
                "number=" + number +
                ", students=" + students +
                ", currentSemester=" + currentSemester +
                '}';
    }
}
