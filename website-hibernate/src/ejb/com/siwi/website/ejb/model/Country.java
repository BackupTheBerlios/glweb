/*
 * $Id: Country.java,v 1.1 2003/10/29 08:27:23 paxson Exp $
 */

package com.siwi.website.ejb.model;

import java.util.Collection;

/**
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/10/29 08:27:23 $
 */
public class Country extends BaseModel {

    private String _name;
    
    private Collection _cities;

    public Collection getCities() {
        return _cities;
    }

    public void setCities(Collection cities) {
        _cities = cities;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

}
