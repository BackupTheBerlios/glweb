<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>

<table width="100%">
  <tr>
    <td><h4><bean:message key="header.title"/></h4></td>
    <td align="right">
      <html:link page="/common/multiLingualAction.do?language=en">
        <bean:message key="link.multilingual.en"/>
      </html:link>
      |
      <html:link page="/common/multiLingualAction.do?language=zh">
        <bean:message key="link.multilingual.zh"/>
      </html:link>
    </td>
  </tr>
</table>
<hr/>