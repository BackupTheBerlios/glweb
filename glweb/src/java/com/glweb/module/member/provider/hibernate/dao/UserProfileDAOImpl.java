/*
 *
 * $Id: UserProfileDAOImpl.java,v 1.1 2003/05/17 10:16:53 kocachen Exp $
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

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;

import com.glweb.infrastructure.persistence.GLWebPersistenceException;
import com.glweb.infrastructure.persistence.hibernate.HibernateUtil;
import com.glweb.module.member.dao.UserProfileDAO;
import com.glweb.module.member.model.UserProfile;

/**
 * @author Administrator
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class UserProfileDAOImpl extends AbstractUserDAO implements UserProfileDAO {

	/**
	 * 
	 */
	public UserProfileDAOImpl() {
	}

	public UserProfileDAOImpl(Session session) {
		super(session);
	}	
	

	/* (non-Javadoc)
	 * @see com.glweb.system.user.UserProfileDAO#getUserProfile(long)
	 */
	public UserProfile getUserProfile(long id) throws GLWebPersistenceException {
		UserProfile _profile = null;
		Session _session = null;

		try {
			
			_session = HibernateUtil.retrieveDefaultSession();
			_profile = (UserProfile) _session.load(UserProfile.class, new Long(id));
			
		} catch (HibernateException he) {
			return null;
		} finally {
			HibernateUtil.commitCloseSession(_session);
		}
		
		return _profile;
	}

	/* (non-Javadoc)
	 * @see com.glweb.system.user.UserProfileDAO#saveUserProfile(com.glweb.model.user.User)
	 */
	public long saveUserProfile(UserProfile profile) throws GLWebPersistenceException {
		
		long _id = 0;
		Session _session = null;

		try {
			_session = super.useSession();
			_id = ((Long) _session.save(profile)).longValue();
		} catch (HibernateException he) {
			throw new GLWebPersistenceException(he);
		} finally {
			super.closeSession();
		}
		return _id;	
	}

	/* (non-Javadoc)
	 * @see com.glweb.system.user.UserProfileDAO#updateUserProfile(com.glweb.model.user.User)
	 */
	public void updateUserProfile(UserProfile profile) throws GLWebPersistenceException {
		Session _session = null;

		try {
			_session = super.useSession();
			_session.update(profile);
		} catch (HibernateException he) {
			throw new GLWebPersistenceException(he);
		} finally {
			super.closeSession();
		}
	}

	/* (non-Javadoc)
	 * @see com.glweb.system.user.UserProfileDAO#removeUserProfile(long)
	 */
	public void removeUserProfile(long id) throws GLWebPersistenceException {
		Session _session = null;
		
		try {
			_session = super.useSession();
			UserProfile _profile = this.getUserProfile(id);
			if (_profile != null)
				_session.delete(_profile);
		} catch (HibernateException he) {
			throw new GLWebPersistenceException(he);
		} finally {
			super.closeSession();
		}
		
	}


}
