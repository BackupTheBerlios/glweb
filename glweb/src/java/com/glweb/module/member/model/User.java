/*
 *
 * $Id: User.java,v 1.1 2003/05/10 11:41:13 paxson Exp $
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

package com.glweb.module.member.model;

import com.glweb.infrastructure.persistence.AbstractPersistableObject;

/**
 * User
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/05/10 11:41:13 $
 */
public class User extends AbstractPersistableObject {

    private String _name;
    
    public User() {
    }

    /**
     * Returns the name.
     * 
     * @return String
     */
    public String getName() {
        return _name;
    }

    /**
     * Sets the name.
     * 
     * @param name The name to set
     */
    public void setName(String name) {
        _name = name;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuffer _buffer = new StringBuffer(50);
        
        _buffer.append(LINESEP);
        _buffer.append(super.toString());
        _buffer.append(LINESEP);
        _buffer.append("    name = ");
        _buffer.append(getName());
        
        return _buffer.toString();
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object object) {
        if (true == super.equals(object)) {
            if (object instanceof User) {
                if (getName().equals(((User) object).getName())) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}