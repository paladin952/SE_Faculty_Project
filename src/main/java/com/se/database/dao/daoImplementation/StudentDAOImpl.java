package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IStudentDAO;
import com.se.database.dao.model.users.PersonVO;
import com.se.database.dao.model.users.StudentVO;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
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

    @Override
    public StudentVO getByID(int id) {
        return (StudentVO) sessionFactory.getCurrentSession().get(StudentVO.class, id);
    }

    @Override
    public StudentVO updateOrSave(StudentVO studentVO) {
        Session session = sessionFactory.getCurrentSession();
        StudentVO exists = (StudentVO) session.get(StudentVO.class, studentVO.getId());
        if (exists != null)
        {
            StudentVO student = (StudentVO) session.load(StudentVO.class, studentVO.getId());
            student.setExtended(studentVO.getExtended())
                .setGroup(studentVO.getGroup())
                .setPersonVO(studentVO.getPersonVO())
                .setStatus(studentVO.getStatus());

            return student;
        }
        else
        {
            System.out.println((studentVO != null)?studentVO.toString():"null");
            if(studentVO.getExtended() == null){
                studentVO.setExtended(false);
            }
            StudentVO new_person = new StudentVO(studentVO.getPersonVO(), studentVO.getGroup(), studentVO.getStatus(), studentVO.getExtended());
            session.save(new_person);
            return new_person;
        }
    }



    @Override
    public Boolean deleteByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        StudentVO student = (StudentVO)session.get(StudentVO.class, id);
        if (student == null)
            return false;

        session.delete(student);
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public StudentVO getStudentFor(String username) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM StudentVO S WHERE S.personVO.userVO.username = :username";
        Query select = session.createQuery(hql)
                .setString("username", username);
        List<StudentVO> student = (List<StudentVO>) select.list();
        if (student.isEmpty())
            return null;
        else
            return student.get(0);
    }
}
