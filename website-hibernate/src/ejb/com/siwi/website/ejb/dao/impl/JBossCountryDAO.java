/*
 *  $Header: /home/xubuntu/berlios_backup/github/tmp-cvs/glweb/Repository/website-hibernate/src/ejb/com/siwi/website/ejb/dao/impl/Attic/JBossCountryDAO.java,v 1.1 2003/10/28 02:56:05 paxson Exp $
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

import com.siwi.website.ejb.dao.CountryDAO;
import com.siwi.website.ejb.dao.DAOException;
import com.siwi.website.ejb.data.CountryData;
import com.siwi.website.ejb.entity.CountryPK;

/**
 *  JBossCountryDAO
 *
 * @author  Paxson Yang
 * @created  2002/8/8
 * @version  $Revision: 1.1 $ $Date: 2003/10/28 02:56:05 $
 */
public class JBossCountryDAO implements CountryDAO {
    private final static String DATA_SOURCE = "java:DefaultDS";
    
    private final static String TABLE = "COUNTRY";
    
    private static DataSource _dataSource;

    /**
     *  Gets the dataSource attribute of the JBossCountryDAO object
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
                CountryData _data = new CountryData();
                _data.setId(_result.getString("id"));
                _data.setName(_result.getString("name"));

                _list.add(_data);
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
    public CountryData findByPrimaryKey(CountryPK pk) throws DAOException {
        CountryData _data = new CountryData();
        // SELECT FROM datasource WHERE pkfields = pk.getX()
        // if not found
        //   throw new ObjectNotFoundException();
        // pk = new CustomerPK(...);
        return _data;
    }

    /**
     *  Description of the Method
     */
    public void init() { }

    /**
     *  Description of the Method
     *
     * @param  pk                Description of the Parameter
     * @param  data              Description of the Parameter
     * @exception  DAOException  Description of the Exception
     */
    public void load(CountryPK pk, CountryData data) throws DAOException {
        // SELECT FROM datasource WHERE pkfields = pk.getX()
        // bean.setX(read values)
    }

    /**
     *  Description of the Method
     *
     * @param  pk                Description of the Parameter
     * @exception  DAOException  Description of the Exception
     */
    public void remove(CountryPK pk) throws DAOException {
        // DELETE FROM datasource WHERE pkfields = pk.getX()
    }

    /**
     *  Description of the Method
     *
     * @param  bean              Description of the Parameter
     * @exception  DAOException  Description of the Exception
     */
    public void store(CountryData bean) throws DAOException {
        // UPDATE datasource SET values = bean.getX()
    }

}