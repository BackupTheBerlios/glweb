<%--
 $Id: rootLayout.jsp,v 1.2 2003/06/12 05:53:11 paxson Exp $
 $Revision: 1.2 $
 $Date: 2003/06/12 05:53:11 $
 $Author: paxson $
--%>

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-tiles.tld" prefix="tiles" %>

<html>
<head>
    <title><tiles:getAsString name="titleString"/></title>
    <link rel=stylesheet href="css/index.css">

    <%@ include file="scriptcss.jsp" %>

</head>
<body>
<center>
<table width="750" cellpadding="0" cellspacing="0" border="0"  >
    <tr><td valign="top" align="left" width="750">
        <img src="images/spacer.gif" height="1" width="750" border="0" hspace="0" vspace="0"  />
    </td></tr>
    <tr><td valign="top" align="left" width="750">
        <img src="images/tjlicp156x60.gif" border="0" hspace=0 vspace="0"/>
    </td></tr>
    <tr><td>
        <!---MAIN  ----->
        <table width="750" cellpadding="0" cellspacing="0" border="0"  >
            <tr><td valign="top" align="left" class="whiteBG">
                <tiles:insert attribute="header"/>
            </td></tr>
            <tr><td valign="top" align="left" class="navactive">
                <img src="images/spacer.gif" height="7" width="4"/>
            </td></tr>
            <tr><td valign="top" align="left" class="whiteBG">
                <tiles:insert attribute="search"/>
            </td></tr>
            <tr><td>
                <%--
                <tiles:insert attribute="data"/>
                --%>
                Data
            </td></tr>
            <tr><td>
                <html:errors/>
            </td></tr>
            <tr><td valign="top" align="left" width="750">
                <table cellspacing=3 border=0 cellpadding="0" >
                    <tr>
                        <td valign="top">
                            <tiles:insert attribute="left"/>
                        </td>
                        <td valign="top">
                            <tiles:insert attribute="middle"/>
                        </td>
                    </tr>
                </table>
            </td></tr>
            <tr><td valign="top" align="left" class="whiteBG">
                <tiles:insert attribute="footer"/>
            </td></tr>
        </table>
        <!--END MAIN  ------------>
    </td></tr>
</table>
<center>

<%@ include file="script.jsp" %>

</body>
</html>
    