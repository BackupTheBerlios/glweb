/*
 *
 * $Id: UserManagerTest.java,v 1.1 2003/05/10 11:41:13 paxson Exp $
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

import junit.framework.Test;
import junit.framework.TestSuite; 

import org.apache.cactus.ServletTestCase;
import org.apache.cactus.WebRequest;
import org.apache.cactus.WebResponse;

import com.glweb.module.member.model.User;

/**
 * UserManagerTest
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/05/10 11:41:13 $
 */
public class UserManagerTest extends ServletTestCase {

    public UserManagerTest(String name) {
        super(name);
        
        removeAllUsers();
    }

    public static Test suite() {
        return new TestSuite(UserManagerTest.class);
    }

    protected UserManager getUserManager() {
        return UserManager.getInstance();
    }

    protected User getNewUser(String name) {
        User _user = new User();
        _user.setName(name);

        return _user;
    
    }
    
    protected void createUsers() {
        getUserManager().createUser(getNewUser("cat"));
        getUserManager().createUser(getNewUser("paxson"));
    }
    
    protected void removeUsers() {
        getUserManager().removeUserByName("cat");
        getUserManager().removeUserByName("paxson");
    }
    
    protected void removeAllUsers() {
        User[] _users = (User[]) getUserManager().getUsers().toArray(new User[0]);
            
        for (int _i=0; _i<_users.length; _i++) {
            getUserManager().removeUser(_users[_i].getId());
        }
    }
    
    protected void printUsers() {
        User[] _users = (User[]) getUserManager().getUsers().toArray(new User[0]);
            
        for (int _i=0; _i<_users.length; _i++) {
            getLogger().info("[" + _i + "]=" + _users[_i]);
        }
    }
    
    public void beginCreateUser(WebRequest request) {
        removeUsers();
    }

    public void testCreateUser() {
        try {
            User _user = getNewUser("cat");
            User _newUser = getUserManager().createUser(_user);

            // assertion
            assertNotNull(_newUser);
            assertTrue(0 != _newUser.getId());
            assertEquals("cat", _newUser.getName());
        } catch (Exception e) {
            getLogger().error(e.getMessage(), e);
            fail(e.toString());
        }
    }
    
    public void endCreateUser(WebResponse response) {
        removeUsers();
    }
    
    public void beginUpdateUser(WebRequest request) {
        createUsers();
    }

    public void testUpdateUser() {
        try {
            User _user = getUserManager().getUserByName("cat");
            
            if (null != _user) {
                _user.setName("cat2");
                getUserManager().updateUser(_user);
            }
            
            assertNotNull(getUserManager().getUserByName("cat2"));
        } catch (Exception e) {
            getLogger().error(e.getMessage(), e);
            fail(e.toString());
        }
    }
    
    public void endUpdateUser(WebResponse response) {
        removeUsers();
    }
    
    public void beginGetUser(WebRequest request) {
        createUsers();
    }

    public void testGetUser() {
        try {
            User _user = getUserManager().getUserByName("cat");
            User _newUser = getUserManager().getUser(_user.getId());
            
            assertNotNull(_user);
            assertNotNull(_newUser);
            
            assertEquals(_user.getId(), _newUser.getId());
            
            assertEquals("cat", _user.getName());
            assertEquals("cat", _newUser.getName());
            
            assertEquals(_user, _newUser);
        } catch (Exception e) {
            getLogger().error(e.getMessage(), e);
            fail(e.toString());
        }
    }
    
    public void endGetUser(WebResponse response) {
        removeUsers();
    }
    
    public void beginGetUsers(WebRequest request) {
        createUsers();
    }
    
    public void testGetUsers() {
        try {
            Collection _users = getUserManager().getUsers();
            
            // assertion
            assertNotNull(_users);
            assertEquals(2, getUserManager().getUserCount());
        } catch (Exception e) {
            getLogger().error(e.getMessage(), e);
            fail(e.toString());
        }
    }
    
    public void endGetUsers(WebResponse response) {
        removeUsers();
    }
    
    public void beginRemoveUser(WebRequest request) {
        createUsers();
    }

    public void testRemoveUser() {
        try {
            long _catId = getUserManager().getUserByName("cat").getId();
            
            assertTrue(getUserManager().removeUser(_catId));
            
            assertNull(getUserManager().getUser(_catId));
            assertEquals(1, getUserManager().getUserCount());
            
            assertTrue(getUserManager().removeUserByName("paxson"));
            
            assertNull(getUserManager().getUserByName("paxson"));
            assertEquals(0, getUserManager().getUserCount());
        } catch (Exception e) {
            getLogger().error(e.getMessage(), e);
            fail(e.toString());
        }
    }
    
    public void endRemoveUser(WebResponse response) {
        removeUsers();
    }

}
