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
          <td align="right">�z�O���峹�� 19 �Ӿ\Ū��</td>
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
          <td colspan="2" class="grey9b">* �峹�D�D�G<%=new String(message.getSubject().getBytes(), encode)%></td>
        </tr>
        <tr valign="middle">
          <td width="25%" rowspan="3" valign="top" class="table3">���D <br>
            <br>
            ��a: ���إ��� �x�W <br>
            ����: + 2 <br>
            �Ӧ�: �x�W <br>
            Ų�w: �w�]���O�K <br>
            �`�o���: 399 �g <br>
            ���U���: 2002/11/28</td>
          <td width="75%" valign="top" class="table3">
              <html:link styleClass="link1" href="#">�d��</html:link>�@
              <html:link styleClass="link1" href="#">����</html:link>�@
              <html:link styleClass="link1" href="#">�l��</html:link>�@
              <html:link styleClass="link1" href="#">�D��</html:link>�@
              <html:link styleClass="link1" href="#">�ޥ�</html:link>�@
              <html:link styleClass="link1" href="<%=replyLink%>">�^��</html:link>
          </td>
        </tr>
        <tr valign="middle">
          <td valign="top" class="table3">
              <%=new String(message.getMessage().getBytes(), encode)%>
          </td>
        </tr>
        <tr valign="middle">
          <td valign="top"  class="table3"> <html:link styleClass="link1" href="#">�s��</html:link>�@2003/02/11
            05:19:29�@ IP: �w�]���O�K </td>
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
                  <td width="25%" rowspan="3" valign="top" class="table3"> �׾� ���`�¥D <br>
                    <br>
                    ��a: ���إ��� �x�W <br>
                    ����: + 4 <br>
                    �Ӧ�: �x�W <br>
                    Ų�w: �w�]���O�K <br>
                    �`�o���: 904 �g <br>
                    ���U���: 2002/11/28</td>
                  <td width="75%" valign="top" class="table3">
                      <html:link styleClass="link1" href="#">�d��</html:link>
                      <html:link styleClass="link1" href="#">����</html:link>�@
                      <html:link styleClass="link1" href="#">�l��</html:link>�@
                      <html:link styleClass="link1" href="#">�D��</html:link>�@
                      <html:link styleClass="link1" href="#">�ޥ�</html:link>�@
                      <html:link styleClass="link1" href="#">�^��</html:link>
                  </td>
                </tr>
                <tr valign="middle"  class="table3">
                  <td height="128" valign="top">
                      <%=new String(replyMsg.getMessage().getBytes(), encode)%>
                  </td>
                </tr>
                <tr valign="middle">
                  <td valign="top" class="table3"><html:link styleClass="link1" href="#">�s��</html:link>�@2003/02/11
                    05:19:29�@ IP: �w�]���O�K </td>
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
