/*
 * $Id: CommonEJBBean.java,v 1.2 2003/10/29 08:27:23 paxson Exp $
 * 
 */

package com.siwi.website.ejb.session;

import java.util.Collection;

import com.siwi.common.logger.Logger;
import com.siwi.common.logger.LoggerFactory;
import com.siwi.website.ejb.model.City;
import com.siwi.website.ejb.model.Country;
import com.siwi.website.ejb.model.Language;

/**
 *  CommonEJBBean
 *
 * @author  Paxson Yang
 * @created  2002/8/7
 * @version  $Revision: 1.2 $ $Date: 2003/10/29 08:27:23 $
 * 
 * @ejb:bean  
 *     name="CommonEJB" type="Stateless"
 *     jndi-name="ejb/session/CommonEJB"
 * 
 * @ejb:transaction  type="Required"
 * 
 * @ejb:transaction-type  type="Container"
 */
public abstract class CommonEJBBean implements javax.ejb.SessionBean {
    private final static boolean DEBUG = true;

    private Logger _logger;

    private Logger getLogger() {
        if (null == _logger) {
            _logger = LoggerFactory.getInstance().getLogger(
                    getClass().getName());
            _logger.setDebug(DEBUG);
        }

        return _logger;
    }

    /**
     * @ejb:interface-method
     */
    public City createCity(City value, String countryId) {
        /*
        getLogger().debug(
                "Executing CommonEJBBean.createCity(CityValue, String)");
        getLogger().debug("    CityValue = " + value);
        getLogger().debug("    CountryId = " + countryId);
        getLogger().debug("    Languages count = " +
                value.getLanguages().length);

        CityLocalHome _cityLocalHome = null;
        CityLocal _cityLocal = null;

        try {
            _cityLocalHome = CityUtil.getLocalHome();
            _cityLocal = _cityLocalHome.create(value);

            CountryPK _countryPK = new CountryPK();
            _countryPK.setId(countryId);

            CountryLocalHome _countryLocalHome =
                    CountryUtil.getLocalHome();
            CountryLocal _countryLocal =
                    _countryLocalHome.findByPrimaryKey(_countryPK);

            _countryLocal.getCities().add(_cityLocal);

            LanguageValue[] _languages = value.getLanguages();
            LanguageLocalHome _languageLocalHome =
                    LanguageUtil.getLocalHome();
            for (int i = 0; i < _languages.length; i++) {
                LanguageLocal _languageLocal =
                        _languageLocalHome.findByPrimaryKey(
                        ((LanguageValue) _languages[i]).getPrimaryKey());
                _cityLocal.getLanguages().add(_languageLocal);
            }
        } catch (NamingException ne) {
            throw new EJBException(ne);
        } catch (CreateException ce) {
            throw new EJBException(ce);
        } catch (Exception e) {
            throw new EJBException(e);
        }

        return _cityLocal.getCityValue();
        */
        
        return null;
    }

    /**
     * @ejb:interface-method
     */
    public Country createCountry(Country value) {
        /*
        getLogger().debug(
                "Executing CommonEJBBean.createCountry(CountryValue)");
        getLogger().debug("    CountryValue = " + value);

        CountryLocalHome _ejbLocalHome = null;
        CountryLocal _ejbLocal = null;

        try {
            _ejbLocalHome = CountryUtil.getLocalHome();
            _ejbLocal = _ejbLocalHome.create(value);
        } catch (NamingException ne) {
            throw new EJBException(ne);
        } catch (CreateException ce) {
            throw new EJBException(ce);
        } catch (Exception e) {
            throw new EJBException(e);
        }

        return _ejbLocal.getCountryValue();
        */
        
        return null;
    }

    /**
     * @ejb:interface-method
     */
    public Language createLanguage(Language value) {
        /*
        getLogger().debug(
                "Executing CommonEJBBean.createLanguage(LanguageValue)");
        getLogger().debug("    LanguageValue = " + value);

        LanguageLocalHome _languageLocalHome = null;
        LanguageLocal _languageLocal = null;

        try {
            _languageLocalHome = LanguageUtil.getLocalHome();
            _languageLocal = _languageLocalHome.create(value);
        } catch (NamingException ne) {
            throw new EJBException(ne);
        } catch (CreateException ce) {
            throw new EJBException(ce);
        } catch (Exception e) {
            throw new EJBException(e);
        }

        return _languageLocal.getLanguageValue();
        */
        
        return null;
    }

