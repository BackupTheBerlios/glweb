<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>

<html:form action="/member/MemberDataAction" method="post">
<html:hidden value="addUser" property="action" />
<table width="100%" border="0" cellpadding="0" cellspacing="8" class="table3">
  <tr>
    <td height="28" colspan="2" class="table3"><html:link href="#" >GL�x�W�v����(�׾³�)</html:link>
      &gt; <html:link href="#" >�i�ȹC�����Q�ת��j</html:link> &gt; <html:link href="#" >�[�J�|��</html:link></td>
  </tr>
  <tr>
    <td height="28" colspan="2" align="center" class="table1"><font class="grey8">�e����
      <font color="#FF0000">*</font> ����쳣������g</font></td>
  </tr>
  <tr>
    <td width="50%" valign="top" >
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table4">
        <tr>
          <td>
            <table width="100%" border="0" cellpadding="5" cellspacing="1" class="grey8">
              <tr align="center">
                <td colspan="2" class="table2"><font class="grey9b">�p����k</font></td>
              </tr>
              <tr>
                <td width="35%" align="right" class="table3"><font color="#FF0000" >*</font><font class="grey8b">
                  �q�l�l��G </font> </td>
                <td width="65%" class="table3">
                  <html:text value="" property="email" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">����ܫH�c��}�G </td>
                <td class="table3">�O
                  <html:radio value="yes" property="emailDisplay"/>
                  �_
                  <html:radio value="no" property="emailDisplay"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">ICQ���X�G </td>
                <td class="table3">
                  <html:text value="" property="icq" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr align="center">
                <td colspan="2" class="table2"><font class="grey9b">�����s��</font>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">�ӤH�����G </td>
                <td class="table3">
                  <html:text value="" property="personHomePage" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr align="center">
                <td colspan="2" class="table2"><font class="grey9b">�ө��Y�� </font>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">�өʹϤ��G</td>
                <td class="table3">
                  <html:select property="personImg" onchange="ShowImage()">
                    <html:option value="non-asp/avatars/image0.gif">image0.gif</html:option>
                    <html:option value="non-asp/avatars/image1.gif">image1.gif</html:option>
                    <html:option value="non-asp/avatars/image2.gif">image2.gif</html:option>
                    <html:option value="non-asp/avatars/image3.gif">image3.gif</html:option>
                    <html:option value="non-asp/avatars/image4.gif">image4.gif</html:option>
                    <html:option value="non-asp/avatars/image5.gif">image5.gif</html:option>
                    <html:option value="non-asp/avatars/image6.gif">image6.gif</html:option>
                    <html:option value="non-asp/avatars/image7.gif">image7.gif</html:option>
                    <html:option value="non-asp/avatars/image8.gif">image8.gif</html:option>
                    <html:option value="non-asp/avatars/image9.gif">image9.gif</html:option>
                    <html:option value="non-asp/avatars/image10.gif">image10.gif</html:option>
                    <html:option value="non-asp/avatars/image11.gif">image11.gif</html:option>
                    <html:option value="non-asp/avatars/image12.gif">image12.gif</html:option>
                    <html:option value="non-asp/avatars/image13.gif">image13.gif</html:option>
                    <html:option value="non-asp/avatars/image14.gif">image14.gif</html:option>
                    <html:option value="non-asp/avatars/image15.gif">image15.gif</html:option>
                    <html:option value="non-asp/avatars/image16.gif">image16.gif</html:option>
                    <html:option value="non-asp/avatars/image17.gif">image17.gif</html:option>
                    <html:option value="non-asp/avatars/image18.gif">image18.gif</html:option>
                    <html:option value="non-asp/avatars/image19.gif">image19.gif</html:option>
                    <html:option value="non-asp/avatars/image20.gif">image20.gif</html:option>
                    <html:option value="non-asp/avatars/image21.gif">image21.gif</html:option>
                    <html:option value="non-asp/avatars/image22.gif">image22.gif</html:option>
                    <html:option value="non-asp/avatars/image23.gif">image23.gif</html:option>
                    <html:option value="non-asp/avatars/image24.gif">image24.gif</html:option>
                    <html:option value="non-asp/avatars/image25.gif">image25.gif</html:option>
                    <html:option value="non-asp/avatars/image26.gif">image26.gif</html:option>
                    <html:option value="non-asp/avatars/image27.gif">image27.gif</html:option>
                    <html:option value="non-asp/avatars/image28.gif">image28.gif</html:option>
                    <html:option value="non-asp/avatars/image29.gif">image29.gif</html:option>
                    <html:option value="non-asp/avatars/image30.gif">image30.gif</html:option>
                    <html:option value="non-asp/avatars/image31.gif">image31.gif</html:option>
                    <html:option value="non-asp/avatars/image32.gif">image32.gif</html:option>
                    <html:option value="non-asp/avatars/image33.gif">image33.gif</html:option>
                    <html:option value="non-asp/avatars/image34.gif">image34.gif</html:option>
                    <html:option value="non-asp/avatars/image35.gif">image35.gif</html:option>
                    <html:option value="non-asp/avatars/image36.gif">image36.gif</html:option>
                    <html:option value="non-asp/avatars/image37.gif">image37.gif</html:option>
                    <html:option value="non-asp/avatars/image38.gif">image38.gif</html:option>
                    <html:option value="non-asp/avatars/image39.gif">image39.gif</html:option>
                    <html:option value="non-asp/avatars/image40.gif">image40.gif</html:option>
                    <html:option value="non-asp/avatars/image41.gif">image41.gif</html:option>
                    <html:option value="non-asp/avatars/image42.gif">image42.gif</html:option>
                    <html:option value="non-asp/avatars/image43.gif">image43.gif</html:option>
                    <html:option value="non-asp/avatars/image44.gif">image44.gif</html:option>
                    <html:option value="non-asp/avatars/image45.gif">image45.gif</html:option>
                    <html:option value="non-asp/avatars/image46.gif">image46.gif</html:option>
                    <html:option value="non-asp/avatars/image47.gif">image47.gif</html:option>
                    <html:option value="non-asp/avatars/image48.gif">image48.gif</html:option>
                    <html:option value="non-asp/avatars/image49.gif">image49.gif</html:option>
                    <html:option value="non-asp/avatars/image50.gif">image50.gif</html:option>
                    <html:option value="non-asp/avatars/image51.gif">image51.gif</html:option>
                    <html:option value="non-asp/avatars/image52.gif">image52.gif</html:option>
                    <html:option value="non-asp/avatars/image53.gif">image53.gif</html:option>
                    <html:option value="non-asp/avatars/image54.gif">image54.gif</html:option>
                    <html:option value="non-asp/avatars/image55.gif">image55.gif</html:option>
                    <html:option value="non-asp/avatars/image56.gif">image56.gif</html:option>
                    <html:option value="non-asp/avatars/image57.gif">image57.gif</html:option>
                    <html:option value="non-asp/avatars/image58.gif">image58.gif</html:option>
                    <html:option value="non-asp/avatars/image59.gif">image59.gif</html:option>
                    <html:option value="non-asp/avatars/image60.gif">image60.gif</html:option>
                    <html:option value="non-asp/avatars/image61.gif">image61.gif</html:option>
                    <html:option value="non-asp/avatars/image62.gif">image62.gif</html:option>
                    <html:option value="non-asp/avatars/image63.gif">image63.gif</html:option>
                    <html:option value="non-asp/avatars/image64.gif">image64.gif</html:option>
                    <html:option value="non-asp/avatars/image65.gif">image65.gif</html:option>
                    <html:option value="non-asp/avatars/image66.gif">image66.gif</html:option>
                    <html:option value="non-asp/avatars/image67.gif">image67.gif</html:option>
                    <html:option value="non-asp/avatars/image68.gif">image68.gif</html:option>
                    <html:option value="non-asp/avatars/image69.gif">image69.gif</html:option>
                    <html:option value="non-asp/avatars/image70.gif">image70.gif</html:option>
                    <html:option value="non-asp/avatars/image71.gif">image71.gif</html:option>
                    <html:option value="non-asp/avatars/image72.gif">image72.gif</html:option>
                    <html:option value="non-asp/avatars/image73.gif">image73.gif</html:option>
                    <html:option value="non-asp/avatars/image74.gif">image74.gif</html:option>
                    <html:option value="non-asp/avatars/image75.gif">image75.gif</html:option>
                    <html:option value="non-asp/avatars/image76.gif">image76.gif</html:option>
                    <html:option value="non-asp/avatars/image77.gif">image77.gif</html:option>
                    <html:option value="non-asp/avatars/image78.gif">image78.gif</html:option>
                    <html:option value="non-asp/avatars/image79.gif">image79.gif</html:option>
                    <html:option value="non-asp/avatars/image80.gif">image80.gif</html:option>
                    <html:option value="non-asp/avatars/image81.gif">image81.gif</html:option>
                    <html:option value="non-asp/avatars/image82.gif">image82.gif</html:option>
                    <html:option value="non-asp/avatars/image83.gif">image83.gif</html:option>
                    <html:option value="non-asp/avatars/image84.gif">image84.gif</html:option>
                    <html:option value="non-asp/avatars/image85.gif">image85.gif</html:option>
                    <html:option value="non-asp/avatars/image86.gif">image86.gif</html:option>
                    <html:option value="non-asp/avatars/image87.gif">image87.gif</html:option>
                    <html:option value="non-asp/avatars/image88.gif">image88.gif</html:option>
                    <html:option value="non-asp/avatars/image89.gif">image89.gif</html:option>
                    <html:option value="non-asp/avatars/image90.gif">image90.gif</html:option>
                    <html:option value="non-asp/avatars/image91.gif">image91.gif</html:option>
                    <html:option value="non-asp/avatars/image92.gif">image92.gif</html:option>
                    <html:option value="non-asp/avatars/image93.gif">image93.gif</html:option>
                    <html:option value="non-asp/avatars/image94.gif">image94.gif</html:option>
                    <html:option value="non-asp/avatars/image95.gif">image95.gif</html:option>
                    <html:option value="non-asp/avatars/image96.gif">image96.gif</html:option>
                    <html:option value="non-asp/avatars/image97.gif">image97.gif</html:option>
                    <html:option value="non-asp/avatars/image98.gif">image98.gif</html:option>
                    <html:option value="non-asp/avatars/image99.gif">image99.gif</html:option>
                    <html:option value="non-asp/avatars/image100.gif">image100.gif</html:option>
                    <html:option value="non-asp/avatars/image101.gif">image101.gif</html:option>
                    <html:option value="non-asp/avatars/image102.gif">image102.gif</html:option>
                    <html:option value="non-asp/avatars/image103.gif">image103.gif</html:option>
                    <html:option value="non-asp/avatars/image104.gif">image104.gif</html:option>
                    <html:option value="non-asp/avatars/image105.gif">image105.gif</html:option>
                    <html:option value="non-asp/avatars/image106.gif">image106.gif</html:option>
                    <html:option value="non-asp/avatars/image107.gif">image107.gif</html:option>
                    <html:option value="non-asp/avatars/image108.gif">image108.gif</html:option>
                    <html:option value="non-asp/avatars/image109.gif">image109.gif</html:option>
                    <html:option value="non-asp/avatars/image110.gif">image110.gif</html:option>
                    <html:option value="non-asp/avatars/image111.gif">image111.gif</html:option>
                    <html:option value="non-asp/avatars/image112.gif">image112.gif</html:option>
                    <html:option value="non-asp/avatars/image113.gif">image113.gif</html:option>
                    <html:option value="non-asp/avatars/image114.gif">image114.gif</html:option>
                    <html:option value="non-asp/avatars/image115.gif">image115.gif</html:option>
                    <html:option value="non-asp/avatars/image116.gif">image116.gif</html:option>
                    <html:option value="non-asp/avatars/image117.gif">image117.gif</html:option>
                    <html:option value="non-asp/avatars/image118.gif">image118.gif</html:option>
                    <html:option value="non-asp/avatars/image119.gif">image119.gif</html:option>
                    <html:option value="non-asp/avatars/image120.gif">image120.gif</html:option>
                    <html:option value="non-asp/avatars/image121.gif">image121.gif</html:option>
                    <html:option value="non-asp/avatars/image122.gif">image122.gif</html:option>
                    <html:option value="non-asp/avatars/image123.gif">image123.gif</html:option>
                    <html:option value="non-asp/avatars/image124.gif">image124.gif</html:option>
                  </html:select>
                  <br>
                  <html:link href="#" >�����d�ݭө��Y���Ϯw</html:link></td>
              </tr>
              <tr>
                <td align="right" class="table3">�ۭq�j�Y�K�G </td>
                <td class="table3">�ϧ}�G
                  <html:text value="" property="personImgURL" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="18"/>
                  <br>
                  <font color="#FF0000">�����a�� http:// ������URL�a�}</font><br>
                  <html:text value="" property="personImgHigh" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="4"/>�e�@�סG 20 -- 120 ���������<br>
                  <html:text value="" property="personImgWidth" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="4"/>���@�סG 20 -- 120 ��������� </td>
              </tr>
              <tr align="center">
                <td colspan="2" class="table3">�p�G�Ϲ���m�����s���A�Ϥ��N�H�ۭq�����D </td>
              </tr>
              <tr align="center">
                <td colspan="2" class="table2"><font class="grey9b">��h�ԲӸ��</font>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">�ӤH²���G </td>
                <td class="table3">
                  <html:textarea property="personDesc"></html:textarea>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">�ӤH�R�n�G </td>
                <td class="table3">
                  <html:textarea property="personFancy"></html:textarea>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">�y �k �ʡG </td>
                <td class="table3">
                  <html:textarea property="motto"></html:textarea>
                </td>
              </tr>
              <tr align="center">
                <td height="26" colspan="2" class="table2"><font class="grey9b">�B�~���</font></td>
              </tr>
              <tr>
                <td align="right" class="table3"><font class="grey8b">�P�y�G</font></td>
                <td class="table3">
                  <html:text value="" property="starSign" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3"><font class="grey8b">MSN Messenger�G</font></td>
                <td class="table3">
                  <html:text value="" property="msn" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
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
              <tr align="center">
                <td colspan="2" class="table2"><font class="grey9b">�򥻸��</font></td>
              </tr>
              <tr>
                <td width="35%" align="right" class="table3"><font color="#FF0000">*</font><font class="grey8b">
                  �Τ�W�١G </font></td>
                <td width="65%" class="table3">
                  <html:text value="" property="userName" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3"><font color="#FF0000" >*</font><font class="grey8b">
                  �Τ�K�X�G</font></td>
                <td class="table3">
                  <html:password value="" property="userPwd" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3"><font color="#FF0000" >*</font><font class="grey8b">
                  �T�{�K�X�G</font></td>
                <td class="table3">
                  <html:password value="" property="confirmPwd" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">�u��W�r�G</td>
                <td class="table3">
                  <html:text value="" property="lastName" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">�A���m��G</td>
                <td class="table3">
                  <html:text value="" property="firstName" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">�~�����G</td>
                <td class="table3">
                  <html:text value="" property="city" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">�Ҧb�٤��G</td>
                <td class="table3">
                  <html:text value="" property="province" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">��a�a�ϡG</td>
                <td class="table3">
                  <html:select property="country" size="1">
                    <html:option value="white"></html:option>
                    <html:option value="�����ڥ���">�����ڥ���</html:option>
                    <html:option value="�����ΧQ��">�����ΧQ��</html:option>
                    <html:option value="�w�D��">�w�D��</html:option>
                    <html:option value="�w����">�w����</html:option>
                    <html:option value="�w�c�Ԯq">�w�c�Ԯq</html:option>
                    <html:option value="���ڧ�">���ڧ�</html:option>
                    <html:option value="�Ȭ�����">�Ȭ�����</html:option>
                    <html:option value="���|�ڮq">���|�ڮq</html:option>
                    <html:option value="�D�j�Q��">�D�j�Q��</html:option>
                    <html:option value="���a�Q">���a�Q</html:option>
                    <html:option value="�����æ">�����æ</html:option>
                    <html:option value="�ګ����s�q">�ګ����s�q</html:option>
                    <html:option value="�ڤڦh���q">�ڤڦh���q</html:option>
                    <html:option value="��Q��">��Q��</html:option>
                    <html:option value="�B�Q����">�B�Q����</html:option>
                    <html:option value="�����W">�����W</html:option>
                    <html:option value="�ʼ}�j�s�q">�ʼ}�j�s�q</html:option>
                    <html:option value="����">����</html:option>
                    <html:option value="���Q����">���Q����</html:option>
                    <html:option value="�i�h����">�i�h����</html:option>
                    <html:option value="�կ��˯�">�կ��˯�</html:option>
                    <html:option value="�ڦ�">�ڦ�</html:option>
                    <html:option value="�Z��">�Z��</html:option>
                    <html:option value="�O�[�Q��">�O�[�Q��</html:option>
                    <html:option value="�B��Ǫk��">�B��Ǫk��</html:option>
                    <html:option value="�����}">�����}</html:option>
                    <html:option value="�Z�H��">�Z�H��</html:option>
                    <html:option value="�[���j">�[���j</html:option>
                    <html:option value="�n�樤">�n�樤</html:option>
                    <html:option value="�s���q">�s���q</html:option>
                    <html:option value="���D">���D</html:option>
                    <html:option value="���Q">���Q</html:option>
                    <html:option value="���ۤ��">���ۤ��</html:option>
                    <html:option value="��G">��G</html:option>
                    <html:option value="�����j���[">�����j���[</html:option>
                    <html:option value="�Jù�a��">�Jù�a��</html:option>
                    <html:option value="�j��">�j��</html:option>
                    <html:option value="�ɴ��Ǵ�">�ɴ��Ǵ�</html:option>
                    <html:option value="���J">���J</html:option>
                    <html:option value="����">����</html:option>
                    <html:option value="�h�����[">�h�����[</html:option>
                    <html:option value="�F�ҨZ">�F�ҨZ</html:option>
                    <html:option value="�̥ʦh��">�̥ʦh��</html:option>
                    <html:option value="�J��">�J��</html:option>
                    <html:option value="�ĺ��˦h">�ĺ��˦h</html:option>
                    <html:option value="�X����">�X����</html:option>
                    <html:option value="�R�F����">�R�F����</html:option>
                    <html:option value="�J��X���">�J��X���</html:option>
                    <html:option value="����">����</html:option>
                    <html:option value="����">����</html:option>
                    <html:option value="�k��">�k��</html:option>
                    <html:option value="����y">����y</html:option>
                    <html:option value="�w��">�w��</html:option>
                    <html:option value="�[��">�[��</html:option>
                    <html:option value="��þ">��þ</html:option>
                    <html:option value="�X����">�X����</html:option>
                    <html:option value="���a">���a</html:option>
                    <html:option value="�x���Դ�">�x���Դ�</html:option>
                    <html:option value="�I���Q">�I���Q</html:option>
                    <html:option value="�B�q">�B�q</html:option>
                    <html:option value="�L��">�L��</html:option>
                    <html:option value="�L��">�L��</html:option>
                    <html:option value="���">���</html:option>
                    <html:option value="��ԧJ">��ԧJ</html:option>
                    <html:option value="�R����">�R����</html:option>
                    <html:option value="�H��C">�H��C</html:option>
                    <html:option value="�q�j�Q">�q�j�Q</html:option>
                    <html:option value="���R�[">���R�[</html:option>
                    <html:option value="�饻">�饻</html:option>
                    <html:option value="����">����</html:option>
                    <html:option value="�ֶ�">�ֶ�</html:option>
                    <html:option value="���A">���A</html:option>
                    <html:option value="��¯S">��¯S</html:option>
                    <html:option value="�Ѿ�">�Ѿ�</html:option>
                    <html:option value="���ڹ�">���ڹ�</html:option>
                    <html:option value="�Q��z��">�Q��z��</html:option>
                    <html:option value="�߳��{">�߳��{</html:option>
                    <html:option value="�c�˳�">�c�˳�</html:option>
                    <html:option value="���F�[���[">���F�[���[</html:option>
                    <html:option value="���Ӧ��">���Ӧ��</html:option>
                    <html:option value="�����N��">�����N��</html:option>
                    <html:option value="�򨽨D��">�򨽨D��</html:option>
                    <html:option value="�����">�����</html:option>
                    <html:option value="�����F��">�����F��</html:option>
                    <html:option value="���ǭ�">���ǭ�</html:option>
                    <html:option value="�X�j">�X�j</html:option>
                    <html:option value="������">������</html:option>
                    <html:option value="���T��J">���T��J</html:option>
                    <html:option value="�q�l">�q�l</html:option>
                    <html:option value="�Ǧ̤��">�Ǧ̤��</html:option>
                    <html:option value="���y��">���y��</html:option>
                    <html:option value="����">����</html:option>
                    <html:option value="�s����">�s����</html:option>
                    <html:option value="���[�ԥ�">���[�ԥ�</html:option>
                    <html:option value="���麸">���麸</html:option>
                    <html:option value="����Q��">����Q��</html:option>
                    <html:option value="����">����</html:option>
                    <html:option value="����">����</html:option>
                    <html:option value="�ڰ򴵩Z">�ڰ򴵩Z</html:option>
                    <html:option value="�ڰǴ��Z">�ڰǴ��Z</html:option>
                    <html:option value="�ڮ���">�ڮ���</html:option>
                    <html:option value="�ڥ��ȷs�F����">�ڥ��ȷs�F����</html:option>
                    <html:option value="�کԦc">�کԦc</html:option>
                    <html:option value="���|">���|</html:option>
                    <html:option value="��߻�">��߻�</html:option>
                    <html:option value="�i��">�i��</html:option>
                    <html:option value="�����">�����</html:option>
                    <html:option value="�d��">�d��</html:option>
                    <html:option value="����">����</html:option>
                    <html:option value="ù������">ù������</html:option>
                    <html:option value="�Xù��">�Xù��</html:option>
                    <html:option value="�c���F">�c���F</html:option>
                    <html:option value="�t�c��Ȯq">�t�c��Ȯq</html:option>
                    <html:option value="�F�Q�a���ԧB">�F�Q�a���ԧB</html:option>
                    <html:option value="�뤺�[��">�뤺�[��</html:option>
                    <html:option value="��ަ�">��ަ�</html:option>
                    <html:option value="��Ԩ���">��Ԩ���</html:option>
                    <html:option value="�s�[�Y">�s�[�Y</html:option>
                    <html:option value="������J">������J</html:option>
                    <html:option value="�����奧��">�����奧��</html:option>
                    <html:option value="��ù��">��ù��</html:option>
                    <html:option value="������">������</html:option>
                    <html:option value="�n�D">�n�D</html:option>
                    <html:option value="��Z��">��Z��</html:option>
                    <html:option value="�������d">�������d</html:option>
                    <html:option value="Ĭ��">Ĭ��</html:option>
                    <html:option value="���¤h��">���¤h��</html:option>
                    <html:option value="���">���</html:option>
                    <html:option value="��h">��h</html:option>
                    <html:option value="�ԧQ��">�ԧQ��</html:option>
                    <html:option value="���إ��� �x�_��">���إ��� �x�_��</html:option>
                    <html:option value="���إ��� ������">���إ��� ������</html:option>
                    <html:option value="���إ��� �x�W">���إ��� �x�W</html:option>
                    <html:option value="�x�W �x�_��">�x�W �x�_��</html:option>
                    <html:option value="�x�W ��">�x�W ��</html:option>
                    <html:option value="�x�W ���">�x�W ���</html:option>
                    <html:option value="�x�W �s��">�x�W �s��</html:option>
                    <html:option value="�x�W �]��">�x�W �]��</html:option>
                    <html:option value="�x�W �x��">�x�W �x��</html:option>
                    <html:option value="�x�W ����">�x�W ����</html:option>
                    <html:option value="�x�W �n��">�x�W �n��</html:option>
                    <html:option value="�x�W ���L">�x�W ���L</html:option>
                    <html:option value="�x�W �Ÿq">�x�W �Ÿq</html:option>
                    <html:option value="�x�W �x�n">�x�W �x�n</html:option>
                    <html:option value="�x�W ������">�x�W ������</html:option>
                    <html:option value="�x�W �̪F">�x�W �̪F</html:option>
                    <html:option value="�x�W �y��">�x�W �y��</html:option>
                    <html:option value="�x�W �Ὤ">�x�W �Ὤ</html:option>
                    <html:option value="�x�W �x�F">�x�W �x�F</html:option>
                    <html:option value="�x�W ���">�x�W ���</html:option>
                    <html:option value="�x�W ����">�x�W ����</html:option>
                    <html:option value="�x�W ��q����">�x�W ��q����</html:option>
                    <html:option value="�x�W �[�y">�x�W �[�y</html:option>
                    <html:option value="����">����</html:option>
                    <html:option value="���� �_��">���� �_��</html:option>
                    <html:option value="���� �s�F">���� �s�F</html:option>
                    <html:option value="���� �W��">���� �W��</html:option>
                    <html:option value="���� �sæ">���� �sæ</html:option>
                    <html:option value="���� ���">���� ���</html:option>
                    <html:option value="���� �s��">���� �s��</html:option>
                    <html:option value="���� ���n">���� ���n</html:option>
                    <html:option value="���� ��n">���� ��n</html:option>
                    <html:option value="���� �̵�">���� �̵�</html:option>
                    <html:option value="���� �e�_">���� �e�_</html:option>
                    <html:option value="���� ��_">���� ��_</html:option>
                    <html:option value="���� ����">���� ����</html:option>
                    <html:option value="���� ��Ĭ">���� ��Ĭ</html:option>
                    <html:option value="���� ����">���� ����</html:option>
                    <html:option value="���� �s�F">���� �s�F</html:option>
                    <html:option value="���� ����">���� ����</html:option>
                    <html:option value="���� �w��">���� �w��</html:option>
                    <html:option value="���� �֫�">���� �֫�</html:option>
                    <html:option value="���� �N�L">���� �N�L</html:option>
                    <html:option value="���� �s��">���� �s��</html:option>
                    <html:option value="���� ���n">���� ���n</html:option>
                    <html:option value="���� �Q�{">���� �Q�{</html:option>
                    <html:option value="���� �|�t">���� �|�t</html:option>
                    <html:option value="���� ����">���� ����</html:option>
                    <html:option value="���� ���y">���� ���y</html:option>
                    <html:option value="���� �Ѭz">���� �Ѭz</html:option>
                    <html:option value="���� �e�n">���� �e�n</html:option>
                    <html:option value="���� �C��">���� �C��</html:option>
                    <html:option value="���� ��L">���� ��L</html:option>
                    <html:option value="���� ����">���� ����</html:option>
                    <html:option value="���� �D��">���� �D��</html:option>
                    <html:option value="���� ��L">���� ��L</html:option>
                    <html:option value="��N�J���Z">��N�J���Z</html:option>
                    <html:option value="�Z�ᥧ��">�Z�ᥧ��</html:option>
                    <html:option value="����">����</html:option>
                    <html:option value="�h��">�h��</html:option>
                    <html:option value="���[">���[</html:option>
                    <html:option value="�S�ߥ��F�M�h�ڭ�">�S�ߥ��F�M�h�ڭ�</html:option>
                    <html:option value="�𥧴�">�𥧴�</html:option>
                    <html:option value="�g�w�Ҵ��Z">�g�w�Ҵ��Z</html:option>
                    <html:option value="�g�ը�">�g�ը�</html:option>
                    <html:option value="�ϥ˿c">�ϥ˿c</html:option>
                    <html:option value="����">����</html:option>
                    <html:option value="�Q�z�F">�Q�z�F</html:option>
                    <html:option value="�Q�J��">�Q�J��</html:option>
                    <html:option value="�^��">�^��</html:option>
                    <html:option value="�Q�Ԧc">�Q�Ԧc</html:option>
                    <html:option value="�Q���O�J���Z">�Q���O�J���Z</html:option>
                    <html:option value="�˧V����">�˧V����</html:option>
                    <html:option value="�븦��">�븦��</html:option>
                    <html:option value="�e�����">�e�����</html:option>
                    <html:option value="�V�n">�V�n</html:option>
                    <html:option value="�����z�s�q">�����z�s�q</html:option>
                    <html:option value="�˧Q���B�I�ϯǸs�q">�˧Q���B�I�ϯǸs�q</html:option>
                    <html:option value="�ī���">�ī���</html:option>
                    <html:option value="���ļ���">���ļ���</html:option>
                    <html:option value="����">����</html:option>
                    <html:option value="�|���">�|���</html:option>
                    <html:option value="���ګ�">���ګ�</html:option>
                  </html:select>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">�~ �֡G</td>
                <td class="table3">
                  <html:text value="" property="age" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">�� �O�G </td>
                <td class="table3">
                  <html:select property="sex" size="1">
                    <html:option value="" >&nbsp;</html:option>
                    <html:option value="male">�ӭ�&nbsp;</html:option>
                    <html:option value="female">���k&nbsp;</html:option>
                  </html:select>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">�{��¾�ȡG</td>
                <td class="table3">
                  <html:text value="" property="position" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">�ӤHñ�W�G</td>
                <td class="table3">
                  <html:text value="" property="sign" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td align="right" valign="top" >
       <html:submit property="submit" onclick="bCancel=false;">
          �e�X
       </html:submit>
    </td>
    <td align="left" valign="top" >
       <html:cancel onclick="bCancel=true;">
          ����
       </html:cancel>
    </td>
  </tr>
</table>
</html:form>
