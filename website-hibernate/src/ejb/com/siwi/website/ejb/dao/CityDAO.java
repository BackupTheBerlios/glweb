/*
 * $ Id: $
 * 
 */

package com.siwi.website.ejb.dao;

import java.util.Collection;

import com.siwi.website.ejb.entity.CityPK;
import com.siwi.website.ejb.value.CityValue;

/**
 *  CityDAO
 *
 * @author  Paxson Yang
 * @created  2002/8/9
 * @version  $Revision: 1.1 $ $Date: 2003/10/28 02:56:05 $
 */
public interface CityDAO {
    final static String IMPL_CLASS =
            "com.siwi.website.ejb.dao.impl.JBossCityDAO";

    /**
     *  Description of the Method
     *
     * @exception  DAOException  Description of the Exception
     */
    void init() throws DAOException;

    /**
     *  Description of the Method
     *
     * @param  pk                Description of the Parameter
     * @param  value             Description of the Parameter
     * @exception  DAOException  Description of the Exception
     */
    void load(CityPK pk, CityValue value) throws DAOException;

    /**
     *  Description of the Method
     *
     * @param  value             Description of the Parameter
     * @exception  DAOException  Description of the Exception
     */
    void store(CityValue value) throws DAOException;

    /**
     *  Description of the Method
     *
     * @param  pk                Description of the Parameter
     * @exception  DAOException  Description of the Exception
     */
    void remove(CityPK pk) throws DAOException;

    /**
     *  Description of the Method
     *
     * @param  pk                Description of the Parameter
     * @return                   Description of the Return Value
     * @exception  DAOException  Description of the Exception
     */
    CityValue findByPrimaryKey(CityPK pk) throws DAOException;

    /**
     *  Description of the Method
     *
     * @return                   Description of the Return Value
     * @exception  DAOException  Description of the Exception
     */
    Collection findAll() throws DAOException;

}