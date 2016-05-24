package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IStudentOptionalCourseDAO;
import com.se.database.dao.model.academic.course.OptionalCourseVO;
import com.se.database.dao.model.academic.study.StudentOptionalCourseVO;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentOptionalCourseDAOImpl implements IStudentOptionalCourseDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public StudentOptionalCourseDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<StudentOptionalCourseVO> list() {
        @SuppressWarnings("unchecked")
        List<StudentOptionalCourseVO> students_optional_courses = (List<StudentOptionalCourseVO>) sessionFactory.getCurrentSession()
                .createCriteria(StudentOptionalCourseVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();

        return students_optional_courses;
    }

    @Override
    public StudentOptionalCourseDAOImpl save(StudentOptionalCourseVO student_optional_course) {
        sessionFactory.getCurrentSession().save(student_optional_course);

        return this;
    }

    @Override
    public Boolean deleteByIDs(int student_id, String optional_course_id) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "DELETE SOC FROM ubbdb.studentoptionalcourse AS SOC\n" +
                "INNER JOIN ubbdb.optionalcourse AS OC\n" +
                "ON OC.OptionalCourseID = SOC.OptionalCourseID\n" +
                "WHERE SOC.StudentID = :student_id AND OC.CourseID = :optional_course_id";
        Query delete = session.createSQLQuery(sql)
            .addEntity(StudentOptionalCourseVO.class)
            .setInteger("student_id", student_id)
            .setString("optional_course_id", optional_course_id);
        return delete.executeUpdate() > 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<OptionalCourseVO> getStudentOptionalCoursesFor(int student_id) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT OC.OptionalCourseID, OC.CourseID, OC.GroupNo FROM ubbdb.optionalcourse AS OC\n" +
                "INNER JOIN ubbdb.studentoptionalcourse AS SOC\n" +
                "ON OC.OptionalCourseID = SOC.OptionalCourseID\n" +
                "WHERE SOC.StudentID = :student_id";
        Query select = session.createSQLQuery(sql)
                .addEntity(OptionalCourseVO.class)
                .setInteger("student_id", student_id);
        return (List<OptionalCourseVO>) select.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<OptionalCourseVO> getStudentOptionalCoursesByGroupFor(int student_id, int optional_course_group) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT OC.OptionalCourseID, OC.CourseID, Oc.GroupNo FROM ubbdb.optionalcourse AS OC\n" +
                "INNER JOIN ubbdb.studentoptionalcourse AS SOC \n" +
                "ON OC.OptionalCourseID = SOC.OptionalCourseID " +
                "WHERE SOC.StudentID = :student_id AND OC.GroupNo = :group_no";
        Query select = session.createSQLQuery(sql)
                .addEntity(OptionalCourseVO.class)
                .setInteger("student_id", student_id)
                .setInteger("group_no", optional_course_group);
        return (List<OptionalCourseVO>) select.list();
    }
}
