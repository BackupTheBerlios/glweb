<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-form.tld" prefix="form" %>
<%@ taglib uri="/WEB-INF/tlds/struts-template.tld" prefix="template" %>

<html:html>
  <head>
    <title><template:get name="title"/></title>
    <html:base/>
  </head>
  <body>
    <html:errors/>
    <table width="100%">
      <tr><td colspan="2">
        <template:get name="header"/>
      </td></tr>
      <tr>
        <td width="20%" valign="top">
          <template:get name="sidebar"/>
        </td>
        <td width="80%" valign="top">
          <template:get name="main"/>
        </td>
      </tr>
      <tr><td colspan="2">
        <template:get name="footer"/>
      </td></tr>
    </table>
  </body>
</html:html>