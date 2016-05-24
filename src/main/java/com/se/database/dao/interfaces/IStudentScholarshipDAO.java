package com.se.database.dao.interfaces;

import com.se.database.dao.model.academic.grants.ScholarshipVO;
import com.se.database.dao.model.academic.grants.StudentScholarshipVO;
import com.se.database.dao.model.users.StudentVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IStudentScholarshipDAO {

    /**
     * Returns a list of admins
     *
     * @return The list
     */
    List<StudentScholarshipVO> list();

    /**
     * Get a ScholarshipVO by student id
     *
     * @return The ScholarshipVO
     */
    List<ScholarshipVO> getScholarshipsForStudent(int studentVOId);

    List<StudentScholarshipVO> getStudentScholarshipsForStudent(int studentVOId);

    StudentScholarshipVO updateOrSave(StudentScholarshipVO newStudentScholarshipVO);

    Boolean deleteScholarshipForStudent(int scholarshipId, int studentId);

    Boolean deleteById(int studentScholarshipId);
}
