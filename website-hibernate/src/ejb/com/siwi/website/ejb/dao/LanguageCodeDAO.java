/*
 * $Id: LanguageCodeDAO.java,v 1.1 2003/10/30 10:28:38 paxson Exp $
 * 
 */

package com.siwi.website.ejb.dao;

import java.util.Collection;

import com.siwi.website.ejb.model.LanguageCode;

/**
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/10/30 10:28:38 $
 */
public interface LanguageCodeDAO {

    final static String IMPL_CLASS = 
            "com.siwi.website.ejb.dao.impl.HibernateLanguageCodeDAO";

    void init() throws DAOException;

    LanguageCode get(long id) throws DAOException;

    long add(LanguageCode value) throws DAOException;

    void update(LanguageCode value) throws DAOException;
    
    void delete(long id) throws DAOException;

    Collection findAll() throws DAOException;

}
