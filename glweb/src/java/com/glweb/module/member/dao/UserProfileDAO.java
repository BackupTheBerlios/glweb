/*
 *
 * $Id: UserProfileDAO.java,v 1.1 2003/05/17 10:16:53 kocachen Exp $
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

package com.glweb.module.member.dao;

import com.glweb.module.member.model.UserProfile;
import com.glweb.infrastructure.persistence.GLWebPersistenceException;

/**
 * UserDAO
 *
 */
public interface UserProfileDAO {
    
    /**
	 * @param id
	 * @return
	 * @throws GLWebPersistenceException
	 */
	public UserProfile getUserProfile(long id) throws GLWebPersistenceException;
    
    /**
	 * @param user
	 * @return
	 * @throws GLWebPersistenceException
	 */
	public long saveUserProfile(UserProfile user) throws GLWebPersistenceException;
    
    /**
	 * @param user
	 * @throws GLWebPersistenceException
	 */
	public void updateUserProfile(UserProfile user) throws GLWebPersistenceException;
    
    /**
	 * @param id
	 * @throws GLWebPersistenceException
	 */
	public void removeUserProfile(long id) throws GLWebPersistenceException;
    
}
