<%--
 $Id: forum_3.jsp,v 1.4 2003/09/22 16:59:43 primo Exp $
 $Revision: 1.4 $
 $Date: 2003/09/22 16:59:43 $
 $Author: primo $
--%>

<%@ page import="java.util.*, com.glweb.module.forum.model.*" %>

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>

<jsp:useBean id="forum3Form" class="com.glweb.module.forum.form.Forum3Form" scope="request" />
<%
    String encode = "8859_1";
%>
<table width="100%" border="0" cellpadding="0" cellspacing="5" class="table3">
  <tr>
    <td background="../image/title_talk-bg.jpg"><html:img width="215" height="36" src="../image/title_talk.jpg"/></td>
  </tr>
  <tr>
    <td class="table1">
      <table width="100%" border="0" cellpadding="0" cellspacing="4" class="grey8">
        <tr>
          <td align="right">您是本文章第 19 個閱讀者</td>
        </tr>
      </table>
    </td>
  </tr>
<%
    Message message = forum3Form.getMessage();
    String categoryId = Long.toString(message.getCategory().getId());
    String messageId = Long.toString(message.getId());
    String replyLink = "../member/member5.do?categoryId=" + categoryId + "&messageId=" + messageId;
%>
  <tr>
    <td  class="table4">
      <table width="100%" border="0" cellpadding="6" cellspacing="1" class="grey8">
        <tr valign="middle"  class="table2">
          <td colspan="2" class="grey9b">* 文章主題：<%=new String(message.getSubject().getBytes(), encode)%></td>
        </tr>
        <tr valign="middle">
          <td width="25%" rowspan="3" valign="top" class="table3">版主 <br>
            <br>
            國家: 中華民國 台灣 <br>
            等級: + 2 <br>
            來自: 台灣 <br>
            鑑定: 已設為保密 <br>
            總發文數: 399 篇 <br>
            註冊日期: 2002/11/28</td>
          <td width="75%" valign="top" class="table3">
              <html:link styleClass="link1" href="#">查看</html:link>　
              <html:link styleClass="link1" href="#">消息</html:link>　
              <html:link styleClass="link1" href="#">郵件</html:link>　
              <html:link styleClass="link1" href="#">主頁</html:link>　
              <html:link styleClass="link1" href="#">引用</html:link>　
              <html:link styleClass="link1" href="<%=replyLink%>">回覆</html:link>
          </td>
        </tr>
        <tr valign="middle">
          <td valign="top" class="table3">
              <%=new String(message.getMessage().getBytes(), encode)%>
          </td>
        </tr>
        <tr valign="middle">
          <td valign="top"  class="table3"> <html:link styleClass="link1" href="#">編輯</html:link>　2003/02/11
            05:19:29　 IP: 已設為保密 </td>
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
    Set replyMsgs = message.getReplyMessages();
    Message replyMsg = null;
    if(replyMsgs != null){
        Iterator iter = replyMsgs.iterator();
        while(iter.hasNext()){
            replyMsg = (Message)iter.next();
%>
          <tr>
            <td class="table4">
              <table width="100%" border="0" cellpadding="6" cellspacing="1" class="grey8">
                <tr>
                  <td width="25%" rowspan="3" valign="top" class="table3"> 論壇 報總壇主 <br>
                    <br>
                    國家: 中華民國 台灣 <br>
                    等級: + 4 <br>
                    來自: 台灣 <br>
                    鑑定: 已設為保密 <br>
                    總發文數: 904 篇 <br>
                    註冊日期: 2002/11/28</td>
                  <td width="75%" valign="top" class="table3">
                      <html:link styleClass="link1" href="#">查看</html:link>
                      <html:link styleClass="link1" href="#">消息</html:link>　
                      <html:link styleClass="link1" href="#">郵件</html:link>　
                      <html:link styleClass="link1" href="#">主頁</html:link>　
                      <html:link styleClass="link1" href="#">引用</html:link>　
                      <html:link styleClass="link1" href="#">回覆</html:link>
                  </td>
                </tr>
                <tr valign="middle"  class="table3">
                  <td height="128" valign="top">
                      <%=new String(replyMsg.getMessage().getBytes(), encode)%>
                  </td>
                </tr>
                <tr valign="middle">
                  <td valign="top" class="table3"><html:link styleClass="link1" href="#">編輯</html:link>　2003/02/11
                    05:19:29　 IP: 已設為保密 </td>
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
