package com.glweb.web.struts.actions;

import java.util.Iterator;
import java.util.HashMap;

/**
 * ActionType
 *
 * @author     Paxson Yang
 * @created    2002/8/23
 */
public class ActionType {
    public static final int NULL_TYPE = 0;
    public static final String NULL_VALUE = "null";
    public static final ActionType NULL = 
            new ActionType(NULL_TYPE, NULL_VALUE);

    public static final int INPUT_TYPE = 1;
    public static final String INPUT_VALUE = "input";
    public static final ActionType INPUT = 
            new ActionType(INPUT_TYPE, INPUT_VALUE);
    
    public static final int SUBMIT_TYPE = 2;
    public static final String SUBMIT_VALUE = "submit";
    public static final ActionType SUBMIT = 
            new ActionType(SUBMIT_TYPE, SUBMIT_VALUE);

    public static final int ADD_TYPE = 3;
    public static final String ADD_VALUE = "add";
    public static final ActionType ADD = 
            new ActionType(ADD_TYPE, ADD_VALUE);

    public static final int QUERY_TYPE = 4;
    public static final String QUERY_VALUE = "query";
    public static final ActionType QUERY = 
            new ActionType(QUERY_TYPE, QUERY_VALUE);
    
    private static java.util.HashMap _members = init();

    private int _type;
    private String _value;
    
    private ActionType(int type, String value) {
        _type = type;
        _value = value;
    }
    
    private static HashMap init() {
        HashMap members = new HashMap();
        
        members.put(INPUT_VALUE, INPUT);
        members.put(SUBMIT_VALUE, SUBMIT);
        members.put(ADD_VALUE, ADD);
        members.put(QUERY_VALUE, QUERY);
        
        return members;
    }
    
    private static HashMap getMembers() {
        return _members;
    }
    
    public static Iterator iterator() {
        return getMembers().values().iterator();
    }
    
    public static ActionType valueOf(String str) {
        if (null != str) {
            return (ActionType)getMembers().get(str);
        } else {
            return NULL;
        }
    }
    
    public int getType() {
        return _type;
    }
    
    public String toString() {
        return _value;
    }
}
