/*
 * $Id: ActionType.java,v 1.2 2003/10/29 08:27:23 paxson Exp $
 * 
 */

package com.siwi.common.web;

import java.util.HashMap;
import java.util.Iterator;

/**
 *  ActionType
 *
 * @author     Paxson Yang
 * @created    2002/8/6
 * @version    $Revision: 1.2 $ $Date: 2003/10/29 08:27:23 $
 */
public class ActionType {

    public final static int NULL_TYPE = 0;
    public final static String NULL_VALUE = "null";
    public final static ActionType NULL =
            new ActionType(NULL_TYPE, NULL_VALUE);

    public final static int INPUT_TYPE = 1;
    public final static String INPUT_VALUE = "input";
    public final static ActionType INPUT =
            new ActionType(INPUT_TYPE, INPUT_VALUE);

    public final static int SUBMIT_TYPE = 2;
    public final static String SUBMIT_VALUE = "submit";
    public final static ActionType SUBMIT =
            new ActionType(SUBMIT_TYPE, SUBMIT_VALUE);

    public final static int ADD_TYPE = 3;
    public final static String ADD_VALUE = "add";
    public final static ActionType ADD =
            new ActionType(ADD_TYPE, ADD_VALUE);

    public final static int QUERY_TYPE = 4;
    public final static String QUERY_VALUE = "query";
    public final static ActionType QUERY =
            new ActionType(QUERY_TYPE, QUERY_VALUE);

    private static java.util.HashMap _members = init();

    private int _type;

    private String _value;

    /**
     *  Constructor for the ActionType object
     *
     * @param  type   Description of the Parameter
     * @param  value  Description of the Parameter
     */
    private ActionType(int type, String value) {
        _type = type;
        _value = value;
    }

    /**
     *  Gets the members attribute of the ActionType class
     *
     * @return  The members value
     */
    private static HashMap getMembers() {
        return _members;
    }

    /**
     *  Gets the type attribute of the ActionType object
     *
     * @return  The type value
     */
    public int getType() {
        return _type;
    }

    /**
     *  Description of the Method
     *
     * @return  Description of the Return Value
     */
    private static HashMap init() {
        HashMap _members = new HashMap();
        _members.put(INPUT_VALUE, INPUT);
        _members.put(SUBMIT_VALUE, SUBMIT);
        _members.put(ADD_VALUE, ADD);
        _members.put(QUERY_VALUE, QUERY);

        return _members;
    }

    /**
     *  Description of the Method
     *
     * @return  Description of the Return Value
     */
    public static Iterator iterator() {
        return getMembers().values().iterator();
    }

    /**
     *  Description of the Method
     *
     * @param  str  Description of the Parameter
     * @return  Description of the Return Value
     */
    public static ActionType valueOf(String str) {
        if (null != str) {
            return (ActionType) getMembers().get(str);
        } else {
            return NULL;
        }
    }

    /**
     *  Description of the Method
     *
     * @return  Description of the Return Value
     */
    public String toString() {
        return _value;
    }
    
}