/*
 * $Id: HandleCreateException.java,v 1.2 2003/10/29 08:27:23 paxson Exp $
 * 
 */

package com.siwi.common.web;

import com.siwi.common.CommonRuntimeException;

/**
 *  HandleCreateException
 *
 * @author  Paxson Yang
 * @created  2002/8/6
 * @version  $Revision: 1.2 $ $Date: 2003/10/29 08:27:23 $
 */

public class HandleCreateException extends CommonRuntimeException {
    /**
     *  Constructor for the HandleCreateException object
     */
    public HandleCreateException() {
        super();
    }

    /**
     *  Constructor for the HandleCreateException object
     *
     * @param  val  Description of the Parameter
     */
    public HandleCreateException(String val) {
        super(val);
    }

    /**
     *  Constructor for the HandleCreateException object
     *
     * @param  t  Description of the Parameter
     */
    public HandleCreateException(Throwable t) {
        setRootCause(t);
    }

}