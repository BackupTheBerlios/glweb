/*
 * $ Id: $
 * 
 */

package com.siwi.common.web;

import org.apache.struts.action.ActionForward;

/**
 *  Handle
 *
 * @author  Paxson Yang
 * @created  2002/8/6
 * @version  $Revision: 1.1 $ $Date: 2003/10/28 02:56:05 $
 */
public interface Handle {
    /**
     *  Description of the Method
     *
     * @return  Description of the Return Value
     * @exception  HandlePerformException  Description of the Exception
     */
    public ActionForward perform() throws HandlePerformException;

}