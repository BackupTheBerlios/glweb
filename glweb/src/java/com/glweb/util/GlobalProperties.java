/*
 *
 * $Id: GlobalProperties.java,v 1.2 2003/09/18 06:55:26 paxson Exp $
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

package com.glweb.util;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * GlobalProperties
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.2 $ $Date: 2003/09/18 06:55:26 $
 *
 * @see java.beans.PropertyChangeListener
 * @see java.beans.PropertyChangeSupport
 */
public class GlobalProperties {
    
    private static final String CONFIG = "glweb_config.properties";

    private static GlobalProperties _instance;
    
    private Properties _globalProperties = new Properties();
    
    private PropertyChangeSupport _propertySupport;
            
    private Log _logger;

    private GlobalProperties() {
        _logger = LogFactory.getLog("com.glweb.util.GlobalProperties");
        
        try {
            InputStream _in = ClassLoader.getSystemResourceAsStream(CONFIG);
            
            if (null == _in) {
                _logger.warn("<Unable to find the global properties from system resources/>");
                _logger.warn("<Try to find the global properties from class resources/>");
                
                _in = getClass().getResourceAsStream(CONFIG);
                
                if (null == _in) {
                    _logger.warn("<Unable to find the global properties from class resources/>");
                } else {
                    _logger.info("<Found the global properties from class resources/>");
                }
            } else {
                _logger.info("<Found the global properties from system resources/>");
            }
            
            getGlobalProperties().load(_in);
        } catch (IOException ioe) {
            _logger.error("<Unable to read global properties!/>");
        }
    }
    
    public static GlobalProperties getInstance() {
        synchronized (GlobalProperties.class) {
            if (null == _instance) {
                _instance = new GlobalProperties();
            }
        }
        
        return _instance;
    }
    
    protected Properties getGlobalProperties() {
        return _globalProperties;
    }
    
    protected PropertyChangeSupport getPropertySupport() {
        if (null == _propertySupport) {
            _propertySupport = new PropertyChangeSupport(getInstance());
        }

        return _propertySupport;
    }

    public String getProperty(String key) {
        return getGlobalProperties().getProperty(key);
    }

    public void subscribe(
            String propertyName, PropertyChangeListener subscriber) {
        getPropertySupport().addPropertyChangeListener(propertyName, subscriber);
    }

    public void unsubscribe(
            String propertyName, PropertyChangeListener subscriber) {
        getPropertySupport().removePropertyChangeListener(propertyName, subscriber);
    }

    private void publishPropChange(
            String propertyName, String oldValue, String newValue) {
        getPropertySupport().firePropertyChange(propertyName, oldValue, newValue);
    }

}
