/*
 * $ Id: $
 * 
 */

package com.siwi.website.testcase;

import junit.framework.Test;

import junit.framework.TestSuite;

/**
 *  Description of the Class
 *
 * @author  <a href="mailto:paxson.yang@ebizprise.com.tw> Paxson Yang </a>
 * @created  2002/8/5
 * @version  $Revision: 1.1 $ $Date: 2003/10/28 02:56:05 $
 */
public class AllSessionTests {

    /**
     *  The main program for the AllSessionTests class
     *
     * @param  args  The command line arguments
     */
    public static void main(String[] args) {
        junit.textui.TestRunner.run(AllSessionTests.class);
    }

    /**
     *  A unit test suite for JUnit
     *
     * @return  The test suite
     */
    public static Test suite() {
        TestSuite suite =
                new TestSuite("Test for com.siwi.website.testcase");
        //$JUnit-BEGIN$
        suite.addTest(new TestSuite(EchoEJBTest.class));
        //$JUnit-END$
        return suite;
    }

}