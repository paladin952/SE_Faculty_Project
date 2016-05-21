package com.se.database.dao.model.academic.faculty;

import com.se.database.dao.model.academic.course.CourseVO;
import com.se.util.enums.DegreeTypesEnum;
import com.se.util.enums.LanguageTypesEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "degree")
public class DegreeVO implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "DegreeID")
    private int id;

    @Column(name = "Field")
    private String field;

    @Column(name = "Type")
    private DegreeTypesEnum type;

    @Column(name = "Duration")
    private int duration;

    @ManyToOne
    @JoinColumn(name = "FacultyID")
    private FacultyVO faculty;

    public DegreeVO(String field, DegreeTypesEnum type, int duration) {
        this.field = field;
        this.type = type;
        this.duration = duration;
    }

    public DegreeVO(String field, DegreeTypesEnum type, int duration, FacultyVO faculty) {
        this.field = field;
        this.type = type;
        this.duration = duration;
        this.faculty = faculty;
    }

    public int getId() {
        return id;
    }

    public String getField() {
        return field;
    }

    public DegreeVO setField(String field) {
        this.field = field;

        return this;
    }

    public DegreeTypesEnum getType() {
        return type;
    }

    public DegreeVO setType(DegreeTypesEnum type) {
        this.type = type;

        return this;
    }

    public int getDuration() {
        return duration;
    }

    public DegreeVO setDuration(int duration) {
        this.duration = duration;

        return this;
    }

    public FacultyVO getFaculty() {
        return faculty;
    }

    public DegreeVO setFaculty(FacultyVO faculty) {
        this.faculty = faculty;

        return this;
    }

    @Override
    public String toString() {
        return "Degree{" +
                "field='" + field + '\'' +
                ", type=" + type +
                ", faculty=" + faculty +
                ", duration=" + duration +
                '}';
    }
}
