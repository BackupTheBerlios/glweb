/*
 * $ Id: $
 * 
 */

package com.siwi.common;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 *  CommonException
 *
 * @author   Paxson Yang
 * @created  2002/8/6
 * @version  $Revision: 1.1 $ $Date: 2003/10/28 02:56:05 $
 */
public class CommonException extends Exception 
    implements CommonThrowable {

    protected Throwable _rootCause;

    public CommonException() {
        super();
    }

    public CommonException(String val) {
        super(val);
    }

    public CommonException(Throwable t) {
        setRootCause(t);
    }

    public void setRootCause(Throwable t) {
        _rootCause = t;
    }

    public Throwable getRootCause() {
        return _rootCause;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream stream) {
        printStackTrace(new PrintWriter(stream));
    }

    public void printStackTrace(PrintWriter writer) {
        super.printStackTrace(writer);

        if (null != getRootCause()) {
            writer.write("[Root Cause]");
            writer.write(System.getProperty("line.separator"));
            getRootCause().printStackTrace(writer);
        }

        writer.flush();
    }

}