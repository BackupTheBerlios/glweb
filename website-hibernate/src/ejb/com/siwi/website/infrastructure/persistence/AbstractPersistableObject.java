/*
 * $Id: AbstractPersistableObject.java,v 1.1 2003/10/29 08:27:23 paxson Exp $
 */

package com.siwi.website.infrastructure.persistence;

/**
 * AbstractPersistableObject
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/10/29 08:27:23 $
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
