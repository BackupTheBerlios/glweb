/*
 *  $Header: /home/xubuntu/berlios_backup/github/tmp-cvs/glweb/Repository/website-hibernate/src/ejb/com/siwi/website/ejb/dao/impl/Attic/JBossCityDAO.java,v 1.1 2003/10/28 02:56:05 paxson Exp $
 *  $Revision: 1.1 $
 *  $Date: 2003/10/28 02:56:05 $
 *  $Author: paxson $
 */

package com.siwi.website.ejb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.siwi.common.logger.Logger;
import com.siwi.common.logger.LoggerFactory;

import com.siwi.website.ejb.dao.CityDAO;
import com.siwi.website.ejb.dao.DAOException;
import com.siwi.website.ejb.entity.CityPK;
import com.siwi.website.ejb.value.CityValue;

/**
 *  JBossCityDAO
 *
 * @author  Paxson Yang
 * @created  2002/8/9
 * @version  $Revision: 1.1 $ $Date: 2003/10/28 02:56:05 $
 */
public class JBossCityDAO implements CityDAO {
    private final static String DATA_SOURCE = "java:DefaultDS";
    
    private final static boolean DEBUG = true;
    
    private final static String TABLE = "CITY";
    
    private static DataSource _dataSource;

    private Logger _logger;

    /**
     *  Gets the dataSource attribute of the JBossCityDAO object
     *
     * @return                      The dataSource value
     * @exception  NamingException  Description of the Exception
     */
    private DataSource getDataSource() throws NamingException {
        if (null == _dataSource) {
            InitialContext _initialContext = new InitialContext();

            try {
                _initialContext = new InitialContext();
                _dataSource =
                        (DataSource) _initialContext.lookup(DATA_SOURCE);
            } finally {
                if (null != _initialContext) {
                    _initialContext.close();
                    _initialContext = null;
                }
            }
        }

        return _dataSource;
    }

    /**
     *  Gets the logger attribute of the JBossCityDAO object
     *
     * @return    The logger value
     */
    private Logger getLogger() {
        if (null == _logger) {
            _logger = LoggerFactory.getInstance().getLogger(
                    getClass().getName());
            _logger.setDebug(DEBUG);
        }

        return _logger;
    }

    /**
     *  Description of the Method
     *
     * @return                   Description of the Return Value
     * @exception  DAOException  Description of the Exception
     */
    public Collection findAll() throws DAOException {
        List _list = new ArrayList();

        String _sql = "SELECT * FROM " + TABLE;

        Connection _connection = null;
        PreparedStatement _pstmt = null;
        ResultSet _result = null;

        try {
            _connection = getDataSource().getConnection();
            _pstmt = _connection.prepareStatement(_sql);
            _result = _pstmt.executeQuery();

            while (_result.next()) {
                CityValue _value = new CityValue();
                _value.setId(_result.getString("id"));
                _value.setName(_result.getString("name"));
                getLogger().debug("Country = " +
                        _result.getString("country_id_fk"));

                _list.add(_value);
            }
        } catch (NamingException ne) {
            throw new DAOException(ne);
        } catch (SQLException sqle) {
            throw new DAOException(sqle);
        } catch (Exception e) {
            throw new DAOException(e);
        } finally {
            try {
                if (null != _result) {
                    _result.close();
                    _result = null;
                }
                if (null != _pstmt) {
                    _pstmt.close();
                    _pstmt = null;
                }
                if (null != _connection) {
                    _connection.close();
                    _connection = null;
                }
            } catch (SQLException sqle) {
                throw new DAOException(sqle);
            }
        }

        return _list;
    }

    /**
     *  Description of the Method
     *
     * @param  pk                Description of the Parameter
     * @return                   Description of the Return Value
     * @exception  DAOException  Description of the Exception
     */
    public CityValue findByPrimaryKey(CityPK pk) throws DAOException {
        CityValue _value = new CityValue();
        // SELECT FROM datasource WHERE pkfields = pk.getX()
        // if not found
        //   throw new ObjectNotFoundException();
        // pk = new CustomerPK(...);
        return _value;
    }

    /**
     *  Description of the Method
     */
    public void init() { }

    /**
     *  Description of the Method
     *
     * @param  pk                Description of the Parameter
     * @param  value             Description of the Parameter
     * @exception  DAOException  Description of the Exception
     */
    public void load(CityPK pk, CityValue value) throws DAOException {
        // SELECT FROM datasource WHERE pkfields = pk.getX()
        // bean.setX(read values)
    }

    /**
     *  Description of the Method
     *
     * @param  pk                Description of the Parameter
     * @exception  DAOException  Description of the Exception
     */
    public void remove(CityPK pk) throws DAOException {
        // DELETE FROM datasource WHERE pkfields = pk.getX()
    }

    /**
     *  Description of the Method
     *
     * @param  value             Description of the Parameter
     * @exception  DAOException  Description of the Exception
     */
    public void store(CityValue value) throws DAOException {
        // UPDATE datasource SET values = bean.getX()
    }

}