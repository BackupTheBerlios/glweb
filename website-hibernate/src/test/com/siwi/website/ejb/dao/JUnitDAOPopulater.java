/*
 * $Id: JUnitDAOPopulater.java,v 1.1 2003/10/30 10:28:38 paxson Exp $
 * 
 */

package com.siwi.website.ejb.dao;

import com.siwi.website.ejb.model.Country;

/**
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/10/30 10:28:38 $
 */
public class JUnitDAOPopulater {
    
    public static Country buildCountry() {
        Country _value = new Country();
        
        _value.setName("TEST");
        
        return _value;
    }

}
