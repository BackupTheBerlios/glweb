/*
 * Created on 2003/4/25
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.glweb.module.member.model;

/**
 * @author Administrator
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class UserProfile extends AbstractMemberValueObject {
	
	
	private String m_PimSign ;
	private String m_PimIntroduction;
	private String m_PimHobby;
	private String m_Motto;

	
	public UserProfile(){}
	

	/**
	 * @return String
	 */
	public String getMotto() {
		return m_Motto;
	}

	/**
	 * @return String
	 */
	public String getPimHobby() {
		return m_PimHobby;
	}

	/**
	 * @return String
	 */
	public String getPimIntroduction() {
		return m_PimIntroduction;
	}

	/**
	 * @return String
	 */
	public String getPimSign() {
		return m_PimSign;
	}

	/**
	 * Sets the motto.
	 * @param motto The motto to set
	 */
	public void setMotto(String motto) {
		m_Motto = motto;
		super.setUpdateFlag();
	}

	/**
	 * Sets the pimHobby.
	 * @param pimHobby The pimHobby to set
	 */
	public void setPimHobby(String pimHobby) {
		m_PimHobby = pimHobby;
		super.setUpdateFlag();
	}

	/**
	 * Sets the pimIntroduction.
	 * @param pimIntroduction The pimIntroduction to set
	 */
	public void setPimIntroduction(String pimIntroduction) {
		m_PimIntroduction = pimIntroduction;
		super.setUpdateFlag();
	}

	/**
	 * Sets the pimSign.
	 * @param pimSign The pimSign to set
	 */
	public void setPimSign(String pimSign) {
		m_PimSign = pimSign;
		super.setUpdateFlag();
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer sbf = new StringBuffer();
		sbf.append(LINESEP);
		sbf.append(super.toString());
		sbf.append(LINESEP);
		sbf.append("    PimHobby:");
		sbf.append(this.getPimHobby());
		sbf.append("    PimIntroduction:");
		sbf.append(this.getPimIntroduction());
		sbf.append("    PimSign");
		sbf.append(this.getPimSign());
		sbf.append("    MOTTO");
		sbf.append(this.getMotto());
		return sbf.toString();
	}

}
