/*
 * $Id: LanguageCode.java,v 1.1 2003/10/29 08:27:23 paxson Exp $
 */

package com.siwi.website.ejb.model;

/**
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/10/29 08:27:23 $
 */
public class LanguageCode extends BaseModel {
    
    private String _name;
    
    private Language _language;

    public Language getLanguage() {
        return _language;
    }

    public void setLanguage(Language language) {
        _language = language;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

}
