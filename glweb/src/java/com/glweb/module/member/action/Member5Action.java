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
import org.apache.commons.beanutils.PropertyUtils;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author   $Author: primo $
 * @version  $Revision: 1.1 $ $Date: 2003/09/22 16:58:41 $
 *
 * @struts:action path="/member/member5"
 *                name="member5Form"
 *                scope="request"
 *                validate="false"
 *                input="glweb.member_5"
 *
 * @struts:action-forward name="next" path="/forum/forum2.do"
 * @struts:action-forward name="forum" path="/forum/forum1.do"
 */
public class Member5Action extends BaseAction {
    /**
     * @see com.glweb.web.struts.actions.BaseAction#getHandleFactory()
     */
    protected HandleFactory getHandleFactory() {
        return null;
    }

    protected void doInsert(ActionForm form, User user) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        FormFile file = (FormFile) PropertyUtils.getSimpleProperty(form, "upload");
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
        String categoryId = (String) PropertyUtils.getSimpleProperty(form, "categoryId");
        String messageId = (String) PropertyUtils.getSimpleProperty(form, "messageId");
        Category category = ForumActionHelper.getCategoryById(categoryId);
        Message msg = ForumActionHelper.getMessageById(messageId);
        if(category != null && msg != null){
            Message reply = new Message();
            reply.setCategory(category);
            reply.setSubject("Reply:" + msg.getSubject());
            String replyMessage = (String) PropertyUtils.getSimpleProperty(form, "message");
            reply.setMessage(replyMessage);
            reply.setPoster(user);
            msg.addReplyMessage(reply);
            ForumManager.getInstance().updateMessage(msg);
        }
    }

    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        String categoryId = request.getParameter("categoryId");
        String messageId = request.getParameter("messageId");

        if(action != null && action.equals("insert")){
            String name = (String) PropertyUtils.getSimpleProperty(form, "name");
            String password = (String) PropertyUtils.getSimpleProperty(form, "password");
            User user = ForumActionHelper.validateUser(name, password);
            if (user == null) {
                ActionErrors errors = new ActionErrors();
                errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.login"));
                this.saveErrors(request, errors);
                return (mapping.getInputForward());
            }else{
                doInsert(form, user);
            }
            ActionForward forward = new ActionForward("/forum/forum2.do?categoryId="+categoryId);
            return forward;
        }else{
            if(categoryId == null){
                return mapping.findForward("forum");
            }
            return (mapping.getInputForward());
        }
    }
}
