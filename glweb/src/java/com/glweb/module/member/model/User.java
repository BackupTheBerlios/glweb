/*
 *
 * $Id: User.java,v 1.2 2003/05/17 10:16:53 kocachen Exp $
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

package com.glweb.module.member.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User
 *
 * @author   $Author: kocachen $
 * @version  $Revision: 1.2 $ $Date: 2003/05/17 10:16:53 $
 */
public class User extends AbstractMemberValueObject {

	private Date m_CreationDate;		  //註冊日期
	private Date m_LastModifiedDate;	      //最後修改日期
    private String m_UserName;        //用戶名稱
	private String m_Password;        //用戶密碼      
	private String m_Email;           //電子郵件      
	private String m_LastName;        //真實名字      
	private String m_FirstName;       //你的姓氏      
	private String m_City;            //居住城市      
	private String m_State;           //所在省分      
	private String m_Country;         //國家地區      
	private int m_Age;                //年齡          
	private boolean m_Sex;             //性別          
	private String m_Position;        //現任職務      
	private boolean m_EmailIsVisiable; //不顯示信箱位址
	private String m_StarSign;        //星座          
	private String m_IcqNo;           //ICQ號碼       
	private String m_MsnNo;           //MSN Messenger 
	private String m_HomePage;        //個人首頁      
	private String m_PimImage;        //個性圖片      
	private String m_PimImgUrl;       //自訂大頭貼圖址
	private int m_PimImgWidth;     //自訂大頭貼寬度
	private int m_PimImgHeight;    //自訂大頭貼高度    
	
	private UserProfile m_UserProfile;
    
	public User() {
	}

