package com.glweb.module.forum.action;

import java.util.Collection;

import com.glweb.module.forum.ForumManager;
import com.glweb.module.forum.model.Category;
import com.glweb.module.forum.model.Message;
import com.glweb.module.member.MembershipManager;
import com.glweb.module.member.model.User;
import java.util.Iterator;
import java.util.Set;
import java.util.ArrayList;

public class ForumActionHelper {
    public static Collection getAllCategory(){
        return ForumManager.getInstance().getRootCategories();
    }

    public static Collection getMessages(Category category){
        return ForumManager.getInstance().getMessages(category);
    }

    public static Category getCategoryById(String categoryId){
        return ForumManager.getInstance().getCategory(Long.parseLong(categoryId));
    }

    public static Message getMessageById(String messageId){
        return ForumManager.getInstance().getMessage(Long.parseLong(messageId));
    }

    public static User validateUser(String name, String password) {
        User user = MembershipManager.getInstance().getUserByName(name);
        if (user != null) {
            if (!user.getPassword().equals(password)) {
                user = null;
            }
        }
        return user;
    }

    public static Collection getAllChildCategory(Collection allCategory) {
        Collection allChildCategory = new ArrayList();
        Iterator iter = allCategory.iterator();
        Category tmp1 = null;
        while(iter.hasNext()){
            tmp1 = (Category)iter.next();
            Set childCategory = tmp1.getChildrenCategories();
            Iterator iter2 = childCategory.iterator();
            while(iter2.hasNext()){
                Category c = (Category)iter2.next();
                allChildCategory.add(c);
            }
        }
        return allChildCategory;
    }
}