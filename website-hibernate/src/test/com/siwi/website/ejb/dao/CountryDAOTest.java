/*
 * $Id: CountryDAOTest.java,v 1.1 2003/10/30 10:28:38 paxson Exp $
 */

package com.siwi.website.ejb.dao;

import com.siwi.website.AbstractTestCase;
import com.siwi.website.ejb.model.Country;

/**
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/10/30 10:28:38 $
 */
public class CountryDAOTest extends AbstractTestCase {

    public static void main(String[] args) {
        junit.textui.TestRunner.run(CountryDAOTest.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public CountryDAOTest(String name) {
        super(name);
    }

    public void testInit() {
        try {
            
        } catch (Exception e) {
            getLogger().error(e.getMessage(), e);
            
            fail(e.getMessage());
        }
    }

    public void testGet() {
        try {
            
        } catch (Exception e) {
            getLogger().error(e.getMessage(), e);
            
            fail(e.getMessage());
        }
    }

    public void testAdd() {
        try {
            CountryDAO _dao = CommonDAOFactory.getCountryDAO();
            
            Country _value = JUnitDAOPopulater.buildCountry();
            
            long _id = _dao.add(_value);
            
            assertTrue(0 < _id);
        } catch (Exception e) {
            getLogger().error(e.getMessage(), e);
            
            fail(e.getMessage());
        }
    }

    public void testUpdate() {
        try {
            
        } catch (Exception e) {
            getLogger().error(e.getMessage(), e);
            
            fail(e.getMessage());
        }
    }

    public void testDelete() {
        try {
            
        } catch (Exception e) {
            getLogger().error(e.getMessage(), e);
            
            fail(e.getMessage());
        }
    }

    public void testFindAll() {
        try {
            
        } catch (Exception e) {
            getLogger().error(e.getMessage(), e);
            
            fail(e.getMessage());
        }
    }

}
