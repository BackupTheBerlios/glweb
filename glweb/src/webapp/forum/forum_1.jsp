<%--
 $Id: forum_1.jsp,v 1.4 2003/09/22 16:59:43 primo Exp $
 $Revision: 1.4 $
 $Date: 2003/09/22 16:59:43 $
 $Author: primo $
--%>
<%@ page import="java.util.*, com.glweb.module.forum.model.*,com.glweb.module.member.model.*, com.glweb.Constants" %>

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>

<jsp:useBean id="forum1Form" class="com.glweb.module.forum.form.Forum1Form" scope="request" />
<%
    String encode = "8859_1";
    User user = (User)session.getAttribute(Constants.USER_KEY);
%>
<html:errors />
<table width="100%" border="0" cellpadding="0" cellspacing="6" class="table3">
  <tr>
    <td background="../image/title_talk-bg.jpg">�@ �@�@ <html:img width="215" height="36" src="../image/title_talk.jpg"/>
    </td>
  </tr>
  <tr>
    <td class="table4">
      <table width="100%" border="0" cellpadding="2" cellspacing="1" class="grey8">
        <tr>
          <td width="88%"  class="table2"> �ֳt�n�J�J�f�@
               <html:link styleClass="link1" href="../member/member1.do">[���U�Τ� ]</html:link>�@
               <html:link styleClass="link1" href="#">[�ѰO�K�X]</html:link>
          </td>
        </tr>
        <tr  class="table3">
          <td>
            <html:form action="/forum/forum1.do" method="post">
              <html:hidden property="action" />
              <strong>�Τ�W:</strong>
              <html:text property="name" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="15"/>
              �@<strong>�K�X:</strong>
              <html:password property="password" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="15"/>              �@

              <html:select property="forumMenu" onchange="MM_jumpMenu('parent',this,0)">
                <html:option value="#">�Q�ת��@</html:option>
                <html:option value="#">�Q�ת��G</html:option>
                <html:option value="#">�Q�ת��T</html:option>
              </html:select>
              �@ <html:link href="javascript:login();"><html:img width="58" height="21" align="absmiddle" border="0" src="../image/login.gif"/></html:link>
            </html:form>
            <%
                //����w��T��
                if(user != null){
                    out.print(new String(user.getLastName().getBytes(), encode) + ", �A�n!");
                }
            %>
          </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td  class="table4">
      <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#C4938E" class="grey9b">
        <tr valign="middle">
          <td width="7%" align="center" class="table2">���A</td>
          <td align="center"  class="table3">�� �� �W �� </td>
          <td width="11%" align="center" class="table2">���D</td>
          <td width="7%" align="center"  class="table3">�D�D</td>
          <td width="7%" align="center"  class="table3">�^��</td>
          <td width="20%" align="center" class="table2">�̫��s</td>
          <td width="7%" align="center" bgcolor="#FFFFFF">����</td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td>
      <table width="100%" height="1" cellpadding="0" cellspacing="0" background="../image/dotline.gif" border="0">
        <tr>
          <td><html:img width="200" height="1" src="../image/h1.gif"/></td>
        </tr>
      </table>
    </td>
  </tr>
<%
    Collection categories = null; //�Ĥ@�h����
    Category category = null;
    Category category2 = null;
    Set childrenCategories = null; //�ĤG�h����
    Set moderators = null;  //���D
    Iterator rootIter = null;
    Iterator childIter = null;
    Iterator moderatorIter = null;
    User moderator = null;
    String messageLink = "#";
    String moderatorLink = "#";

    //��ܲĤ@�h����
    categories = forum1Form.getCategories();
    if(categories != null){
        rootIter = categories.iterator();
        while(rootIter.hasNext()){
            category = (Category)rootIter.next();
%>
          <tr>
            <td>
              <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FDF2F1" class="grey9b">
                <tr>
                  <td class="table1"> <html:img width="27" height="20" align="absbottom" src="../image/dot.jpg"/><%=new String(category.getName().getBytes(), encode)%><html:link styleClass="link" href="#"></html:link></td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td>
              <table width="100%" height="1" cellpadding="0" cellspacing="0" background="../image/dotline.gif" border="0">
                <tr>
                  <td><html:img width="200" height="1" src="../image/h1.gif"/></td>
                </tr>
              </table>
            </td>
          </tr>
                <%
                    //��ܲĤG�h����
                    childrenCategories = category.getChildrenCategories();
                    childIter = childrenCategories.iterator();
                    while(childIter.hasNext()){
                        category2 = (Category)childIter.next();
                        messageLink = "forum2.do?action=query&categoryId=" + category2.getId();
                %>
                          <tr>
                            <td  class="table4">
                              <table width="100%" border="0" cellpadding="6" cellspacing="1" class="grey8">
                                <tr valign="middle">
                                  <td width="7%" align="center" class="table2"><html:link href="#"><html:img width="16" height="15" border="0" src="../image/icon01.gif"/></html:link></td>
                                  <td class="table3"><html:link styleClass="link1" href="<%=messageLink%>">�i<%=new String(category2.getName().getBytes(), encode)%>�j</html:link><br>
                                    <%=new String(category2.getDescription().getBytes(), encode)%></td>
                                  <td width="11%" align="center" class="table2">
                                    <%
                                        //��ܪ��D
                                        moderators = category2.getModerators();
                                        moderatorIter = moderators.iterator();
                                        while(moderatorIter.hasNext()){
                                            moderator = (User)moderatorIter.next();
                                            moderatorLink = "../member/member3.do?userId=" + moderator.getId();
                                    %>
                                            <html:link styleClass="link1" href="<%=moderatorLink%>"><%=moderator.getName()%></html:link><br>
                                    <%
                                        }
                                    %>
                                  <td width="7%" align="center"  class="table3">34</td>
                                  <td width="7%" align="center" class="table3">63</td>
                                  <td width="20%" class="table2">�D�D�G[����]����....<br>
                                    �̫�o��G<html:link href="#"><html:img width="13" height="13" align="absmiddle" border="0" src="../image/link.gif"/></html:link><br>
                                    2003�~03��15�� 06:18pm</td>
                                  <td width="7%" align="center" class="table3"><html:link href="#"><html:img width="17" height="16" border="0" src="../image/star.gif"/></html:link></td>
                                </tr>
                              </table>
                            </td>
                          </tr>
                          <tr>
                            <td>
                              <table width="100%" height="1" cellpadding="0" cellspacing="0" background="../image/dotline.gif" border="0">
                                <tr>
                                  <td><html:img width="200" height="1" src="../image/h1.gif"/></td>
                                </tr>
                              </table>
                            </td>
                          </tr>
<%
                    }
        }
    }
%>
</table>
<script language='javascript'>
    function login(){
        document.forum1Form.action.value = 'login';
        document.forum1Form.submit();
    }
</script>