/*
 * $ Id: $
 * 
 */
 
package com.siwi.website.testcase;

import javax.naming.NamingException;

import com.siwi.website.ejb.session.EchoEJB;
import com.siwi.website.ejb.util.EchoEJBUtil;

/**
 *  EchoEJBTest
 *
 * @author  Paxson Yang
 * @created  2002/8/5
 * @version  $Revision: 1.1 $ $Date: 2003/10/28 02:56:05 $
 */

public class EchoEJBTest extends AbstractEJBTest {

    /**
     *  Constructor for EchoEJBTest.
     *
     * @param  val
     */
    public EchoEJBTest(String val) {
        super(val);
    }

    /**
     *  The main program for the EchoEJBTest class
     *
     * @param  args  The command line arguments
     */
    public static void main(String[] args) {
        junit.textui.TestRunner.run(EchoEJBTest.class);
    }

    /**
     *  A unit test for JUnit
     *
     * @param  val  Description of the Parameter
     */
    public void testEcho(String val) {
        EchoEJB _ejb = null;

        try {
            _ejb = EchoEJBUtil.getHome().create();
            getLogger().debug("Create EchoEJB successful");
            String _message = _ejb.echo("test");
            assertEquals("test", _message);
        } catch (NamingException ne) {
            ne.printStackTrace();
            fail(ne.toString());
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }

}