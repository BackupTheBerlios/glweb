package com.glweb.module.forum.action;

import java.util.Collection;

import com.glweb.module.forum.ForumManager;
import com.glweb.module.forum.model.Category;
import com.glweb.module.forum.model.Message;

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

    public static Message getMessage(String messageId){
        return ForumManager.getInstance().getMessage(Long.parseLong(messageId));
    }
}