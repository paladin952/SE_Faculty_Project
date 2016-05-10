package com.se.database.dao.model.academic.faculty;

import com.se.database.dao.model.academic.course.CourseVO;
import com.se.util.enums.DegreeTypesEnum;
import com.se.util.enums.LanguageTypesEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Catalin on 03-Apr-16.
 */
@Entity
@Table(name = "degree")
public class DegreeVO implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "DegreeID")
    private int degreeId;

    @Column(name = "Field")
    private String field;

    @Column(name = "Type")
    private int type;

    @Column(name = "Duration")
    private int duration;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FacultyID")
    private FacultyVO faculty;

    public DegreeVO() {
    }

    public DegreeVO(String field, int type, int duration, FacultyVO faculty) {
        this.field = field;
        this.type = type;
        this.duration = duration;
        this.faculty = faculty;
    }

    public int getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(int degreeId) {
        this.degreeId = degreeId;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public FacultyVO getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyVO faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "DegreeVO{" +
                "degreeId=" + degreeId +
                ", field='" + field + '\'' +
                ", type=" + type +
                ", duration=" + duration +
                ", faculty=" + faculty +
                '}';
    }
/*
    private String field;

    private DegreeTypesEnum type;

    private List<LanguageTypesEnum> languages;

    private int duration;

    private List<CourseVO> courses;

    public DegreeVO(String field, DegreeTypesEnum type, List<LanguageTypesEnum> languages, int duration, List<CourseVO> courses) {
        this.field = field;
        this.type = type;
        this.languages = languages;
        this.duration = duration;
        this.courses = courses;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public DegreeTypesEnum getType() {
        return type;
    }

    public void setType(DegreeTypesEnum type) {
        this.type = type;
    }

    public List<LanguageTypesEnum> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LanguageTypesEnum> languages) {
        this.languages = languages;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<CourseVO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseVO> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Degree{" +
                "field='" + field + '\'' +
                ", type=" + type +
                ", languages=" + languages +
                ", duration=" + duration +
                ", courses=" + courses +
                '}';
    }
    */
}
