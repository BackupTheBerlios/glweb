/*
 * $Id: LanguageDAO.java,v 1.1 2003/10/30 10:28:38 paxson Exp $
 * 
 */

package com.siwi.website.ejb.dao;

import java.util.Collection;

import com.siwi.website.ejb.model.Language;

/**
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/10/30 10:28:38 $
 */
public interface LanguageDAO {

    final static String IMPL_CLASS = 
            "com.siwi.website.ejb.dao.impl.HibernateLanguageDAO";

    void init() throws DAOException;

    Language get(long id) throws DAOException;

    long add(Language value) throws DAOException;

    void update(Language value) throws DAOException;
    
    void delete(long id) throws DAOException;

    Collection findAll() throws DAOException;

}
