/*
 *
 * $Id: ForumManager.java,v 1.1 2003/05/10 11:41:13 paxson Exp $
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

import java.util.Collection;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;

import com.glweb.BaseObject;
import com.glweb.infrastructure.persistence.GLWebPersistenceException;
import com.glweb.module.forum.dao.*;
import com.glweb.module.forum.factory.CategoryDAOFactory;
import com.glweb.module.forum.factory.MessageDAOFactory;
import com.glweb.module.forum.model.Category;
import com.glweb.module.forum.model.Message;

/**
 * ForumManager
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/05/10 11:41:13 $
 */
public class ForumManager extends BaseObject {

    private static ForumManager _instance;
    
    private CategoryDAO _categoryDAO;
    
    private MessageDAO _messageDAO;

    private ForumManager() {
        setCategoryDAO(CategoryDAOFactory.getCategoryDAO());
        setMessageDAO(MessageDAOFactory.getMessageDAO());
    }

    /**
     * Get a new instance of this manager.
     *
     * @return instance
     */
    public static ForumManager getInstance() {
        if (null == _instance) {
            _instance = new ForumManager();
        }

        return _instance;
    }
    
    protected CategoryDAO getCategoryDAO() {
        return _categoryDAO;
    }

    protected void setCategoryDAO(CategoryDAO categoryDAO) {
        _categoryDAO = categoryDAO;
    }
    
    protected MessageDAO getMessageDAO() {
        return _messageDAO;
    }

    protected void setMessageDAO(MessageDAO messageDAO) {
        _messageDAO = messageDAO;
    }
    
    public Category getCategory(long categoryId) {
        try {
            return getCategoryDAO().getCategory(categoryId);
        } catch (GLWebPersistenceException e) {
            getLogger().error(e);
            return null;
        }
    }

    public Collection getRootCategories() {
        try {
            return getCategoryDAO().getRootCategories();
        } catch (GLWebPersistenceException e) {
            getLogger().error(e);
            return null;
        }
    }

    public long addCategory(Category category) {
        try {
            if (null == category.getCreationDate()) {
                category.setCreationDate(new Date());
                category.setModifiedDate(category.getCreationDate());
            } else {
                category.setModifiedDate(category.getCreationDate());
            }
            
            return getCategoryDAO().addCategory(category);
        } catch (GLWebPersistenceException e) {
            getLogger().error(e);
            return 0;
        }
    }

    public boolean updateCategory(Category newCategory) {
        Category _category = null;
        
        try {
            _category = getCategory(newCategory.getId());
            
            PropertyUtils.copyProperties(_category, newCategory);
            
            _category.setModifiedDate(new Date());
            
            getCategoryDAO().updateCategory(_category);
        } catch (GLWebPersistenceException e) {
            getLogger().error(e);
            return false;
        } catch (Exception e) {
            getLogger().error(e);
            return false;
        }
        
        return true;
    }

    public boolean deleteCategory(Category category) {
        try {
            getCategoryDAO().deleteCategory(category);
        } catch (GLWebPersistenceException e) {
            getLogger().error(e);
            return false;
        } catch (Exception e) {
            getLogger().error(e);
            return false;
        }

        return true;
    }
    
    public Message getMessage(long messageId) {
        try {
            return getMessageDAO().getMessage(messageId);
        } catch (GLWebPersistenceException e) {
            getLogger().error(e);
            return null;
        }
    }

    public long addMessage(Message message) {
        try {
            if (null == message.getCreationDate()) {
                message.setCreationDate(new Date());
                message.setModifiedDate(message.getCreationDate());
            }
            
            return getMessageDAO().addMessage(message);
        } catch (GLWebPersistenceException e) {
            getLogger().error(e);
            return 0;
        }
    }
    
    public boolean updateMessage(Message newMessage) {
        Message _message = null;
        
        try {
            _message = getMessage(newMessage.getId());
            
            PropertyUtils.copyProperties(_message, newMessage);
            
            _message.setModifiedDate(new Date());
            
            getMessageDAO().updateMessage(_message);
        } catch (GLWebPersistenceException e) {
            getLogger().error(e);
            return false;
        } catch (Exception e) {
            getLogger().error(e);
            return false;
        }
        
        return true;
    }
    
    public boolean deleteMessage(Message message) {
        try {
            getMessageDAO().deleteMessage(message);
        } catch (GLWebPersistenceException e) {
            getLogger().error(e);
            return false;
        }

        return true;
    }
    
    public Collection getMessages(Category category) {
        try {
            return getMessageDAO().getMessages(category);
        } catch (GLWebPersistenceException e) {
            getLogger().error(e);
            return null;
        }
    }

}
