/*
 * $Id: Logger.java,v 1.2 2003/10/29 08:27:23 paxson Exp $
 * 
 */

package com.siwi.common.logger;

/**
 *  Logger
 *
 * @author  Paxson Yang
 * @created  2002/8/2
 * @version  $Revision: 1.2 $ $Date: 2003/10/29 08:27:23 $
 */

public interface Logger {
    /**
     *  Sets the debug attribute of the Logger object
     *
     * @param  debug  The new debug value
     */
    public void setDebug(boolean debug);

    /**
     *  Description of the Method
     *
     * @param  obj  Description of the Parameter
     */
    public void error(Object obj);

    /**
     *  Description of the Method
     *
     * @param  obj  Description of the Parameter
     */
    public void info(Object obj);

    /**
     *  Description of the Method
     *
     * @param  obj  Description of the Parameter
     */
    public void debug(Object obj);

    /**
     *  Description of the Method
     *
     * @param  mode  Description of the Parameter
     * @param  obj   Description of the Parameter
     */
    public void log(String mode, Object obj);

}