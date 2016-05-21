package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IProfessorDAO;
import com.se.database.dao.model.users.ProfessorVO;
import com.se.database.dao.model.users.UserVO;
import org.hibernate.Criteria;
import org.hibernate.Query;
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
        return (ProfessorVO) sessionFactory.getCurrentSession().get(ProfessorVO.class, id);
    }

    @Override
    @Transactional
    public ProfessorVO updateOrSave(ProfessorVO professorVO) {
        Session session = sessionFactory.getCurrentSession();
        ProfessorVO exists = (ProfessorVO) session.get(ProfessorVO.class, professorVO.getId());
        if (exists != null) {
            ProfessorVO professor = (ProfessorVO) session.load(ProfessorVO.class, professorVO.getId());
            professor.setPersonVO(professorVO.getPersonVO());
            professor.setDepartmentVO(professorVO.getDepartmentVO());
            professor.setChief(professorVO.isChief());
            professor.setWage(professorVO.getWage());
            professor.setPersonVO(professorVO.getPersonVO());

            return professor;
        } else {
            ProfessorVO new_professor = new ProfessorVO(professorVO.getPersonVO(), professorVO.getDepartmentVO(), professorVO.isChief(), professorVO.getWage());
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

    @Override
    @Transactional
    public ProfessorVO getByUser(UserVO userVO) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery(
                "select * from professor p where p.PersonID in (select PersonID from person pp where pp.UserID = :UserID)")
                .addEntity(ProfessorVO.class)
                .setString("UserID", String.valueOf(userVO.getId()));
        List<ProfessorVO> result = (List<ProfessorVO>) query.list();

        if (result.size() == 1) {
            return result.get(0);
        }
        return null;
    }
}
