/*
 * $Id: DAOFactoryException.java,v 1.2 2003/10/29 08:27:23 paxson Exp $
 * 
 */

package com.siwi.website.ejb.dao;

import org.apache.commons.lang.exception.NestableRuntimeException;

/**
 *  DAOFactoryException
 *
 * @author  Paxson Yang
 * @created  2002/8/8
 * @version  $Revision: 1.2 $ $Date: 2003/10/29 08:27:23 $
 */
public class DAOFactoryException extends NestableRuntimeException {
    
    public DAOFactoryException() {
        super();
    }

    public DAOFactoryException(String message) {
        super(message);
    }

    public DAOFactoryException(Throwable cause) {
        super(cause.getMessage(), cause);
    }
    
    public DAOFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

}