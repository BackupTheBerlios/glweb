/*
 * $Id: Language.java,v 1.1 2003/10/29 08:27:23 paxson Exp $
 */

package com.siwi.website.ejb.model;

import java.util.Collection;

/**
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/10/29 08:27:23 $
 */
public class Language extends BaseModel {
    
    private String _name;
    
    private LanguageCode _languageCode;
    
    private Collection _cities;

    public Collection getCities() {
        return _cities;
    }

    public void setCities(Collection cities) {
        _cities = cities;
    }

    public LanguageCode getLanguageCode() {
        return _languageCode;
    }

    public void setLanguageCode(LanguageCode languageCode) {
        _languageCode = languageCode;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

}
