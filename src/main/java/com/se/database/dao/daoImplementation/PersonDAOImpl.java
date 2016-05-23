package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IPersonDAO;
import com.se.database.dao.model.users.PersonVO;
import com.se.database.dao.model.users.UserVO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public class PersonDAOImpl implements IPersonDAO {
    /**
     * The session factory from spring
     */
    private SessionFactory sessionFactory;

    public PersonDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<PersonVO> list() {
        @SuppressWarnings("unchecked")
        List<PersonVO> listUser = (List<PersonVO>) sessionFactory.getCurrentSession()
                .createCriteria(PersonVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listUser;
    }

    @Transactional
    public PersonVO getByID(int id) {
        return (PersonVO)sessionFactory.getCurrentSession().get(PersonVO.class, id) ;
    }

    @Override
    @Transactional
    public PersonVO updateOrSave(PersonVO person) {
        Session session = sessionFactory.getCurrentSession();
        PersonVO exists = (PersonVO) session.get(PersonVO.class, person.getId());
        if (exists != null)
        {
            PersonVO pers = (PersonVO) session.load(PersonVO.class, person.getId());
//            pers.setUserVO(person.getUserVO());
            pers.setFirstName(person.getFirstName());
            pers.setLastName(person.getLastName());
            pers.setAddress(person.getAddress());
            pers.setDob(person.getDob());
            pers.setPhoneNo(person.getPhoneNo());
            pers.setSsn(person.getSsn());

            return pers;
        }
        else
        {
            PersonVO new_person = new PersonVO(person.getUserVO(), person.getFirstName(), person.getLastName(), person.getDob(), person.getSsn(), person.getAddress(), person.getPhoneNo());
            session.save(new_person);
            return new_person;
        }
    }

    @Override
    @Transactional
    public Boolean deleteByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        PersonVO person = (PersonVO) session.load(PersonVO.class, id);
        if (person == null)
            return false;
        else
            session.delete(person);

        return true;
    }
}
