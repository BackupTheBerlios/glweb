package com.glweb.module.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.glweb.Constants;
import com.glweb.module.member.MembershipManager;
import com.glweb.module.member.model.User;
import com.glweb.web.struts.actions.BaseAction;
import com.glweb.web.struts.actions.HandleFactory;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.glweb.module.member.model.UserProfile;

public class MemberDataAction extends BaseAction {
    /**
     * @see com.glweb.web.struts.actions.BaseAction#getHandleFactory()
     */
    protected HandleFactory getHandleFactory() {
        return null;
    }

    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(true);
        String forward = null;

        String action = (String) PropertyUtils.getSimpleProperty(form, "action");
        if (null == action) {
            return (mapping.getInputForward());
        }

        if (action.equals("addUser")) {
            User user = null;

            String email = (String) PropertyUtils.getSimpleProperty(form, "email");
            String emailDisplay = (String) PropertyUtils.getSimpleProperty(form, "emailDisplay");
            boolean emailVisiable = false;
            if (emailDisplay != null && emailDisplay.equals("yes")) {
                emailVisiable = true;
            }

            String icq = (String) PropertyUtils.getSimpleProperty(form, "icq");

            String personHomePage = (String) PropertyUtils.getSimpleProperty(form, "personHomePage");

            String personImg = (String) PropertyUtils.getSimpleProperty(form, "personImg");
            String personImgURL = (String) PropertyUtils.getSimpleProperty(form, "personImgURL");
            String personImgHigh = (String) PropertyUtils.getSimpleProperty(form, "personImgHigh");
            String personImgWidth = (String) PropertyUtils.getSimpleProperty(form, "personImgWidth");

            String personDesc = (String) PropertyUtils.getSimpleProperty(form, "personDesc");
            String personFancy = (String) PropertyUtils.getSimpleProperty(form, "personFancy");
            String motto = (String) PropertyUtils.getSimpleProperty(form, "motto");

            String startSign = (String) PropertyUtils.getSimpleProperty(form, "startSign");
            String msn = (String) PropertyUtils.getSimpleProperty(form, "msn");

            String userName = (String) PropertyUtils.getSimpleProperty(form, "userName");
            String userPwd = (String) PropertyUtils.getSimpleProperty(form, "userPwd");
            String confirmPwd = (String) PropertyUtils.getSimpleProperty(form, "confirmPwd");
            String lastName = (String) PropertyUtils.getSimpleProperty(form, "lastName");
            String firstName = (String) PropertyUtils.getSimpleProperty(form, "firstName");
            String city = (String) PropertyUtils.getSimpleProperty(form, "city");
            String province = (String) PropertyUtils.getSimpleProperty(form, "province");
            String country = (String) PropertyUtils.getSimpleProperty(form, "country");
            String age = (String) PropertyUtils.getSimpleProperty(form, "age");
            String sex = (String) PropertyUtils.getSimpleProperty(form, "sex");
            boolean sex1 = true;
            if (sex != null && sex.equals("female")) {
                sex1 = false;
            }
            String position = (String) PropertyUtils.getSimpleProperty(form, "position");
            String sign = (String) PropertyUtils.getSimpleProperty(form, "sign");

            //create new user
            MembershipManager memberManger = MembershipManager.getInstance();
            user = memberManger.createUser(userName, userPwd, email);

            user.setEmailIsVisiable(emailVisiable);
            user.setIcqNo(icq);
            user.setHomePage(personHomePage);
            user.setPimImage(personImg);
            user.setPimImgUrl(personImgURL);
            user.setPimImgHeight(Integer.parseInt(personImgHigh));
            user.setPimImgWidth(Integer.parseInt(personImgWidth));
            user.setStarSign(startSign);
            user.setMsnNo(msn);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setCity(city);
            user.setState(province);
            user.setCountry(country);
            user.setAge(Integer.parseInt(age));
            user.setSex(sex1);
            user.setPosition(position);

            UserProfile profile = new UserProfile();
            user.setUserProfile(profile);
            user.getUserProfile().setPimIntroduction(personDesc);
            user.getUserProfile().setPimHobby(personFancy);
            user.getUserProfile().setMotto(motto);
            user.getUserProfile().setPimSign(sign);

            user = memberManger.updateUser(user);
            if (user == null) {
                return (mapping.getInputForward());
            }
            if (getLogger().isInfoEnabled()) {
                getLogger().info("user = " + user);
            }

            session.setAttribute(Constants.USER_KEY, user);
        }

        return (mapping.findForward("forum"));
    }
}