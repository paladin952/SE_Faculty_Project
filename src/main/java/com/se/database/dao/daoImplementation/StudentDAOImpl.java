package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IStudentDAO;
import com.se.database.dao.model.users.StudentVO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentDAOImpl implements IStudentDAO {
    /**
     * The session factory from spring
     */
    private SessionFactory sessionFactory;

    public StudentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<StudentVO> list() {
        @SuppressWarnings("unchecked")
        List<StudentVO> listUser = (List<StudentVO>) sessionFactory.getCurrentSession()
                .createCriteria(StudentVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listUser;
    }

    @Transactional
    public StudentVO getById(int id) {
        return (StudentVO) sessionFactory.getCurrentSession()
                .get(StudentVO.class, id);
    }

    @Transactional
    public void deleteById(int id) {
        StudentVO student = (StudentVO) sessionFactory.getCurrentSession().get(StudentVO.class, id);
        sessionFactory.getCurrentSession().delete(student);
    }

    @Transactional
    public StudentVO updateStudent(StudentVO newStudent) {
        Session session = sessionFactory.getCurrentSession();
        StudentVO student = (StudentVO) session.load(StudentVO.class, newStudent.getId());
        if (student == null)
        {
            StudentVO tmp = new StudentVO(newStudent.getPersonVO(), newStudent.getGroup(), newStudent.getStatus(), newStudent.getExtended());
            session.save(tmp);
            return tmp;
        }
        else
        {
            student.setPersonVO(newStudent.getPersonVO());
            student.setGroup(newStudent.getGroup());
            student.setStatus(newStudent.getStatus());
            student.setExtended(newStudent.getExtended());
            return student;
        }
    }
}
