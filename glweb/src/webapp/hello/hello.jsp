<%--
 $Id: hello.jsp,v 1.1 2003/05/10 11:41:13 paxson Exp $
--%>

<%@ page contentType="text/html" language="java" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>

<html:form action="/action/helloAction" onsubmit="return validateHelloForm(this);">
    <html:hidden property="action" value="save"/>
 
    <table width="60%" bgcolor="#CCCCCC" cellpadding="0" cellspacing="0" border="0">
        <tr colspan="2">
            <td height="30" align="center">
                &nbsp;<font color="#FFFFFF">
                    <b><bean:message key="helloForm.title"/></b>
                </font>
            </td>
        </tr>
        <tr><td>
            <table width="100%" cellpadding="2" cellspacing="1" border="0">
                <tr>
                    <td bgcolor="#EEEEEE">
                        <bean:message key="helloForm.name.displayname"/>
                    </td>
                    <td bgcolor="#FFFFFF">
                        <html:text property="name" size="22"/>
                    </td>
                </tr>
                <tr><td colspan="2" bgcolor="#FFFFFF">
                    <html:submit property="submit" onclick="bCancel=false;">
                        <bean:message key="button.save"/>
                    </html:submit>
                    <html:reset>
                        <bean:message key="button.reset"/>
                    </html:reset>
                    <html:cancel onclick="bCancel=true;">
                        <bean:message key="button.cancel"/>
                    </html:cancel>
                </td></tr>
            </table>
        </td></tr>
    </table>
</html:form>

<html:javascript formName="helloForm"/>
