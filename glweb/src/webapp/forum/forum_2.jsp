<%--
 $Id: forum_2.jsp,v 1.3 2003/09/14 12:05:54 primo Exp $
 $Revision: 1.3 $
 $Date: 2003/09/14 12:05:54 $
 $Author: primo $
--%>
<%@ page import="java.util.*, com.glweb.module.forum.model.*" %>

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>

<jsp:useBean id="forum2Form" class="com.glweb.module.forum.form.Forum2Form" scope="request" />
<%
    String encode = "8859_1";
%>
<table width="100%" border="0" cellpadding="0" cellspacing="5" class="table3">
  <tr>
    <td background="../image/title_talk-bg.jpg"><html:img width="215" height="36" src="../image/title_talk.jpg"/></td>
  </tr>
  <tr>
    <td class="table4">
      <table width="100%" border="0" cellpadding="2" cellspacing="1" class="grey8">
        <tr>
          <td width="88%" class="table2"> 目前論壇線上總共 1 人，本分類論壇共有 1 人。其中註冊用戶 0 人，訪客
            1 人。　<html:link styleClass="link" href="#">[ 關閉詳細列表 ]</html:link><br>
          </td>
          <td width="12%" align="center" class="table2"><html:link href="#"><html:img width="58" height="21" border="0" src="../image/reflesh.gif"/></html:link></td>
        </tr>
        <tr>
          <td class="table3"><html:link styleClass="link1" href="#">客人 </html:link><br>
          </td>
          <td class="table3">&nbsp;</td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td><html:link href="#"><html:img width="95" height="21" border="0" src="../image/new-topic.gif"/></html:link></td>
  </tr>
  <tr>
    <td class="table4">
      <table width="100%" border="0" cellpadding="2" cellspacing="1" class="grey9b">
        <tr valign="middle">
          <td width="7%" height="24" align="center" class="table2">狀態</td>
          <td width="48%" align="center" class="table3">主　題</td>
          <td width="10%" align="center" class="table2">作者</td>
          <td width="7%" align="center" class="table3">回覆</td>
          <td width="7%" align="center" class="table3">點選</td>
          <td width="21%" align="center" class="table2">最後更新 | 回覆者 </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td>
      <table width="100%" height="1"border="0" cellpadding="0" cellspacing="0" background="../image/dotline.gif">
        <tr>
          <td><html:img width="200" height="1" src="../image/h1.gif"/></td>
        </tr>
      </table>
    </td>
  </tr>
<%
    Collection messages = null;
    Message msg = null;
    Iterator iter = null;
    String messageLink = "#";

    messages = forum2Form.getMessages();
    if(messages != null){
        iter = messages.iterator();
        while(iter.hasNext()){
            msg = (Message)iter.next();
            messageLink = "forum3.do?action=query&messageId=" + msg.getId();
%>
              <tr>
                <td class="table4">
                  <table width="100%" border="0" cellpadding="6" cellspacing="1" class="grey8">
                    <tr valign="middle">
                      <td width="7%" align="center" class="table2"><html:link href="#"><html:img width="16" height="15" border="0" src="../image/icon01.gif"/></html:link></td>
                      <td width="48%" class="table3"><html:link styleClass="link1" href="<%=messageLink%>"><%=new String(msg.getSubject().getBytes(), encode)%></html:link></td>
                      <td width="10%" align="center" class="table2"> <html:link styleClass="link1" href="#">pony</html:link></td>
                      <td width="7%" align="center" class="table3">1</td>
                      <td width="7%" align="center" class="table3">99</td>
                      <td width="21%" class="table2">2003/03/30 23:22 | <html:link styleClass="link2" href="#">test</html:link></td>
                    </tr>
                  </table>
                </td>
              </tr>
              <tr>
                <td>
                  <table width="100%" height="1"border="0" cellpadding="0" cellspacing="0" background="../image/dotline.gif">
                    <tr>
                      <td><html:img width="200" height="1" src="../image/h1.gif"/></td>
                    </tr>
                  </table>
                </td>
              </tr>
<%
        }
    }
%>
</table>