    /**
     * @ejb:interface-method
     */
    public void createLanguageCode(String name) { }

    /**
     * @ejb:interface-method
     */
    public City findCity(long id) {
        /*
        getLogger().debug("Executing CommonEJBBean.findCity(CityPK)");
        getLogger().debug("    CityPK = " + pk);

        CityLocalHome _ejbLocalHome = null;
        CityLocal _ejbLocal = null;

        try {
            _ejbLocalHome = CityUtil.getLocalHome();
            _ejbLocal = _ejbLocalHome.findByPrimaryKey(pk);
            getLogger().debug("    City = " + _ejbLocal.getCityValue());
            getLogger().debug("    Language count = " +
                    _ejbLocal.getLanguages().size());
        } catch (NamingException ne) {
            throw new EJBException(ne);
        } catch (FinderException fe) {
            throw new EJBException(fe);
        } catch (Exception e) {
            throw new EJBException(e);
        }

        return _ejbLocal.getCityValue();
        */
        
        return null;
    }

    /**
     * @ejb:interface-method
     */
    public Country findCountry(long id) {
        /*
        getLogger().debug(
                "Executing CommonEJBBean.findCountry(CountryPK)");
        getLogger().debug("    CountryPK = " + pk);

        CountryLocalHome _ejbLocalHome = null;
        CountryLocal _ejbLocal = null;

        try {
            _ejbLocalHome = CountryUtil.getLocalHome();
            _ejbLocal = _ejbLocalHome.findByPrimaryKey(pk);
            getLogger().debug("    City count = " +
                    _ejbLocal.getCities().size());
        } catch (NamingException ne) {
            throw new EJBException(ne);
        } catch (FinderException fe) {
            throw new EJBException(fe);
        } catch (Exception e) {
            throw new EJBException(e);
        }

        return _ejbLocal.getValue();
        */
        
        return null;
    }

    /**
     * @ejb:interface-method
     */
    public Collection findLanguage() {
        /*
        getLogger().debug("Executing CommonEJBBean.findLanguage()");

        Collection _languages = new ArrayList();
        LanguageLocalHome _ejbLocalHome = null;

        try {
            _ejbLocalHome = LanguageUtil.getLocalHome();
            Iterator _iterator = _ejbLocalHome.findAll().iterator();

            while (_iterator.hasNext()) {
                _languages.add(
                        ((LanguageLocal) _iterator.next()).getLanguageValue());
            }

            getLogger().debug("    Language count = " +
                    _languages.size());
        } catch (NamingException ne) {
            throw new EJBException(ne);
        } catch (FinderException fe) {
            throw new EJBException(fe);
        } catch (Exception e) {
            throw new EJBException(e);
        }

        return _languages;
        */
        
        return null;
    }

    /**
     * @ejb:interface-method
     */
    public Language findLanguage(long id) {
        /*
        getLogger().debug(
                "Executing CommonEJBBean.findLanguage(LanguagePK)");
        getLogger().debug("    LanguagePK = " + pk);

        LanguageLocal _ejbLocal = null;

        try {
            LanguageLocalHome _ejbLocalHome = LanguageUtil.getLocalHome();
            _ejbLocal = _ejbLocalHome.findByPrimaryKey(pk);

            getLogger().debug("    Language = " +
                    _ejbLocal.getValue());
            getLogger().debug("    City count = " +
                    _ejbLocal.getValue().getCitys().length);
        } catch (NamingException ne) {
            throw new EJBException(ne);
        } catch (FinderException fe) {
            throw new EJBException(fe);
        } catch (Exception e) {
            throw new EJBException(e);
        }

        return _ejbLocal.getLanguageValue();
        */
        
        return null;
    }

}