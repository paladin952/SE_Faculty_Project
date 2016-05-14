package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IScholarshipDAO;
import com.se.database.dao.model.academic.grants.ScholarshipVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ScholarshipDAOImpl implements IScholarshipDAO {

    @Override
    public List<ScholarshipVO> list() {
        return null;
    }

    @Override
    public ScholarshipVO getById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public ScholarshipVO updateUser(ScholarshipVO newScolarship) {
        return null;
    }
}
