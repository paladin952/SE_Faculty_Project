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
     * Get a user by id
     *
     * @return The user
     */
    List<ScholarshipVO> getScholarshipsForStudent(StudentVO studentVO);

    void deleteScholarshipForStudent(int scholarshipId, int studentId);
}
