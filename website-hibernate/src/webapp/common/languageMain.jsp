<%@ page contentType="text/html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>

<html:form action="/common/languageAction">
  <html:hidden property="action" value="add"/>
  <html:hidden property="validate" value="true"/>  
  <table width="60%" bgcolor="#CCCCCC" cellpadding="0" cellspacing="0" border="0">
    <tr colspan="2">
      <td height="30" align="center">
        &nbsp;<font color="#FFFFFF">
          <b><bean:message key="heading.language"/></b>
        </font>
      </td>
    </tr>
    <tr><td>
      <table width="100%" cellpadding="2" cellspacing="1" border="0">
        <tr>
          <td bgcolor="#EEEEEE">
            <bean:message key="prompt.id"/>
          </td>
          <td bgcolor="#FFFFFF">
            <html:text property="id" size="22"/>
          </td>
        </tr>
        <tr>
          <td bgcolor="#EEEEEE">
            <bean:message key="prompt.name"/>
          </td>
          <td bgcolor="#FFFFFF">
            <html:text property="name" size="22"/>
          </td>
        </tr>
        <tr><td colspan="2" bgcolor="#FFFFFF">
          <html:submit>
            <bean:message key="button.submit"/>
          </html:submit>
          <html:reset>
            <bean:message key="button.reset"/>
          </html:reset>
        </td></tr>
      </table>
    </td></tr>
  </table>
</html:form>