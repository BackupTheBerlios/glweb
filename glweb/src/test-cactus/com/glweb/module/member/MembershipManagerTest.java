/*
 * Created on 2003/5/7
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.glweb.module.member;

import java.util.Collection;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.apache.cactus.ServletTestCase;

import com.glweb.module.member.MembershipManager;
import com.glweb.module.member.model.User;
import com.glweb.module.member.model.UserProfile;

/**
 * @author Administrator
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class MembershipManagerTest extends ServletTestCase{

	private long m_userA_Id ;
	private long m_userB_Id ;

	/**
	 * 
	 */
	public MembershipManagerTest() {
		super();
	}
	
	public MembershipManagerTest(String name) {
		super(name);
	}	

	public static Test suite() {
		return new TestSuite(MembershipManagerTest.class);
	}
	
	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		User _userA = this.getMembershipManager().createUser("kocaA","iamkocaA","kocaA@siwi.com.tw");
		m_userA_Id = _userA.getId();
		

		User _userB = this.setUserKoca_B(
						this.getMembershipManager().createUser("kocaB","iamkocaB","kocaB@siwi.com.tw")
						);
		_userB.setUserProfile(this.getUserProfileKoca_B());					
		this.getMembershipManager().updateUser(_userB);
		m_userB_Id = _userB.getId();
		
		
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		
		if(this.getMembershipManager().getUser(m_userA_Id)!=null)
			this.getMembershipManager().removeUser(m_userA_Id);
		if(this.getMembershipManager().getUser(m_userB_Id)!=null)
			this.getMembershipManager().removeUser(m_userB_Id);
		
	}	
	
	
	
	protected MembershipManager getMembershipManager(){
		return MembershipManager.getInstance();
	}	
	
	public void testCreateUser(){
		User _user = this.getMembershipManager().createUser("koca","iamkoca","koca@siwi.com.tw");
		
		assertNotNull(_user);
		assertTrue(0 != _user.getId());
		assertEquals("koca", _user.getName());
		assertEquals("iamkoca", _user.getPassword());
		assertEquals("koca@siwi.com.tw", _user.getEmail());
		assertNull(_user.getUserProfile());
		
		this.getMembershipManager().removeUser(_user.getId());
		
	}

	public void testGetUserByName(){

		/*
		 * for the USER : koca_A
		 */
		User _userA = this.getMembershipManager().getUserByName("kocaA");

		// assertion
		assertNotNull(_userA);
		assertTrue(0 != _userA.getId());
		assertEquals("kocaA", _userA.getName());
		assertEquals("iamkocaA", _userA.getPassword());
		assertEquals("kocaA@siwi.com.tw", _userA.getEmail());
		assertNull(_userA.getUserProfile());

		/*
		 * for the USER : koca_B
		 */
		User _userB = this.getMembershipManager().getUserByName("kocaB");

		// assertion
		assertNotNull(_userB);
		assertTrue(0 != _userB.getId());
		assertEquals("kocaB", _userB.getName());
		assertEquals("BBBB", _userB.getPassword());
		assertEquals("kocaUserB@siwi.com.tw", _userB.getEmail());
		assertEquals(20,_userB.getAge());
		assertEquals("KC_B",_userB.getFirstName());
		assertEquals("Chen",_userB.getLastName());
		assertEquals(true,_userB.getSex());
		assertEquals("TAIPEI",_userB.getCity());
		assertEquals("TAIWAN",_userB.getCountry());
		assertEquals("E",_userB.getStarSign());		
		assertEquals("kocaB.siwi.com.tw",_userB.getHomePage());
		
		assertNotNull(_userB.getUserProfile());	
		assertEquals("This is KOCA[B]'s motto.",_userB.getUserProfile().getMotto());
		assertEquals("This is KOCA[B]'s NEW Hobby.",_userB.getUserProfile().getPimHobby());
		assertEquals("This is KOCA[B]'s NEW Introduction.",_userB.getUserProfile().getPimIntroduction());
		assertEquals("This is KOCA[B]'s NEW Sign.",_userB.getUserProfile().getPimSign());
				
	}
	
	public void testGetUsers(){
		Collection _users = getMembershipManager().getUsers();
		assertNotNull(_users);
		assertTrue(!_users.isEmpty());
	}
	
	public void testUpdateUser(){
		
		User _user = null;
		User _updateUser = null;
		
		/*
		 * for the USER : koca_A
		 */		
		User _userA = this.getMembershipManager().getUserByName("kocaA");		
		if (_userA != null){
			_user = this.setUserKoca_A(_userA);
			_updateUser = this.getMembershipManager().updateUser(_user);

			// assertion
			assertNotNull(_updateUser);
			assertTrue(0 != _updateUser.getId());
			assertEquals(19,_updateUser.getAge());
			assertEquals("KC",_updateUser.getFirstName());
			assertEquals("Chen",_updateUser.getLastName());
			assertEquals(true,_updateUser.getSex());
			assertEquals("TAIPEI_A",_updateUser.getCity());
			assertEquals("TAIWAN_A",_updateUser.getCountry());
			assertEquals("¤ô²~",_updateUser.getStarSign());		
			assertEquals("koca.siwi.com.tw",_updateUser.getHomePage());
		}else{
			fail("Can't get the user, kocaA.");
		}
		
		/*
		 * for the USER : koca_B1
		 */		
		User _userB = this.getMembershipManager().getUserByName("kocaB");		
		if (_userB != null){
			_user = this.setUserKoca_B1(_userB);
			_updateUser = this.getMembershipManager().updateUser(_user);

			// assertion
			assertNotNull(_updateUser);
			assertTrue(0 != _updateUser.getId());
			assertEquals("bbbb", _updateUser.getPassword());
			assertEquals("kocaUserB1@siwi.com.tw", _updateUser.getEmail());
			assertEquals(21,_updateUser.getAge());
			assertEquals("KC_B1",_updateUser.getFirstName());
			assertEquals("Chen",_updateUser.getLastName());
			assertEquals(false,_updateUser.getSex());
			assertEquals("TAIPEI",_updateUser.getCity());
			assertEquals("TAIWAN",_updateUser.getCountry());
			assertEquals("M",_updateUser.getStarSign());		
			assertEquals("kocaB1.siwi.com.tw",_updateUser.getHomePage());
		}else{
			fail("Can't get the user, kocaB1.");
		}		
		
	}
	
	public void testUpdateUserProfile(){

		User _user = null;
		User _updateUser = null;
		
		/*
		 * for the USER : koca_A
		 */		
		User _userA = this.getMembershipManager().getUserByName("kocaA");		
		if (_userA != null){
			_user = _userA ;
			_user.setUserProfile(this.getUserProfileKoca_A());
			_updateUser = this.getMembershipManager().updateUser(_user);

			// assertion
			assertNotNull(_updateUser);
			assertNotNull(_updateUser.getUserProfile());	
			assertEquals("This is KOCA[A]'s motto.",_updateUser.getUserProfile().getMotto());
			assertEquals("This is KOCA[A]'s Hobby.",_updateUser.getUserProfile().getPimHobby());
			assertEquals("This is KOCA[A]'s Introduction.",_updateUser.getUserProfile().getPimIntroduction());
			assertEquals("This is KOCA[A]'s Sign.",_updateUser.getUserProfile().getPimSign());
		}else{
			fail("Can't get the user, kocaA.");
		}
		
		/*
		 * for the USER : koca_B1
		 */		
		User _userB = this.getMembershipManager().getUserByName("kocaB");		
		if (_userB != null){
			_user = _userB ;
			_user.setUserProfile(this.getUserProfileKoca_B1());
			_updateUser = this.getMembershipManager().updateUser(_user);

			// assertion
			assertNotNull(_updateUser);
			assertNotNull(_updateUser.getUserProfile());	
			assertEquals("This is KOCA[B1]'s motto.",_updateUser.getUserProfile().getMotto());
			assertEquals("This is KOCA[B1]'s NEW Hobby.",_updateUser.getUserProfile().getPimHobby());
			assertEquals("This is KOCA[B1]'s NEW Introduction.",_updateUser.getUserProfile().getPimIntroduction());
			assertEquals("This is KOCA[B1]'s NEW Sign.",_updateUser.getUserProfile().getPimSign());
		}else{
			fail("Can't get the user, kocaB1.");
		}		
				
	}

	public void testRemoveUser(){	
		
		/*
		 * for the USER : koca_A
		 */
		if (this.getMembershipManager().removeUser(m_userA_Id)){
			User _userA = this.getMembershipManager().getUser(m_userA_Id);
			assertNull(_userA);
		}else{
			fail("Can't remove the user, koca_A.");
		}
		
		/*
		 * for the USER : koca_B
		 */
		if (this.getMembershipManager().removeUserByName("kocaB")){
			User _userB = this.getMembershipManager().getUserByName("kocaB");
			assertNull(_userB);
		}else{
			fail("Can't remove the user, koca_B.");
		}			
		
	}

	
	protected User setUserKoca_A(User user){
		
		user.setAge(19);
		user.setFirstName("KC");
		user.setLastName("Chen");
		user.setSex(true);
		user.setCity("TAIPEI_A");
		user.setCountry("TAIWAN_A");
		user.setStarSign("¤ô²~");
		user.setHomePage("koca.siwi.com.tw");
		
		return user;
	}	

	protected User setUserKoca_B(User user){
		
		user.setEmail("kocaUserB@siwi.com.tw");
		user.setPassword("BBBB");
		
		user.setAge(20);
		user.setFirstName("KC_B");
		user.setLastName("Chen");
		user.setSex(true);
		user.setCity("TAIPEI");
		user.setCountry("TAIWAN");
		user.setStarSign("E");
		user.setHomePage("kocaB.siwi.com.tw");
		
		return user;
	}	

	protected User setUserKoca_B1(User user){
		
		user.setEmail("kocaUserB1@siwi.com.tw");
		user.setPassword("bbbb");
		
		user.setAge(21);
		user.setFirstName("KC_B1");
		user.setLastName("Chen");
		user.setSex(false);
		user.setCity("TAIPEI");
		user.setCountry("TAIWAN");
		user.setStarSign("M");
		user.setHomePage("kocaB1.siwi.com.tw");
		
		return user;
	}		
	
	protected UserProfile getUserProfileKoca_A(){
		UserProfile profile = new UserProfile();
		profile.setMotto("This is KOCA[A]'s motto.");
		profile.setPimHobby("This is KOCA[A]'s Hobby.");
		profile.setPimIntroduction("This is KOCA[A]'s Introduction.");
		profile.setPimSign("This is KOCA[A]'s Sign.");
		return profile;
	}
	
	protected UserProfile getUserProfileKoca_B(){
		UserProfile profile = new UserProfile();
		profile.setMotto("This is KOCA[B]'s motto.");
		profile.setPimHobby("This is KOCA[B]'s NEW Hobby.");
		profile.setPimIntroduction("This is KOCA[B]'s NEW Introduction.");
		profile.setPimSign("This is KOCA[B]'s NEW Sign.");
		return profile;
	}

	protected UserProfile getUserProfileKoca_B1(){
		UserProfile profile = new UserProfile();
		profile.setMotto("This is KOCA[B1]'s motto.");
		profile.setPimHobby("This is KOCA[B1]'s NEW Hobby.");
		profile.setPimIntroduction("This is KOCA[B1]'s NEW Introduction.");
		profile.setPimSign("This is KOCA[B1]'s NEW Sign.");
		return profile;
	}	
	
	
	
	
	


}
