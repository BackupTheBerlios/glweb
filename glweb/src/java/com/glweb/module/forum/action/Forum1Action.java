package com.glweb.module.forum.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.glweb.Constants;
import com.glweb.module.forum.form.Forum1Form;
import com.glweb.module.member.MembershipManager;
import com.glweb.module.member.model.User;
import com.glweb.web.struts.actions.BaseAction;
import com.glweb.web.struts.actions.HandleFactory;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author   $Author: primo $
 * @version  $Revision: 1.2 $ $Date: 2003/09/22 16:58:41 $
 *
 * @struts:action path="/forum/forum1"
 *                name="forum1Form"
 *                scope="request"
 *                validate="false"
 *                input="glweb.forum_1"
 *
 * @struts:action-forward name="next" path="glweb.forum_2"
 *
 */
public class Forum1Action extends BaseAction {
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
     Forum1Form forum1Form = (Forum1Form) form;
     String action = request.getParameter("action");
     Collection allCategory = ForumActionHelper.getAllCategory();
     forum1Form.setCategories(allCategory);
     request.setAttribute("forum1Form", forum1Form);
     if (action != null && action.equals("login")) {
         String name = request.getParameter("name");
         String password = request.getParameter("password");
         User user = ForumActionHelper.validateUser(name, password);
         if( user == null){
             ActionErrors errors = new ActionErrors();
             errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.login"));
             this.saveErrors(request, errors);
         }else{
             request.getSession(true).setAttribute(Constants.USER_KEY, user);
             forum1Form.setName("");
             forum1Form.setPassword("");
         }
         return mapping.getInputForward();
     }
     return mapping.getInputForward();
 }

}