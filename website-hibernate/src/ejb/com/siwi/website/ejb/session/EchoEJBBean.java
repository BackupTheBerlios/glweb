/*
 * $Id: EchoEJBBean.java,v 1.2 2003/10/29 08:27:23 paxson Exp $
 * 
 */

package com.siwi.website.ejb.session;

import com.siwi.common.logger.Logger;
import com.siwi.common.logger.LoggerFactory;

/**
 *  EchoEJB
 *
 * @author  Paxson Yang
 * @created  2002/8/2
 * @version  $Revision: 1.2 $ $Date: 2003/10/29 08:27:23 $
 * 
 * @ejb:bean
 *     name="EchoEJB" 
 *     type="Stateless" 
 *     jndi-name="ejb/session/EchoEJB"
 */
public abstract class EchoEJBBean implements javax.ejb.SessionBean {
    private final static boolean DEBUG = true;

    private Logger _logger;

    /**
     *  Gets the logger attribute of the EchoEJBBean object
     *
     * @return  The logger value
     */
    private Logger getLogger() {
        if (null == _logger) {
            _logger = LoggerFactory.getInstance().getLogger(
                    getClass().getName());
            _logger.setDebug(DEBUG);
        }

        return _logger;
    }

    /**
     * @param  val  Description of the Parameter
     * @return  Description of the Return Value
     * 
     * @ejb:interface-method
     */
    public String echo(String val) {
        getLogger().debug("Executing EchoEJBBean.echo()");

        return "Message from EchoEJB is " + val;
    }

}