/*
 * $ Id: $
 * 
 */

package com.siwi.common;

/**
 *  CommonThrowable
 *
 * @author  Paxson Yang
 * @created  2002/8/6
 * @version  $Revision: 1.1 $ $Date: 2003/10/28 02:56:05 $
 */
public interface CommonThrowable {

    Throwable getRootCause();

    void setRootCause(Throwable t);

}