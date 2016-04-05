package com.se.detabase.dao.model.academic.faculty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Catalin on 03-Apr-16.
 */
public class FacultyVO implements Serializable {

    private final String name;

    private List<DegreeVO> degrees;

    public FacultyVO(String name) {
        this.name = name;
    }

    public FacultyVO(String name, List<DegreeVO> degrees) {
        this.name = name;
        this.degrees = degrees;
    }

    public String getName() {
        return name;
    }

    public List<DegreeVO> getDegrees() {
        return degrees;
    }

    public void setDegrees(List<DegreeVO> degrees) {
        this.degrees = degrees;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", degrees=" + degrees +
                '}';
    }
}
