/*
 *
 * $Id: Message.java,v 1.1 2003/05/10 11:41:13 paxson Exp $
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
 * Message
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/05/10 11:41:13 $
 */
public class Message extends AbstractPersistableObject {
    private User _poster;
    private Date _creationDate;
    private Date _modifiedDate;
    private Category _category;
    private String _subject;
    private String _message;
    private Set _parentMessages;
    private Set _replyMessages;

    public Message() {
    }

    public User getPoster() {
        return _poster;
    }

    public void setPoster(User poster) {
        _poster = poster;
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

    public Category getCategory() {
        return _category;
    }

    public void setCategory(Category category) {
        _category = category;
    }

    public String getSubject() {
        return _subject;
    }

    public void setSubject(String subject) {
        _subject = subject;
    }

    public String getMessage() {
        return _message;
    }

    public void setMessage(String message) {
        _message = message;
    }

    public boolean addParentMessage(Message parentMessage) {
        if (null == getParentMessages()) {
            setParentMessages(new HashSet(1));
        }
        return getParentMessages().add(parentMessage);
    }

    public Set getParentMessages() {
        return _parentMessages;
    }

    public boolean removeParentMessage(Message parentMessage) {
        if (null != getParentMessages()) {
            return getParentMessages().remove(parentMessage);
        } else {
            return false;
        }
    }

    public void setParentMessages(Set parentMessages) {
        _parentMessages = parentMessages;
    }

    public boolean addReplyMessage(Message replyMessage) {
        if (null == getReplyMessages()) {
            setReplyMessages(new HashSet(1));
        }
        
        return getReplyMessages().add(replyMessage);
    }

    public Set getReplyMessages() {
        return _replyMessages;
    }

    public boolean removeReplyMessage(Message replyMessage) {
        if (null != getReplyMessages()) {
            return getReplyMessages().remove(replyMessage);
        } else {
            return false;
        }
    }

    public void setReplyMessages(Set replyMessage) {
        _replyMessages = replyMessage;
    }

}