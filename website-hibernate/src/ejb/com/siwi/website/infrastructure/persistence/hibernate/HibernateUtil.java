/*
 * $Id: HibernateUtil.java,v 1.1 2003/10/29 08:27:23 paxson Exp $
 */

package com.siwi.website.infrastructure.persistence.hibernate;

import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.cfg.Configuration;

import com.siwi.website.infrastructure.persistence.WebsitePersistenceException;
import com.siwi.website.util.GlobalProperties;
import com.siwi.website.util.NamingUtilities;

/**
 * HibernateUtil
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/10/29 08:27:23 $
 */
public class HibernateUtil {
    
    private static final ThreadLocal _currentSession = new ThreadLocal();
    
    private static Log _logger;
    
    private static String KEY_SESSION_FACTORY_TYPE = "session.factory.type";
    
    private static String JNDI_SESSION_FACTORY = "/glweb/hibernate/SessionFactory";
    
    private static SessionFactory _localSessionFactory;
    
    private static SessionFactory _jndiSessionFactory;
    
    protected static Log getLogger() {
        if (null == _logger) {
            setLogger(LogFactory.getLog(
                    "com.glweb.infrastructure.persistence.hibernate.HibernateUtil"));
        }
        
        return _logger;
    }

    protected static void setLogger(Log log) {
        _logger = log;
    }
    
    protected static ThreadLocal getCurrentSession() {
        return _currentSession;
    }
    
    protected static SessionFactory getLocalSessionFactory() {
        return _localSessionFactory;
    }

    protected static void setLocalSessionFactory(SessionFactory factory) {
        _localSessionFactory = factory;
    }
    
    protected static SessionFactory getJndiSessionFactory() {
        return _jndiSessionFactory;
    }

    protected static void setJndiSessionFactory(SessionFactory factory) {
        _jndiSessionFactory = factory;
    }
    
    /**
     * Returns the default <code>SessionFactory</code> .
     */
    public static SessionFactory retrieveDefaultSessionFactory() 
        throws WebsitePersistenceException {
        
        String _sessionFactoryType = GlobalProperties.getInstance().getProperty(
                KEY_SESSION_FACTORY_TYPE);
        
        if ("local".equals(_sessionFactoryType)) {
            return HibernateUtil.retrieveLocalSessionFactory();
        } else {
            return HibernateUtil.retrieveJndiSessionFactory();
        }
    }

    /**
     * Returns the <code>SessionFactory</code> retrieved via JNDI.
     */
    public static SessionFactory retrieveJndiSessionFactory() 
        throws WebsitePersistenceException {
        
        if (null == getJndiSessionFactory()) {
            try {
                new Configuration().configure();
                InitialContext _ctx = NamingUtilities.getInitialContext();
                setJndiSessionFactory(
                        (SessionFactory) _ctx.lookup(JNDI_SESSION_FACTORY));
            } catch (HibernateException he) {
                throw new WebsitePersistenceException(he);
            } catch (NamingException ne) {
                throw new WebsitePersistenceException(ne);
            }
        }

        return getJndiSessionFactory();
    }
    
    /**
     * Returns the <code>SessionFactory</code> locally configured.
     */
    public static SessionFactory retrieveLocalSessionFactory() 
        throws WebsitePersistenceException {
        
        if (null == getLocalSessionFactory()) {
            try {
                setLocalSessionFactory(
                        new Configuration().configure().buildSessionFactory());
            } catch (HibernateException he) {
                throw new WebsitePersistenceException(he);
            }
        }
        
        return getLocalSessionFactory();
    }
    
    public static Session retrieveDefaultSession() 
        throws WebsitePersistenceException {
        
        Session _session = null;

        try {
            _session = HibernateUtil.retrieveDefaultSessionFactory().openSession();
        } catch (HibernateException he) {
            throw new WebsitePersistenceException(he);
        }

        return _session;
    }

    /**
     * Returns the current <code>Session</code> for the current thread.
     * If none available, it creates the necessary and stores it via <code>ThreadLocal</thread>.
     */
    public static Session currentSession() 
        throws WebsitePersistenceException {
        
        Session _session = (Session) HibernateUtil.getCurrentSession().get();

        if (null == _session) {
            try {
                _session = HibernateUtil.retrieveDefaultSessionFactory().openSession();
                HibernateUtil.getCurrentSession().set(_session);
            } catch (HibernateException he) {
                throw new WebsitePersistenceException(he);
            }
        }

        return _session;
    }

    /**
     * Flushes, commits, and closes current <code>Session</code> stored via <code>ThreadLocal</code>
     */
    public static void commitCloseCurrentSession() {
        Session _session = (Session) HibernateUtil.getCurrentSession().get();
        HibernateUtil.getCurrentSession().set(null);
        HibernateUtil.commitCloseSession(_session);
    }

    /**
     * Flushes, commits, and closes <code>Session</code> passed.
     */
    public static void commitCloseSession(Session session) {
        if (null != session) {
            try {
                session.flush();
                
                if (!session.connection().getAutoCommit()) {
                    session.connection().commit();
                }
            } catch (HibernateException he) {
                getLogger().error(he);
            } catch (SQLException sqle) {
                getLogger().error(sqle);
            } finally {
                try {
                    session.close();
                } catch (HibernateException he) {
                    getLogger().error(he);
                }
            }
        }
    }

    /**
     * Flushes and closes <code>Session</code> passed.
     */
    public static void closeSession(Session session) {
        if (null != session) {
            try {
                session.flush();
            } catch (HibernateException he) {
                getLogger().error(he);
            } finally {
                try {
                    session.close();
                } catch (HibernateException he) {
                    getLogger().error(he);
                }
            }
        }
    }


    /**
     * Flush current <code>Session</code> and commit <code>Transaction</code>.
     */
    public static void commitCurrentSessionTransaction(Transaction transaction) 
        throws WebsitePersistenceException {
        
        commitTransaction(HibernateUtil.currentSession(), transaction);
    }

    /**
     * Flush <code>Session</code> and commit <code>Transaction</code>.
     */
    public static void commitTransaction(Session session, Transaction transaction) 
        throws WebsitePersistenceException {
        
        try {
            if ((session != null) && (transaction != null)) {
                session.flush();
                transaction.commit();
            }
        } catch (HibernateException he) {
            throw new WebsitePersistenceException(he);
        }
    }

    /**
     * Rollback <code>Transaction</code>.
     */
    public static void rollBackTransaction(Transaction transaction) 
        throws WebsitePersistenceException {
        
        if (transaction != null) {
            try {
                transaction.rollback();
            } catch (HibernateException he) {
                throw new WebsitePersistenceException(he);
            }
        }
    }

}
