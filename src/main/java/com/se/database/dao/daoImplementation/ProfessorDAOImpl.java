package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IProfessorDAO;
import com.se.database.dao.model.users.ProfessorVO;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ProfessorDAOImpl implements IProfessorDAO {
    /**
     * The session factory from spring
     */
    private SessionFactory sessionFactory;

    public ProfessorDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<ProfessorVO> list() {
        @SuppressWarnings("unchecked")
        List<ProfessorVO> listUser = (List<ProfessorVO>) sessionFactory.getCurrentSession()
                .createCriteria(ProfessorVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listUser;
    }

    @Override
    @Transactional
    public ProfessorVO getByID(int id) {
        return (ProfessorVO)sessionFactory.getCurrentSession().get(ProfessorVO.class, id) ;
    }

    @Override
    @Transactional
    public ProfessorVO updateOrSave(ProfessorVO professorVO) {
        Session session = sessionFactory.getCurrentSession();
        try {
            ProfessorVO tmp = (ProfessorVO) session.load(ProfessorVO.class, professorVO.getId());

            tmp.setPersonVO(professorVO.getPersonVO());
            tmp.setDepartmentVO(professorVO.getDepartmentVO());
            tmp.setChief(professorVO.isChief());
            tmp.setWage(professorVO.getWage());


            //tmp?
            return professorVO;
        } catch (HibernateException e){
            ProfessorVO new_professor = new ProfessorVO(professorVO.getPersonVO(), professorVO.getDepartmentVO(),professorVO.isChief(),professorVO.getWage());
            session.save(new_professor);

            return new_professor;
        }
    }

    @Override
    @Transactional
    public Boolean deleteByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        ProfessorVO professorVO = (ProfessorVO) session.load(ProfessorVO.class, id);
        if (professorVO == null)
            return false;
        else
            session.delete(professorVO);

        return true;
    }
}
