<%@ page contentType="text/html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>

<table width="60%" bgcolor="#CCCCCC" cellpadding="0" cellspacing="0" border="0">
  <tr colspan="2">
    <td height="30" align="center">
      &nbsp;<font color="#FFFFFF">
        <b><bean:message key="heading.languageDetail"/></b>
      </font>
    </td>
  </tr>
  <tr><td>
    <table width="100%" cellpadding="2" cellspacing="1" border="0">
      <tr>
        <td bgcolor="#EEEEEE" width="20%">
          <bean:message key="heading.id"/>
        </td>
        <td bgcolor="#FFFFFF" width="80%">
          <bean:write name="language" property="id"/>
        </td>
      </tr>
      <tr>
        <td bgcolor="#EEEEEE" width="20%">
          <bean:message key="heading.name"/>
        </td>
        <td bgcolor="#FFFFFF" width="80%">
          <bean:write name="language" property="name"/>
        </td>
      </tr>
    </table>
  </td></tr>
</table>