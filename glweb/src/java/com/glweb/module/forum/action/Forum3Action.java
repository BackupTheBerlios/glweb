package com.glweb.module.forum.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.glweb.module.forum.form.Forum3Form;
import com.glweb.module.forum.model.Message;
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
 * @struts:action path="/forum/forum3"
 *                name="forum3Form"
 *                scope="request"
 *                validate="false"
 *                input="glweb.forum_3"
 *
 * @struts:action-forward name="next" path="glweb.forum_3"
 *
 */
public class Forum3Action extends BaseAction {
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
     Forum3Form forum3Form = (Forum3Form)form;
     String action = request.getParameter("action");
     String messageId = request.getParameter("messageId");

     Message message = ForumActionHelper.getMessage(messageId);
     forum3Form.setMessage(message);
     request.setAttribute("forum3Form", forum3Form);
     return (forward);
 }

}
