/*
 * $Id: CityDAO.java,v 1.3 2003/10/30 10:28:38 paxson Exp $
 * 
 */

package com.siwi.website.ejb.dao;

import java.util.Collection;

import com.siwi.website.ejb.model.City;

/**
 *  CityDAO
 *
 * @author  Paxson Yang
 * @created  2002/8/9
 * @version  $Revision: 1.3 $ $Date: 2003/10/30 10:28:38 $
 */
public interface CityDAO {
    final static String IMPL_CLASS = 
            "com.siwi.website.ejb.dao.impl.HibernateCityDAO";

    void init() throws DAOException;

    City get(long id) throws DAOException;

    long add(City value) throws DAOException;

    void update(City value) throws DAOException;
    
    void delete(long id) throws DAOException;

    Collection findAll() throws DAOException;

}