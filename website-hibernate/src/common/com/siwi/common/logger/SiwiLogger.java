/*
 * $ Id: $
 * 
 */

package com.siwi.common.logger;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *  SiwiLogger
 *
 * @author  Paxson Yang
 * @created  2002/8/2
 * @version  $Revision: 1.1 $ $Date: 2003/10/28 02:56:05 $
 */

public class SiwiLogger implements Logger {

    private final static char SPACE = ' ';

    private static DateFormat _dateFormat;

    private boolean _debug;

    private String _name;

    /**
     *  Constructor for Logger.
     *
     * @param  name  Description of the Parameter
     */
    public SiwiLogger(String name) {
        setName(name);
    }

    /**
     *  Sets the name attribute of the SiwiLogger object
     *
     * @param  name  The new name value
     */
    private void setName(String name) {
        _name = name.substring(name.lastIndexOf(".") + 1);
    }

    /**
     *  Sets the debug attribute of the SiwiLogger object
     *
     * @param  debug  The new debug value
     */
    public void setDebug(boolean debug) {
        _debug = debug;
    }

    /**
     *  Gets the dateFormat attribute of the SiwiLogger object
     *
     * @return  The dateFormat value
     */
    private DateFormat getDateFormat() {
        if (null == _dateFormat) {
            _dateFormat = DateFormat.getDateTimeInstance(
                    DateFormat.SHORT, DateFormat.SHORT, Locale.US);
        }

        return _dateFormat;
    }

    /**
     *  Gets the debug attribute of the SiwiLogger object
     *
     * @return  The debug value
     */
    private boolean isDebug() {
        return _debug;
    }

    /**
     *  Gets the name attribute of the SiwiLogger object
     *
     * @return  The name value
     */
    private String getName() {
        return _name;
    }

    /**
     *  Description of the Method
     *
     * @param  obj  Description of the Parameter
     */
    public void debug(Object obj) {
        if (isDebug()) {
            log("DEBUG", obj);
        }
    }

    /**
     *  Description of the Method
     *
     * @param  obj  Description of the Parameter
     */
    public void error(Object obj) {
        log("ERROR", obj);
    }

    /**
     *  Description of the Method
     *
     * @param  obj  Description of the Parameter
     */
    public void info(Object obj) {
        log("INFO", obj);
    }

    /**
     *  Description of the Method
     *
     * @param  mode  Description of the Parameter
     * @param  obj   Description of the Parameter
     */
    public void log(String mode, Object obj) {
        StringBuffer _buffer = new StringBuffer();
        _buffer.append(
                getDateFormat().format(
                new Date()));
        _buffer.append(SPACE);
        _buffer.append(mode);
        _buffer.append(SPACE);
        _buffer.append("[");
        _buffer.append(getName());
        _buffer.append("]");
        _buffer.append(SPACE);
        _buffer.append(obj);

        System.out.println(_buffer.toString());
    }

}