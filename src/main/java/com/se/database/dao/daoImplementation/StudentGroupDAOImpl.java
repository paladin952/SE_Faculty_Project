package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IStudentGroupDAO;
import com.se.database.dao.model.academic.groups.StudentGroupVO;
import com.se.database.dao.model.users.StudentVO;
import com.se.database.dao.model.users.UserVO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class StudentGroupDAOImpl implements IStudentGroupDAO {

    private SessionFactory sessionFactory;

    public StudentGroupDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<StudentGroupVO> list() {
        @SuppressWarnings("unchecked")
        List<StudentGroupVO> studentGroups = (List<StudentGroupVO>) sessionFactory.getCurrentSession()
                .createCriteria(StudentGroupVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();

        return studentGroups;
    }

    @Override
    public StudentGroupVO getByID(int id) {
        return (StudentGroupVO)sessionFactory.getCurrentSession().get(StudentGroupVO.class, id);
    }

    @Override
    public StudentGroupVO updateOrSave(StudentGroupVO student_group) {
        Session session = sessionFactory.getCurrentSession();
        StudentGroupVO exists = (StudentGroupVO) session.get(StudentGroupVO.class, student_group.getId());
        if (exists != null)
        {
            StudentGroupVO sg = (StudentGroupVO) session.load(StudentGroupVO.class, student_group.getId());
            sg.setId(student_group.getId());
            sg.setCurrentSemester(student_group.getCurrentSemester());
            sg.setStudents(student_group.getStudents());

            return sg;
        }
        else
        {
            StudentGroupVO new_person = new StudentGroupVO(student_group.getId(), student_group.getStudents(), student_group.getCurrentSemester());
            session.save(new_person);

            return new_person;
        }
    }

    @Override
    public Boolean deleteByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        StudentGroupVO student_group = (StudentGroupVO) session.get(StudentGroupVO.class, id);
        if (student_group == null)
            return false;

        session.delete(student_group);
        return true;
    }

    @Override
    public List<StudentVO> getStudentsFor(int id) {
        StudentGroupVO student_group = getByID(id);
        return student_group != null ? student_group.getStudents() : null;
    }
}
