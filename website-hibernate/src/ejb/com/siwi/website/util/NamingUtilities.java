/*
 * $Id: NamingUtilities.java,v 1.1 2003/10/29 08:27:23 paxson Exp $
 */

package com.siwi.website.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

/**
 * NamingUtilities
 * 
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/10/29 08:27:23 $
 */

public class NamingUtilities {

    public static InitialContext getInitialContext() throws NamingException {
        InitialContext _ctx = null;
        
        try {
            _ctx = new InitialContext();
        } catch (NamingException ne) {
            throw ne;
        }
        
        return _ctx;
    }

    public static Object narrow(Object object, Class clazz) {
        return PortableRemoteObject.narrow(object, clazz);
    }

}
