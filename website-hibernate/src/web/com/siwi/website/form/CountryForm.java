/*
 * $ Id: $
 * 
 */

package com.siwi.website.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 *  CountryForm
 *
 * @author  Paxson Yang
 * @created  2002/8/7
 * @version  $Revision: 1.1 $ $Date: 2003/10/28 02:56:05 $
 * 
 * @struts:form  name="countryForm"
 */
public class CountryForm extends ActionForm {

    private String _id;

    private String _name;

    private boolean _validate;

    /**
     *  Sets the id attribute of the CountryForm object
     *
     * @param  val  The new id value
     */
    public void setId(String val) {
        _id = val;
    }

    /**
     *  Sets the name attribute of the CountryForm object
     *
     * @param  val  The new name value
     */
    public void setName(String val) {
        _name = val;
    }

    /**
     *  Sets the validate attribute of the CountryForm object
     *
     * @param  val  The new validate value
     */
    public void setValidate(boolean val) {
        _validate = val;
    }

    /**
     *  Gets the id attribute of the CountryForm object
     *
     * @return  The id value
     */
    public String getId() {
        return _id;
    }

    /**
     *  Gets the name attribute of the CountryForm object
     *
     * @return  The name value
     */
    public String getName() {
        return _name;
    }

    /**
     *  Gets the validate attribute of the CountryForm object
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
        setValidate(false);
        setId(null);
        setName(null);
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
            if (null == getId() ||
                    0 == getId().trim().length()) {
                _errors.add("message",
                        new ActionError("error.countryId.required"));
            }

            if (null == getName() ||
                    0 == getName().trim().length()) {
                _errors.add("message",
                        new ActionError("error.countryName.required"));
            }
        }

        return _errors;
    }

}