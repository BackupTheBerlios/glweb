/*
 *
 * $Id: JUnitForumHelper.java,v 1.4 2003/06/03 01:51:17 paxson Exp $
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

package com.glweb.module.forum;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.glweb.module.forum.model.Category;
import com.glweb.module.forum.model.Message;
import com.glweb.module.member.MembershipManager;
import com.glweb.module.member.model.User;

/**
 * JUnitForumHelper
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.4 $ $Date: 2003/06/03 01:51:17 $
 */
public class JUnitForumHelper {

    private static Log _logger;

    protected static Log getLogger() {
        if (null == _logger) {
            _logger = LogFactory.getLog(JUnitForumHelper.class);
        }

        return _logger;
    }

    protected static MembershipManager getUserManager() {
        return MembershipManager.getInstance();
    }

    protected static ForumManager getForumManager() {
        return ForumManager.getInstance();
    }

    public static void addUsers() {
        User _paxson = new User();
        _paxson.setName("Paxson Yang");
        _paxson.setPassword("");
        _paxson.setEmail("");

        User _cat = new User();
        _cat.setName("Cat Chen");
        _cat.setPassword("");
        _cat.setEmail("");

        if (null == getUserManager().getUserByName(_paxson.getName())) {
            getUserManager().createUser(
                    _paxson.getName(),
                    _paxson.getPassword(),
                    _paxson.getEmail());
        }

        if (null == getUserManager().getUserByName(_cat.getName())) {
            getUserManager().createUser(
                    _cat.getName(),
                    _cat.getPassword(),
                    _paxson.getEmail());
        }
    }

    public static void deleteUsers() {
        getUserManager().removeUserByName("Paxson Yang");
        getUserManager().removeUserByName("Cat Chen");
    }

    public static User getPosterPaxson() {
        return getUserManager().getUserByName("Paxson Yang");
    }

    public static User getPosterCat() {
        return getUserManager().getUserByName("Cat Chen");
    }

    public static Category buildCategory(String name) {
        Category _category = new Category();
        _category.setName(name);
        _category.setDescription("Description of " + name + " Category");

        return _category;
    }

    public static Set buildModerators() {
        Set _moderators = new HashSet();

        _moderators.add(JUnitForumHelper.getPosterPaxson());
        _moderators.add(JUnitForumHelper.getPosterCat());

        return _moderators;
    }

    public static void addCategoriesAndMessages() {
        getForumManager().addCategory(buildCategory("Java"));
        getForumManager().addCategory(buildCategory("JXTA"));
    }

    public static void deleteCategoriesAndMessages() {
        Category[] _categories =
            (Category[]) getForumManager().getRootCategories().toArray(
                new Category[0]);

        for (int _i = 0; _i < _categories.length; _i++) {
            getForumManager().deleteCategory(_categories[_i]);
        }
    }

    public static Category getCategoryByName(String name) {
        Category[] _categories =
            (Category[]) getForumManager().getRootCategories().toArray(
                new Category[0]);

        for (int _i = 0; _i < _categories.length; _i++) {
            if (name.equals(_categories[_i].getName())) {
                return _categories[_i];
            }
        }

        return null;
    }

    public static Message buildMassage(Category category, int index) {
        Message _message = new Message();

        _message.setCategory(category);
        _message.setSubject("Subject of " + category.getName() + " " + index);
        _message.setMessage("Message of " + category.getName() + " " + index);
        _message.setPoster(getPosterPaxson());

        return _message;
    }

}
