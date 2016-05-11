package com.se.database.dao.interfaces;

import com.se.database.dao.model.academic.course.OptionalCourseVO;

import java.util.List;

public interface IOptionalCourseDAO {
    /**
     * Returns a list of optional courses
     * @return The list
     */
    List<OptionalCourseVO> list();

    /**
     * Returns an optional course having a given id
     * @param id the id to look up
     * @return an optional course (or null if the id doesn't exist)
     */
    OptionalCourseVO getByID(int id);

    /**
     * Updates an optional course, using the id passed as argument to identify it
     * @param optionalCourse the updated optional course
     */
    OptionalCourseVO updateOrSave(OptionalCourseVO optionalCourse);

    /**
     * Deletes an optional course, using the id passed as argument to identify it
     * @param id the optionalCourse's id
     * @return true if an optional course having the id was deleted, false otherwise
     */
    Boolean deleteByID(int id);
}
