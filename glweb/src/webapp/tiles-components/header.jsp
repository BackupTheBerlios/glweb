<%--
 $Id: header.jsp,v 1.1 2003/05/10 11:41:13 paxson Exp $
 $Revision: 1.1 $
 $Date: 2003/05/10 11:41:13 $
 $Author: paxson $
--%>

<%@ page contentType="text/html" language="java" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>

<table width="100%">
    <tr>
        <td><h4><bean:message key="index.title"/></h4></td>
        <td align="right">
            <html:link page="/action/localeAction.do?language=en">
                <bean:message key="link.locale.en"/>
            </html:link>
            |
            <html:link page="/action/localeAction.do?language=zh">
                <bean:message key="link.locale.zh"/>
            </html:link>
        </td>
    </tr>
</table>
<hr/>