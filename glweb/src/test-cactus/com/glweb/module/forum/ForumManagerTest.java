/*
 *
 * $Id: ForumManagerTest.java,v 1.1 2003/05/10 11:41:13 paxson Exp $
 *
 * Copyright (c) 2003 SIWI.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a 
 * copy of this software and associated documentation files (the 
 * "Software"), to deal in the Software without restriction, including 
 * without limitation the rights to use, copy, modify, merge, publish, 
 * distribute, sublicense, and/or sell copies of the Software, and to 
 * permit persons to whom the Software is furnished to do so, subject to 
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included 
 * in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF 
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY 
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, 
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.glweb.module.forum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.apache.cactus.ServletTestCase;

import net.sf.hibernate.Hibernate;

import com.glweb.module.forum.model.Category;
import com.glweb.module.forum.model.Message;

/**
 * ForumManagerTest
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/05/10 11:41:13 $
 */
public class ForumManagerTest extends ServletTestCase {

    public ForumManagerTest(String name) {
        super(name);
    }
    
    public static Test suite() {
        return new TestSuite(ForumManagerTest.class);
    }
    
    protected ForumManager getForumManager() {
        return ForumManager.getInstance();
    }
    
    /**
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        
        JUnitForumHelper.addUsers();
        
        deleteCategoriesAndMessages();
        
        addCategoriesAndMessages();
    }

    /**
     * @see junit.framework.TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        deleteCategoriesAndMessages();
    }
    
    protected Set buildModerators() {
        Set _moderators = new HashSet();
        
        _moderators.add(JUnitForumHelper.getPosterPaxson());
        _moderators.add(JUnitForumHelper.getPosterCat());
        
        return _moderators;
    }
    
    protected void addCategoriesAndMessages() {
        getLogger().info("<addCategoriesAndMessages()>");
        
        long _javaId = 0;
        long _jspId = 0;
        long _jxtaId = 0;
        
        Category _category = null;
        
        // java category - root
        Category _javaCategory = new Category();
        _javaCategory.setName("Java");
        _javaCategory.setDescription("Description of Java Category");

        _javaId = getForumManager().addCategory(_javaCategory);
        _category = getForumManager().getCategory(_javaId);
        
        Message _javaMessage1 = new Message();
        _javaMessage1.setSubject("Subject of Java Message 1");
        _javaMessage1.setMessage("Message of Java Message 1");
        _javaMessage1.setPoster(JUnitForumHelper.getPosterPaxson());
        _javaMessage1.setCategory(_category);
        
        getForumManager().addMessage(_javaMessage1);
        
        Message _javaMessage2 = new Message();
        _javaMessage2.setSubject("Subject of Java Message 2");
        _javaMessage2.setMessage("Message of Java Message 2");
        _javaMessage2.setPoster(JUnitForumHelper.getPosterCat());
        _javaMessage2.setCategory(_category);
        
        getForumManager().addMessage(_javaMessage2);
        
        // jsp category - child of java
        _category = getForumManager().getCategory(_javaId);
        
        Category _jspCategory = new Category();
        _jspCategory.setName("JSP");
        _jspCategory.setDescription("Description of JSP Category");
        _jspCategory.setParentCategory(_category);
        
        _jspId = getForumManager().addCategory(_jspCategory);
        _category = getForumManager().getCategory(_jspId);
        
        Message _jspMessage1 = new Message();
        _jspMessage1.setSubject("Subject of JSP Message 1");
        _jspMessage1.setMessage("Message of JSP Message 1");
        _jspMessage1.setPoster(JUnitForumHelper.getPosterPaxson());
        _jspMessage1.setCategory(_category);
        
        getForumManager().addMessage(_jspMessage1);
        
        Message _jspMessage2 = new Message();
        _jspMessage2.setSubject("Subject of JSP Message 2");
        _jspMessage2.setMessage("Message of JSP Message 2");
        _jspMessage2.setPoster(JUnitForumHelper.getPosterCat());
        _jspMessage2.setCategory(_category);
        
        getForumManager().addMessage(_jspMessage2);
        
        // jxta category - root
        Category _jxtaCategory = new Category();
        _jxtaCategory.setName("JXTA");
        _jxtaCategory.setDescription("Description of JXTA Category");
        
        _jxtaId = getForumManager().addCategory(_jxtaCategory);
        _category = getForumManager().getCategory(_jxtaId);
        
        Message _jxtaMessage1 = new Message();
        _jxtaMessage1.setSubject("Subject of JXTA Message 1");
        _jxtaMessage1.setMessage("Message of JXTA Message 1");
        _jxtaMessage1.setPoster(JUnitForumHelper.getPosterPaxson());
        _jxtaMessage1.setCategory(_category);
        
        getForumManager().addMessage(_jxtaMessage1);
        
        Message _jxtaMessage2 = new Message();
        _jxtaMessage2.setSubject("Subject of JXTA Message 2");
        _jxtaMessage2.setMessage("Message of JXTA Message 2");
        _jxtaMessage2.setPoster(JUnitForumHelper.getPosterCat());
        _jxtaMessage2.setCategory(_category);
        _jxtaMessage2.addParentMessage(_jxtaMessage1);
        
        getForumManager().addMessage(_jxtaMessage2);
        
        assertEquals(2, getForumManager().getRootCategories().size());
        
        getLogger().info("</addCategoriesAndMessages()>");
    }
    
    protected void deleteCategoriesAndMessages() {
        getLogger().info("<deleteCategoriesAndMessages()>");
        
        Category[] _categories = 
                (Category[]) getForumManager().getRootCategories().toArray(new Category[0]);
        
        getLogger().info("<Tere is/are " + _categories.length + 
                " existing root category/categories in repository/>");

        for (int _i=0; _i<_categories.length; _i++) {
            getForumManager().deleteCategory(_categories[_i]);
        }
        
        assertEquals(0, getForumManager().getRootCategories().size());
        
        getLogger().info("</deleteCategoriesAndMessages()>");
    }
    
    protected Category getCategoryByName(String name) {
        Category[] _categories = 
                (Category[]) getForumManager().getRootCategories().toArray(new Category[0]);

        for (int _i=0; _i<_categories.length; _i++) {
            if (name.equals(_categories[_i].getName())) {
                return _categories[_i];
            }
        }
        
        return null;
    }
    
    protected void assertJavaCategory(Category category) {
        assertJavaCategory(category, true);
    }
    
    protected void assertJavaCategory(Category category, boolean assertChildren) {
        getLogger().info("<assertJavaCategory(Category)>");
        
        assertEquals("Java", category.getName());
        assertEquals("Description of Java Category", category.getDescription());
        assertNotNull(category.getCreationDate());
        assertNotNull(category.getModifiedDate());
        
        // assert messages
        Message _message = null;
        Message[] _messages = 
                (Message[]) getForumManager().getMessages(category).toArray(new Message[0]);
                
        assertEquals(2, _messages.length);
        
        for (int _i=0; _i<_messages.length; _i++) {
            _message = _messages[_i];
            
            if ("Subject of Java Message 1".equals(_message.getSubject())) {
                assertEquals("Message of Java Message 1", _message.getMessage());
                assertNotNull(_message.getCreationDate());
                assertNotNull(_message.getModifiedDate());
                assertEquals(JUnitForumHelper.getPosterPaxson(), _message.getPoster());
                assertEquals(0, _message.getParentMessages().size());
                assertEquals(0, _message.getReplyMessages().size());
            } else if ("Subject of Java Message 2".equals(_message.getSubject())) {
                assertEquals("Message of Java Message 2", _message.getMessage());
                assertNotNull(_message.getCreationDate());
                assertNotNull(_message.getModifiedDate());
                assertEquals(JUnitForumHelper.getPosterCat(), _message.getPoster());
                assertEquals(0, _message.getParentMessages().size());
                assertEquals(0, _message.getReplyMessages().size());
            }
        }
        
        // assert parent categories
        assertNull(category.getParentCategory());
        
        // assert children categories
        assertEquals(1, category.getChildrenCategories().size());
        Category[] _childrenCategories = 
                (Category[]) category.getChildrenCategories().toArray(new Category[0]);
        
        if (assertChildren) {
            assertJSPCategory(_childrenCategories[0]);
        }
        
        getLogger().info("</assertJavaCategory(Category)>");
    }
    
    protected void assertJXTACategory(Category category) {
        getLogger().info("<assertJXTACategory(Category)>");
        
        assertEquals("JXTA", category.getName());
        assertEquals("Description of JXTA Category", category.getDescription());
        assertNotNull(category.getCreationDate());
        assertNotNull(category.getModifiedDate());
        
        // assert messages
        Message _message = null;
        Message[] _messages = 
                (Message[]) getForumManager().getMessages(category).toArray(new Message[0]);
                
        assertEquals(2, _messages.length);
        
        for (int _i=0; _i<_messages.length; _i++) {
            _message = _messages[_i];
            
            if ("Subject of JXTA Message 1".equals(_message.getSubject())) {
                assertEquals("Message of JXTA Message 1", _message.getMessage());
                assertNotNull(_message.getCreationDate());
                assertNotNull(_message.getModifiedDate());
                assertEquals(JUnitForumHelper.getPosterPaxson(), _message.getPoster());
                assertEquals(0, _message.getParentMessages().size());
                assertEquals(1, _message.getReplyMessages().size());
            } else if ("Subject of JXTA Message 2".equals(_message.getSubject())) {
                assertEquals("Message of JXTA Message 2", _message.getMessage());
                assertNotNull(_message.getCreationDate());
                assertNotNull(_message.getModifiedDate());
                assertEquals(JUnitForumHelper.getPosterCat(), _message.getPoster());
                assertEquals(1, _message.getParentMessages().size());
                assertEquals(0, _message.getReplyMessages().size());
            }
        }
        
        // assert parent categories
        assertNull(category.getParentCategory());
        
        // assert children categories
        assertEquals(0, category.getChildrenCategories().size());
        
        getLogger().info("</assertJXTACategory(Category)>");
    }
    
    protected void assertJSPCategory(Category category) {
        getLogger().info("<assertJSPCategory(Category)>");
        
        assertEquals("JSP", category.getName());
        assertEquals("Description of JSP Category", category.getDescription());
        assertNotNull(category.getCreationDate());
        assertNotNull(category.getModifiedDate());
        
        // assert messages
        Message _message = null;
        Message[] _messages = 
                (Message[]) getForumManager().getMessages(category).toArray(new Message[0]);
                
        assertEquals(2, _messages.length);
        
        for (int _i=0; _i<_messages.length; _i++) {
            _message = _messages[_i];
            
            if ("Subject of JSP Message 1".equals(_message.getSubject())) {
                assertEquals("Message of JSP Message 1", _message.getMessage());
                assertNotNull(_message.getCreationDate());
                assertNotNull(_message.getModifiedDate());
                assertEquals(JUnitForumHelper.getPosterPaxson(), _message.getPoster());
                assertEquals(0, _message.getParentMessages().size());
                assertEquals(0, _message.getReplyMessages().size());
            } else if ("Subject of JSP Message 2".equals(_message.getSubject())) {
                assertEquals("Message of JSP Message 2", _message.getMessage());
                assertNotNull(_message.getCreationDate());
                assertNotNull(_message.getModifiedDate());
                assertEquals(JUnitForumHelper.getPosterCat(), _message.getPoster());
                assertEquals(0, _message.getParentMessages().size());
                assertEquals(0, _message.getReplyMessages().size());
            }
        }
        
        // assert parent categories
        assertNotNull(category.getParentCategory());
        assertJavaCategory(category.getParentCategory(), false);
        
        // assert children categories
        assertEquals(0, category.getChildrenCategories().size());
        
        getLogger().info("<assertJSPCategory(Category)>");
    }

    public void testGetCategory() {
        try {
            long _id = 0;
            Category _category = null;
            
            Category[] _categories = 
                    (Category[]) getForumManager().getRootCategories().toArray(
                            new Category[0]);
            
            assertNotNull(_categories);
            assertEquals(2, _categories.length);
            
            for (int _i=0; _i<_categories.length; _i++) {
                _id = _categories[_i].getId();
                _category = getForumManager().getCategory(_id);
                
                if ("Java".equals(_category.getName())) {
                    assertJavaCategory(_category);
                } else if ("JXTA".equals(_category.getName())) {
                    assertJXTACategory(_category);
                }
            }
        } catch (Exception e) {
            getLogger().error(e);
            fail(e.toString());
        }
    }
    
    public void testGetRootCategories() {
        try {
            Category _category = null;
            List _categories = (List) getForumManager().getRootCategories();
            
            assertNotNull(_categories);
            assertEquals(2, _categories.size());
            
            for (int _i=0; _i<_categories.size(); _i++) {
                _category = (Category) _categories.get(_i);
                
                if ("Java".equals(_category.getName())) {
                    assertJavaCategory(_category);
                } else if ("JXTA".equals(_category.getName())) {
                    assertJXTACategory(_category);
                }
            }
        } catch (Exception e) {
            getLogger().error(e);
            fail(e.toString());
        }
    }

    public void testAddCategory() {
        try {
            // <init environment>
            getForumManager().deleteCategory(getCategoryByName("Java"));
        
            assertEquals(1, getForumManager().getRootCategories().size());
            // </init environment>
            
            long _javaId = 0;
            long _jspId = 0;
            
            Category _category = null;
            
            // java category - root
            Category _javaCategory = new Category();
            _javaCategory.setName("Java");
            _javaCategory.setDescription("Description of Java Category");

            _javaId = getForumManager().addCategory(_javaCategory);
            _category = getForumManager().getCategory(_javaId);
        
            Message _javaMessage1 = new Message();
            _javaMessage1.setSubject("Subject of Java Message 1");
            _javaMessage1.setMessage("Message of Java Message 1");
            _javaMessage1.setPoster(JUnitForumHelper.getPosterPaxson());
            _javaMessage1.setCategory(_category);
        
            getForumManager().addMessage(_javaMessage1);
        
            Message _javaMessage2 = new Message();
            _javaMessage2.setSubject("Subject of Java Message 2");
            _javaMessage2.setMessage("Message of Java Message 2");
            _javaMessage2.setPoster(JUnitForumHelper.getPosterCat());
            _javaMessage2.setCategory(_category);
        
            getForumManager().addMessage(_javaMessage2);
        
            // jsp category - child of java
            _category = getForumManager().getCategory(_javaId);
        
            Category _jspCategory = new Category();
            _jspCategory.setName("JSP");
            _jspCategory.setDescription("Description of JSP Category");
            _jspCategory.setParentCategory(_category);
        
            _jspId = getForumManager().addCategory(_jspCategory);
            _category = getForumManager().getCategory(_jspId);
        
            Message _jspMessage1 = new Message();
            _jspMessage1.setSubject("Subject of JSP Message 1");
            _jspMessage1.setMessage("Message of JSP Message 1");
            _jspMessage1.setPoster(JUnitForumHelper.getPosterPaxson());
            _jspMessage1.setCategory(_category);
        
            getForumManager().addMessage(_jspMessage1);
        
            Message _jspMessage2 = new Message();
            _jspMessage2.setSubject("Subject of JSP Message 2");
            _jspMessage2.setMessage("Message of JSP Message 2");
            _jspMessage2.setPoster(JUnitForumHelper.getPosterCat());
            _jspMessage2.setCategory(_category);
        
            getForumManager().addMessage(_jspMessage2);
            
            assertEquals(2, getForumManager().getRootCategories().size());
            assertJavaCategory(getCategoryByName("Java"));
        } catch (Exception e) {
            getLogger().error(e);
            fail(e.toString());
        }
    }

    public void testUpdateCategory() {
        try {
            String _newName = "Java - Updated";
            String _newDescription = "Description of Java Category - Updated";
            
            Category _javaCategory = getCategoryByName("Java");
            
            _javaCategory.setName(_newName);
            _javaCategory.setDescription(_newDescription);
            _javaCategory.setModerators(buildModerators());
            
            getForumManager().updateCategory(_javaCategory);
            
            // assertion
            Hibernate.initialize(_javaCategory);
            
            assertNotNull(_javaCategory = getCategoryByName(_newName));
            assertEquals(_newDescription, _javaCategory.getDescription());
            assertTrue(_javaCategory.getCreationDate() != _javaCategory.getModifiedDate());
            //assertEquals(2, _javaCategory.getModerators().size());
            //assertTrue(_javaCategory.getModerators().containsAll(buildModerators()));
        } catch (Exception e) {
            getLogger().error(e);
            fail(e.toString());
        }
    }

    public void testDeleteCategory() {
        try {
            Category _category = null;
            
            _category = getCategoryByName("Java");
            getForumManager().deleteCategory(_category);
            assertEquals(1, getForumManager().getRootCategories().size());
            
            _category = getCategoryByName("JXTA");
            getForumManager().deleteCategory(_category);
            assertEquals(0, getForumManager().getRootCategories().size());
        } catch (Exception e) {
            getLogger().error(e);
            fail(e.toString());
        }
    }

    /*
    public void testGetMessage() {
    }

    public void testAddMessage() {
    }

    public void testUpdateMessage() {
    }

    public void testDeleteMessage() {
    }
    
    public void testGetMessages() {
    }
    */

}
