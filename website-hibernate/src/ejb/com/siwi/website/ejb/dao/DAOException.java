/*
 * $Id: DAOException.java,v 1.2 2003/10/29 08:27:23 paxson Exp $
 * 
 */

package com.siwi.website.ejb.dao;

import org.apache.commons.lang.exception.NestableRuntimeException;

/**
 *  DAOException
 *
 * @author  Paxson Yang
 * @created  2002/8/9
 * @version  $Revision: 1.2 $ $Date: 2003/10/29 08:27:23 $
 */
public class DAOException extends NestableRuntimeException {

    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Throwable cause) {
        super(cause.getMessage(), cause);
    }
    
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

}