/*
 * $ Id: $
 * 
 */

package com.siwi.website.action;

import java.rmi.ServerException;
import java.util.Collection;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionForward;

import com.siwi.common.web.ActionType;
import com.siwi.common.web.CommonAction;
import com.siwi.common.web.Handle;
import com.siwi.common.web.HandleCreateException;
import com.siwi.common.web.HandleFactory;
import com.siwi.common.web.HandlePerformException;
import com.siwi.website.ejb.dao.CityDAO;
import com.siwi.website.ejb.dao.CommonDAOFactory;
import com.siwi.website.ejb.dao.CountryDAO;
import com.siwi.website.ejb.entity.CityPK;
import com.siwi.website.ejb.session.CommonEJB;
import com.siwi.website.ejb.session.CommonEJBHome;
import com.siwi.website.ejb.util.CommonEJBUtil;
import com.siwi.website.ejb.value.CityValue;
import com.siwi.website.ejb.value.LanguageValue;
import com.siwi.website.form.CityForm;

/**
 *  CityAction
 *
 * @author  Paxson Yang
 * @created  2002/8/7
 * @version  $Revision: 1.1 $ $Date: 2003/10/28 02:56:05 $
 * 
 * @web:ejb-ref  name="CommonEJB" 
 *               type="Session"
 *               home="com.siwi.website.ejb.session.CommonEJBHome"
 *               remote="com.siwi.website.ejb.session.CommonEJB" 
 *               link="CommonEJB"
 *               description="A test reference to the Common EJB"
 * 
 * @struts:action  path="/common/cityAction" 
 *                 name="cityForm"
 *                 scope="request" 
 *                 validate="true" 
 *                 input="/common/city.jsp"
 * 
 * @struts:action-forward  name="action/queryCity"
 *                         path="/common/cityAction.do?action=query"
 * 
 * @struts:action-forward  name="view/cityList" 
 *                         path="/common/cityList.jsp"
 * 
 * @struts:action-forward  name="view/cityDetail"
 *                         path="/common/cityDetail.jsp"
 * 
 * @jboss:ejb-ref-jndi  ref-name="CommonEJB"
 *                      jndi-name="ejb/session/CommonEJB"
 */
public class CityAction extends CommonAction {
    private final static boolean DEBUG = true;
    
    private final static String FORWARD_ACTION_QUERY = "action/queryCity";
    
    private final static String FORWARD_VIEW_DETAIL = "view/cityDetail";
    
    private final static String FORWARD_VIEW_LIST = "view/cityList";
    
    private final static String PARAM_CITY = "city";
    
    private final static String PARAM_CITY_LIST = "cityList";
    
    private final static String PARAM_CITY_LIST_SIZE = "cityListSize";
    
    private final static String PARAM_COUNTRY_LIST = "countryList";
    
    private final static String PARAM_LANGUAGE_LIST = "languageList";
    
    private final static String PARAM_LANGUAGE_LIST_SIZE = "languageListSize";
    
    private static HandleFactory _handleFactory;

    /**
     *  Gets the handleFactory attribute of the CityAction object
     *
     * @return  The handleFactory value
     */
    protected HandleFactory getHandleFactory() {
        if (null == _handleFactory) {
            _handleFactory = new CityHandleFactory();
        }
        return _handleFactory;
    }

    /**
     *  CityAddHandle
     *
     * @author  paxson.yang
     * @created  2002/9/5
     */
    class CityAddHandle implements Handle {
        /**
         *  Description of the Method
         *
         * @return  Description of the Return Value
         * @exception  HandlePerformException  Description of the Exception
         */
        public ActionForward perform() throws HandlePerformException {
            getLogger().debug("CountryId = '" + 
                    ((CityForm) getActionForm()).getCountry() + "'");
            getLogger().debug("CityId = '" + 
                    ((CityForm) getActionForm()).getId() + "'");
            getLogger().debug("CityName = '" + 
                    ((CityForm) getActionForm()).getName() + "'");
            
            if (null != ((CityForm) getActionForm()).getLanguages()) {
                getLogger().debug("Languages count = '" + 
                        ((CityForm) getActionForm()).getLanguages().length + "'");
            }
            
            try {
                CommonEJBHome _ejbHome = CommonEJBUtil.getHome();
                CommonEJB _ejb = _ejbHome.create();
                CityValue _cityValue = new CityValue();

                PropertyUtils.copyProperties(
                        _cityValue, (CityForm) getActionForm());

                if (null != ((CityForm) getActionForm()).getLanguages()) {
                    String[] _languages =
                            ((CityForm) getActionForm()).getLanguages();

                    for (int i = 0; i < _languages.length; i++) {
                        LanguageValue _languageValue = new LanguageValue();
                        _languageValue.setId(_languages[i]);
                        _cityValue.addLanguage(_languageValue);
                    }
                }

                CityValue _city = _ejb.createCity(
                        _cityValue, ((CityForm) getActionForm()).getCountry());
                getLogger().debug("Create City successful");
            } catch (ServerException se) {
                getLogger().debug(
                        "ServerException Detail : " + se.detail.toString());
                if (isEJBDuplicateKeyException(se)) {
                    getActionErrors().add(
                            "duplicate", new ActionError("error.cityId.unique"));
                }
            } catch (Exception e) {
                throw new HandlePerformException(e);
            }
            if (!getActionErrors().empty()) {
                saveErrors(getRequest(), getActionErrors());
                saveToken(getRequest());
                
                return new ActionForward(getActionMapping().getInput());
            } else {
                return getActionMapping().findForward(FORWARD_ACTION_QUERY);
            }
        }
    }

