/*
 *
 * $Id: UserDAOImpl.java,v 1.2 2003/05/17 10:16:53 kocachen Exp $
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
import java.util.Iterator;
import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.glweb.infrastructure.persistence.GLWebPersistenceException;
import com.glweb.infrastructure.persistence.hibernate.HibernateUtil;
import com.glweb.module.member.dao.UserDAO;
import com.glweb.module.member.dao.UserProfileDAO;
import com.glweb.module.member.factory.UserDAOFactory;
import com.glweb.module.member.model.User;

/**
 * HibernateUserDAO
 *
 * @author   $Author: kocachen $
 * @version  $Revision: 1.2 $ $Date: 2003/05/17 10:16:53 $
 */
public class UserDAOImpl implements UserDAO {
	
	private UserProfileDAO m_UserProfileDAO;
    
    public UserDAOImpl() throws GLWebPersistenceException  {
    	this.setUserProfileDAO(UserDAOFactory.getUserProfileDAO());
    }
    
    /**
     * @see com.glweb.system.user.UserDAO#getUser(long)
     */
    public User getUser(long id) throws GLWebPersistenceException {
        User _user = null;
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            _user = (User) _session.load(User.class, new Long(id));
            
            this.assignUserProfile(_user, _session);    
                    
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
            _query = _session.getNamedQuery("com.glweb.module.member.model.User.findAll");
            _users = _query.list();
            
            this.assignUsersProfile(_users, _session);
            
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
            _query = _session.getNamedQuery("com.glweb.module.member.model.User.findByName");
            _query.setParameter("name", name);
            _users = _query.list();
            
            this.assignUsersProfile(_users, _session);
            
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
     * @see com.glweb.system.user.UserDAO#removeUser(long)
     */
    public void removeUser(long id) throws GLWebPersistenceException {
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            
			this.removeUserProfile(id, _session);
            _session.delete(getUser(id)); 
                       
        } catch (HibernateException he) {
            throw new GLWebPersistenceException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }
    }
    
    /**
     * @see com.glweb.system.user.UserDAO#removeUserByName(java.lang.String)
     */
    public void removeUserByName(String name) throws GLWebPersistenceException {
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            
            User _user = getUserByName(name);
            if (null != _user) {
            	this.removeUserProfile(_user.getId(), _session);
                _session.delete(_user);
            }
        } catch (HibernateException he) {
            throw new GLWebPersistenceException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }
    }

    /**
     * @see com.glweb.system.user.UserDAO#saveUser(com.glweb.model.member.User)
     */
    public long saveUser(User user) throws GLWebPersistenceException {
        long _id = 0;
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            _id = ((Long) _session.save(user)).longValue();
            
            /*
             * save the UserProfile. (without use UserProfileDAO?)
             */
			if(user.getUserProfile()!=null){
				user.getUserProfile().setId(_id);				
				_session.save(user.getUserProfile());
        	}
        				
        } catch (HibernateException he) {
            throw new GLWebPersistenceException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }

        return _id;
    }

    /**
     * @see com.glweb.system.user.UserDAO#updateUser(com.glweb.model.user.User)
     */
    public void updateUser(User user) throws GLWebPersistenceException {
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            if (user.isUpdateFlag())
            	_session.update(user);
            
			/*
			 * save the UserProfile. (without use UserProfileDAO?)
			 */
			if(user.getUserProfile()!=null 
					&& (user.getUserProfile().isInsertFlag()
						|| user.getUserProfile().isUpdateFlag())
				){
												
				user.getUserProfile().setId(user.getId());				
				if (this.getUserProfileDAO(_session).getUserProfile(user.getId())!= null){
					_session.update(user.getUserProfile());
				}else{
					_session.save(user.getUserProfile());
				}
			}
			
        } catch (HibernateException he) {
            throw new GLWebPersistenceException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }
    }

	/**
	 * @return UserProfileDAO
	 */
	protected UserProfileDAO getUserProfileDAO(Session session) {
		
		UserProfileDAOImpl _dao = (UserProfileDAOImpl)m_UserProfileDAO ;
		_dao.setSession(session);
		return _dao;
	}

	/**
	 * Sets the userProfileDAO.
	 * @param userProfileDAO The userProfileDAO to set
	 */
	protected void setUserProfileDAO(UserProfileDAO userProfileDAO) {
		m_UserProfileDAO = userProfileDAO;
	}



	private void assignUserProfile(User user,Session session) throws GLWebPersistenceException{
		user.setUserProfile(
			this.getUserProfileDAO(session).getUserProfile(user.getId())
		);
	}
	
	private void assignUsersProfile(List users,Session session){
		
		Iterator iterator = users.iterator();
		while (iterator.hasNext()){
			try {
				this.assignUserProfile((User)iterator.next(),session);
			} catch (GLWebPersistenceException e) {
				e.printStackTrace();
			}
		}		
	}
	
	private void removeUserProfile(long id, Session session) throws GLWebPersistenceException{
		
		this.getUserProfileDAO(session).removeUserProfile(id);
			
	}
	
	
	

}
