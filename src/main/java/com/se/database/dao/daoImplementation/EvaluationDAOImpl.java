package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IEvaluationDAO;
import com.se.database.dao.model.academic.course.EvaluationVO;
import com.se.database.dao.model.users.AdminVO;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class EvaluationDAOImpl implements IEvaluationDAO {

    private SessionFactory sessionFactory;

    public EvaluationDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    @Transactional
    public List<EvaluationVO> list() {
        @SuppressWarnings("unchecked")
        List<EvaluationVO> evaluationVOList = (List<EvaluationVO>) sessionFactory.getCurrentSession()
                .createCriteria(EvaluationVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return evaluationVOList;
    }

    @Override
    @Transactional
    public EvaluationVO getByID(int id) {
        return (EvaluationVO)sessionFactory.getCurrentSession().get(EvaluationVO.class, id);
    }

    @Override
    @Transactional
    public EvaluationVO updateOrSave(EvaluationVO evaluation) {
        Session session = sessionFactory.getCurrentSession();
        EvaluationVO exists = (EvaluationVO) session.get(EvaluationVO.class, evaluation.getId());
        if (exists != null)
        {
            EvaluationVO eval = (EvaluationVO) session.load(EvaluationVO.class, evaluation.getId());
            eval.setType(evaluation.getType());

            return eval;
        }
        else
        {
            EvaluationVO new_eval = new EvaluationVO(evaluation.getType());
            session.save(new_eval);
            return new_eval;
        }
    }

    @Override
    @Transactional
    public Boolean deleteByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        EvaluationVO evaluationVO = (EvaluationVO) session.load(EvaluationVO.class, id);
        if (evaluationVO == null)
            return false;
        else
            session.delete(evaluationVO);

        return true;
    }
}
