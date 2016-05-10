package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IEvaluationDAO;
import com.se.database.dao.model.academic.course.EvaluationVO;
import org.hibernate.Criteria;
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
        EvaluationVO tmp = (EvaluationVO) session.load(EvaluationVO.class, evaluation.getId());
        if (tmp == null)
        {
//            EvaluationVO new_evaluation = new EvaluationVO(evaluation.getType(), evaluation.getGrade(), evaluation.isAbsent());
            EvaluationVO new_evaluation = new EvaluationVO(evaluation.getType());
            session.save(new_evaluation);

            return new_evaluation;
        }
        else
        {
            tmp.setType(evaluation.getType());
//            tmp.setGrade(evaluation.getGrade());
//            tmp.setIsAbsent(evaluation.isAbsent());

            //tmp?
            return evaluation;
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
