/*
 * $Id: CountryDAO.java,v 1.2 2003/10/29 08:27:23 paxson Exp $
 * 
 */

package com.siwi.website.ejb.dao;

import java.util.Collection;

import com.siwi.website.ejb.model.Country;

/**
 *  CountryDAO
 *
 * @author  Paxson Yang
 * @created  2002/8/8
 * @version  $Revision: 1.2 $ $Date: 2003/10/29 08:27:23 $
 */
public interface CountryDAO {
    final static String IMPL_CLASS =
            "com.siwi.website.ejb.dao.impl.HibernateCountryDAO";

    void init() throws DAOException;

    Country get(long id) throws DAOException;

    void add(Country vakue) throws DAOException;

    void update(Country value) throws DAOException;
    
    void delete(long id) throws DAOException;

    Collection findAll() throws DAOException;

}