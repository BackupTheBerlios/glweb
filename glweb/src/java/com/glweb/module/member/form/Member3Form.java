package com.glweb.module.member.form;

import com.glweb.module.member.model.User;
import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author   $Author: primo $
 * @version  $Revision: 1.1 $ $Date: 2003/09/14 12:05:05 $
 *
 * @struts:form name="member3Form"
 */
public class Member3Form extends ValidatorForm {
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

}
