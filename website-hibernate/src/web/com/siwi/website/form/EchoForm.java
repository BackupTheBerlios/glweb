/*
 * $Id: EchoForm.java,v 1.2 2003/10/29 08:27:23 paxson Exp $
 * 
 */
 
package com.siwi.website.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 *  Description of the Class
 *
 * @author  Paxson Yang
 * @created  2002/8/5
 * @version  $Revision: 1.2 $ $Date: 2003/10/29 08:27:23 $
 * 
 * @struts:form  name="echoForm"
 */
public class EchoForm extends ActionForm {

    private String _message;

    private boolean _validate;

    /**
     *  Sets the message attribute of the EchoForm object
     *
     * @param  val  The new message value
     */
    public void setMessage(String val) {
        _message = val;
    }

    /**
     *  Sets the validate attribute of the EchoForm object
     *
     * @param  val  The new validate value
     */
    public void setValidate(boolean val) {
        _validate = val;
    }

    /**
     *  Gets the message attribute of the EchoForm object
     *
     * @return  The message value
     */
    public String getMessage() {
        return _message;
    }

    /**
     *  Gets the validate attribute of the EchoForm object
     *
     * @return  The validate value
     */
    public boolean isValidate() {
        return _validate;
    }

    /**
     *  Description of the Method
     *
     * @param  mapping  Description of the Parameter
     * @param  request  Description of the Parameter
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        setMessage(null);
    }

    /**
     *  Description of the Method
     *
     * @return  Description of the Return Value
     */
    public String toString() {
        return "";
    }

    /**
     *  Description of the Method
     *
     * @param  mapping  Description of the Parameter
     * @param  request  Description of the Parameter
     * @return  Description of the Return Value
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors _errors = new ActionErrors();

        if (isValidate()) {
            if (null == getMessage() ||
                    0 == getMessage().trim().length()) {
                _errors.add("message",
                        new ActionError("error.echoMessage.required"));
            }
        }

        return _errors;
    }

}