<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-tiles.tld" prefix="tiles" %>

<html:html>
<head>
<title><tiles:getAsString name="title"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=big5">
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_jumpMenu(targ,selObj,restore){ //v3.0
  eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
  if (restore) selObj.selectedIndex=0;
}
//-->
</script>
<link href="../image/wstyle2.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#666666" topmargin="8">
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td> 
      <!--第一部份:logo/banner/btn link -->
      <tiles:insert attribute="header"/> </td>
  </tr>
  <tr> 
    <td align="center" valign="top">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td width="1" background="../image/leftside.jpg"><img src="../image/leftside.jpg" width="10" height="10"></td>
          <td class="table3"> 
            <!--第二部分:論壇 -->
            <tiles:insert attribute="body"/> </td>
          <td width="10" background="../image/rightside.jpg"><img src="../image/rightside.jpg" width="10" height="10"></td>
        </tr>
      </table>
    </td>
  </tr>
  <tr> 
    <td height="1" align="center" bgcolor="#FFCC00" class="copyright"> 
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td width="9"></td>
          <td height="1" bgcolor="#663300"><img src="../image/h1.gif" width="200" height="1"></td>
          <td width="9"></td>
        </tr>
      </table>
    </td>
  </tr>
  <tr> 
    <td align="center" class="copyright"> 
      <!--第三部份:copyright -->
      <tiles:insert attribute="footer"/> </td>
  </tr>
</table>
</body>
</html:html>
