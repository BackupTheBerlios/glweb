/*
 *
 * $Id: Category.java,v 1.1 2003/05/10 11:41:13 paxson Exp $
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

package com.glweb.module.forum.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.glweb.infrastructure.persistence.AbstractPersistableObject;
import com.glweb.module.member.model.User;

/**
 * Category
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/05/10 11:41:13 $
 */
public class Category extends AbstractPersistableObject {
    private String _name;
    private String _description;
    private Set _moderators;
    private Category _parentCategory;
    private Set _childrenCategories;
    private Set _messages;
    private Date _creationDate;
    private Date _modifiedDate;

    public Category() {
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public boolean addModerator(User moderator) {
        if (null == getModerators()) {
            setModerators(new HashSet(1));
        }
        
        return getModerators().add(moderator);
    }

    public Set getModerators() {
        return _moderators;
    }

    public void setModerators(Set moderators) {
        _moderators = moderators;
    }

    public boolean removeModerator(User moderator) {
        if (null != getModerators()) {
            return getModerators().remove(moderator);
        } else {
            return false;
        }
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public Category getParentCategory() {
        return _parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        _parentCategory = parentCategory;
    }

    public Date getCreationDate() {
        return _creationDate;
    }

    public void setCreationDate(Date creationDate) {
        _creationDate = creationDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public boolean addChildrenCategory(Category childrenCategory) {
        if (null == getChildrenCategories()) {
            setChildrenCategories(new HashSet(1));
        }
        
        return getChildrenCategories().add(childrenCategory);
    }

    public Set getChildrenCategories() {
        return _childrenCategories;
    }

    public boolean removeChildrenCategory(Category childrenCategory) {
        if (null != getChildrenCategories()) {
            return getChildrenCategories().remove(childrenCategory);
        } else {
            return false;
        }
    }

    public void setChildrenCategories(Set childrenCategories) {
        _childrenCategories = childrenCategories;
    }

    public boolean addMessage(Message message) {
        if (null == getMessages()) {
            setMessages(new HashSet(1));
        }
        
        return getMessages().add(message);
    }

    public void clearMessages() {
        if (null != getMessages()) {
            getMessages().clear();
        }
    }

    public Set getMessages() {
        return _messages;
    }

    public boolean removeMessage(Message message) {
        if (null != getMessages()) {
            return getMessages().remove(message);
        } else {
            return false;
        }
    }

    public void setMessages(Set messages) {
        _messages = messages;
    }

}