<%@ page contentType="text/html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>

<bean:message key="heading.echoMessage"/> : 
<bean:write name="echoForm" property="message"/>