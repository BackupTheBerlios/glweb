/*
 * $Id: LanguageCodeAction.java,v 1.2 2003/10/29 08:27:23 paxson Exp $
 * 
 */

package com.siwi.website.action;

import org.apache.struts.action.ActionForward;

import com.siwi.common.web.ActionType;
import com.siwi.common.web.CommonAction;
import com.siwi.common.web.Handle;
import com.siwi.common.web.HandleCreateException;
import com.siwi.common.web.HandleFactory;
import com.siwi.common.web.HandlePerformException;

/**
 *  LanguageCodeAction
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
 * @struts:action  path="/common/languageCodeAction"
 *                 name="languageCodeForm" 
 *                 scope="request" 
 *                 validate="true"
 *                 input="/common/languageCode.jsp"
 *
 * @struts:action-forward  name="languageCode" 
 *                         path="/common/languageCode.jsp"
 *
 * @struts:action-forward  name="list" 
 *                         path="/common/languageCodeList.jsp"
 *
 * @struts:action-forward  name="detail" 
 *                         path="/common/languageCodeDetail.jsp"
 *
 * @jboss:ejb-ref-jndi  ref-name="CommonEJB"
 *                      jndi-name="ejb/session/CommonEJB"
 */
public class LanguageCodeAction extends CommonAction {

    private final static boolean DEBUG = true;

    private final static String FORWARD_DETAIL = "detail";

    private final static String FORWARD_INPUT = "input";

    private final static String FORWARD_LIST = "list";

    private static HandleFactory _handleFactory;

    /**
     *  Gets the handleFactory attribute of the LanguageCodeAction object
     *
     * @return  The handleFactory value
     */
    protected HandleFactory getHandleFactory() {
        if (null == _handleFactory) {
            _handleFactory = new LanguageCodeHandleFactory();
        }

        return _handleFactory;
    }

    /**
     *  LanguageCodeHandleFactory
     *
     * @author  paxson.yang
     * @created  2002/9/5
     */
    class LanguageCodeHandleFactory implements HandleFactory {
        /**
         *  Gets the handle attribute of the LanguageCodeHandleFactory object
         *
         * @param  action  Description of the Parameter
         * @return  The handle value
         * @exception  HandleCreateException  Description of the Exception
         */
        public Handle getHandle(ActionType action) throws HandleCreateException {

            switch (action.getType()) {

                case ActionType.NULL_TYPE:
                    return new LanguageCodeInputHandle();

                case ActionType.INPUT_TYPE:
                    return new LanguageCodeInputHandle();

                default:
                    return new LanguageCodeInputHandle();
            }
        }
    }

    /**
     *  LanguageCodeInputHandle
     *
     * @author  paxson.yang
     * @created  2002/9/5
     */
    class LanguageCodeInputHandle implements Handle {
        /**
         *  Description of the Method
         *
         * @return  Description of the Return Value
         * @exception  HandlePerformException  Description of the Exception
         */
        public ActionForward perform() throws HandlePerformException {
            return getActionMapping().findForward(FORWARD_INPUT);
        }
    }

}