package com.glweb.module.member.action;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.glweb.module.forum.ForumManager;
import com.glweb.module.forum.action.ForumActionHelper;
import com.glweb.module.forum.model.Category;
import com.glweb.module.forum.model.Message;
import com.glweb.module.member.form.Member4Form;
import com.glweb.module.member.model.User;
import com.glweb.web.struts.actions.BaseAction;
import com.glweb.web.struts.actions.HandleFactory;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import javax.servlet.*;

/**
 *
 * @author   $Author: primo $
 * @version  $Revision: 1.1 $ $Date: 2003/09/22 16:58:41 $
 *
 * @struts:action path="/member/member4"
 *                name="member4Form"
 *                scope="request"
 *                validate="false"
 *                input="glweb.member_4"
 *
 * @struts:action-forward name="next" path="/forum/forum2.do"
 * @struts:action-forward name="forum" path="/forum/forum1.do"
 */
public class Member4Action extends BaseAction {
    /**
     * @see com.glweb.web.struts.actions.BaseAction#getHandleFactory()
     */
    protected HandleFactory getHandleFactory() {
        return null;
    }

    protected void doInsert(Member4Form form, User user) {
        FormFile file = form.getUpload();
        if(file != null){
            try {
                String path = getServletContext().getRealPath("upload");
                if(!path.substring(path.length()-1).equals("/")){
                    path += "/";
                }
                System.out.println("path="+path);
                String fname = file.getFileName();
                InputStream streamIn = file.getInputStream();
                OutputStream streamOut = new FileOutputStream(path + fname);
                int bytesRead = 0;
                byte[] buffer = new byte[2048];
                while ((bytesRead = streamIn.read(buffer, 0, 2048)) != -1) {
                    streamOut.write(buffer, 0, bytesRead);
                }
                streamOut.close();
                streamIn.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        Category category = ForumActionHelper.getCategoryById(form.getCategoryId());
        if(category != null){
            Message msg = new Message();
            msg.setCategory(category);
            msg.setSubject(form.getSubject());
            msg.setMessage(form.getMessage());
            msg.setPoster(user);
            ForumManager.getInstance().addMessage(msg);
        }
    }

    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        Member4Form member4Form = (Member4Form)form;
        String action = request.getParameter("action");
        String categoryId = request.getParameter("categoryId");

        if(action != null && action.equals("insert")){
            User user = ForumActionHelper.validateUser(member4Form.getName(), member4Form.getPassword());
            if (user == null) {
                ActionErrors errors = new ActionErrors();
                errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.login"));
                this.saveErrors(request, errors);
                return (mapping.getInputForward());
            }else{
                doInsert(member4Form, user);
            }
            ActionForward forward = new ActionForward("/forum/forum2.do?categoryId="+categoryId);
            return forward;
        }else{
            if(categoryId == null){
                return mapping.findForward("forum");
            }
            member4Form.setCategoryId(categoryId);
            return (mapping.getInputForward());
        }
    }
}
