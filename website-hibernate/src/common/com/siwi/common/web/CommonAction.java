/*
 * $Id: CommonAction.java,v 1.2 2003/10/29 08:27:23 paxson Exp $
 * 
 */

package com.siwi.common.web;

import java.io.IOException;
import java.rmi.ServerException;

import javax.ejb.DuplicateKeyException;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.siwi.common.logger.Logger;
import com.siwi.common.logger.LoggerFactory;

/**
 *  CommonAction
 *
 * @author  Paxson Yang
 * @created  2002/8/6
 * @version  $Revision: 1.2 $ $Date: 2003/10/29 08:27:23 $
 */
public abstract class CommonAction extends Action {

    private final static boolean DEBUG = true;

    private final static String PARAM_ACTION = "action";

    private final static String PARAM_OID = "oid";

    private ActionErrors _errors;

    private ActionForm _form;

    private Logger _logger;

    private ActionMapping _mapping;

    private HttpServletRequest _request;

    /**
     *  Sets the actionErrors attribute of the CommonAction object
     *
     * @param  val  The new actionErrors value
     */
    protected void setActionErrors(ActionErrors val) {
        _errors = val;
    }

    /**
     *  Sets the actionForm attribute of the CommonAction object
     *
     * @param  form  The new actionForm value
     */
    protected void setActionForm(ActionForm form) {
        _form = form;
    }

    /**
     *  Sets the actionMapping attribute of the CommonAction object
     *
     * @param  mapping  The new actionMapping value
     */
    protected void setActionMapping(ActionMapping mapping) {
        _mapping = mapping;
    }

    /**
     *  Sets the attribute attribute of the CommonAction object
     *
     * @param  key    The new attribute value
     * @param  value  The new attribute value
     */
    protected void setAttribute(String key, Object value) {
        if ("request".equals(getActionMapping().getScope())) {
            getLogger().debug("Set attributes with scope " +
                    getActionMapping().getScope());
            getRequest().setAttribute(key, value);
        } else if ("session".equals(getActionMapping().getScope())) {
            getLogger().debug("Set attributes with scope " +
                    getActionMapping().getScope());
            getSession().setAttribute(key, value);
        }
    }

    /**
     *  Sets the request attribute of the CommonAction object
     *
     * @param  request  The new request value
     */
    protected void setRequest(HttpServletRequest request) {
        _request = request;
    }

    /**
     *  Gets the actionErrors attribute of the CommonAction object
     *
     * @return  The actionErrors value
     */
    protected ActionErrors getActionErrors() {
        if (null == _errors) {
            setActionErrors(new ActionErrors());
        }

        return _errors;
    }

    /**
     *  Gets the actionForm attribute of the CommonAction object
     *
     * @return  The actionForm value
     */
    protected ActionForm getActionForm() {
        return _form;
    }

    /**
     *  Gets the actionMapping attribute of the CommonAction object
     *
     * @return  The actionMapping value
     */
    protected ActionMapping getActionMapping() {
        return _mapping;
    }

    /**
     *  Gets the attribute attribute of the CommonAction object
     *
     * @param  key  Description of the Parameter
     * @return  The attribute value
     */
    protected Object getAttribute(String key) {
        if ("request".equals(getActionMapping().getScope())) {
            getLogger().debug(
                    "Get attributes with scope " + getActionMapping().getScope());

            return getRequest().getAttribute(key);
        } else if ("session".equals(getActionMapping().getScope())) {
            getLogger().debug(
                    "Get attributes with scope " + getActionMapping().getScope());

            return getSession().getAttribute(key);
        } else {
            return null;
        }
    }

    /**
     *  Gets the debug attribute of the CommonAction object
     *
     * @return  The debug value
     */
    protected boolean getDebug() {
        return DEBUG;
    }

    /**
     *  Gets the eJBDuplicateKeyException attribute of the CommonAction object
     *
     * @param  e  Description of the Parameter
     * @return  The eJBDuplicateKeyException value
     */
    protected boolean isEJBDuplicateKeyException(ServerException e) {
        if (isEJBException(e)) {
            if (((EJBException) e.detail).getCausedByException()
                    instanceof DuplicateKeyException) {

                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     *  Gets the eJBException attribute of the CommonAction object
     *
     * @param  e  Description of the Parameter
     * @return  The eJBException value
     */
    protected boolean isEJBException(ServerException e) {
        if (e.detail instanceof EJBException) {

            return true;
        } else {
            return false;
        }
    }

    /**
     *  Gets the handleFactory attribute of the CommonAction object
     *
     * @return  The handleFactory value
     */
    protected abstract HandleFactory getHandleFactory();

    /**
     *  Gets the logger attribute of the CommonAction object
     *
     * @return  The logger value
     */
    protected Logger getLogger() {
        if (null == _logger) {
            _logger = LoggerFactory.getInstance().getLogger(
                    getClass().getName());
            _logger.setDebug(getDebug());
        }

        return _logger;
    }

    /**
     *  Gets the queryObjectId attribute of the CommonAction object
     *
     * @return  The queryObjectId value
     */
    protected String getQueryObjectId() {
        getLogger().debug("ObjectId = " +
                getRequest().getParameter(PARAM_OID));

        return getRequest().getParameter(PARAM_OID);
    }

    /**
     *  Gets the request attribute of the CommonAction object
     *
     * @return  The request value
     */
    protected HttpServletRequest getRequest() {
        return _request;
    }

    /**
     *  Gets the session attribute of the CommonAction object
     *
     * @return  The session value
     */
    protected HttpSession getSession() {
        return getRequest().getSession(true);
    }

    /**
     *  Description of the Method
     *
     * @param  mapping               Description of the Parameter
     * @param  form                  Description of the Parameter
     * @param  request               Description of the Parameter
     * @param  response              Description of the Parameter
     * @return                       Description of the Return Value
     * @exception  IOException       Description of the Exception
     * @exception  ServletException  Description of the Exception
     */
    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
        throws IOException, ServletException {

        setActionForm(form);
        setActionMapping(mapping);
        setRequest(request);
        getActionErrors().clear();

        Handle _handle = null;
        ActionForward _forward = null;
        String _action = request.getParameter(PARAM_ACTION);

        getLogger().debug("Action = '" + _action + "'");

        try {
            _handle = getHandleFactory().getHandle(
                    ActionType.valueOf(_action));
            _forward = _handle.perform();
        } catch (HandleCreateException hce) {
            throw new ServletException(hce);
        } catch (HandlePerformException hpe) {
            throw new ServletException(hpe);
        } catch (Exception e) {
            throw new ServletException(e);
        }

        return _forward;
    }

}