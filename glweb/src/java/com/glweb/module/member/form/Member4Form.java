package com.glweb.module.member.form;

import com.glweb.module.member.model.User;
import org.apache.struts.validator.ValidatorForm;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author   $Author: primo $
 * @version  $Revision: 1.1 $ $Date: 2003/09/22 16:58:41 $
 *
 * @struts:form name="member4Form"
 */
public class Member4Form extends ValidatorForm {
    private String categoryId;
    private String action;
    private String main;
    private String subject;
    private String name;
    private String password;
    private String message;
    private FormFile upload;
    private boolean sign;

    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public String getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
    public String getMain() {
        return main;
    }
    public void setMain(String main) {
        this.main = main;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isSign() {
        return sign;
    }
    public void setSign(boolean sign) {
        this.sign = sign;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public FormFile getUpload() {
        return upload;
    }
    public void setUpload(FormFile upload) {
        this.upload = upload;
    }


}
