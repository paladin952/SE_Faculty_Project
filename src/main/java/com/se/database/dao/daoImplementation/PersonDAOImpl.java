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
    public PersonVO updateOrSave(int id, String firstName, String lastName, Date dob, long ssn, String address, int phoneNo, UserVO userVO) {
        Session session = sessionFactory.getCurrentSession();
        PersonVO person = (PersonVO) session.load(PersonVO.class, id);
        if (person == null)
        {
            PersonVO tmp = new PersonVO(userVO, firstName, lastName, dob, ssn, address, phoneNo);
            session.save(tmp);

            return tmp;
        }
        else
        {
            person.setFirstName(firstName)
                .setLastName(lastName)
                .setDob(dob)
                .setSsn(ssn)
                .setAddress(address)
                .setPhoneNo(phoneNo)
                .setUserVO(userVO);

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
