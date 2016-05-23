package com.se.model.academic.grants;

import com.se.database.dao.model.academic.grants.ScholarshipVO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.print.attribute.standard.MediaSize;

import static org.junit.Assert.*;


public class ScholarshipVOTest {
    private static final int ID = 1;
    private static final String NAME = "NAME1";
    private static final String NAME_NEW = "NAME2";
    private static final float SUM = 100;
    private static final float SUM_NEW = 1000;
    private ScholarshipVO scholarshipVO;

    @Before
    public void setUp() throws Exception {
        scholarshipVO = new ScholarshipVO(NAME, SUM);
        scholarshipVO.setId(ID);
    }

    @After
    public void tearDown() throws Exception {
        scholarshipVO = null;
    }

    @Test
    public void getId() throws Exception {
        assertEquals(ID, scholarshipVO.getId());
    }

    @Test
    public void getName() throws Exception {
        assertEquals(NAME, scholarshipVO.getName());
    }

    @Test
    public void setName() throws Exception {
        scholarshipVO.setName(NAME_NEW);;
        assertEquals(NAME_NEW, scholarshipVO.getName());
    }

    @Test
    public void getSum() throws Exception {
        assertEquals(SUM, scholarshipVO.getSum(),0);
    }

    @Test
    public void setSum() throws Exception {
        scholarshipVO.setSum(SUM_NEW);;
        assertEquals(SUM_NEW, scholarshipVO.getSum(),0);
    }
}
