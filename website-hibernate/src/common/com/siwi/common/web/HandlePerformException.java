/*
 * $ Id: $
 * 
 */

package com.siwi.common.web;

import com.siwi.common.CommonRuntimeException;

/**
 *  HandlePerformException
 *
 * @author  Paxson Yang
 * @created  2002/8/6
 * @version  $Revision: 1.1 $ $Date: 2003/10/28 02:56:05 $
 */
public class HandlePerformException extends CommonRuntimeException {
    /**
     *  Constructor for the HandlePerformException object
     */
    public HandlePerformException() {
        super();
    }

    /**
     *  Constructor for the HandlePerformException object
     *
     * @param  str  Description of the Parameter
     */
    public HandlePerformException(String str) {
        super(str);
    }

    /**
     *  Constructor for the HandlePerformException object
     *
     * @param  t  Description of the Parameter
     */
    public HandlePerformException(Throwable t) {
        setRootCause(t);
    }

}