/*
 * $ Id: $
 * 
 */

package com.siwi.website.ejb.entity;

import com.siwi.common.logger.Logger;
import com.siwi.common.logger.LoggerFactory;
import com.siwi.website.ejb.data.CountryData;
import com.siwi.website.ejb.value.CountryValue;

/**
 *  CountryEJBBean
 *
 * @author  Paxson Yang
 * @created  2002/8/7
 * @version  $Revision: 1.1 $ $Date: 2003/10/28 02:56:05 $
 * 
 * @ejb:bean  type="CMP" cmp-version="2.x" name="Country"
 *            jndi-name="ejb/entity/Country" 
 *            local-jndi-name="ejb/entity/CountryLocal"
 *            view-type="both"
 * 
 * @ejb:value-object  name="Country" match="*" instantiation="eager"
 * 
 * @ejb.env-entry  name="dao/countryDAO"
 *                 value="com.siwi.wensite.ejb.dao.impl.JBossCountryDAO"
 *                 type="java.lang.String"
 * 
 * @jboss:table-name  "country"
 * @jboss:create-table  "true"
 * @jboss:remove-table  "false"
 * @jboss:read-only  "false"
 * 
 * @struts:form  include-all="true"
 */
public abstract class CountryEJBBean implements javax.ejb.EntityBean {
    private final static boolean DEBUG = true;
    
    private javax.ejb.EntityContext _entityContext;

    private Logger _logger;

    /**
     * @param  cities  all cities of this country
     * 
     * @ejb:interface-method  view-type="local"
     */
    public abstract void setCities(java.util.Collection cities);

    /**
     *  Sets the entityContext attribute of the CountryEJBBean object
     *
     * @param  entityContext  The new entityContext value
     */
    public void setEntityContext(javax.ejb.EntityContext entityContext) {
        _entityContext = entityContext;
    }

    /**
     * @param  id  id of this country
     */
    public abstract void setId(java.lang.String id);

    /**
     * @param  name  name of this country
     * 
     * @ejb:interface-method    view-type="both"
     */
    public abstract void setName(java.lang.String name);

    /**
     *  Gets the logger attribute of the CountryEJBBean object
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
     * @return  all cities of this country
     * 
     * @ejb:interface-method  view-type="local"
     * 
     * @ejb:relation  name="country-city"
     *                role-name="one-country-has-many-cities"
     *                target-role-name="one-city-belongs-to-one-country" target-ejb="City"
     *                target-multiple="no"
     * 
     * @ejb:value-object  match="*" type="java.util.Collection"
     *                    relation="external" 
     *                    aggregate="com.siwi.website.ejb.value.CityValue"
     *                        aggregate-name="City" 
     *                    members="com.siwi.website.ejb.entity.CityLocal"
     *                        members-name="City"
     * 
     * @jboss:target-relation  related-pk-field="id" 
     *                         fk-column="country_id_fk"
     */
    public abstract java.util.Collection getCities();

    /**
     * @return  value object of this country
     * 
     * @ejb:interface-method  view-type="both"
     */
    public CountryValue getCountryValue() {
        return null;
    }

    /**
     * @return  data object of this country
     * @deprecated
     * @see  #getCountryValue()
     * 
     * @ejb:interface-method  view-type="both"
     */
    public CountryData getData() {
        return null;
    }

    /**
     * @return  id of this country
     * 
     * @ejb:persistent-field
     * 
     * @ejb:pk-field
     */
    public abstract java.lang.String getId();


    /**
     * @return  name of this country
     * 
     * @ejb:interface-method  view-type="both"
     * 
     * @ejb:persistent-field
     */
    public abstract java.lang.String getName();

    /**
     * @return  value object of this country
     * 
     * @ejb:interface-method  view-type="both"
     */
    public CountryValue getValue() {
        CountryValue _countryValue = new CountryValue();

        _countryValue.setId(getId());
        _countryValue.setName(getName());
        java.util.Iterator _iterator = getCities().iterator();

        while (_iterator.hasNext()) {
            _countryValue.addCity(
                    ((CityLocal) _iterator.next()).getCityValue());
            getLogger().debug("Add City");
        }

        getLogger().debug("    City count = " +
                _countryValue.getCitys().length);

        return _countryValue;
    }

    /**
     *  Description of the Method
     */
    public void ejbActivate() { }

    /**
     *  Create country.
     *
     * @param  data  Description of the Parameter
     * @return  Description of the Return Value
     * @exception  javax.ejb.CreateException  Description of the Exception
     * @deprecated
     * @see  #ejbCreate(CountryValue)
     * 
     * @ejb:create-method
     */
    public CountryPK ejbCreate(CountryData data) throws javax.ejb.CreateException {
        getLogger().debug("Executing CountryEJBBean.ejbCreate()");
        getLogger().debug("    CountryData = " + data);

        setId(data.getId());
        setName(data.getName());

        return null;
    }

    /**
     *  Create country.
     *
     * @param  value  Description of the Parameter
     * @return  Description of the Return Value
     * @exception  javax.ejb.CreateException  Description of the Exception
     * 
     * @ejb:create-method
     */
    public CountryPK ejbCreate(CountryValue value) throws javax.ejb.CreateException {
        getLogger().debug("Executing CountryEJBBean.ejbCreate()");
        getLogger().debug("    CountryValue = " + value);

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
    public void ejbPostCreate(CountryData data) throws javax.ejb.CreateException { }

    /**
     *  Description of the Method
     *
     * @param  value  Description of the Parameter
     * @exception  javax.ejb.CreateException  Description of the Exception
     */
    public void ejbPostCreate(CountryValue value) throws javax.ejb.CreateException { }

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