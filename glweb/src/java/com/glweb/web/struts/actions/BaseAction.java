/*
 *
 * $Id: BaseAction.java,v 1.1 2003/05/10 11:41:13 paxson Exp $
 *
 * Copyright (c) 2003 SIWI.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a 
 * copy of this software and associated documentation files (the 
 * "Software"), to deal in the Software without restriction, including 
 * without limitation the rights to use, copy, modify, merge, publish, 
 * distribute, sublicense, and/or sell copies of the Software, and to 
 * permit persons to whom the Software is furnished to do so, subject to 
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included 
 * in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF 
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY 
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, 
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.glweb.web.struts.actions;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * BaseAction
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/05/10 11:41:13 $
 */
public abstract class BaseAction extends Action {
    private static final String PARAM_ACTION = "action";
    private static final String PARAM_IDENTITY = "identity";
    private static final String PARAM_ROLE = "role";
    private static final String PARAM_SUBMIT = "submit";

    private Log _logger;
    private ActionErrors _errors;
    private ActionForm _form;
    private ActionMapping _mapping;
    private HttpServletRequest _request;
    
    protected abstract HandleFactory getHandleFactory();
    
    protected Log getLogger() {
        if (null == _logger) {
            setLogger(LogFactory.getLog(getClass()));
        }
        
        return _logger;
    }
    
    protected void setLogger(Log logger) {
        _logger = logger;
    }
    
    protected void removeFormBean(ActionMapping mapping, HttpServletRequest request) {
       // Remove the obsolete form bean
       if (null != mapping.getAttribute()) {
           if ("request".equals(mapping.getScope())) {
               request.removeAttribute(mapping.getAttribute());
           } else {
              HttpSession _session = request.getSession();
              _session.removeAttribute(mapping.getAttribute());
           }
       }
    }
    
    protected Object getAttribute(String key) {
        if ("request".equals(getActionMapping().getScope())) {
            if (getLogger().isDebugEnabled()) {
                getLogger().debug(
                        "Get attributes with scope " + 
                                getActionMapping().getScope());
            }
                    
            return getRequest().getAttribute(key);
        } else if ("session".equals(getActionMapping().getScope())) {
            if (getLogger().isDebugEnabled()) {
                getLogger().debug(
                        "Get attributes with scope " + 
                                getActionMapping().getScope());
            }
                    
            return getSession().getAttribute(key);
        } else {
            return null;
        }
    }
    
    protected void setAttribute(String key, Object value) {
        if ("request".equals(getActionMapping().getScope())) {
            if (getLogger().isDebugEnabled()) {
                getLogger().debug("Set attributes with scope " + 
                        getActionMapping().getScope());
            }
            
            getRequest().setAttribute(key, value);
        } else if ("session".equals(getActionMapping().getScope())) {
            if (getLogger().isDebugEnabled()) {
                getLogger().debug("Set attributes with scope " + 
                        getActionMapping().getScope());
            }
            
            getSession().setAttribute(key, value);
        }
    }
    
    protected void setActionForm(ActionForm form) {
        _form = form;
    }

    protected ActionForm getActionForm() {
        return _form;
    }
    
    protected void setActionMapping(ActionMapping mapping) {
        _mapping = mapping;
    }

    protected ActionMapping getActionMapping() {
        return _mapping;
    }
    
    protected ActionErrors getActionErrors() {
        if (null == _errors) {
            setActionErrors(new ActionErrors());
        }
        
        return _errors;
    }
    
    protected void setActionErrors(ActionErrors val) {
        _errors = val;;
    }
    
    protected void setRequest(HttpServletRequest request) {
        _request = request;
    }

    protected HttpServletRequest getRequest() {
        return _request;
    }

    protected HttpSession getSession() {
        return getRequest().getSession(true);
    }
    
    protected ServletContext getServletContext() {
        return getServlet().getServletContext();
    }
    
    protected String getSubmit() {
        return getRequest().getParameter(PARAM_SUBMIT);
    }
    
    protected String getRole() {
        return getRequest().getParameter(PARAM_ROLE);
    }
    
    protected String getIdentity() {
        return getRequest().getParameter(PARAM_IDENTITY);
    }

    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {
        if (getLogger().isDebugEnabled()) {
            getLogger().debug("Executing CommonAction.perform(..)");
        }
        
        setActionForm(form);
        setActionMapping(mapping);
        setRequest(request);
        getActionErrors().clear();
        
        Handle _handle = null;
        ActionForward _forward = null;
        String _action = request.getParameter(PARAM_ACTION);
        
        if (getLogger().isDebugEnabled()) {
            getLogger().debug("    Action = '" + _action + "'");
        }

        try {
            _handle = getHandleFactory().getHandle(
                    ActionType.valueOf(_action));
            _forward = _handle.perform();
        } catch (HandleCreateException hce) {
            getLogger().error(hce.toString(), hce);
            throw new ServletException(hce);
        } catch (HandlePerformException hpe) {
            getLogger().error(hpe.toString(), hpe);
            throw new ServletException(hpe);
        } catch (Exception e) {
            getLogger().error(e.toString(), e);
            throw new ServletException(e);
        }

        return _forward;
    }

}