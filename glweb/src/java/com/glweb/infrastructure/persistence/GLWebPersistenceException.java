/*
 *
 * $Id: GLWebPersistenceException.java,v 1.1 2003/05/10 11:41:13 paxson Exp $
 *
 * Copyright (c) 2003 SIWI.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a 
 * copy of this software and associated documentation files (the 
 * "Software"), to deal in the Software without restriction, including 
 * without limitation the rights to use, copy, modify, merge, publish, 
 * distribute, sublicense, and/or sell copies of the Software, and to 
 * permit persons to whom the Software is furnished to do so, subject to 
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included 
 * in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF 
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY 
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, 
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.glweb.infrastructure.persistence;

import org.apache.commons.lang.exception.NestableException;

/**
 * GLWebPersistenceException
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/05/10 11:41:13 $
 */
public class GLWebPersistenceException extends NestableException {

    /**
     * Creates a new instance of <code>GLWebPersistenceException</code> 
     * without detail message.
     */
    public GLWebPersistenceException() {
        super();
    }

    /**
     * Constructs an instance of <code>GLWebPersistenceException</code> 
     * with the specified detail message.
     * 
     * @param msg The detail message.
     */
    public GLWebPersistenceException(String message) {
        super(message);
    }

    /**
     * Constructs an instance of <code>GLWebPersistenceException</code> 
     * with a nested <code>Throwable</code>.
     * 
     * @param throwable the Throwable to nest.
     */
    public GLWebPersistenceException(Throwable throwable) {
        super(throwable.getMessage(), throwable);
    }
    

    /**
     * Constructs an instance of <code>GLWebPersistenceException</code> 
     * with the specified detail message and a nested <code>Throwable</code>.
     * 
     * @param msg The detail message.
     * @param throwable the Throwable to nest.
     */
    public GLWebPersistenceException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
