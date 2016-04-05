package com.se.detabase.dao.model.academic.faculty;

import com.se.detabase.dao.model.academic.course.CourseVO;
import com.se.util.enums.DegreeTypesEnum;
import com.se.util.enums.LanguageTypesEnum;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Catalin on 03-Apr-16.
 */
public class DegreeVO implements Serializable {

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
}
