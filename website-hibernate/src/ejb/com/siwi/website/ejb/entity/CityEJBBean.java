/*
 * $ Id: $
 * 
 */

package com.siwi.website.ejb.entity;

import java.util.Iterator;

import com.siwi.common.logger.Logger;
import com.siwi.common.logger.LoggerFactory;
import com.siwi.website.ejb.data.CityData;
import com.siwi.website.ejb.value.CityValue;

/**
 *  CityEJBBean
 *
 * @author  Paxson Yang
 * @created  2002/8/7
 * @version  $Revision: 1.1 $ $Date: 2003/10/28 02:56:05 $
 * 
 * @ejb:bean  type="CMP" cmp-version="2.x" name="City"
 *            jndi-name="ejb/entity/City" local-jndi-name="ejb/entity/CityLocal"
 *            view-type="both"
 * 
 * @ejb:transaction  type="Required"
 * 
 * @ejb:value-object  name="City" match="*" instantiation="eager"
 * 
 * @jboss:table-name  "city"
 * @jboss:create-table  "true"
 * @jboss:remove-table  "false"
 * @jboss:read-only  "false"
 * 
 * @struts:form  include-all="true"
 */
public abstract class CityEJBBean implements javax.ejb.EntityBean {
    private final static boolean DEBUG = true;

    private javax.ejb.EntityContext _entityContext;

    private Logger _logger;

    /**
     *  Sets the entityContext attribute of the CityEJBBean object
     *
     * @param  entityContext  The new entityContext value
     */
    public void setEntityContext(javax.ejb.EntityContext entityContext) {
        _entityContext = entityContext;
    }

    /**
     * @param  id  id of this city
     */
    public abstract void setId(java.lang.String id);

    /**
     * @param  languages  all languages of this city
     * 
     * @ejb:interface-method  view-type="local"
     */
    public abstract void setLanguages(java.util.Collection languages);

    /**
     * @param  name  name of this city
     * 
     * @ejb:interface-method  view-type="both"
     */
    public abstract void setName(java.lang.String name);

    /**
     *  Gets the logger attribute of the CityEJBBean object
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
     * @return  data object of this city
     * 
     * @ejb:interface-method  view-type="both"
     * @ejb:transaction  type="Supports"
     */
    public CityValue getCityValue() {
        return null;
    }

    /**
     * @return  data object of this city
     * @deprecated
     * @see  #getCityValue()
     * 
     * @ejb:interface-method  view-type="both"
     * @ejb:transaction  type="Supports"
     */
    public CityData getData() {
        return null;
    }

    /**
     * @return  id of this city
     * 
     * @ejb:persistent-field
     * @ejb:pk-field
     */
    public abstract java.lang.String getId();

    /**
     * @return  all languages of this city
     * 
     * @ejb:interface-method  view-type="local"
     * 
     * @ejb:transaction  type="Supports"
     * 
     * @ejb:relation  name="language-city"
     *                role-name="many-city-has-many-language"
     * 
     * @ejb:value-object  match="*" type="java.util.Collection"
     *                    relation="external" 
     *                    aggregate="com.siwi.website.ejb.value.LanguageValue"
     *                        aggregate-name="Language" 
     *                    members="com.siwi.website.ejb.entity.LanguageLocal"
     *                        members-name="Language"
     * 
     * @jboss:auto-key-fields
     * 
     * @jboss:relation-table  table-name="LANGUAGE_CITY" 
     *                        create-table="true"
     *                        remove-table="false" 
     *                        row-locking="false"
     */
    public abstract java.util.Collection getLanguages();

    /**
     * @return  name of this city
     * 
     * @ejb:interface-method  view-type="both"
     * 
     * @ejb:transaction  type="Supports"
     * 
     * @ejb:persistent-field
     */
    public abstract java.lang.String getName();

    /**
     * @return  value object of this city
     * 
     * @ejb:interface-method  view-type="both"
     */
    public CityValue getValue() {
        CityValue _cityValue = new CityValue();

        _cityValue.setId(getId());
        _cityValue.setName(getName());

        Iterator _iterator = getLanguages().iterator();

        while (_iterator.hasNext()) {
            _cityValue.addLanguage(
                    ((LanguageLocal) _iterator.next()).getLanguageValue());
        }

        return _cityValue;
    }

    /**
     *  Description of the Method
     */
    public void ejbActivate() { }

    /**
     *  Create city.
     *
     * @param  data  Description of the Parameter
     * @return  Description of the Return Value
     * @exception  javax.ejb.CreateException  Description of the Exception
     * @deprecated
     * @see  #ejbCreate(CityValue)
     * 
     * @ejb:create-method
     */
    public CityPK ejbCreate(CityData data) throws javax.ejb.CreateException {
        getLogger().debug("Executing CityEJBBean.ejbCreate()");
        getLogger().debug("    CityData = " + data);

        setId(data.getId());
        setName(data.getName());

        return null;
    }

    /**
     *  Create city.
     *
     * @param  value  Description of the Parameter
     * @return  Description of the Return Value
     * @exception  javax.ejb.CreateException  Description of the Exception
     * 
     * @ejb:create-method
     */
    public CityPK ejbCreate(CityValue value) throws javax.ejb.CreateException {
        getLogger().debug("Executing CityEJBBean.ejbCreate()");
        getLogger().debug("    CityValue = " + value);

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
     * @param  data  Description of the Parameter
     * @exception  javax.ejb.CreateException  Description of the Exception
     */
    public void ejbPostCreate(CityData data) throws javax.ejb.CreateException { }

    /**
     *  Description of the Method
     *
     * @param  value  Description of the Parameter
     * @exception  javax.ejb.CreateException  Description of the Exception
     */
    public void ejbPostCreate(CityValue value) throws javax.ejb.CreateException { }

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