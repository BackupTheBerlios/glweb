package com.glweb.module.forum.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.glweb.module.forum.form.Forum2Form;
import com.glweb.module.forum.model.Category;
import com.glweb.web.struts.actions.BaseAction;
import com.glweb.web.struts.actions.HandleFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author   $Author: primo $
 * @version  $Revision: 1.1 $ $Date: 2003/09/14 12:03:02 $
 *
 * @struts:action path="/forum/forum2"
 *                name="forum2Form"
 *                scope="request"
 *                validate="false"
 *                input="glweb.forum_2"
 *
 * @struts:action-forward name="next" path="glweb.forum_3"
 *
 */
public class Forum2Action extends BaseAction {
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
     ActionForward forward = mapping.getInputForward();
     Forum2Form forum2Form = (Forum2Form)form;
     String action = request.getParameter("action");
     String categoryId = request.getParameter("categoryId");

     Category category = ForumActionHelper.getCategoryById(categoryId);
     Collection messages = category.getMessages();
//     Collection messages = ForumActionHelper.getMessages(category);
     forum2Form.setCategory(category);
     forum2Form.setMessages(messages);
     request.setAttribute("forum2Form", forum2Form);
     return (forward);
 }

}
