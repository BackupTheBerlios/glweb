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
import com.siwi.website.ejb.entity.LanguagePK;
import com.siwi.website.ejb.session.CommonEJB;
import com.siwi.website.ejb.session.CommonEJBHome;
import com.siwi.website.ejb.util.CommonEJBUtil;
import com.siwi.website.ejb.value.LanguageValue;
import com.siwi.website.form.LanguageForm;

/**
 *  LanguageAction
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
 * @struts:action  path="/common/languageAction" 
 *                 name="languageForm"
 *                 scope="request" 
 *                 validate="true" 
 *                 input="/common/language.jsp"
 * 
 * @struts:action-forward  name="action/queryLanguage"
 *                         path="/common/languageAction.do?action=query"
 * 
 * @struts:action-forward  name="view/languageList"
 *                         path="/common/languageList.jsp"
 * 
 * @struts:action-forward  name="view/languageDetail"
 *                         path="/common/languageDetail.jsp"
 * 
 * @jboss:ejb-ref-jndi  ref-name="CommonEJB"
 *                      jndi-name="ejb/session/CommonEJB"
 */
public class LanguageAction extends CommonAction {

    private final static boolean DEBUG = true;

    private final static String FORWARD_ACTION_QUERY =
            "action/queryLanguage";

    private final static String FORWARD_VIEW_DETAIL =
            "view/languageDetail";

    private final static String FORWARD_VIEW_LIST =
            "view/languageList";

    private final static String PARAM_LANGUAGE = "language";

    private final static String PARAM_LANGUAGE_LIST = "languageList";

    private final static String PARAM_LANGUAGE_LIST_SIZE =
            "languageListSize";

    private static HandleFactory _handleFactory;

    /**
     *  Gets the handleFactory attribute of the LanguageAction object
     *
     * @return  The handleFactory value
     */
    protected HandleFactory getHandleFactory() {
        if (null == _handleFactory) {
            _handleFactory = new LanguageHandleFactory();
        }

        return _handleFactory;
    }

    /**
     *  LanguageAddHandle
     *
     * @author  paxson.yang
     * @created  2002/9/5
     */
    class LanguageAddHandle implements Handle {
        /**
         *  Description of the Method
         *
         * @return  Description of the Return Value
         * @exception  HandlePerformException  Description of the Exception
         */
        public ActionForward perform() throws HandlePerformException {
            getLogger().debug("LanguageId = '" +
                    ((LanguageForm) getActionForm()).getId() + "'");
            getLogger().debug("LanguageName = '" +
                    ((LanguageForm) getActionForm()).getName() + "'");

            try {
                CommonEJBHome _ejbHome = CommonEJBUtil.getHome();
                CommonEJB _ejb = _ejbHome.create();

                LanguageValue _value = new LanguageValue();

                PropertyUtils.copyProperties(_value,
                        (LanguageForm) getActionForm());

                LanguageValue _language = _ejb.createLanguage(_value);

                getLogger().debug("Create Language successful");
            } catch (ServerException se) {
                getLogger().debug("ServerException Detail : " +
                        se.detail.toString());
                if (isEJBDuplicateKeyException(se)) {
                    getActionErrors().add("duplicate",
                            new ActionError("error.languageId.unique"));
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
     *  LanguageHandleFactory
     *
     * @author  paxson.yang
     * @created  2002/9/5
     */

    class LanguageHandleFactory implements HandleFactory {
        /**
         *  Gets the handle attribute of the LanguageHandleFactory object
         *
         * @param  action  Description of the Parameter
         * @return  The handle value
         * @exception  HandleCreateException  Description of the Exception
         */
        public Handle getHandle(ActionType action) throws HandleCreateException {

            switch (action.getType()) {

                case ActionType.NULL_TYPE:
                    return new LanguageInputHandle();

                case ActionType.INPUT_TYPE:
                    return new LanguageInputHandle();

                case ActionType.ADD_TYPE:
                    return new LanguageAddHandle();

                case ActionType.QUERY_TYPE:
                    return new LanguageQueryHandle();

                default:
                    return new LanguageInputHandle();
            }
        }
    }

    /**
     *  LanguageInputHandle
     *
     * @author  paxson.yang
     * @created  2002/9/5
     */
    class LanguageInputHandle implements Handle {
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
     *  LanguageQueryHandle
     *
     * @author  paxson.yang
     * @created  2002/9/5
     */
    class LanguageQueryHandle implements Handle {
        /**
         *  Description of the Method
         *
         * @param  id  Description of the Parameter
         * @return  Description of the Return Value
         */
        private ActionForward LanguageDetailHandle(String id) {
            LanguageValue _languageValue = null;

            try {
                CommonEJBHome _commonEJBHome = CommonEJBUtil.getHome();
                CommonEJB _commonEJB = _commonEJBHome.create();

                LanguagePK _languagePK = new LanguagePK();
                _languagePK.setId(id);
                _languageValue = _commonEJB.findLanguage(_languagePK);
            } catch (ServerException se) {
                getLogger().debug("ServerException Detail : " +
                        se.detail.toString());
            } catch (Exception e) {
                getLogger().debug("Exception : " + e.toString());
                throw new HandlePerformException(e);
            }

            setAttribute(PARAM_LANGUAGE, _languageValue);

            return getActionMapping().findForward(FORWARD_VIEW_DETAIL);
        }

        /**
         *  Description of the Method
         *
         * @return  Description of the Return Value
         */
        private ActionForward LanguageListHandle() {
            try {
                CommonEJBHome _ejbHome = CommonEJBUtil.getHome();
                CommonEJB _ejb = _ejbHome.create();

                Collection _languages = _ejb.findLanguage();

                setAttribute(PARAM_LANGUAGE_LIST, _languages);
                setAttribute(PARAM_LANGUAGE_LIST_SIZE,
                        new Integer(_languages.size()));
            } catch (ServerException se) {
                getLogger().debug("ServerException Detail : " +
                        se.detail.toString());
            } catch (Exception e) {
                getLogger().debug("Exception : " + e.toString());
                throw new HandlePerformException(e);
            }

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
                getLogger().debug("Executing LanguageListHandle");

                return LanguageListHandle();
            } else {
                getLogger().debug("Executing LanguageDetailHandle");

                return LanguageDetailHandle(getQueryObjectId());
            }
        }
    }

}