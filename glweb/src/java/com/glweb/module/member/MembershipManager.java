/*
 *
 * $Id: MembershipManager.java,v 1.1 2003/05/17 10:16:53 kocachen Exp $
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

package com.glweb.module.member;

import java.util.Collection;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;

import com.glweb.BaseObject;
import com.glweb.infrastructure.persistence.GLWebPersistenceException;
import com.glweb.module.member.dao.UserDAO;
import com.glweb.module.member.factory.*;
import com.glweb.module.member.model.User;


/**
 * UserManager
 *
 * @author   $Author: kocachen $
 * @version  $Revision: 1.1 $ $Date: 2003/05/17 10:16:53 $
 */
public class MembershipManager extends BaseObject {
    
    private static MembershipManager _instance;
    
    private UserDAO _userDAO;

    private MembershipManager() {
        setUserDAO(UserDAOFactory.getUserDAO());
    }

    /**
     * Get a new instance of this manager.
     *
     * @return instance
     */
    public static MembershipManager getInstance() {
        if (null == _instance) {
            _instance = new MembershipManager();
        }

        return _instance;
    }
    
    protected UserDAO getUserDAO() {
        return _userDAO;
    }

    protected void setUserDAO(UserDAO userDAO) {
        _userDAO = userDAO;
    }
    
    /**
     * @param  User
     * @return true/false
     */
    protected User createUser(User user) {
        long _id = 0;
        
        try {
            _id = getUserDAO().saveUser(user);
        } catch (GLWebPersistenceException e) {
            getLogger().error(e.getMessage(), e);
            return null;
        }
        
        return getUser(_id);
    }
    
    /**
	 * @param userName
	 * @param password
	 * @param email
	 * @return com.glweb.model.user.User
	 */
	public User createUser(String userName, String password, String email){
    	User _user = new User();
    	_user.setName(userName);
    	_user.setPassword(password);
    	_user.setEmail(email);
		_user.setCreationDate(new Date());
		_user.setLastModifiedDate(new Date());
    	return createUser(_user);
    }
    
    /**
     * @param  User
     * @return true/false
     */
    public User updateUser(User newUser) {
        User _user = null;
        
        try {
            _user = getUser(newUser.getId());
            
            PropertyUtils.copyProperties(_user, newUser);
            
			_user.setLastModifiedDate(new Date());
            getUserDAO().updateUser(_user);
        } catch (GLWebPersistenceException e) {
            getLogger().error(e.getMessage(), e);
            return null;
        } catch (Exception e) {
            getLogger().error(e.getMessage(), e);
            return null;
        }

        return getUser(newUser.getId());
    }
    

    
    /**
     * @param  id
     * @return true/false
     */
    public boolean removeUser(long id) {
        try {
            getUserDAO().removeUser(id);
        } catch (GLWebPersistenceException e) {
            getLogger().error(e.getMessage(), e);
            return false;
        }

        return true;
    }
    
    /**
     * @param  name
     * @return true/false
     */
    public boolean removeUserByName(String name) {
        try {
            getUserDAO().removeUserByName(name);
        } catch (GLWebPersistenceException e) {
            getLogger().error(e.getMessage(), e);
            return false;
        }

        return true;
    }


	/**
	 * @param  id
	 * @return User
	 */
	public User getUser(long id) {
		try {
			return getUserDAO().getUser(id);
		} catch (GLWebPersistenceException e) {
			getLogger().error(e.getMessage(), e);
			return null;
		}
	}
    
	/**
	 * @param  name
	 * @return User
	 */
	public User getUserByName(String name) {
		try {
			return getUserDAO().getUserByName(name);
		} catch (GLWebPersistenceException e) {
			getLogger().error(e.getMessage(), e);
			return null;
		}
	}
    
	/**
	 * @return Collection
	 */
	public Collection getUsers() {
		try {
			return getUserDAO().getUsers();
		} catch (GLWebPersistenceException e) {
			getLogger().error(e.getMessage(), e);
			return null;
		}
	}
    
	/**
	 * @return
	 */
	public int getUserCount() {
		return getUsers().size();
	} 
	
}
