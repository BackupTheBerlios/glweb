/*
 * $Id: HandleFactory.java,v 1.2 2003/10/29 08:27:23 paxson Exp $
 * 
 */

package com.siwi.common.web;

/**
 *  HandleFactory
 *
 * @author  Paxson Yang
 * @created  2002/8/6
 * @version  $Revision: 1.2 $ $Date: 2003/10/29 08:27:23 $
 */
public interface HandleFactory {
    /**
     *  Gets the handle attribute of the HandleFactory object
     *
     * @param  type  Description of the Parameter
     * @return  The handle value
     * @exception  HandleCreateException  Description of the Exception
     */
    public Handle getHandle(ActionType type) throws HandleCreateException;

}