    /**
     *  CityHandleFactory
     *
     * @author  paxson.yang
     * @created  2002/9/5
     */
    class CityHandleFactory implements HandleFactory {
        /**
         *  Gets the handle attribute of the CityHandleFactory object
         *
         * @param  action  Description of the Parameter
         * @return  The handle value
         * @exception  HandleCreateException  Description of the Exception
         */
        public Handle getHandle(ActionType action) throws HandleCreateException {
            switch (action.getType()) {
                
                case ActionType.NULL_TYPE:
                    return new CityInputHandle();
                
                case ActionType.INPUT_TYPE:
                    return new CityInputHandle();
                
                case ActionType.ADD_TYPE:
                    return new CityAddHandle();
                
                case ActionType.QUERY_TYPE:
                    return new CityQueryHandle();
                
                default:
                    return new CityInputHandle();
            }
        }
    }

    /**
     *  CityInputHandle
     *
     * @author  paxson.yang
     * @created  2002/9/5
     */
    class CityInputHandle implements Handle {
        /**
         *  Description of the Method
         *
         * @return  Description of the Return Value
         * @exception  HandlePerformException  Description of the Exception
         */
        public ActionForward perform() throws HandlePerformException {
            CountryDAO _countryDAO = CommonDAOFactory.getCountryDAO();
            Collection _countries = _countryDAO.findAll();
            getLogger().debug("CountryList size = " + _countries.size());
            Collection _languages = null;
            
            try {
                CommonEJBHome _commonEJBHome = CommonEJBUtil.getHome();
                CommonEJB _commonEJB = _commonEJBHome.create();
                _languages = _commonEJB.findLanguage();
            } catch (ServerException se) {
                getLogger().debug(
                        "ServerException Detail : " + se.detail.toString());
            } catch (Exception e) {
                throw new HandlePerformException(e);
            }

            setAttribute(PARAM_COUNTRY_LIST, _countries);
            setAttribute(PARAM_LANGUAGE_LIST, _languages);
            
            if (0 == _countries.size()) {
                getActionErrors().add(
                        "message",
                        new ActionError("error.countryList.empty"));
            }

            if (!getActionErrors().empty()) {
                saveErrors(getRequest(), getActionErrors());
                saveToken(getRequest());
            }

            return new ActionForward(getActionMapping().getInput());
        }
    }

    /**
     *  CityQueryHandle
     *
     * @author  paxson.yang
     * @created  2002/9/5
     */
    class CityQueryHandle implements Handle {
        /**
         *  Description of the Method
         *
         * @param  id  Description of the Parameter
         * @return  Description of the Return Value
         */
        private ActionForward CityDetailHandle(String id) {
            CityValue _cityValue = null;
            try {
                CommonEJBHome _commonEJBHome = CommonEJBUtil.getHome();
                CommonEJB _commonEJB = _commonEJBHome.create();
                CityPK _cityPK = new CityPK();
                _cityPK.setId(id);
                _cityValue = _commonEJB.findCity(_cityPK);
                
                getLogger().debug("City = " + _cityValue);
            } catch (ServerException se) {
                getLogger().debug(
                        "ServerException Detail : " + se.detail.toString());
            } catch (Exception e) {
                throw new HandlePerformException(e);
            }
            
            setAttribute(PARAM_CITY, _cityValue);
            setAttribute(
                    PARAM_LANGUAGE_LIST_SIZE,
                    new Integer(_cityValue.getLanguages().length));
            
            return getActionMapping().findForward(FORWARD_VIEW_DETAIL);
        }

        /**
         *  Description of the Method
         *
         * @return  Description of the Return Value
         */
        private ActionForward CityListHandle() {
            CityDAO _cityDAO = CommonDAOFactory.getCityDAO();
            Collection _collection = _cityDAO.findAll();
            getLogger().debug("CityList size = " + _collection.size());
            setAttribute(PARAM_CITY_LIST, _collection);
            setAttribute(PARAM_CITY_LIST_SIZE, new Integer(_collection.size()));
            
            return getActionMapping().findForward(FORWARD_VIEW_LIST);
        }

        /**
         *  Description of the Method
         *
         * @return  Description of the Return Value
         * @exception  HandlePerformException  Description of the Exception
         */
        public ActionForward perform() throws HandlePerformException {
            if (null == getQueryObjectId()) {
                getLogger().debug("Executing CityListHandle");
                
                return CityListHandle();
            } else {
                getLogger().debug("Executing CityDetailHandle");
                
                return CityDetailHandle(getQueryObjectId());
            }
        }
    }

}