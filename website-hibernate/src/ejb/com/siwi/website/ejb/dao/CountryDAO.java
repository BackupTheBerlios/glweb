/*
 * $ Id: $
 * 
 */

package com.siwi.website.ejb.dao;

import java.util.Collection;

import com.siwi.website.ejb.data.CountryData;
import com.siwi.website.ejb.entity.CountryPK;

/**
 *  CountryDAO
 *
 * @author  Paxson Yang
 * @created  2002/8/8
 * @version  $Revision: 1.1 $ $Date: 2003/10/28 02:56:05 $
 */
public interface CountryDAO {
    final static String IMPL_CLASS =
            "com.siwi.website.ejb.dao.impl.JBossCountryDAO";

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
     * @param  data              Description of the Parameter
     * @exception  DAOException  Description of the Exception
     */
    void load(CountryPK pk, CountryData data) throws DAOException;

    /**
     *  Description of the Method
     *
     * @param  bean              Description of the Parameter
     * @exception  DAOException  Description of the Exception
     */
    void store(CountryData bean) throws DAOException;

    /**
     *  Description of the Method
     *
     * @param  pk                Description of the Parameter
     * @exception  DAOException  Description of the Exception
     */
    void remove(CountryPK pk) throws DAOException;

    /**
     *  Description of the Method
     *
     * @param  pk                Description of the Parameter
     * @return                   Description of the Return Value
     * @exception  DAOException  Description of the Exception
     */
    CountryData findByPrimaryKey(CountryPK pk) throws DAOException;

    /**
     *  Description of the Method
     *
     * @return                   Description of the Return Value
     * @exception  DAOException  Description of the Exception
     */
    Collection findAll() throws DAOException;

}