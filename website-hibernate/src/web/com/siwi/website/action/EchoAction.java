/*
 * $Id: EchoAction.java,v 1.2 2003/10/29 08:27:23 paxson Exp $
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
import com.siwi.website.form.EchoForm;

/**
 *  EchoAction
 *
 * @author  Paxson Yang
 * @created  2002/8/5
 * @version  $Revision: 1.2 $ $Date: 2003/10/29 08:27:23 $
 * 
 * @web:ejb-ref  name="EchoEJB" 
 *               type="Session"
 *               home="com.siwi.website.ejb.session.EchoEJBHome"
 *               remote="com.siwi.website.ejb.session.EchoEJB" 
 *               link="EchoEJB"
 *               description="A test reference to the Echo EJB"
 * 
 * @struts:action  path="/echo/echoAction" 
 *                 name="echoForm"
 *                 scope="request" 
 *                 validate="true" 
 *                 input="/echo/echo.jsp"
 * 
 * @struts:action-forward  name="input" 
 *                         path="/echo/echo.jsp"
 * 
 * @struts:action-forward  name="result" 
 *                         path="/echo/result.jsp"
 * 
 * @jboss:ejb-ref-jndi  ref-name="EchoEJB" 
 *                      jndi-name="ejb/session/EchoEJB"
 */
public class EchoAction extends CommonAction {

    private final static boolean DEBUG = true;

    private final static String FORWARD_INPUT = "input";

    private final static String FORWARD_RESULT = "result";

    private static HandleFactory _handleFactory;

    /**
     *  Gets the handleFactory attribute of the EchoAction object
     *
     * @return  The handleFactory value
     */
    protected HandleFactory getHandleFactory() {
        if (null == _handleFactory) {
            _handleFactory = new EchoHandleFactory();
        }

        return _handleFactory;
    }

    /**
     *  EchoHandleFactory
     *
     * @author  paxson.yang
     * @created  2002/9/5
     */
    class EchoHandleFactory implements HandleFactory {
        /**
         *  Gets the handle attribute of the EchoHandleFactory object
         *
         * @param  action  Description of the Parameter
         * @return  The handle value
         * @exception  HandleCreateException  Description of the Exception
         */
        public Handle getHandle(ActionType action)throws HandleCreateException {

            switch (action.getType()) {

                case ActionType.NULL_TYPE:
                    return new EchoInputHandle();

                case ActionType.INPUT_TYPE:
                    return new EchoInputHandle();

                case ActionType.SUBMIT_TYPE:
                    return new EchoSubmitHandle();

                default:
                    return new EchoInputHandle();
            }
        }
    }

    /**
     *  EchoInputHandle
     *
     * @author  paxson.yang
     * @created  2002/9/5
     */
    class EchoInputHandle implements Handle {
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

    /**
     *  EchoSubmitHandle
     *
     * @author  paxson.yang
     * @created  2002/9/5
     */
    class EchoSubmitHandle implements Handle {
        /**
         *  Description of the Method
         *
         * @return  Description of the Return Value
         * @exception  HandlePerformException  Description of the Exception
         */
        public ActionForward perform() throws HandlePerformException {
            getLogger().debug("Message = '" +
                    ((EchoForm) getActionForm()).getMessage() + "'");

            /*
            try {
                EchoEJBHome _ejbHome = EchoEJBUtil.getHome();
                EchoEJB _ejb = _ejbHome.create();
                ((EchoForm) getActionForm()).setMessage(
                        _ejb.echo(((EchoForm) getActionForm()).getMessage()));
            } catch (NamingException ne) {
                throw new HandlePerformException(ne);
            } catch (RemoteException re) {
                throw new HandlePerformException(re);
            } catch (CreateException ce) {
                throw new HandlePerformException(ce);
            } catch (Exception e) {
                throw new HandlePerformException(e);
            }

            setAttribute(getActionMapping().getAttribute(),
                    getActionForm());
            */

            return getActionMapping().findForward(FORWARD_RESULT);
        }
    }

}