package com.glweb.module.forum.form;

import java.util.Collection;

import com.glweb.module.forum.model.Category;
import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author   $Author: primo $
 * @version  $Revision: 1.1 $ $Date: 2003/09/14 12:03:02 $
 *
 * @struts:form name="forum2Form"
 */
public class Forum2Form extends ValidatorForm {
    private Category category;
    private Collection messages;

    public Collection getMessages() {
        return messages;
    }
    public void setMessages(Collection messages) {
        this.messages = messages;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
}
