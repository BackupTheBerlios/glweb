/*
 * $Id: CityDAO.java,v 1.2 2003/10/29 08:27:23 paxson Exp $
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
 * @version  $Revision: 1.2 $ $Date: 2003/10/29 08:27:23 $
 */
public interface CityDAO {
    final static String IMPL_CLASS = 
            "com.siwi.website.ejb.dao.impl.HibernateCityDAO";

    void init() throws DAOException;

    City get(long id) throws DAOException;

    void add(City vakue) throws DAOException;

    void update(City value) throws DAOException;
    
    void delete(long id) throws DAOException;

    Collection findAll() throws DAOException;

}