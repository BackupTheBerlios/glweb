/*
 * $Id: WebsitePersistenceException.java,v 1.1 2003/10/29 08:27:23 paxson Exp $
 */

package com.siwi.website.infrastructure.persistence;

import org.apache.commons.lang.exception.NestableException;

/**
 * GLWebPersistenceException
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/10/29 08:27:23 $
 */
public class WebsitePersistenceException extends NestableException {

    /**
     * Creates a new instance of <code>GLWebPersistenceException</code> 
     * without detail message.
     */
    public WebsitePersistenceException() {
        super();
    }

    /**
     * Constructs an instance of <code>GLWebPersistenceException</code> 
     * with the specified detail message.
     * 
     * @param msg The detail message.
     */
    public WebsitePersistenceException(String message) {
        super(message);
    }

    /**
     * Constructs an instance of <code>GLWebPersistenceException</code> 
     * with a nested <code>Throwable</code>.
     * 
     * @param throwable the Throwable to nest.
     */
    public WebsitePersistenceException(Throwable throwable) {
        super(throwable.getMessage(), throwable);
    }
    

    /**
     * Constructs an instance of <code>GLWebPersistenceException</code> 
     * with the specified detail message and a nested <code>Throwable</code>.
     * 
     * @param msg The detail message.
     * @param throwable the Throwable to nest.
     */
    public WebsitePersistenceException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
