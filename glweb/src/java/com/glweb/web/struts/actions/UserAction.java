/*
 *
 * $Id: UserAction.java,v 1.2 2003/05/17 10:16:53 kocachen Exp $
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.glweb.Constants;
import com.glweb.module.member.MembershipManager;
import com.glweb.module.member.model.User;

/**
 * HelloAction
 *
 * @author   $Author: kocachen $
 * @version  $Revision: 1.2 $ $Date: 2003/05/17 10:16:53 $
 * 
 * @struts:action path="/action/userAction"
 *                name="userForm"
 *                scope="request"
 *                validate="true"
 *                input="tile.user.input"
 * 
 * @struts:action-forward name="/view/user/list"
 *                        path="tile.user.list"
 * 
 * @struts:action-forward name="/view/user/detail"
 *                        path="tile.user.detail"
 */
public class UserAction extends BaseAction {
    
    /**
     * @see com.glweb.web.struts.actions.BaseAction#getHandleFactory()
     */
    protected HandleFactory getHandleFactory() {
        return null;
    }
    
    /**
     * @return UserManager
     */
    protected MembershipManager getUserManager() {
        return MembershipManager.getInstance();
    }
    
    /**
     * @see org.apache.struts.action.Action#execute(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse)
     */
    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
        throws Exception {
            
        HttpSession _session = request.getSession();
        
        String _action = (String) PropertyUtils.getSimpleProperty(form, "action");
            
        if (null == _action) {
            return (mapping.getInputForward());
        }
            
        // Was this transaction cancelled?
        if (isCancelled(request)) {
            if (getLogger().isInfoEnabled()) {
                getLogger().info(" " + mapping.getAttribute() + 
                        " - User transaction was cancelled");
            }

            removeFormBean(mapping, request);
            
            _session.removeAttribute(Constants.USER_KEY);

            return (mapping.findForward("/view/user/cancel"));
        }
        
        User _user = null;
        String _name = (String) PropertyUtils.getSimpleProperty(form, "name");
        
        _user = new User();
        _user.setName(_name);
        
        if (getLogger().isInfoEnabled()) {
            getLogger().info("user = " + _user);
        }
        
        _session.setAttribute(Constants.USER_KEY, _user);

        return (mapping.findForward("/view/user/success"));
    }

}
