/*
 *
 * $Id: AbstractTestCase.java,v 1.1 2003/05/10 11:41:13 paxson Exp $
 *
 * Copyright (c) 2003 SIWI
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

package com.glweb;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import junit.framework.TestCase;

/**
 * Abstract base class for test cases.
 * 
 * @author  $Autjor: $
 * @version $Revision: 1.1 $ $Date: 2003/05/10 11:41:13 $
 */
public abstract class AbstractTestCase extends TestCase {
    
    private Log _logger;
    
    /** 
     * Basedir for all file I/O. Important when running tests from
     * the reactor.
     */
    private String _basedir = System.getProperty("basedir");
    
    /**
     * Constructor.
     */
    public AbstractTestCase(String testName) {
        super(testName);
    }
       
    /**
     * Returns the basedir.
     * 
     * @return String
     */
    protected String getBasedir() {
        return _basedir;
    }

    /**
     * Sets the basedir.
     * 
     * @param basedir The basedir to set
     */
    protected void setBasedir(String basedir) {
        _basedir = basedir;
    }
    
    protected Log getLogger() {
        if (null == _logger) {
            setLogger(LogFactory.getLog(getClass()));
        }
        
        return _logger;
    }

    protected void setLogger(Log log) {
        _logger = log;
    }

    /**
     * Get test input file.
     *
     * @param path Path to test input file.
     */
    public String getTestFile(String path) {
        return new File(getBasedir(), path).getAbsolutePath();
    }

}
