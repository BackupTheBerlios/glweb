/*
 *
 * $Id: ForumManagerTest.java,v 1.2 2003/05/12 09:36:54 paxson Exp $
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

import java.util.List;

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
 * @version  $Revision: 1.2 $ $Date: 2003/05/12 09:36:54 $
 */
public class ForumManagerTest extends ServletTestCase {

    public ForumManagerTest(String name) {
        super(name);
    }
    
    public static Test suite() {
        return new TestSuite(ForumManagerTest.class);
    }
    
    /**
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        
        JUnitForumHelper.addUsers();
        
        JUnitForumHelper.deleteCategoriesAndMessages();
        
        JUnitForumHelper.addCategoriesAndMessages();
    }

    /**
     * @see junit.framework.TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        JUnitForumHelper.deleteCategoriesAndMessages();
    }
    
    protected ForumManager getForumManager() {
        return ForumManager.getInstance();
    }
    
    protected void assertCategory(Category category, String name) {
        assertEquals(name, category.getName());
        assertEquals("Description of " + name + " Category", category.getDescription());
        assertNotNull(category.getCreationDate());
        assertNotNull(category.getModifiedDate());
        
        // assert parent categories
        assertNull(category.getParentCategory());
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
                    assertCategory(_category, "Java");
                } else if ("JXTA".equals(_category.getName())) {
                    assertCategory(_category, "JXTA");
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
                    assertCategory(_category, "Java");
                } else if ("JXTA".equals(_category.getName())) {
                    assertCategory(_category, "JXTA");
                }
            }
        } catch (Exception e) {
            getLogger().error(e);
            fail(e.toString());
        }
    }

    public void testAddCategory() {
        try {
            Category _category = JUnitForumHelper.buildCategory("J2EE");
            
            getForumManager().addCategory(_category);
            
            assertEquals(3, getForumManager().getRootCategories().size());
            assertCategory(JUnitForumHelper.getCategoryByName("J2EE"), "J2EE");
        } catch (Exception e) {
            getLogger().error(e);
            fail(e.toString());
        }
    }

    public void testUpdateCategory() {
        try {
            String _newName = "Java - Updated";
            String _newDescription = "Description of Java Category - Updated";
            
            Category _javaCategory = JUnitForumHelper.getCategoryByName("Java");
            
            _javaCategory.setName(_newName);
            _javaCategory.setDescription(_newDescription);
            
            getForumManager().updateCategory(_javaCategory);
            
            // assertion
            Hibernate.initialize(_javaCategory);
            
            assertNotNull(_javaCategory = JUnitForumHelper.getCategoryByName(_newName));
            assertEquals(_newDescription, _javaCategory.getDescription());
            assertTrue(_javaCategory.getCreationDate() != _javaCategory.getModifiedDate());
        } catch (Exception e) {
            getLogger().error(e);
            fail(e.toString());
        }
    }

    public void testDeleteCategory() {
        try {
            Category _category = null;
            
            _category = JUnitForumHelper.getCategoryByName("Java");
            getForumManager().deleteCategory(_category);
            assertEquals(1, getForumManager().getRootCategories().size());
            
            _category = JUnitForumHelper.getCategoryByName("JXTA");
            getForumManager().deleteCategory(_category);
            assertEquals(0, getForumManager().getRootCategories().size());
        } catch (Exception e) {
            getLogger().error(e);
            fail(e.toString());
        }
    }

    /*
    public void testGetMessage() {
        try {
            
        } catch (Exception e) {
            getLogger().error(e);
            fail(e.toString());
        }
    }
    */

    public void testAddMessage() {
        try {
            int _loop = 10;
            Category _category = JUnitForumHelper.getCategoryByName("Java");
            
            Message _message = null;
            
            for (int _i=0; _i<_loop; _i++) {
                _message = JUnitForumHelper.buildMassage(_category, _i);
                getForumManager().addMessage(_message);
            }
            
            _category = JUnitForumHelper.getCategoryByName("Java");
            
            assertEquals(_loop, getForumManager().getMessages(_category).size());
        } catch (Exception e) {
            getLogger().error(e);
            fail(e.toString());
        }
    }

    /*
    public void testUpdateMessage() {
        try {
            
        } catch (Exception e) {
            getLogger().error(e);
            fail(e.toString());
        }
    }

    public void testDeleteMessage() {
        try {
            
        } catch (Exception e) {
            getLogger().error(e);
            fail(e.toString());
        }
    }
    */
    
    public void testGetMessages() {
        try {
        try {
            int _loop = 10;
            Category _category = JUnitForumHelper.getCategoryByName("Java");
            
            Message _message = null;
            
            for (int _i=0; _i<_loop; _i++) {
                _message = JUnitForumHelper.buildMassage(_category, _i);
                getForumManager().addMessage(_message);
            }
            
            _category = JUnitForumHelper.getCategoryByName("Java");
            
            assertEquals(_loop, getForumManager().getMessages(_category).size());
        } catch (Exception e) {
            getLogger().error(e);
            fail(e.toString());
        }
        } catch (Exception e) {
            getLogger().error(e);
            fail(e.toString());
        }
    }

}
