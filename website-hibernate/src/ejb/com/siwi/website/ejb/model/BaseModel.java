/*
 * $Id: BaseModel.java,v 1.1 2003/10/29 08:27:23 paxson Exp $
 */

package com.siwi.website.ejb.model;

/**
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/10/29 08:27:23 $
 */
public abstract class BaseModel {
    
    private long _id;

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

}
