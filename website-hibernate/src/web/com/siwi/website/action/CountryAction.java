/*
 * $Id: CountryAction.java,v 1.2 2003/10/29 08:27:23 paxson Exp $
 * 
 */
 
package com.siwi.website.action;

import java.util.Collection;

import org.apache.struts.action.ActionForward;

import com.siwi.common.web.ActionType;
import com.siwi.common.web.CommonAction;
import com.siwi.common.web.Handle;
import com.siwi.common.web.HandleCreateException;
import com.siwi.common.web.HandleFactory;
import com.siwi.common.web.HandlePerformException;
import com.siwi.website.ejb.dao.CommonDAOFactory;
import com.siwi.website.ejb.dao.CountryDAO;
import com.siwi.website.form.CountryForm;

/**
 *  CountryAction
 *
 * @author  Paxson Yang
 * @created  2002/8/7
 * @version  $Revision: 1.2 $ $Date: 2003/10/29 08:27:23 $
 * 
 * @web:ejb-ref  name="CommonEJB" 
 *               type="Session"
 *               home="com.siwi.website.ejb.session.CommonEJBHome"
 *               remote="com.siwi.website.ejb.session.CommonEJB" 
 *               link="CommonEJB"
 *               description="A test reference to the Common EJB"
 * 
 * @struts:action  path="/common/countryAction" 
 *                 name="countryForm"
 *                 scope="request" 
 *                 validate="true" 
 *                 input="/common/country.jsp"
 * 
 * @struts:action-forward  name="action/queryCountry"
 *                         path="/common/countryAction.do?action=query"
 * 
 * @struts:action-forward  name="view/countryList"
 *                         path="/common/countryList.jsp"
 * 
 * @struts:action-forward  name="view/countryDetail"
 *                         path="/common/countryDetail.jsp"
 * 
 * @jboss:ejb-ref-jndi  ref-name="CommonEJB"
 *                      jndi-name="ejb/session/CommonEJB"
 */
public class CountryAction extends CommonAction {

    private final static boolean DEBUG = true;

    private final static String FORWARD_ACTION_QUERY = "action/queryCountry";

    private final static String FORWARD_VIEW_DETAIL = "view/countryDetail";

    private final static String FORWARD_VIEW_LIST = "view/countryList";

    private final static String PARAM_CITY_LIST_SIZE = "cityListSize";

    private final static String PARAM_COUNTRY = "country";

    private final static String PARAM_COUNTRY_LIST = "countryList";

    private final static String PARAM_COUNTRY_LIST_SIZE = "countryListSize";

    private static HandleFactory _handleFactory;

    /**
     *  Gets the handleFactory attribute of the CountryAction object
     *
     * @return  The handleFactory value
     */
    protected HandleFactory getHandleFactory() {
        if (null == _handleFactory) {
            _handleFactory = new CountryHandleFactory();
        }

        return _handleFactory;
    }

    /**
     *  CountryAddHandle
     *
     * @author  paxson.yang
     * @created  2002/9/5
     */
    class CountryAddHandle implements Handle {
        /**
         *  Description of the Method
         *
         * @return  Description of the Return Value
         * @exception  HandlePerformException  Description of the Exception
         */
        public ActionForward perform() throws HandlePerformException {
            getLogger().debug("CountryId = '" +
                    ((CountryForm) getActionForm()).getId() + "'");
            getLogger().debug("CountryName = '" +
                    ((CountryForm) getActionForm()).getName() + "'");

            /*
            try {
                CommonEJBHome _ejbHome = CommonEJBUtil.getHome();
                CommonEJB _ejb = _ejbHome.create();
                CountryValue _value = new CountryValue();

                PropertyUtils.copyProperties(_value,
                        (CountryForm) getActionForm());

                CountryValue _country = _ejb.createCountry(_value);

                getLogger().debug("Create Country successful");
            } catch (ServerException se) {
                getLogger().debug("ServerException Detail : " +
                        se.detail.toString());
                if (isEJBDuplicateKeyException(se)) {
                    getActionErrors().add("duplicate",
                            new ActionError("error.countryId.unique"));
                }
            } catch (Exception e) {
                getLogger().debug("Exception : " + e.toString());
                throw new HandlePerformException(e);
            }
            */

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
     *  CountryHandleFactory
     *
     * @author  paxson.yang
     * @created  2002/9/5
     */

    class CountryHandleFactory implements HandleFactory {
        /**
         *  Gets the handle attribute of the CountryHandleFactory object
         *
         * @param  action  Description of the Parameter
         * @return  The handle value
         * @exception  HandleCreateException  Description of the Exception
         */
        public Handle getHandle(ActionType action) throws HandleCreateException {

            switch (action.getType()) {

                case ActionType.NULL_TYPE:
                    return new CountryInputHandle();

                case ActionType.INPUT_TYPE:
                    return new CountryInputHandle();

                case ActionType.ADD_TYPE:
                    return new CountryAddHandle();

                case ActionType.QUERY_TYPE:
                    return new CountryQueryHandle();

                default:
                    return new CountryInputHandle();
            }
        }
    }

    /**
     *  CountryInputHandle
     *
     * @author  paxson.yang
     * @created  2002/9/5
     */
    class CountryInputHandle implements Handle {
        /**
         *  Description of the Method
         *
         * @return  Description of the Return Value
         * @exception  HandlePerformException  Description of the Exception
         */
        public ActionForward perform() throws HandlePerformException {
            return new ActionForward(getActionMapping().getInput());
        }
    }

    /**
     *  CountryQueryHandle
     *
     * @author  paxson.yang
     * @created  2002/9/5
     */
    class CountryQueryHandle implements Handle {
        /**
         *  Description of the Method
         *
         * @param  id  Description of the Parameter
         * @return  Description of the Return Value
         */
        private ActionForward CountryDetailHandle(String id) {
            /*
            CountryPK _pk = new CountryPK();
            _pk.setId(id);

            try {
                CommonEJBHome _ejbHome = CommonEJBUtil.getHome();
                CommonEJB _ejb = _ejbHome.create();
                CountryValue _country = _ejb.findCountry(_pk);

                getLogger().debug("CountryValue = " + _country);
                getLogger().debug("    City count = " +
                        _country.getCitys().length);

                setAttribute(PARAM_COUNTRY, _country);
                setAttribute(PARAM_CITY_LIST_SIZE,
                        new Integer(_country.getCitys().length));
            } catch (ServerException se) {
                getLogger().debug("ServerException Detail : " +
                        se.detail.toString());
            } catch (Exception e) {
                getLogger().debug("Exception : " + e.toString());
                throw new HandlePerformException(e);
            }
            */

            return getActionMapping().findForward(FORWARD_VIEW_DETAIL);
        }

        /**
         *  Description of the Method
         *
         * @return  Description of the Return Value
         */
        private ActionForward CountryListHandle() {
            CountryDAO _countryDAO = CommonDAOFactory.getCountryDAO();
            Collection _collection = _countryDAO.findAll();

            getLogger().debug("CountryList size = " + _collection.size());

            setAttribute(PARAM_COUNTRY_LIST, _collection);
            setAttribute(PARAM_COUNTRY_LIST_SIZE,
                    new Integer(_collection.size()));

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
                getLogger().debug("Executing CountryListHandle");

                return CountryListHandle();
            } else {
                getLogger().debug("Executing CountryDetailHandle");

                return CountryDetailHandle(getQueryObjectId());
            }
        }
    }

}