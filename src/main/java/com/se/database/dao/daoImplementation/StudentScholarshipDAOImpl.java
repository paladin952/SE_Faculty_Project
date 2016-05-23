package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IStudentScholarshipDAO;
import com.se.database.dao.model.academic.grants.ScholarshipVO;
import com.se.database.dao.model.academic.grants.StudentScholarshipVO;
import com.se.database.dao.model.users.StudentVO;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class StudentScholarshipDAOImpl implements IStudentScholarshipDAO {

    /**
     * The session factory from spring
     */
    private SessionFactory sessionFactory;

    public StudentScholarshipDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<StudentScholarshipVO> list() {
        @SuppressWarnings("unchecked")
        List<StudentScholarshipVO> listUser = (List<StudentScholarshipVO>) sessionFactory.getCurrentSession()
                .createCriteria(StudentScholarshipVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();

        return listUser;
    }

    @Override
    @Transactional
    public List<ScholarshipVO> getScholarshipsForStudent(int studentVOId) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT SC.ScholarshipID, SC.Name, SC.Award FROM ubbdb.scholarship SC\n" +
                "INNER JOIN ubbdb.studentscholarship SS\n" +
                "ON SS.ScholarshipID = SC.ScholarshipID\n" +
                "WHERE SS.StudentID = :student_id";
        Query select = session.createSQLQuery(sql)
                .addEntity(ScholarshipVO.class)
                .setInteger("student_id", studentVOId);

        return (List<ScholarshipVO>) select.list();
    }

    @Override
    @Transactional
    public List<StudentScholarshipVO> getStudentScholarshipsForStudent(int studentVOId) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT SS.* FROM ubbdb.studentscholarship SS\n" +
                "WHERE SS.StudentID = :student_id";
        Query select = session.createSQLQuery(sql)
                .addEntity(StudentScholarshipVO.class)
                .setInteger("student_id", studentVOId);

        return (List<StudentScholarshipVO>) select.list();
    }

    @Override
    public StudentScholarshipVO updateOrSave(StudentScholarshipVO newStudentScholarshipVO) {
        Session session = sessionFactory.getCurrentSession();
        StudentScholarshipVO exists = (StudentScholarshipVO) session.get(StudentScholarshipVO.class, newStudentScholarshipVO.getId());
        if (exists != null) {
            StudentScholarshipVO studentScholarshipVO = (StudentScholarshipVO) session.load(StudentScholarshipVO.class, newStudentScholarshipVO.getId());
            studentScholarshipVO.setScholarshipVO(newStudentScholarshipVO.getScholarshipVO());
            studentScholarshipVO.setStudentVO(newStudentScholarshipVO.getStudentVO());
            session.save(studentScholarshipVO);

            return studentScholarshipVO;
        } else {
            StudentScholarshipVO new_sStudentScholarshipVO = new StudentScholarshipVO(newStudentScholarshipVO.getScholarshipVO(), newStudentScholarshipVO.getStudentVO());
            session.save(new_sStudentScholarshipVO);
            return new_sStudentScholarshipVO;
        }
    }


    @Override
    @Transactional
    public Boolean deleteScholarshipForStudent(int scholarshipId, int studentId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "DELETE FROM StudentScholarshipVO SS WHERE SS.studentVO.id = :studentId AND SS.scholarshipVO.id = :scholarshipId";
        Query delete = session.createQuery(hql);
        delete.setParameter("studentId", studentId)
                .setParameter("scholarshipId", scholarshipId);
        return delete.executeUpdate() > 0;
    }

    @Override
    @Transactional
    public Boolean deleteById(int studentScholarshipId) {
        Session session = sessionFactory.getCurrentSession();
        StudentScholarshipVO studentScholarshipVO = (StudentScholarshipVO) session.load(StudentScholarshipVO.class, studentScholarshipId);
        if (studentScholarshipVO == null)
            return false;
        else
            session.delete(studentScholarshipVO);

        return true;
    }


}
