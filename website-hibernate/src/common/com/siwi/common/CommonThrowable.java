/*
 * $Id: CommonThrowable.java,v 1.2 2003/10/29 08:27:23 paxson Exp $
 * 
 */

package com.siwi.common;

/**
 *  CommonThrowable
 *
 * @author  Paxson Yang
 * @created  2002/8/6
 * @version  $Revision: 1.2 $ $Date: 2003/10/29 08:27:23 $
 */
public interface CommonThrowable {

    Throwable getRootCause();

    void setRootCause(Throwable t);

}