<%--
 $Id: member_3.jsp,v 1.2 2003/06/12 05:52:46 paxson Exp $
 $Revision: 1.2 $
 $Date: 2003/06/12 05:52:46 $
 $Author: paxson $
--%>

<jsp:useBean id = "user" class="com.glweb.module.member.model.User" scope="session" />

<table width="100%" border="0" cellpadding="0" cellspacing="8" class="table3">
  <tr>
    <td height="26" colspan="2"><a href="#" class="link1">GL�x�W�v����(�׾³�)</a> &gt;
      <a href="#" class="link1">�i�ȹC�����Q�ת��j</a> &gt; <a href="#" class="link1">�Τ���</a></td>
  </tr>
  <tr>
    <td height="26" colspan="2" align="center" class="grey9b">�Τ���</td>
  </tr>
  <tr>
    <td height="26" colspan="2" align="center" class="table2">
      <table width="100%" border="0" cellpadding="0" cellspacing="2" class="grey8">
        <tr>
          <td width="50%" align="left">�m�W:<%= user.getName()%></td>
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
                <td colspan="2" align="center" class="table3"><img src="<%=user.getPimImage()%>" width="100" height="80"></td>
              </tr>
              <tr>
                <td colspan="2" align="center" class="table2"><font class="grey9b">
                  �pô��� </font> </td>
              </tr>
              <tr>
                <td width="25%" class="table3"><font class="grey8b"> �q�l�l��G </font>
                </td>
                <td width="75%" class="table3"><a href="%20mailto:<%=user.getEmail()%>w%20" class="link1">pony@gl.com.tw</a></td>
              </tr>
              <tr>
                <td colspan="2" align="center" class="table2"><font class="grey9b">�̪�o���D�D
                  </font> </td>
              </tr>
              <tr>
                <td colspan="2" class="table3">
                  <table width="100%" border="0" cellspacing="2" cellpadding="0">
                    <tr>
                      <td><a href="#"><img src="../image/link_article.gif" width="16" height="16" border="0" align="absmiddle"></a>
                        <a href="#" class="link1">�^�� ABC �о�</a></td>
                    </tr>
                    <tr>
                      <td><a href="#"><img src="../image/link_article.gif" width="16" height="16" border="0" align="absmiddle"></a>
                        <a href="#" class="link1"> �����Z�H��[�H�t�A��] </a></td>
                    </tr>
                    <tr>
                      <td><a href="#"><img src="../image/link_article.gif" width="16" height="16" border="0" align="absmiddle"></a>
                        <a href="#" class="link1">�a���˭פp���D�䤣��H�i�ݮ�? ���D���ܧi�D�A.[���i]
                        </a></td>
                    </tr>
                    <tr>
                      <td><a href="#"><img src="../image/link_article.gif" width="16" height="16" border="0" align="absmiddle"></a>
                        <a href="#" class="link1">[����]GAME\uFF5E�ҦҧA��IQ\uFF5E </a></td>
                    </tr>
                    <tr>
                      <td><a href="#"><img src="../image/link_article.gif" width="16" height="16" border="0" align="absmiddle"></a>
                        <a href="#" class="link1"> [���]�H�H���L�� </a></td>
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
                <td width="75%" class="table3"><%= user.getName()%> </td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b">�u��m�W�G</font></td>
                <td class="table3"><%=user.getFirstName()+user.getLastName()%></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b"> ��a�a�ϡG</font></td>
                <td class="table3"><%=user.getCountry()%> </td>
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
                <td class="table3"><%=user.getUserProfile().getPimIntroduction()%></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b"> �ӤH�R�n�G </font></td>
                <td class="table3"><%=user.getUserProfile().getPimHobby()%></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b">�y �k �ʡG</font></td>
                <td class="table3"><%=user.getUserProfile().getMotto()%></td>
              </tr>
              <tr align="center">
                <td colspan="2" class="table3"><font class="grey9b">��h�ԲӸ��</font></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b">�P �y �G</font></td>
                <td class="table3"><%=user.getStarSign()%></td>
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
                <td class="table3"><a href="#" class="link1"><%=user.getHomePage()%></a></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td align="right" valign="top" ><a href="member_4.do"><img src="../image/ok.gif" width="58" height="21"></a></td>
    <td align="left" valign="top" ><img src="../image/clear.gif" width="58" height="21"></td>
  </tr>
</table>
