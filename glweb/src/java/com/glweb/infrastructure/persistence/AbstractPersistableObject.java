/*
 *
 * $Id: AbstractPersistableObject.java,v 1.1 2003/05/10 11:41:13 paxson Exp $
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

package com.glweb.infrastructure.persistence;

/**
 * AbstractPersistableObject
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/05/10 11:41:13 $
 */
public class AbstractPersistableObject implements PersistableObject {
    
    protected static final String LINESEP = System.getProperty("line.separator");
    
    private long _id;

    /**
     * @see com.glweb.model.PersistableObject#getId()
     */
    public long getId() {
        return _id;
    }

    /**
     * @see com.glweb.model.PersistableObject#setId(long)
     */
    public void setId(long id) {
        _id = id;
    }
    
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuffer _buffer = new StringBuffer();

        _buffer.append(super.toString());
        _buffer.append(LINESEP);
        _buffer.append("    id = ");
        _buffer.append(getId());
        
        return _buffer.toString();
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object object) {
        if (object instanceof PersistableObject) {
            if (hashCode() == object.hashCode()) {
                return true;
            } else {
                if (getId() == ((PersistableObject) object).getId()) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

}
