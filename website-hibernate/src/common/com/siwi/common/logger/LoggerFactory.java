/*
 * $Id: LoggerFactory.java,v 1.2 2003/10/29 08:27:23 paxson Exp $
 * 
 */

package com.siwi.common.logger;

import java.util.HashMap;
import java.util.Map;

/**
 *  LoggerFactory
 *
 * @author  Paxson Yang
 * @created  2002/8/2
 * @version  $Revision: 1.2 $ $Date: 2003/10/29 08:27:23 $
 */
public class LoggerFactory {

    private static LoggerFactory _factory;

    private static Map _loggerList = new HashMap();

    /**
     *  Constructor for LoggerFactory.
     */

    private LoggerFactory() { }

    /**
     *  Gets the instance attribute of the LoggerFactory class
     *
     * @return  The instance value
     */
    public static LoggerFactory getInstance() {
        if (null == _factory) {
            _factory = new LoggerFactory();
        }

        return _factory;
    }

    /**
     *  Gets the logger attribute of the LoggerFactory object
     *
     * @param  name  Description of the Parameter
     * @return  The logger value
     */
    public Logger getLogger(String name) {
        if (null == _loggerList.get(name)) {
            Logger _logger = new SiwiLogger(name);
            _loggerList.put(name, _logger);

            return _logger;
        } else {
            return (Logger) _loggerList.get(name);
        }
    }

}