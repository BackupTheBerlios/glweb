/*
 * $ Id: $
 * 
 */

package com.siwi.website.ejb.entity;

import com.siwi.common.logger.Logger;
import com.siwi.common.logger.LoggerFactory;

import com.siwi.website.ejb.data.LanguageData;
import com.siwi.website.ejb.value.LanguageValue;

/**
 *  LanguageEJBBean
 *
 * @author  Paxson Yang
 * @created  2002/8/7
 * @version  $Revision: 1.1 $ $Date: 2003/10/28 02:56:05 $
 * 
 * @ejb:bean  type="CMP" cmp-version="2.x" name="Language"
 *            jndi-name="ejb/entity/Language" local-jndi-name="ejb/entity/LanguageLocal"
 *            view-type="both"
 * 
 * @ejb:transaction  type="Required"
 * 
 * @ejb:finder  signature="java.util.Collection findAll()"
 *              unchecked="true" 
 *              query="SELECT DISTINCT OBJECT(o) FROM Language o WHERE o.id IS NOT NULL" 
 *              result-type-mapping="Local"
 * 
 * @ejb:value-object  name="Language" match="*" instantiation="eager"
 * 
 * @jboss:table-name  "language"
 * @jboss:create-table  "true"
 * @jboss:remove-table  "false"
 * @jboss:read-only  "false"
 * 
 * @struts:form  include-all="true"
 */
public abstract class LanguageEJBBean implements javax.ejb.EntityBean {
    private final static boolean DEBUG = true;
    
    private javax.ejb.EntityContext _entityContext;

    private Logger _logger;

    /**
     * @param  cities  all cities of this language
     * 
     * @ejb:interface-method  view-type="local"
     */
    public abstract void setCities(java.util.Collection cities);

    /**
     *  Sets the entityContext attribute of the LanguageEJBBean object
     *
     * @param  entityContext  The new entityContext value
     */
    public void setEntityContext(javax.ejb.EntityContext entityContext) {
        _entityContext = entityContext;
    }

    /**
     * @param  id  id of this language
     */
    public abstract void setId(java.lang.String id);

    /**
     * @param  languageCode  language code of this language
     * 
     * @ejb:interface-method  view-type="local"
     */
    public abstract void setLanguageCode(LanguageCodeLocal languageCode);

    /**
     * @param  name  name of this language
     * 
     * @ejb:interface-method  view-type="both"
     */
    public abstract void setName(java.lang.String name);

    /**
     *  Gets the logger attribute of the LanguageEJBBean object
     *
     * @return  The logger value
     */
    private Logger getLogger() {
        if (null == _logger) {
            _logger = LoggerFactory.getInstance().getLogger(
                    getClass().getName());
            _logger.setDebug(DEBUG);
        }

        return _logger;
    }

    /**
     * @return  all cities of this language
     * 
     * @ejb:interface-method  view-type="local"
     * 
     * @ejb:relation  name="language-city"
     *                role-name="many-language-has-many-city"
     * 
     * @ejb:value-object  match="*" 
     *                    type="java.util.Collection"
     *                    relation="external" 
     *                    aggregate="com.siwi.website.ejb.value.CityValue"
     *                        aggregate-name="City" 
     *                    members="com.siwi.website.ejb.entity.CityLocal"
     *                        members-name="City"
     * 
     * @jboss:auto-key-fields
     */
    public abstract java.util.Collection getCities();

    /**
     * @return  data object of this language
     * @deprecated
     * @see  #getLanguageValue()
     * 
     * @ejb:interface-method  view-type="both"
     */
    public LanguageData getData() {
        return null;
    }

    /**
     * @return  id of this language
     * 
     * @ejb:persistent-field
     * 
     * @ejb:pk-field
     */
    public abstract java.lang.String getId();

    /**
     * @return  language code of this language
     * 
     * @ejb:interface-method  view-type="local"
     * 
     * @ejb:relation  name="language-languagecode"
     *                role-name="one-language-has-one-languagecode"
     */
    public abstract LanguageCodeLocal getLanguageCode();

    /**
     * @return  value object of this language
     * 
     * @ejb:interface-method  view-type="both"
     */
    public LanguageValue getLanguageValue() {
        return null;
    }

    /**
     * @return  name of this language
     * 
     * @ejb:interface-method  view-type="both"
     * 
     * @ejb:persistent-field
     */
    public abstract java.lang.String getName();

    /**
     * @return  value object of this language
     * 
     * @ejb:interface-method  view-type="both"
     */
    public LanguageValue getValue() {
        getLogger().debug("Executing LanguageEJBBean.getValue()");

        LanguageValue _languageValue = new LanguageValue();

        _languageValue.setId(getId());
        _languageValue.setName(getName());

        getLogger().debug("    City count[LanguageEJBBean] = " +
                getCities().size());

        java.util.Iterator _iterator = getCities().iterator();

        while (_iterator.hasNext()) {
            _languageValue.addCity(
                    ((CityLocal) _iterator.next()).getCityValue());
            getLogger().debug("    Add City");
        }

        getLogger().debug("    City count[LanguageValue] = " +
                _languageValue.getCitys().length);

        return _languageValue;
    }

    /**
     *  Description of the Method
     */
    public void ejbActivate() { }

    /**
     *  Create language.
     *
     * @param  value  Description of the Parameter
     * @return  Description of the Return Value
     * @exception  javax.ejb.CreateException  Description of the Exception
     * 
     * @ejb:create-method
     */
    public LanguagePK ejbCreate(LanguageValue value) throws javax.ejb.CreateException {
        getLogger().debug(
                "Executing LanguageEJBBean.ejbCreate(LanguageValue)");
        getLogger().debug("    LanguageValue = " + value);

        setId(value.getId());
        setName(value.getName());

        return null;
    }

    /**
     *  Description of the Method
     */
    public void ejbLoad() { }

    /**
     *  Description of the Method
     */
    public void ejbPassivate() { }

    /**
     *  Description of the Method
     *
     * @param  value  Description of the Parameter
     * @exception  javax.ejb.CreateException  Description of the Exception
     */
    public void ejbPostCreate(LanguageValue value) throws javax.ejb.CreateException { }

    /**
     *  Description of the Method
     *
     * @exception  javax.ejb.RemoveException  Description of the Exception
     */
    public void ejbRemove() throws javax.ejb.RemoveException { }

    /**
     *  Description of the Method
     */
    public void ejbStore() { }

    /**
     *  Description of the Method
     */
    public void unsetEntityContext() {
        setEntityContext(null);
    }

}