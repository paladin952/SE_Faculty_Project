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
        PersonVO tmp = (PersonVO) session.load(PersonVO.class, person.getId());
        if (tmp == null)
        {
            PersonVO new_person = new PersonVO(person.getUserVO(), person.getFirstName(), person.getLastName(), person.getDob(), person.getSsn(), person.getAddress(), person.getPhoneNo());
            session.save(new_person);

            return new_person;
        }
        else
        {
            tmp.setFirstName(person.getFirstName())
                .setLastName(person.getLastName())
                .setDob(person.getDob())
                .setSsn(person.getSsn())
                .setAddress(person.getAddress())
                .setPhoneNo(person.getPhoneNo())
                .setUserVO(person.getUserVO());

            return person;
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
