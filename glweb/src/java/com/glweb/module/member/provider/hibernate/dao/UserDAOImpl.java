/*
 *
 * $Id: UserDAOImpl.java,v 1.1 2003/05/10 11:41:13 paxson Exp $
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

package com.glweb.module.member.provider.hibernate.dao;

import java.util.Collection;
import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.glweb.infrastructure.persistence.GLWebPersistenceException;
import com.glweb.infrastructure.persistence.hibernate.HibernateUtil;
import com.glweb.module.member.dao.UserDAO;
import com.glweb.module.member.model.User;

/**
 * UserDAOImpl
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/05/10 11:41:13 $
 */
public class UserDAOImpl implements UserDAO {
    
    public UserDAOImpl() throws GLWebPersistenceException  {
    }
    
    /**
     * @see com.glweb.module.user.UserDAO#getUser(long)
     */
    public User getUser(long id) throws GLWebPersistenceException {
        User _user = null;
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            _user = (User) _session.load(User.class, new Long(id));
        } catch (HibernateException he) {
            return null;
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }

        return _user;
    }
    
    public Collection getUsers() throws GLWebPersistenceException {
        List _users = null;
        Query _query = null;
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            _query = _session.getNamedQuery("member.model.User.findAll");
            _users = _query.list();
        } catch (HibernateException he) {
            throw new GLWebPersistenceException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }

        return _users;
    }
    
    public User getUserByName(String name) throws GLWebPersistenceException {
        List _users = null;
        Query _query = null;
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            _query = _session.getNamedQuery("member.model.User.findByName");
            _query.setParameter("name", name);
            _users = _query.list();
        } catch (HibernateException he) {
            throw new GLWebPersistenceException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }

        if (0 != _users.size()) {
            return (User) _users.get(0);
        } else {
            return null;
        }
    }

    /**
     * @see com.glweb.module.user.UserDAO#removeUser(long)
     */
    public void removeUser(long id) throws GLWebPersistenceException {
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            _session.delete(getUser(id));
        } catch (HibernateException he) {
            throw new GLWebPersistenceException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }
    }
    
    /**
     * @see com.glweb.module.user.UserDAO#removeUserByName(java.lang.String)
     */
    public void removeUserByName(String name) throws GLWebPersistenceException {
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            
            User _user = getUserByName(name);
            if (null != _user) {
                _session.delete(_user);
            }
        } catch (HibernateException he) {
            throw new GLWebPersistenceException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }
    }

    /**
     * @see com.glweb.module.user.UserDAO#saveUser(com.glweb.model.user.User)
     */
    public long saveUser(User user) throws GLWebPersistenceException {
        long _id = 0;
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            _id = ((Long) _session.save(user)).longValue();
        } catch (HibernateException he) {
            throw new GLWebPersistenceException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }

        return _id;
    }

    /**
     * @see com.glweb.module.user.UserDAO#updateUser(com.glweb.model.user.User)
     */
    public void updateUser(User user) throws GLWebPersistenceException {
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            _session.update(user);
        } catch (HibernateException he) {
            throw new GLWebPersistenceException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }
    }

}
