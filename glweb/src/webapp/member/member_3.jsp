<%--
 $Id: member_3.jsp,v 1.3 2003/09/14 12:06:14 primo Exp $
 $Revision: 1.3 $
 $Date: 2003/09/14 12:06:14 $
 $Author: primo $
--%>
<%@ page import="com.glweb.module.member.model.*" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>

<jsp:useBean id = "member3Form" class="com.glweb.module.member.form.Member3Form" scope="request" />
<%
    String encode = "8859_1";
    User user = member3Form.getUser();
%>
<table width="100%" border="0" cellpadding="0" cellspacing="8" class="table3">
  <tr>
    <td height="26" colspan="2"><html:link styleClass="link1" href="../forum/forum1.do">GL�x�W�v����(�׾³�)</html:link> &gt;
      <html:link styleClass="link1" href="#">�i�ȹC�����Q�ת��j</html:link> &gt; <html:link styleClass="link1" href="#">�Τ���</html:link></td>
  </tr>
  <tr>
    <td height="26" colspan="2" align="center" class="grey9b">�Τ���</td>
  </tr>
  <tr>
    <td height="26" colspan="2" align="center" class="table2">
      <table width="100%" border="0" cellpadding="0" cellspacing="2" class="grey8">
        <tr>
          <td width="50%" align="left">�m�W:<%= new String(user.getName().getBytes(), encode)%></td>
          <td width="50%" align="right">���U����G<%= user.getCreationDate() %> </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td width="50%" valign="top" >
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table4">
        <tr>
          <td>
            <table width="100%" border="0" cellpadding="5" cellspacing="1" class="grey8">
              <tr>
                <td colspan="2" align="center" class="table2"><font class="grey9b">�ӤH�Y���G</font></td>
              </tr>
              <tr>
                <td colspan="2" align="center" class="table3"><html:img src="<%=user.getPimImage()%>" width="100" height="80"/></td>
              </tr>
              <tr>
                <td colspan="2" align="center" class="table2"><font class="grey9b">
                  �pô��� </font> </td>
              </tr>
              <tr>
                <td width="25%" class="table3"><font class="grey8b"> �q�l�l��G </font>
                </td>
                <td width="75%" class="table3"><html:link href="<%="mailto:"+ user.getEmail()%>" styleClass="link1"><%=user.getEmail()%></html:link></td>
              </tr>
              <tr>
                <td colspan="2" align="center" class="table2"><font class="grey9b">�̪�o���D�D
                  </font> </td>
              </tr>
              <tr>
                <td colspan="2" class="table3">
                  <table width="100%" border="0" cellspacing="2" cellpadding="0">
                    <tr>
                      <td><html:link href="#"><html:img width="16" height="16" align="absmiddle" border="0" src="../image/link_article.gif"/></html:link>
                        <html:link styleClass="link1" href="#">�^�� ABC �о�</html:link></td>
                    </tr>
                    <tr>
                      <td><html:link href="#"><html:img width="16" height="16" align="absmiddle" border="0" src="../image/link_article.gif"/></html:link>
                        <html:link styleClass="link1" href="#"> �����Z�H��[�H�t�A��] </html:link></td>
                    </tr>
                    <tr>
                      <td><html:link href="#"><html:img width="16" height="16" align="absmiddle" border="0" src="../image/link_article.gif"/></html:link>
                        <html:link styleClass="link1" href="#">�a���˭פp���D�䤣��H�i�ݮ�? ���D���ܧi�D�A.[���i]
                        </html:link></td>
                    </tr>
                    <tr>
                      <td><html:link href="#"><html:img width="16" height="16" align="absmiddle" border="0" src="../image/link_article.gif"/></html:link>
                        <html:link styleClass="link1" href="#">[����]GAME\uFF5E�ҦҧA��IQ\uFF5E </html:link></td>
                    </tr>
                    <tr>
                      <td><html:link href="#"><html:img width="16" height="16" align="absmiddle" border="0" src="../image/link_article.gif"/></html:link>
                        <html:link styleClass="link1" href="#"> [���]�H�H���L�� </html:link></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
    <td width="50%" valign="top">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table4">
        <tr>
          <td>
            <table width="100%" border="0" cellpadding="5" cellspacing="1" class="grey8">
              <tr>
                <td colspan="2" align="center" class="table2"><font class="grey9b">�򥻸��</font></td>
              </tr>
              <tr>
                <td width="25%" class="table3"><font class="grey8b"> �|���W�r�G </font></td>
                <td width="75%" class="table3"><%= new String(user.getName().getBytes(), encode)%> </td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b">�u��m�W�G</font></td>
                <td class="table3"><%=new String(user.getFirstName().getBytes(), encode) + new String(user.getLastName().getBytes(), encode)%></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b"> ��a�a�ϡG</font></td>
                <td class="table3"><%=new String(user.getCountry().getBytes(), encode)%> </td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b"> �� �O�G</font></td>
                <%
                    String sex = "�ӭ�";
                    if(user.getSex() == false){
                       sex = "���k";
                    }
                %>
                <td class="table3"><%=sex%></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b">�峹�`�ơG </font></td>
                <td class="table3">422</td>
              </tr>
              <tr align="center">
                <td colspan="2" class="table3"><font class="grey9b"> ��h�ԲӸ��</font></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b">�ӤH²���G </font></td>
                <td class="table3"><%=new String(user.getUserProfile().getPimIntroduction().getBytes(), encode)%></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b"> �ӤH�R�n�G </font></td>
                <td class="table3"><%=new String(user.getUserProfile().getPimHobby().getBytes(), encode)%></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b">�y �k �ʡG</font></td>
                <td class="table3"><%=new String(user.getUserProfile().getMotto().getBytes(), encode)%></td>
              </tr>
              <tr align="center">
                <td colspan="2" class="table3"><font class="grey9b">��h�ԲӸ��</font></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b">�P �y �G</font></td>
                <td class="table3"><%=new String(user.getStarSign().getBytes(), encode)%></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b">MSN Messenger�G</font></td>
                <td class="table3"><%=user.getMsnNo()%></td>
              </tr>
              <tr align="center">
                <td colspan="2" class="table3"><font class="grey9b">�����s��</font></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b">�ӤH�����G</font></td>
                <td class="table3"><html:link styleClass="link1" href="<%=user.getHomePage()%>"><%=user.getHomePage()%></html:link></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td align="right" valign="top" ><html:link href="../forum/forum1.do"><html:img width="58" height="21" src="../image/ok.gif"/></html:link></td>
    <td align="left" valign="top" ><html:img width="58" height="21" src="../image/clear.gif"/></td>
  </tr>
</table>
