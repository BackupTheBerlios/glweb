/*
 * $Id: CommonDAOFactory.java,v 1.2 2003/10/29 08:27:23 paxson Exp $
 * 
 */

package com.siwi.website.ejb.dao;

import com.siwi.common.logger.Logger;
import com.siwi.common.logger.LoggerFactory;

/**
 *  CommonDAOFactory
 *
 * @author  Paxson Yang
 * @created  2002/8/8
 * @version  $Revision: 1.2 $ $Date: 2003/10/29 08:27:23 $
 */
public class CommonDAOFactory {
    private final static String CLASS_NAME =
            "com.siwi.website.ejb.dao.CommonDAOFactory";

    private final static boolean DEBUG = true;

    private static Logger _logger;

    /**
     *  Gets the logger attribute of the CommonDAOFactory class
     *
     * @return    The logger value
     */
    private static Logger getLogger() {
        if (null == _logger) {
            _logger = LoggerFactory.getInstance().getLogger(CLASS_NAME);
            _logger.setDebug(DEBUG);
        }

        return _logger;
    }

    /**
     *  Gets the cityDAO attribute of the CommonDAOFactory class
     *
     * @return                          The cityDAO value
     * @exception  DAOFactoryException  Description of the Exception
     */
    public static CityDAO getCityDAO() throws DAOFactoryException {
        return (CityDAO) newDAO(CityDAO.IMPL_CLASS);
    }

    /**
     *  Gets the countryDAO attribute of the CommonDAOFactory class
     *
     * @return                          The countryDAO value
     * @exception  DAOFactoryException  Description of the Exception
     */
    public static CountryDAO getCountryDAO() throws DAOFactoryException {
        return (CountryDAO) newDAO(CountryDAO.IMPL_CLASS);
    }

    /**
     *  Description of the Method
     *
     * @param  name  Description of the Parameter
     * @return       Description of the Return Value
     */
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

}