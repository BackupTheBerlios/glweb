/*
 * Created on 2010/5/3
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.glweb.module.member.model;

import com.glweb.infrastructure.persistence.AbstractPersistableObject;

/**
 * @author Administrator
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public abstract class AbstractMemberValueObject extends AbstractPersistableObject {
	
	private boolean m_isInsertFlag ;
	private boolean m_isUpdateFlag ;
	private boolean m_isDeleteFlag ;
	
	public void resetAccessFlag(){
		m_isInsertFlag = false;
		m_isUpdateFlag = false;
		m_isDeleteFlag = false;	
	}

	public void setInsertFlag(){
		m_isInsertFlag = true;
		m_isUpdateFlag = false;
		m_isDeleteFlag = false;	
	}
	
	public void setUpdateFlag(){
		m_isInsertFlag = false;
		m_isUpdateFlag = true;
		m_isDeleteFlag = false;	
	}
	
	public void setDeleteFlag(){
		m_isInsertFlag = false;
		m_isUpdateFlag = false;
		m_isDeleteFlag = true;	
	}

	/**
	 * @return boolean
	 */
	public boolean isDeleteFlag() {
		return m_isDeleteFlag;
	}

	/**
	 * @return boolean
	 */
	public boolean isInsertFlag() {
		return m_isInsertFlag;
	}

	/**
	 * @return boolean
	 */
	public boolean isUpdateFlag() {
		return m_isUpdateFlag;
	}

}
