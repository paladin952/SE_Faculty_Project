package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IEnrolledDAO;
import com.se.database.dao.model.academic.course.CourseVO;
import com.se.database.dao.model.academic.study.EnrolledVO;
import com.se.database.dao.model.users.StudentVO;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SuppressWarnings("unchecked")
public class EnrolledDAOImpl implements IEnrolledDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public EnrolledDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<EnrolledVO> list() {
        return (List<EnrolledVO>)sessionFactory.getCurrentSession()
                .createCriteria(EnrolledVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }

    @Override
    public EnrolledVO save(EnrolledVO enrolled) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM EnrolledVO E WHERE E.student.id = :student_id AND E.course.id = :course_id";
        Query exists = session.createQuery(hql)
                .setInteger("student_id", enrolled.getStudent().getId())
                .setString("course_id", enrolled.getCourse().getId());

        if (exists.list().isEmpty())
            session.save(enrolled);

        return enrolled;
    }

    @Override
    public List<CourseVO> getEnrolledCoursesForStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT C.CourseID, C.DegreeID, C.Name, C.Credits, C.AssignedSemester FROM ubbdb.course C\n" +
                "INNER JOIN ubbdb.enrolled E\n" +
                "ON E.CourseID = C.CourseID\n" +
                "WHERE E.StudentID = :student_id";
        Query select = session.createSQLQuery(sql)
                .addEntity(CourseVO.class)
                .setInteger("student_id", id);
        return (List<CourseVO>)select.list();
    }

    @Override
    public List<StudentVO> getEnrolledStudentsForCourse(String id) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT S.StudentID, S.GroupID, S.Status, S.IsExtended, S.PersonID FROM ubbdb.student S \n" +
                "INNER JOIN ubbdb.enrolled E \n" +
                "ON E.StudentID = S.StudentID \n" +
                "WHERE E.CourseID = :course_id";
        Query select = session.createSQLQuery(sql)
                .addEntity(StudentVO.class)
                .setString("course_id", id);

        return (List<StudentVO>)select.list();
    }

    @Override
    public Boolean deleteByIDs(int student_id, String course_id) {
        Session session = sessionFactory.getCurrentSession();

        String hql = "DELETE FROM EnrolledVO E WHERE E.course.id = :course_id AND E.student.id = :student_id";
        Query delete = session.createQuery(hql)
                .setString("course_id", course_id)
                .setInteger("student_id", student_id);
        return delete.executeUpdate() > 0;
    }
}
