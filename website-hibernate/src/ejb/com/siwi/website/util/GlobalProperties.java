/*
 * $Id: GlobalProperties.java,v 1.2 2003/10/30 10:28:38 paxson Exp $
 */

package com.siwi.website.util;

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
 * @version  $Revision: 1.2 $ $Date: 2003/10/30 10:28:38 $
 *
 * @see java.beans.PropertyChangeListener
 * @see java.beans.PropertyChangeSupport
 */
public class GlobalProperties {
    
    private static final String FQCN = GlobalProperties.class.getName();
    
    private static final String CONFIG = "website_config.properties";

    private static GlobalProperties _instance;
    
    private Properties _globalProperties = new Properties();
    
    private PropertyChangeSupport _propertySupport;
            
    private Log _logger;

    private GlobalProperties() {
        _logger = LogFactory.getLog(FQCN);
        
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
