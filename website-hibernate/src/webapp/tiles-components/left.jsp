<%--
 $Id: left.jsp,v 1.1 2003/05/10 11:41:13 paxson Exp $
 $Revision: 1.1 $
 $Date: 2003/05/10 11:41:13 $
 $Author: paxson $
--%>

<%@ page contentType="text/html" language="java" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>

<table width="100%" bgcolor="#EEEEEE">
    <tr><td>
        <b><bean:message key="sidebar.example"/></b>
        <ul>
            <li><html:link page="/action/helloAction.do">
                <bean:message key="link.hello"/>
            </html:link></li>
        </ul>
    </td></tr>
</table>