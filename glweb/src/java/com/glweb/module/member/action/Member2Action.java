package com.glweb.module.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.glweb.Constants;
import com.glweb.module.member.MembershipManager;
import com.glweb.module.member.model.User;
import com.glweb.module.member.model.UserProfile;
import com.glweb.web.struts.actions.BaseAction;
import com.glweb.web.struts.actions.HandleFactory;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author   $Author: primo $
 * @version  $Revision: 1.1 $ $Date: 2003/09/14 12:05:05 $
 *
 * @struts:action path="/member/member2"
 *                name="member2Form"
 *                scope="request"
 *                validate="true"
 *                input="glweb.member_2"
 *
 * @struts:action-forward name="forum" path="/forum/forum1.do"
 *
 */
public class Member2Action extends BaseAction {
    /**
     * @see com.glweb.web.struts.actions.BaseAction#getHandleFactory()
     */
    protected HandleFactory getHandleFactory() {
        return null;
    }

    protected boolean duplicateUser(String name){
        boolean isDuplicate = false;
        User user = MembershipManager.getInstance().getUserByName(name);
        if(user == null){
            isDuplicate = false;
        }else{
            isDuplicate = true;
        }
        return isDuplicate;
    }

    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        String action = (String) PropertyUtils.getSimpleProperty(form, "action");

        if (action == null) {
            return (mapping.getInputForward());
        }else if (action.equals("addUser")) {
                String email = (String) PropertyUtils.getSimpleProperty(form, "email");
                Boolean emailDisplay = (Boolean) PropertyUtils.getSimpleProperty(form, "emailDisplay");

                String icq = (String) PropertyUtils.getSimpleProperty(form, "icq");

                String personHomePage = (String) PropertyUtils.getSimpleProperty(form, "personHomePage");

                String personImg = (String) PropertyUtils.getSimpleProperty(form, "personImg");
                String personImgURL = (String) PropertyUtils.getSimpleProperty(form, "personImgURL");
                Integer personImgHigh = (Integer) PropertyUtils.getSimpleProperty(form, "personImgHigh");
                Integer personImgWidth = (Integer) PropertyUtils.getSimpleProperty(form, "personImgWidth");

                String personDesc = (String) PropertyUtils.getSimpleProperty(form, "personDesc");
                String personFancy = (String) PropertyUtils.getSimpleProperty(form, "personFancy");
                String motto = (String) PropertyUtils.getSimpleProperty(form, "motto");

                String starSign = (String) PropertyUtils.getSimpleProperty(form, "starSign");
                String msn = (String) PropertyUtils.getSimpleProperty(form, "msn");

                String userName = (String) PropertyUtils.getSimpleProperty(form, "userName");
                String userPwd = (String) PropertyUtils.getSimpleProperty(form, "userPwd");
                String confirmPwd = (String) PropertyUtils.getSimpleProperty(form, "confirmPwd");
                String lastName = (String) PropertyUtils.getSimpleProperty(form, "lastName");
                String firstName = (String) PropertyUtils.getSimpleProperty(form, "firstName");
                String city = (String) PropertyUtils.getSimpleProperty(form, "city");
                String province = (String) PropertyUtils.getSimpleProperty(form, "province");
                String country = (String) PropertyUtils.getSimpleProperty(form, "country");
                Integer age = (Integer) PropertyUtils.getSimpleProperty(form, "age");
                Boolean sex = (Boolean) PropertyUtils.getSimpleProperty(form, "sex");

                String position = (String) PropertyUtils.getSimpleProperty(form, "position");
                String sign = (String) PropertyUtils.getSimpleProperty(form, "sign");

                //create new user
                User user = null;
                //check user duplicate
                if (duplicateUser(userName)) {
                    ActionErrors errors = new ActionErrors();
                    errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.duplicateUser"));
                    this.saveErrors(request, errors);
                    return (mapping.getInputForward());
                } else {
                    user = MembershipManager.getInstance().createUser(userName,
                            userPwd, email);
                }
                if(emailDisplay != null){
                    user.setEmailIsVisiable(emailDisplay.booleanValue());
                }
                user.setIcqNo(icq);
                user.setHomePage(personHomePage);
                user.setPimImage(personImg);
                user.setPimImgUrl(personImgURL);
                if(personImgHigh != null){
                    user.setPimImgHeight(personImgHigh.intValue());
                }
                if(personImgWidth != null){
                    user.setPimImgWidth(personImgWidth.intValue());
                }
                user.setStarSign(starSign);
                user.setMsnNo(msn);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setCity(city);
                user.setState(province);
                user.setCountry(country);
                if(age != null){
                    user.setAge(age.intValue());
                }
                if(sex != null){
                    user.setSex(sex.booleanValue());
                }
                user.setPosition(position);

                UserProfile profile = new UserProfile();
                profile.setPimIntroduction(personDesc);
                profile.setPimHobby(personFancy);
                profile.setMotto(motto);
                profile.setPimSign(sign);
                user.setUserProfile(profile);
                user = MembershipManager.getInstance().updateUser(user);
                if (user == null) {
                    return (mapping.getInputForward());
                }
                if (getLogger().isInfoEnabled()) {
                    getLogger().info("user = " + user);
                }

                request.getSession(true).setAttribute(Constants.USER_KEY, user);
            return (mapping.findForward("forum"));
        }
        return (mapping.getInputForward());
    }
}
