<%--
 $Id: member_3.jsp,v 1.2 2003/06/12 05:52:46 paxson Exp $
 $Revision: 1.2 $
 $Date: 2003/06/12 05:52:46 $
 $Author: paxson $
--%>

<jsp:useBean id = "user" class="com.glweb.module.member.model.User" scope="session" />

<table width="100%" border="0" cellpadding="0" cellspacing="8" class="table3">
  <tr>
    <td height="26" colspan="2"><a href="#" class="link1">GL台灣影音旅(論壇報)</a> &gt;
      <a href="#" class="link1">【旅遊相關討論版】</a> &gt; <a href="#" class="link1">用戶資料</a></td>
  </tr>
  <tr>
    <td height="26" colspan="2" align="center" class="grey9b">用戶資料</td>
  </tr>
  <tr>
    <td height="26" colspan="2" align="center" class="table2">
      <table width="100%" border="0" cellpadding="0" cellspacing="2" class="grey8">
        <tr>
          <td width="50%" align="left">姓名:<%= user.getName()%></td>
          <td width="50%" align="right">註冊日期：<%= user.getCreationDate() %> </td>
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
                <td colspan="2" align="center" class="table2"><font class="grey9b">個人頭像：</font></td>
              </tr>
              <tr>
                <td colspan="2" align="center" class="table3"><img src="<%=user.getPimImage()%>" width="100" height="80"></td>
              </tr>
              <tr>
                <td colspan="2" align="center" class="table2"><font class="grey9b">
                  聯繫資料 </font> </td>
              </tr>
              <tr>
                <td width="25%" class="table3"><font class="grey8b"> 電子郵件： </font>
                </td>
                <td width="75%" class="table3"><a href="%20mailto:<%=user.getEmail()%>w%20" class="link1">pony@gl.com.tw</a></td>
              </tr>
              <tr>
                <td colspan="2" align="center" class="table2"><font class="grey9b">最近發表的主題
                  </font> </td>
              </tr>
              <tr>
                <td colspan="2" class="table3">
                  <table width="100%" border="0" cellspacing="2" cellpadding="0">
                    <tr>
                      <td><a href="#"><img src="../image/link_article.gif" width="16" height="16" border="0" align="absmiddle"></a>
                        <a href="#" class="link1">英文 ABC 教學</a></td>
                    </tr>
                    <tr>
                      <td><a href="#"><img src="../image/link_article.gif" width="16" height="16" border="0" align="absmiddle"></a>
                        <a href="#" class="link1"> 防止擾人的[信差服務] </a></td>
                    </tr>
                    <tr>
                      <td><a href="#"><img src="../image/link_article.gif" width="16" height="16" border="0" align="absmiddle"></a>
                        <a href="#" class="link1">家中裝修小問題找不到人可問時? 知道的話告訴你.[公告]
                        </a></td>
                    </tr>
                    <tr>
                      <td><a href="#"><img src="../image/link_article.gif" width="16" height="16" border="0" align="absmiddle"></a>
                        <a href="#" class="link1">[分享]GAME\uFF5E考考你的IQ\uFF5E </a></td>
                    </tr>
                    <tr>
                      <td><a href="#"><img src="../image/link_article.gif" width="16" height="16" border="0" align="absmiddle"></a>
                        <a href="#" class="link1"> [原創]淡淡的微笑 </a></td>
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
                <td colspan="2" align="center" class="table2"><font class="grey9b">基本資料</font></td>
              </tr>
              <tr>
                <td width="25%" class="table3"><font class="grey8b"> 會員名字： </font></td>
                <td width="75%" class="table3"><%= user.getName()%> </td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b">真實姓名：</font></td>
                <td class="table3"><%=user.getFirstName()+user.getLastName()%></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b"> 國家地區：</font></td>
                <td class="table3"><%=user.getCountry()%> </td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b"> 性 別：</font></td>
                <%
                    String sex = "帥哥";
                    if(user.getSex() == false){
                       sex = "美女";
                    }
                %>
                <td class="table3"><%=sex%></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b">文章總數： </font></td>
                <td class="table3">422</td>
              </tr>
              <tr align="center">
                <td colspan="2" class="table3"><font class="grey9b"> 更多詳細資料</font></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b">個人簡介： </font></td>
                <td class="table3"><%=user.getUserProfile().getPimIntroduction()%></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b"> 個人愛好： </font></td>
                <td class="table3"><%=user.getUserProfile().getPimHobby()%></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b">座 右 銘：</font></td>
                <td class="table3"><%=user.getUserProfile().getMotto()%></td>
              </tr>
              <tr align="center">
                <td colspan="2" class="table3"><font class="grey9b">更多詳細資料</font></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b">星 座 ：</font></td>
                <td class="table3"><%=user.getStarSign()%></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b">MSN Messenger：</font></td>
                <td class="table3"><%=user.getMsnNo()%></td>
              </tr>
              <tr align="center">
                <td colspan="2" class="table3"><font class="grey9b">相關連結</font></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b">個人首頁：</font></td>
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
