/*
 *
 * $Id: MessageDAOImpl.java,v 1.1 2003/05/10 11:41:13 paxson Exp $
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

package com.glweb.module.forum.provider.hibernate.dao;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.ObjectNotFoundException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.glweb.infrastructure.persistence.GLWebPersistenceException;
import com.glweb.infrastructure.persistence.hibernate.HibernateUtil;
import com.glweb.module.forum.dao.MessageDAO;
import com.glweb.module.forum.model.Category;
import com.glweb.module.forum.model.Message;

public class MessageDAOImpl implements MessageDAO {
    
    private static final String MESSAGES_BY_CATEGORY_ID = 
            "forum.model.Message.findMessagesByCategoryId";
    
    private static Log log = LogFactory.getLog(MessageDAOImpl.class.getName());

    public Message getMessage(long messageId) throws GLWebPersistenceException {
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            
            return (Message) _session.load(Message.class, new Long(messageId));
        } catch (ObjectNotFoundException onfe) {
            return null;
        } catch (HibernateException he) {
            throw new GLWebPersistenceException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }
    }

    public long addMessage(Message message) throws GLWebPersistenceException {
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            
            return ((Long) _session.save(message)).longValue();
        } catch (HibernateException he) {
            throw new GLWebPersistenceException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }
    }

    public void updateMessage(Message message) throws GLWebPersistenceException {
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            _session.update(message);
        } catch (HibernateException he) {
            throw new GLWebPersistenceException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }
    }

    public void deleteMessage(Message message) throws GLWebPersistenceException {
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();
            _session.delete(message);
        } catch (HibernateException he) {
            throw new GLWebPersistenceException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }
    }
    
    public Collection getMessages(Category category) throws GLWebPersistenceException {
        Session _session = null;
        Query _query = null;

        try {
            _session = HibernateUtil.retrieveDefaultSession();

            _query = _session.getNamedQuery(MESSAGES_BY_CATEGORY_ID);
            _query.setLong("categoryId", category.getId());
            
            return _query.list();
        } catch (HibernateException he) {
            throw new GLWebPersistenceException(he);
        } finally {
            HibernateUtil.commitCloseSession(_session);
        }
    }
    
}
