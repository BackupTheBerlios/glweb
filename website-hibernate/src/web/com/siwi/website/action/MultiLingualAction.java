/*
 * $ Id: $
 * 
 */
 
package com.siwi.website.action;

import java.util.Locale;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;

import com.siwi.common.web.ActionType;
import com.siwi.common.web.CommonAction;
import com.siwi.common.web.Handle;
import com.siwi.common.web.HandleCreateException;
import com.siwi.common.web.HandleFactory;
import com.siwi.common.web.HandlePerformException;

/**
 *  MultiLingualAction
 *
 * @author  Paxson Yang
 * @created  2002/8/16
 * @version  $Revision: 1.1 $ $Date: 2003/10/28 02:56:05 $
 * 
 * @struts:action  path="/common/multiLingualAction" 
 *                 scope="request"
 *                 validate="false"
 */
public class MultiLingualAction extends CommonAction {

    private final static boolean DEBUG = true;

    private final static String PARAM_LANGUAGE = "language";

    private static HandleFactory _handleFactory;

    /**
     *  Gets the handleFactory attribute of the MultiLingualAction object
     *
     * @return  The handleFactory value
     */
    protected HandleFactory getHandleFactory() {
        if (null == _handleFactory) {
            _handleFactory = new MultiLingualHandleFactory();
        }

        return _handleFactory;
    }

    /**
     *  MultiLingualHandleFactory
     *
     * @author  paxson.yang
     * @created  2002/9/5
     */
    class MultiLingualHandleFactory implements HandleFactory {
        /**
         *  Gets the handle attribute of the MultiLingualHandleFactory object
         *
         * @param  action  Description of the Parameter
         * @return  The handle value
         * @exception  HandleCreateException  Description of the Exception
         */
        public Handle getHandle(ActionType action) throws HandleCreateException {

            switch (action.getType()) {

                case ActionType.NULL_TYPE:
                    return new MultiLingualSubmitHandle();

                default:
                    return new MultiLingualSubmitHandle();
            }
        }
    }

    /**
     *  MultiLingualSubmitHandle
     *
     * @author  paxson.yang
     * @created  2002/9/5
     */
    class MultiLingualSubmitHandle implements Handle {
        /**
         *  Description of the Method
         *
         * @return  Description of the Return Value
         * @exception  HandlePerformException  Description of the Exception
         */
        public ActionForward perform() throws HandlePerformException {
            String _locale =
                    (String) getRequest().getParameter(PARAM_LANGUAGE);

            getLogger().debug("Language = '" + _locale + "'");

            if (null != _locale) {
                getSession().setAttribute(Action.LOCALE_KEY,
                        new Locale(_locale, ""));
            }

            return new ActionForward(getRequest().getHeader("Referer"), true);
        }
    }

}