/*
 *
 * $Id: AbstractUserDAO.java,v 1.1 2003/05/17 10:16:53 kocachen Exp $
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
package com.glweb.module.member.provider.hibernate.dao;

import com.glweb.infrastructure.persistence.GLWebPersistenceException;
import com.glweb.infrastructure.persistence.hibernate.HibernateUtil;

import net.sf.hibernate.Session;

/**
 * @author Administrator
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public abstract class AbstractUserDAO {

	private Session m_session;
	private boolean isExternalSession;


	/**
	 * 
	 */
	protected AbstractUserDAO() {
		isExternalSession = false;
	}
	
	protected AbstractUserDAO(Session session) {
		super();
		setSession(session);
	}
 
 	protected Session useSession() throws GLWebPersistenceException{
		if (getSession()!=null){	
			return getSession();
		}else{
			setSession(HibernateUtil.retrieveDefaultSession());
			isExternalSession = false;
			return getSession();
		}		
 	}
 	
 	protected void releaseSession(){
 		setSession(null);
 	}
 	
 	protected void closeSession() throws GLWebPersistenceException{
		if (getSession()!=null && !isExternalSession)
			HibernateUtil.commitCloseSession(getSession());
		else
			releaseSession();
 	}
 

	/**
	 * @return Session
	 */
	protected Session getSession(){
		return m_session;
	}

	/**
	 * Sets the session.
	 * @param session The session to set
	 */
	protected void setSession(Session session) {
		m_session = session;
		isExternalSession = true;
	}

}
