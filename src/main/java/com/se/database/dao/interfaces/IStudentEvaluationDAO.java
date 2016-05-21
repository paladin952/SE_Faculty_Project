package com.se.database.dao.interfaces;

import com.se.database.dao.model.academic.study.StudentEvaluationVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IStudentEvaluationDAO {
    List<StudentEvaluationVO> list();
    StudentEvaluationVO updateOrSave(StudentEvaluationVO student_evaluation);
    Boolean deleteByIDs(int student_id, int evaluation_id);
    List<StudentEvaluationVO> getStudentEvaluationsFor(int student_id);
}
