/*
 *
 * $Id: CategoryDAOImpl.java,v 1.1 2003/05/10 11:41:13 paxson Exp $
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

package com.glweb.module.forum.provider.hibernate.dao;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.ObjectNotFoundException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.glweb.infrastructure.persistence.GLWebPersistenceException;
import com.glweb.infrastructure.persistence.hibernate.HibernateUtil;
import com.glweb.module.forum.dao.CategoryDAO;
import com.glweb.module.forum.model.Category;

public class CategoryDAOImpl implements CategoryDAO {
    
    private static final String ROOT_CATEGORIES = 
            "forum.model.Category.findRootCategories";
    
    private static Log log = LogFactory.getLog(CategoryDAOImpl.class.getName());

    public Category getCategory(long categoryId) throws GLWebPersistenceException {
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            
            return (Category) _session.load(Category.class, new Long(categoryId));
        } catch (ObjectNotFoundException onfe) {
            return null;
        } catch (HibernateException he) {
            throw new GLWebPersistenceException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }
    }

    public Collection getRootCategories() throws GLWebPersistenceException {
        Session _session = null;
        Query _query = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();

            _query = _session.getNamedQuery(ROOT_CATEGORIES);
            
            return _query.list();
        } catch (HibernateException he) {
            throw new GLWebPersistenceException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }
    }

    public long addCategory(Category category) throws GLWebPersistenceException {
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            
            return ((Long) _session.save(category)).longValue();
        } catch (HibernateException he) {
            throw new GLWebPersistenceException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }
    }

    public void updateCategory(Category category) throws GLWebPersistenceException {
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            _session.update(category);
        } catch (HibernateException he) {
            throw new GLWebPersistenceException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }
    }

    public void deleteCategory(Category category) throws GLWebPersistenceException {
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            _session.delete(getCategory(category.getId()));
        } catch (HibernateException he) {
            throw new GLWebPersistenceException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }
    }
}
