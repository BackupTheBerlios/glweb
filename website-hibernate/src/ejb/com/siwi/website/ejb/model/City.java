/*
 * $Id: City.java,v 1.1 2003/10/29 08:27:23 paxson Exp $
 */

package com.siwi.website.ejb.model;

import java.util.Collection;

/**
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/10/29 08:27:23 $
 */
public class City extends BaseModel {
    
    private String _name;
    
    private Collection _languages;

    public Collection getLanguages() {
        return _languages;
    }

    public void setLanguages(Collection languages) {
        _languages = languages;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

}
