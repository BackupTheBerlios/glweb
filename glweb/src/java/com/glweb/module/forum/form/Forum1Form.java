package com.glweb.module.forum.form;

import java.util.Collection;

import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author   $Author: primo $
 * @version  $Revision: 1.1 $ $Date: 2003/09/14 12:03:02 $
 *
 * @struts:form name="forum1Form"
 */
public class Forum1Form extends ValidatorForm {
    private String name; //¥Î¤á¦W
    private String password; //±K½X
    private String action;
    private String forumMenu;
    private Collection categories;

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
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public String getForumMenu() {
        return forumMenu;
    }
    public void setForumMenu(String forumMenu) {
        this.forumMenu = forumMenu;
    }
    public Collection getCategories() {
        return categories;
    }
    public void setCategories(Collection categories) {
        this.categories = categories;
    }

}