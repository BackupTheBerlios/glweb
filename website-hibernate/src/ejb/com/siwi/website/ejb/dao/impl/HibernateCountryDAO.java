/*
 * $Id: HibernateCountryDAO.java,v 1.1 2003/10/30 10:28:38 paxson Exp $
 * 
 */

package com.siwi.website.ejb.dao.impl;

import java.util.Collection;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.ObjectNotFoundException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.siwi.website.ejb.dao.CountryDAO;
import com.siwi.website.ejb.dao.DAOException;
import com.siwi.website.ejb.model.Country;
import com.siwi.website.infrastructure.persistence.WebsitePersistenceException;
import com.siwi.website.infrastructure.persistence.hibernate.HibernateUtil;

/**
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/10/30 10:28:38 $
 */
public class HibernateCountryDAO implements CountryDAO {
    
    private static final String ALL_COUNTRIES = "Country.findAll";
    
    public void init() throws DAOException {
        // TODO Auto-generated method stub
    }

    public long add(Country value) throws DAOException {
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            
            return ((Long) _session.save(value)).longValue();
        } catch (WebsitePersistenceException wpe) {
            throw new DAOException(wpe);
        } catch (HibernateException he) {
            throw new DAOException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }
    }

    public void delete(long id) throws DAOException {
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            
            _session.delete(get(id));
        } catch (WebsitePersistenceException wpe) {
            throw new DAOException(wpe);
        } catch (HibernateException he) {
            throw new DAOException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }
    }

    public Collection findAll() throws DAOException {
        Session _session = null;
        Query _query = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();

            _query = _session.getNamedQuery(ALL_COUNTRIES);
            
            return _query.list();
        } catch (WebsitePersistenceException wpe) {
            throw new DAOException(wpe);
        } catch (HibernateException he) {
            throw new DAOException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }
    }

    public Country get(long id) throws DAOException {
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            
            return (Country) _session.load(Country.class, new Long(id));
        } catch (ObjectNotFoundException onfe) {
            return null;
        } catch (WebsitePersistenceException wpe) {
            throw new DAOException(wpe);
        } catch (HibernateException he) {
            throw new DAOException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }
    }

    public void update(Country value) throws DAOException {
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            
            _session.update(value);
        } catch (WebsitePersistenceException wpe) {
            throw new DAOException(wpe);
        } catch (HibernateException he) {
            throw new DAOException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }
    }

}
