package com.glweb.module.forum.form;

import com.glweb.module.forum.model.Category;
import com.glweb.module.forum.model.Message;
import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author   $Author: primo $
 * @version  $Revision: 1.1 $ $Date: 2003/09/14 12:03:02 $
 *
 * @struts:form name="forum3Form"
 */
public class Forum3Form extends ValidatorForm {
    private Category category;
    private Message message;

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public Message getMessage() {
        return message;
    }
    public void setMessage(Message message) {
        this.message = message;
    }
}
