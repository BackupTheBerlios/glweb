/*
 * $Id: AbstractTestCase.java,v 1.1 2003/10/30 10:28:38 paxson Exp $
 */

package com.siwi.website;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/10/30 10:28:38 $
 */
public class AbstractTestCase extends TestCase {
    
    private Log _logger;
    
    public AbstractTestCase(String name) {
        super(name);
    }
    
    protected Log getLogger() {
        if (null == _logger) {
            _logger = LogFactory.getLog(getClass());
        }
        
        return _logger;
    }

}
