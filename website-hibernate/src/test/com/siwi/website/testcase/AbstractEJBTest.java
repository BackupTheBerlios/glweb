/*
 * $ Id: $
 * 
 */
 
package com.siwi.website.testcase;

import org.apache.cactus.ServletTestCase;

/**
 *  AbstractEJBTest
 *
 * @author  Paxson Yang
 * @created  2002/8/5
 * @version  $Revision: 1.1 $ $Date: 2003/10/28 02:56:05 $
 */
public abstract class AbstractEJBTest extends ServletTestCase {

    /**
     *  Constructor for AbstractEJBTest.
     *
     * @param  val
     */
    public AbstractEJBTest(String val) {
        super(val);
    }

    /**
     * @exception  Exception  Description of the Exception
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * @exception  Exception  Description of the Exception
     * @see  TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

}