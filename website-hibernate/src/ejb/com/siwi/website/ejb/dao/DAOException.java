/*
 * $ Id: $
 * 
 */

package com.siwi.website.ejb.dao;

import com.siwi.common.CommonRuntimeException;

/**
 *  DAOException
 *
 * @author  Paxson Yang
 * @created  2002/8/9
 * @version  $Revision: 1.1 $ $Date: 2003/10/28 02:56:05 $
 */
public class DAOException extends CommonRuntimeException {

    /**
     *  Constructor for the DAOException object
     */
    public DAOException() {
        super();
    }

    /**
     *  Constructor for the DAOException object
     *
     * @param  val  Description of the Parameter
     */
    public DAOException(String val) {
        super(val);
    }

    /**
     *  Constructor for the DAOException object
     *
     * @param  t  Description of the Parameter
     */
    public DAOException(Throwable t) {
        super(t);
    }

}