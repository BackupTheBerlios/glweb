/*
 * $Id: CommonRuntimeException.java,v 1.2 2003/10/29 08:27:23 paxson Exp $
 * 
 */

package com.siwi.common;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 *  CommonRuntimeException
 *
 * @author  Paxson Yang
 * @created  2002/8/6
 * @version  $Revision: 1.2 $ $Date: 2003/10/29 08:27:23 $
 */
public class CommonRuntimeException extends RuntimeException 
    implements CommonThrowable {

    protected Throwable _rootCause;

    public CommonRuntimeException() {
        super();
    }

    public CommonRuntimeException(String val) {
        super(val);
    }

    public CommonRuntimeException(Throwable t) {
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