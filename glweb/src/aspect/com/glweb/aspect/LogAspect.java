/*
 *
 * $Id: LogAspect.java,v 1.1 2003/05/23 09:13:29 paxson Exp $
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

package com.glweb.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

/**
 * LogAspect
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/05/23 09:13:29 $
 */
public aspect LogAspect {

    /**
     * All objects in the log package. We don't want to log these as they are
     * the object that perform the logging and thus at execution time we would
     * enter an infinite recursive loop.
     */
    pointcut logObjectCalls() : 
            execution(public * com.glweb.aspect.log..* (..));

    /**
     * All public static methods that have parameters.
     */
    pointcut publicStaticMethodsWithParameterCalls() : 
            !execution(public static * com.glweb..* ()) && 
            execution(public static * com.glweb..* (..));

    /**
     * All public methods that have parameters.
     */
    pointcut publicMethodsWithParameterCalls() : 
            !execution(public * com.glweb..* ()) && 
            execution(public * com.glweb..* (..));

    /**
     * All public methods that return values
     */
    pointcut publicMethodsWithReturnValueCalls() : 
            !execution(public void com.glweb..* (..)) && 
            execution(public * com.glweb..* (..));

    /**
     * Log all entries and exits of static methods that have no return values.
     */
    Object around() : 
            !logObjectCalls() && 
            publicMethodsWithParameterCalls() && 
            publicStaticMethodsWithParameterCalls() && 
            !publicMethodsWithReturnValueCalls() {
        // Get The logger to perform logging
        Log _logger = LogFactory.getLog(
                thisJoinPoint.getSignature().getDeclaringType());

        if (_logger.isDebugEnabled()) {
            // Log the entry
            _logger.debug('<' + getFullSignature(thisJoinPoint));

            // Execute the method
            final Object _result = proceed();

            // Log the exit
            _logger.debug('>' + thisJoinPoint.getSignature().getName());
            
            return _result;
        }

        return proceed();
    }

    /**
     * Log all entries and exits of non-static methods that have no return
     * values.
     */
    Object around() : 
            !logObjectCalls() && 
            publicMethodsWithParameterCalls() && 
            !publicStaticMethodsWithParameterCalls() && 
            !publicMethodsWithReturnValueCalls() {
        // The class that uses the method that has been called
        final Class _target = thisJoinPoint.getTarget().getClass();

        // Get The logger to perform logging
        Log logger = LogFactory.getLog(_target);

        if (logger.isDebugEnabled()) {
            // Log the entry
            logger.debug('<' + getFullSignature(thisJoinPoint));

            // Execute the method
            final Object result = proceed();

            // Log the exit
            logger.debug('>' + thisJoinPoint.getSignature().getName());
            return result;
        }

        return proceed();
    }

    /**
     * Log all entries and exits of static methods that have return values.
     */
    Object around() : 
            !logObjectCalls() && 
            publicMethodsWithParameterCalls() && 
            publicMethodsWithReturnValueCalls() && 
            publicStaticMethodsWithParameterCalls() {
        // Get The logger to perform logging
        Log _logger = LogFactory.getLog(
                thisJoinPoint.getSignature().getDeclaringType());

        if (_logger.isDebugEnabled()) {
            // Log the entry
            _logger.debug('<' + getFullSignature(thisJoinPoint));

            // Execute the method
            final Object _result = proceed();

            // Compute the exit string to print
            final StringBuffer _exitString =
                    new StringBuffer(thisJoinPoint.getSignature().getName());

            _exitString.append(' ');
            _exitString.append('=');
            _exitString.append(' ');
            _exitString.append('[');
            _exitString.append(_result);
            _exitString.append(']');

            // Log the exit
            _logger.debug('>' + _exitString.toString());
            
            return _result;
        }

        return proceed();
    }

    /**
     * Log all entries and exits of non-static methods that have return values.
     */
    Object around() : 
            !logObjectCalls() && 
            publicMethodsWithParameterCalls() && 
            publicMethodsWithReturnValueCalls() && 
            !publicStaticMethodsWithParameterCalls() {
        // The class that uses the method that has been called
        final Class _target = thisJoinPoint.getTarget().getClass();

        // Get The logger to perform logging
        Log _logger = LogFactory.getLog(_target);

        if (_logger.isDebugEnabled()) {
            // Log the entry
            _logger.debug('<' + getFullSignature(thisJoinPoint));

            // Execute the method
            final Object _result = proceed();

            // Compute the exit string to print
            final StringBuffer _exitString =
                    new StringBuffer(thisJoinPoint.getSignature().getName());

            _exitString.append(' ');
            _exitString.append('=');
            _exitString.append(' ');
            _exitString.append('[');
            _exitString.append(_result);
            _exitString.append(']');

            // Log the exit
            _logger.debug('>' + _exitString.toString());
            
            return _result;
        }

        return proceed();
    }

    /**
     * @return the full signature of a method
     */
    private final String getFullSignature(final JoinPoint jp) {
        StringBuffer _buffer = new StringBuffer();
        _buffer.append(jp.getSignature().getName());
        _buffer.append('(');
        
        final Object[] _objs = jp.getArgs();
        
        if (0 < _objs.length) {
            for (int _i = 0; _i < _objs.length - 1; _i++) {
                _buffer.append('[');
                _buffer.append(_objs[_i]);
                _buffer.append(']');
                _buffer.append(',');
                _buffer.append(' ');
            }
            
            _buffer.append('[');
            _buffer.append(_objs[_objs.length - 1]);
            _buffer.append(']');
        }
        
        _buffer.append(')');
        
        return _buffer.toString();
    }

}
