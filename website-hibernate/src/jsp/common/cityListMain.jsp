<%@ page contentType="text/html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>

<html:link page="/common/cityAction.do">
  <bean:message key="link.addCity"/>
</html:link>
<table width="60%" bgcolor="#CCCCCC" cellpadding="0" cellspacing="0" border="0">
  <tr colspan="2">
    <td height="30" align="center">
      &nbsp;<font color="#FFFFFF">
        <b><bean:message key="heading.cityList"/></b>
      </font>
    </td>
  </tr>
  <tr><td>
    <table width="100%" cellpadding="2" cellspacing="1" border="0">
      <tr>
        <td bgcolor="#EEEEEE" width="20%">
          <bean:message key="heading.id"/>
        </td>
        <td bgcolor="#EEEEEE" width="40%">
          <bean:message key="heading.name"/>
        </td>
      </tr>
      <logic:iterate id="cityListItem" name="cityList">
        <tr>
          <td bgcolor="#FFFFFF">
            <html:link page="/common/cityAction.do?action=query"
                       paramId="oid" 
                       paramName="cityListItem" 
                       paramProperty="id">
              <bean:write name="cityListItem" property="id"/>
            </html:link>
          </td>
          <td bgcolor="#FFFFFF">
            <bean:write name="cityListItem" property="name"/>
          </td>
        </tr>
      </logic:iterate>
      <logic:equal name="cityListSize" scope="request" value="0">
        <tr>
          <td colspan="2" bgcolor="#FFFFFF" height="30" align="center">
            <font color="red">
              <bean:message key="heading.empty"/>
            </font>
          </td>
        </tr>
      </logic:equal>
    </table>
  </td></tr>
</table>