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
    <td height="26" colspan="2"><html:link styleClass="link1" href="../forum/forum1.do">GL台灣影音旅(論壇報)</html:link> &gt;
      <html:link styleClass="link1" href="#">【旅遊相關討論版】</html:link> &gt; <html:link styleClass="link1" href="#">用戶資料</html:link></td>
  </tr>
  <tr>
    <td height="26" colspan="2" align="center" class="grey9b">用戶資料</td>
  </tr>
  <tr>
    <td height="26" colspan="2" align="center" class="table2">
      <table width="100%" border="0" cellpadding="0" cellspacing="2" class="grey8">
        <tr>
          <td width="50%" align="left">姓名:<%= new String(user.getName().getBytes(), encode)%></td>
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
                <td colspan="2" align="center" class="table3"><html:img src="<%=user.getPimImage()%>" width="100" height="80"/></td>
              </tr>
              <tr>
                <td colspan="2" align="center" class="table2"><font class="grey9b">
                  聯繫資料 </font> </td>
              </tr>
              <tr>
                <td width="25%" class="table3"><font class="grey8b"> 電子郵件： </font>
                </td>
                <td width="75%" class="table3"><html:link href="<%="mailto:"+ user.getEmail()%>" styleClass="link1"><%=user.getEmail()%></html:link></td>
              </tr>
              <tr>
                <td colspan="2" align="center" class="table2"><font class="grey9b">最近發表的主題
                  </font> </td>
              </tr>
              <tr>
                <td colspan="2" class="table3">
                  <table width="100%" border="0" cellspacing="2" cellpadding="0">
                    <tr>
                      <td><html:link href="#"><html:img width="16" height="16" align="absmiddle" border="0" src="../image/link_article.gif"/></html:link>
                        <html:link styleClass="link1" href="#">英文 ABC 教學</html:link></td>
                    </tr>
                    <tr>
                      <td><html:link href="#"><html:img width="16" height="16" align="absmiddle" border="0" src="../image/link_article.gif"/></html:link>
                        <html:link styleClass="link1" href="#"> 防止擾人的[信差服務] </html:link></td>
                    </tr>
                    <tr>
                      <td><html:link href="#"><html:img width="16" height="16" align="absmiddle" border="0" src="../image/link_article.gif"/></html:link>
                        <html:link styleClass="link1" href="#">家中裝修小問題找不到人可問時? 知道的話告訴你.[公告]
                        </html:link></td>
                    </tr>
                    <tr>
                      <td><html:link href="#"><html:img width="16" height="16" align="absmiddle" border="0" src="../image/link_article.gif"/></html:link>
                        <html:link styleClass="link1" href="#">[分享]GAME\uFF5E考考你的IQ\uFF5E </html:link></td>
                    </tr>
                    <tr>
                      <td><html:link href="#"><html:img width="16" height="16" align="absmiddle" border="0" src="../image/link_article.gif"/></html:link>
                        <html:link styleClass="link1" href="#"> [原創]淡淡的微笑 </html:link></td>
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
                <td width="75%" class="table3"><%= new String(user.getName().getBytes(), encode)%> </td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b">真實姓名：</font></td>
                <td class="table3"><%=new String(user.getFirstName().getBytes(), encode) + new String(user.getLastName().getBytes(), encode)%></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b"> 國家地區：</font></td>
                <td class="table3"><%=new String(user.getCountry().getBytes(), encode)%> </td>
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
                <td class="table3"><%=new String(user.getUserProfile().getPimIntroduction().getBytes(), encode)%></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b"> 個人愛好： </font></td>
                <td class="table3"><%=new String(user.getUserProfile().getPimHobby().getBytes(), encode)%></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b">座 右 銘：</font></td>
                <td class="table3"><%=new String(user.getUserProfile().getMotto().getBytes(), encode)%></td>
              </tr>
              <tr align="center">
                <td colspan="2" class="table3"><font class="grey9b">更多詳細資料</font></td>
              </tr>
              <tr>
                <td class="table3"><font class="grey8b">星 座 ：</font></td>
                <td class="table3"><%=new String(user.getStarSign().getBytes(), encode)%></td>
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