	/**
	 * Returns the name.
	 * 
	 * @return String
	 */
	public String getName() {
		return m_UserName;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name The name to set
	 */
	public void setName(String name) {
		m_UserName = name;
	}

	/**
	 * @return String
	 */
	public int getAge() {
		return m_Age;
	}

	/**
	 * @return String
	 */
	public String getCity() {
		return m_City;
	}

	/**
	 * @return String
	 */
	public String getCountry() {
		return m_Country;
	}

	/**
	 * @return String
	 */
	public String getEmail() {
		return m_Email;
	}

	/**
	 * @return String
	 */
	public boolean getEmailIsVisiable() {
		return m_EmailIsVisiable;
	}

	/**
	 * @return String
	 */
	public String getFirstName() {
		return m_FirstName;
	}

	/**
	 * @return String
	 */
	public String getHomePage() {
		return m_HomePage;
	}

	/**
	 * @return String
	 */
	public String getIcqNo() {
		return m_IcqNo;
	}

	/**
	 * @return String
	 */
	public String getLastName() {
		return m_LastName;
	}

	/**
	 * @return String
	 */
	public String getMsnNo() {
		return m_MsnNo;
	}

	/**
	 * @return String
	 */
	public String getPassword() {
		return m_Password;
	}

	/**
	 * @return String
	 */
	public String getPimImage() {
		return m_PimImage;
	}

	/**
	 * @return String
	 */
	public int getPimImgHeight() {
		return m_PimImgHeight;
	}

	/**
	 * @return String
	 */
	public String getPimImgUrl() {
		return m_PimImgUrl;
	}

	/**
	 * @return String
	 */
	public int getPimImgWidth() {
		return m_PimImgWidth;
	}

	/**
	 * @return String
	 */
	public String getPosition() {
		return m_Position;
	}

	/**
	 * @return boolean True:Male ; False:Famale
	 */
	public boolean getSex() {
		return m_Sex;
	}

	/**
	 * @return String
	 */
	public String getStarSign() {
		return m_StarSign;
	}

	/**
	 * @return String
	 */
	public String getState() {
		return m_State;
	}

	/**
	 * Sets the age.
	 * @param age The age to set
	 */
	public void setAge(int age) {
		m_Age = age;
		super.setUpdateFlag();
	}

	/**
	 * Sets the city.
	 * @param city The city to set
	 */
	public void setCity(String city) {
		m_City = city;
		super.setUpdateFlag();
	}

	/**
	 * Sets the country.
	 * @param country The country to set
	 */
	public void setCountry(String country) {
		m_Country = country;
		super.setUpdateFlag();
	}

	/**
	 * Sets the email.
	 * @param email The email to set
	 */
	public void setEmail(String email) {
		m_Email = email;
		super.setUpdateFlag();
	}

	/**
	 * Sets the emailIsVisiable.
	 * @param emailIsVisiable The emailIsVisiable to set
	 */
	public void setEmailIsVisiable(boolean emailIsVisiable) {
		m_EmailIsVisiable = emailIsVisiable;
		super.setUpdateFlag();
	}

	/**
	 * Sets the firstName.
	 * @param firstName The firstName to set
	 */
	public void setFirstName(String firstName) {
		m_FirstName = firstName;
		super.setUpdateFlag();
	}

	/**
	 * Sets the homePage.
	 * @param homePage The homePage to set
	 */
	public void setHomePage(String homePage) {
		m_HomePage = homePage;
		super.setUpdateFlag();
	}

	/**
	 * Sets the icqNo.
	 * @param icqNo The icqNo to set
	 */
	public void setIcqNo(String icqNo) {
		m_IcqNo = icqNo;
		super.setUpdateFlag();
	}

	/**
	 * Sets the lastName.
	 * @param lastName The lastName to set
	 */
	public void setLastName(String lastName) {
		m_LastName = lastName;
		super.setUpdateFlag();
	}

	/**
	 * Sets the msnNo.
	 * @param msnNo The msnNo to set
	 */
	public void setMsnNo(String msnNo) {
		m_MsnNo = msnNo;
		super.setUpdateFlag();
	}

	/**
	 * Sets the password.
	 * @param password The password to set
	 */
	public void setPassword(String password) {
		m_Password = password;
		super.setUpdateFlag();
	}

	/**
	 * Sets the pimImage.
	 * @param pimImage The pimImage to set
	 */
	public void setPimImage(String pimImage) {
		m_PimImage = pimImage;
		super.setUpdateFlag();
	}

	/**
	 * Sets the pimImgHeight.
	 * @param pimImgHeight The pimImgHeight to set
	 */
	public void setPimImgHeight(int pimImgHeight) {
		m_PimImgHeight = pimImgHeight;
		super.setUpdateFlag();
	}

	/**
	 * Sets the pimImgUrl.
	 * @param pimImgUrl The pimImgUrl to set
	 */
	public void setPimImgUrl(String pimImgUrl) {
		m_PimImgUrl = pimImgUrl;
		super.setUpdateFlag();
	}

	/**
	 * Sets the pimImgWidth.
	 * @param pimImgWidth The pimImgWidth to set
	 */
	public void setPimImgWidth(int pimImgWidth) {
		m_PimImgWidth = pimImgWidth;
		super.setUpdateFlag();
	}

	/**
	 * Sets the position.
	 * @param position The position to set
	 */
	public void setPosition(String position) {
		m_Position = position;
		super.setUpdateFlag();
	}

	/**
	 * Sets the sex.
	 * @param sex The sex to set; 
	 *            True:Male ; False:Famale
	 */
	public void setSex(boolean sex) {
		m_Sex = sex;
		super.setUpdateFlag();
	}

	/**
	 * Sets the starSign.
	 * @param starSign The starSign to set
	 */
	public void setStarSign(String starSign) {
		m_StarSign = starSign;
		super.setUpdateFlag();
	}

	/**
	 * Sets the state.
	 * @param state The state to set
	 */
	public void setState(String state) {
		m_State = state;
		super.setUpdateFlag();
	}

	/**
	 * @return UserProfile
	 */
	public UserProfile getUserProfile() {
		return m_UserProfile;
	}

	/**
	 * Sets the userProfile.
	 * @param userProfile The userProfile to set
	 */
	public void setUserProfile(UserProfile userProfile) {
		m_UserProfile = userProfile;
	}

	/**
	 * @return Date
	 */
	public Date getCreationDate() {
		return m_CreationDate;
	}

	/**
	 * @return Date
	 */
	public Date getLastModifiedDate() {
		return m_LastModifiedDate;
	}

	/**
	 * Sets the creationDate.
	 * @param creationDate The creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
			m_CreationDate = creationDate;
	}

	/**
	 * Sets the lastModifiedDate.
	 * @param lastModifiedDate The lastModifiedDate to set
	 */
	public void setLastModifiedDate(Date lastModifiedDate) {
		m_LastModifiedDate = lastModifiedDate;
	}
	

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer _buffer = new StringBuffer(50);
		
		_buffer.append(LINESEP);
		_buffer.append(super.toString());
		_buffer.append(LINESEP);
		_buffer.append("    CreationDate=");
		_buffer.append(new SimpleDateFormat("yyyy-MM-dd HH-mm-SS z").format(this.getCreationDate()));
		_buffer.append("    LastModifiedDate=");
		_buffer.append(new SimpleDateFormat("yyyy-MM-dd HH-mm-SS z").format(this.getLastModifiedDate()));

		_buffer.append("    UserName=");
		_buffer.append(this.getName());
		_buffer.append("    Password=");
		_buffer.append(this.getPassword());
		_buffer.append("    Email=");
		_buffer.append(this.getEmail());
		_buffer.append("    LastName=");
		_buffer.append(this.getLastName());
		_buffer.append("    FirstName=");
		_buffer.append(this.getFirstName());
		_buffer.append("    Sex=");
		_buffer.append(this.getSex());
		_buffer.append("    Age=");
		_buffer.append(this.getAge());
		_buffer.append("    StarSign=");
		_buffer.append(this.getStarSign());
		_buffer.append("    Position=");
		_buffer.append(this.getPosition());

		_buffer.append("    City=");
		_buffer.append(this.getCity());
		_buffer.append("    State=");
		_buffer.append(this.getState());
		_buffer.append("    Country=");
		_buffer.append(this.getCountry());

		_buffer.append("    ICQNO=");
		_buffer.append(this.getIcqNo());
		_buffer.append("    MSNNO=");
		_buffer.append(this.getMsnNo());
		_buffer.append("    HomePage=");
		_buffer.append(this.getHomePage());
		
		_buffer.append("    PimImage=");
		_buffer.append(this.getPimImage());
		_buffer.append("    PimImgUrl=");
		_buffer.append(this.getPimImgUrl());
		_buffer.append("    PimImgHeight=");
		_buffer.append(this.getPimImgHeight());
		_buffer.append("    PimImgWidth=");
		_buffer.append(this.getPimImgWidth());        
        
        _buffer.append("    ***** UserProfile **** ");
        _buffer.append((this.getUserProfile()==null)?null:(">>"+this.getUserProfile().toString()));
        
		return _buffer.toString();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object object) {
		if (true == super.equals(object)) {
			if (object instanceof User) {
				if (getName().equals(((User) object).getName())) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * @param password
	 * @return true/false 
	 */
	public boolean isPasswordValidated(String password){		
		if (password!=null)
			return password.equals(this.getPassword());
		else
			return false;
	}



}