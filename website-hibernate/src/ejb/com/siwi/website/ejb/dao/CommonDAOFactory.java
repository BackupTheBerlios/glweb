/*
 * $Id: CommonDAOFactory.java,v 1.3 2003/10/30 10:28:38 paxson Exp $
 * 
 */

package com.siwi.website.ejb.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.3 $ $Date: 2003/10/30 10:28:38 $
 */
public class CommonDAOFactory {
    private final static String FQCN = CommonDAOFactory.class.getName();

    private static Log _logger;
    
    private static Object newDAO(String name) {
        getLogger().debug("Class Name = " + name);

        try {
            return Class.forName(name).newInstance();
        } catch (ClassNotFoundException cnfe) {
            throw new DAOFactoryException(cnfe);
        } catch (IllegalAccessException iae) {
            throw new DAOFactoryException(iae);
        } catch (InstantiationException ie) {
            throw new DAOFactoryException(ie);
        }
    }

    private static Log getLogger() {
        if (null == _logger) {
            _logger = LogFactory.getLog(FQCN);
        }

        return _logger;
    }

    public static CountryDAO getCountryDAO() throws DAOFactoryException {
        return (CountryDAO) newDAO(CountryDAO.IMPL_CLASS);
    }
    
    public static CityDAO getCityDAO() throws DAOFactoryException {
        return (CityDAO) newDAO(CityDAO.IMPL_CLASS);
    }
    
    public static LanguageDAO getLanguageDAO() throws DAOFactoryException {
        return (LanguageDAO) newDAO(LanguageDAO.IMPL_CLASS);
    }
    
    public static LanguageCodeDAO getLanguageCodeDAO() throws DAOFactoryException {
        return (LanguageCodeDAO) newDAO(LanguageCodeDAO.IMPL_CLASS);
    }

}