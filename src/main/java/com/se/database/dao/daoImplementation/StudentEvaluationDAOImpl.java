package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IStudentEvaluationDAO;
import com.se.database.dao.model.academic.study.StudentEvaluationVO;
import com.se.database.dao.model.users.AdminVO;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentEvaluationDAOImpl implements IStudentEvaluationDAO {
    private SessionFactory sessionFactory;

    public StudentEvaluationDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<StudentEvaluationVO> list() {
        @SuppressWarnings("unchecked")
        List<StudentEvaluationVO> student_evaluations = (List<StudentEvaluationVO>) sessionFactory.getCurrentSession()
                .createCriteria(StudentEvaluationVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();

        return student_evaluations;
    }

    @Override
    public StudentEvaluationVO updateOrSave(StudentEvaluationVO student_evaluation) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM studentevaluation SE WHERE SE.StudentID = :student_id AND SE.EvaluationID = :evaluation_id";
        Query select = session.createQuery(hql);
        select.setParameter("student_id", student_evaluation.getStudentVO().getId())
                .setParameter("evaluation_id", student_evaluation.getEvaluationVO().getId());

        @SuppressWarnings("unchecked")
        List<StudentEvaluationVO> student_evaluations = (List<StudentEvaluationVO>) select.list();
        if (student_evaluations.isEmpty())
        {
            StudentEvaluationVO new_student_evaluation = new StudentEvaluationVO(student_evaluation.getEvaluationVO(), student_evaluation.getStudentVO(), student_evaluation.getGrade(), student_evaluation.isAbsent());
            session.save(new_student_evaluation);
            return new_student_evaluation;
        }
        else
        {
            StudentEvaluationVO tmp = student_evaluations.get(0);
            hql = "UPDATE studentevaluation SET Grade = :grade, IsAbsent = :is_absent WHERE StudentID = :student_id AND EvaluationID = :evaluation_id";
            Query update = session.createQuery(hql);
            update.setParameter("grade", student_evaluation.getGrade())
                    .setParameter("is_absent", student_evaluation.isAbsent())
                    .setParameter("student_id", student_evaluation.getStudentVO().getId())
                    .setParameter("evaluation_id", student_evaluation.getEvaluationVO().getId());
            update.executeUpdate();
            return student_evaluation;
        }
    }

    @Override
    public Boolean deleteByIDs(int student_id, int evaluation_id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "DELETE FROM studentevaluation WHERE StudentID = :student_id AND EvaluationID = :evaluation_id";
        Query delete = session.createQuery(hql);
        delete.setParameter("student_id", student_id)
                .setParameter("evaluation_id", evaluation_id);
        return delete.executeUpdate() > 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<StudentEvaluationVO> getStudentEvaluationsFor(int student_id) {

        Query query = sessionFactory.getCurrentSession().createSQLQuery(
                "select * FROM studentevaluation e WHERE e.StudentID = :student_id")
                .addEntity(StudentEvaluationVO.class)
                .setString("student_id", String.valueOf(student_id));
        List<StudentEvaluationVO> result = (List<StudentEvaluationVO>) query.list();
        return result;
    }
}
