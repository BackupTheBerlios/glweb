/*
 *
 * $Id: UserDAO.java,v 1.1 2003/05/10 11:41:13 paxson Exp $
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

import java.util.Collection;

import com.glweb.module.member.model.User;
import com.glweb.infrastructure.persistence.GLWebPersistenceException;

/**
 * UserDAO
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/05/10 11:41:13 $
 */
public interface UserDAO {
    
    /**
     * getUser
     * 
     * @param id
     * @return
     * @throws GLWebPersistenceException
     */
    public User getUser(long id) throws GLWebPersistenceException;
    
    /**
     * getUserByName
     * 
     * @param name
     * @return User
     * @throws GLWebPersistenceException
     */
    public User getUserByName(String name) throws GLWebPersistenceException;
    
    /**
     * getUsers
     * 
     * @return Collection
     * @throws GLWebPersistenceException
     */
    public Collection getUsers() throws GLWebPersistenceException;
    
    /**
     * saveUser
     * 
     * @param user
     * @return
     * @throws GLWebPersistenceException
     */
    public long saveUser(User user) throws GLWebPersistenceException;
    
    /**
     * updateUser
     * 
     * @param user
     * @throws GLWebPersistenceException
     */
    public void updateUser(User user) throws GLWebPersistenceException;
    
    /**
     * removeUser
     * 
     * @param id
     * @throws GLWebPersistenceException
     */
    public void removeUser(long id) throws GLWebPersistenceException;
    
    /**
     * removeUserByName
     * 
     * @param  name
     * @throws GLWebPersistenceException
     */
    public void removeUserByName(String name) throws GLWebPersistenceException;

}
