package com.se.database.dao.interfaces;

import com.se.database.dao.model.academic.groups.DepartmentVO;

import java.util.List;

public interface IDepartmentDAO {
    /**
     * Returns a list of departments
     * @return The list
     */
    List<DepartmentVO> list();

    /**
     * Returns a department having a given id
     * @param id the id to look up
     * @return a department (or null if the id doesn't exist)
     */
    DepartmentVO getByID(int id);

    /**
     * Updates a department, using the id passed as argument to identify it
     * @param departmentVO the updated department
     */
    DepartmentVO updateOrSave(DepartmentVO departmentVO);

    /**
     * Deletes a department, using the id passed as argument to identify it
     * @param id the department's id
     * @return true if a department having the id was deleted, false otherwise
     */
    Boolean deleteByID(int id);
}
