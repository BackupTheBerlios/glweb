/*
 * $Id: PersistableObject.java,v 1.1 2003/10/29 08:27:23 paxson Exp $
 */

package com.siwi.website.infrastructure.persistence;

/**
 * PersistableObject
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/10/29 08:27:23 $
 */
public interface PersistableObject {
    
    public long getId();

    public void setId(long id);
}
