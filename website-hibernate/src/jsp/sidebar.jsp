<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>

<table width="100%" bgcolor="#EEEEEE">
  <tr><td>
    <b><bean:message key="sidebar.sessionExample"/></b>
    <ul>
      <li>
        <html:link page="/echo/echoAction.do">
          EchoEJB
        </html:link>
      </li>
    </ul>
  </td></tr>
  <tr><td>&nbsp;</td></tr>
  <tr><td>
    <b><bean:message key="sidebar.cmrExample"/></b>
    <ul>
      <li><html:link page="/common/countryAction.do?action=query">
        Country
      </html:link></li>
      <li><html:link page="/common/cityAction.do?action=query">
        City
      </html:link></li>
      <li><html:link page="/common/languageAction.do?action=query">
        Language
      </html:link></li>
      <li><html:link page="/common/languageCodeAction.do?action=query">
        Language Code
      </html:link></li>
    </ul>
  </td></tr>
</table>