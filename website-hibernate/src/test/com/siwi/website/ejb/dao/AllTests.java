/*
 * $Id: AllTests.java,v 1.1 2003/10/30 10:28:38 paxson Exp $
 * 
 */

package com.siwi.website.ejb.dao;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/10/30 10:28:38 $
 */
public class AllTests {

    public static void main(String[] args) {
        junit.textui.TestRunner.run(AllTests.class);
    }

    public static Test suite() {
        TestSuite _suite = new TestSuite("Test for com.siwi.website.ejb.dao");
        
        //$JUnit-BEGIN$
        _suite.addTestSuite(CountryDAOTest.class);
        //$JUnit-END$
        
        return _suite;
    }
}
