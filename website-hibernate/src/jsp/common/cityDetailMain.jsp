<%@ page contentType="text/html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>

<table width="60%" bgcolor="#CCCCCC" cellpadding="0" cellspacing="0" border="0">
  <tr colspan="2">
    <td height="30" align="center">
      &nbsp;<font color="#FFFFFF">
        <b><bean:message key="heading.cityDetail"/></b>
      </font>
    </td>
  </tr>
  <tr><td>
    <table width="100%" cellpadding="2" cellspacing="1" border="0">
      <tr>
        <td bgcolor="#EEEEEE" width="20%">
          <bean:message key="heading.country"/>
        </td>
        <td bgcolor="#FFFFFF" width="80%">
          <logic:present name="country">
            <html:link page="/common/countryAction.do?action=query"
                       paramId="oid" paramName="country" paramProperty="id">
              <bean:write name="country" property="name"/>
            </html:link>
          </logic:present>
        </td>
      </tr>
      <tr>
        <td bgcolor="#EEEEEE" width="20%">
          <bean:message key="heading.id"/>
        </td>
        <td bgcolor="#FFFFFF" width="80%">
          <bean:write name="city" property="id"/>
        </td>
      </tr>
      <tr>
        <td bgcolor="#EEEEEE" width="20%">
          <bean:message key="heading.name"/>
        </td>
        <td bgcolor="#FFFFFF" width="80%">
          <bean:write name="city" property="name"/>
        </td>
      </tr>
      <tr>
        <td bgcolor="#EEEEEE" width="20%">
          <bean:message key="heading.languages"/>
        </td>
        <td bgcolor="#FFFFFF" width="80%">
          <logic:iterate id="language" name="city" property="languages">
            <html:link page="/common/languageAction.do?action=query"
                       paramId="oid" paramName="language" paramProperty="id">
              <bean:write name="language" property="name"/>
            </html:link>
            <br/>
          </logic:iterate>
          <logic:equal name="languageListSize" scope="request" value="0">
            <font color="red">
              <bean:message key="heading.empty"/>
            </font>
          </logic:equal>
        </td>
      </tr>
    </table>
  </td></tr>
</table>