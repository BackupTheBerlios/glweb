/*
 * $ Id: $
 * 
 */

package com.siwi.website.ejb.dao;

import com.siwi.common.CommonRuntimeException;

/**
 *  DAOFactoryException
 *
 * @author  Paxson Yang
 * @created  2002/8/8
 * @version  $Revision: 1.1 $ $Date: 2003/10/28 02:56:05 $
 */
public class DAOFactoryException extends CommonRuntimeException {
    /**
     *  Constructor for the DAOFactoryException object
     */
    public DAOFactoryException() {
        super();
    }

    /**
     *  Constructor for the DAOFactoryException object
     *
     * @param  val  Description of the Parameter
     */
    public DAOFactoryException(String val) {
        super(val);
    }

    /**
     *  Constructor for the DAOFactoryException object
     *
     * @param  t  Description of the Parameter
     */
    public DAOFactoryException(Throwable t) {
        super(t);
    }

}