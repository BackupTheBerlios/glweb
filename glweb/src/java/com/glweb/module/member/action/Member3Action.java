package com.glweb.module.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.glweb.Constants;
import com.glweb.module.member.MembershipManager;
import com.glweb.module.member.form.Member3Form;
import com.glweb.module.member.model.User;
import com.glweb.web.struts.actions.BaseAction;
import com.glweb.web.struts.actions.HandleFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author   $Author: primo $
 * @version  $Revision: 1.1 $ $Date: 2003/09/14 12:05:05 $
 *
 * @struts:action path="/member/member3"
 *                name="member3Form"
 *                scope="request"
 *                validate="false"
 *                input="glweb.member_3"
 *
 * @struts:action-forward name="forum" path="/forum/forum1.do"
 *
 */
public class Member3Action extends BaseAction {
    /**
     * @see com.glweb.web.struts.actions.BaseAction#getHandleFactory()
     */
    protected HandleFactory getHandleFactory() {
        return null;
    }

    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        Member3Form member3Form = (Member3Form)form;
        String action = request.getParameter("action");

        if(action != null && action.equals("confirm")){
            return mapping.findForward("forum");
        }else{
            String userId = request.getParameter("userId");
            User user = null;
            if (userId != null) {
                user = MembershipManager.getInstance().getUser(Long.parseLong(userId));
            } else {
                user = (User) request.getSession().getAttribute(Constants.USER_KEY);
                if(user == null){
                    return mapping.findForward("forum");
                }
            }
            member3Form.setUser(user);
            request.setAttribute("member3Form", member3Form);
        }
        return (mapping.getInputForward());
    }
}
