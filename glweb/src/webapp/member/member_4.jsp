<%--
 $Id: member_4.jsp,v 1.3 2003/09/22 17:00:10 primo Exp $
 $Revision: 1.3 $
 $Date: 2003/09/22 17:00:10 $
 $Author: primo $
--%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>

<html:form action="/member/member4.do" method="post" enctype="multipart/form-data">
<table width="100%" border="0" cellspacing="8" cellpadding="0">
  <html:hidden property="categoryId" />
  <html:hidden property="action" value="insert" />
  <tr>
    <td class="table3"><html:link styleClass="link1" href="../forum/forum.do">GL�x�W�v����(�׾³�)</html:link> &gt; <html:link styleClass="link1" href="#">�i�ȹC�����Q�ת��j</html:link>
      &gt; <html:link styleClass="link1" href="#">�o��s�D�D</html:link></td>
  </tr>
  <tr>
    <td class="table4">
      <table width="100%" border="0" cellpadding="5" cellspacing="1" class="grey8">
        <tr>
          <td height="26" colspan="2" align="center" class="table3">�o��s�D�D </td>
        </tr>
        <tr>
          <td height="26" colspan="2" class="table2"><font class="grey8">�`�N�G �o��峹���e���������U���|���C���U��<html:link styleClass="link1" href="member1.do">���o�̵��U</html:link>�C���U�O�����K�O���I</font></td>
        </tr>
        <tr>
          <td width="25%" align="right" valign="top" class="table3">
            <p><font class="grey8b">�峹�D�D�G</font>
              <html:select property="main">
                <html:option value="">��ܸ��D</html:option>
                <html:option value="���">[���]</html:option>
                <html:option value="��K">[��K]</html:option>
                <html:option value="���">[���]</html:option>
                <html:option value="�Q��">[�Q��]</html:option>
                <html:option value="�D�U">[�D�U]</html:option>
                <html:option value="����">[����]</html:option>
                <html:option value="���i">[���i]</html:option>
                <html:option value="�`�N">[�`�N]</html:option>
                <html:option value="�K��">[�K��]</html:option>
                <html:option value="��ĳ">[��ĳ]</html:option>
                <html:option value="�U��">[�U��]</html:option>
                <html:option value="����">[����]</html:option>
                <html:option value="���">[���]</html:option>
                <html:option value="�ޥ�">[�ޥ�]</html:option>
                <html:option value="�s�D">[�s�D]</html:option>
              </html:select>
            </p>
          </td>
          <td width="75%" class="table3">
            <html:text maxlength = "40" property="subject" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="40"/>
            ���o�W�L 40 �Ӥ���r
          </td>
        </tr>
        <tr>
          <td align="right" valign="top" class="table3">�Τ�W�١G</td>
          <td class="table3">
            <html:text property="name" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
            <html:link styleClass="link1" href="member1.do">�z�٨S�����U�H</html:link></td>
        </tr>
        <tr>
          <td align="right" valign="top" class="table3">�K�X�G</td>
          <td class="table3">
            <html:password  property="password" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
            <html:link styleClass="link1" href="#">�ѰO�K�X�H</html:link></td>
        </tr>
        <tr>
          <td align="right" valign="top" class="table3"><font class="grey8b">�ثe�߱��G</font>
            <br>
            �N��b�峹���e��</td>
          <td class="table3">
            <input name=usericon type=radio
            value=00>
            <img border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/00.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=01>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/01.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=02>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/02.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=03>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/03.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=04>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/04.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=05>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/05.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=06>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/06.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=07>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/07.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=08>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/08.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=09>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/09.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=10>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/10.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=11>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/11.gif"
            width=13>&nbsp; <br>
            <input name=usericon type=radio value=12>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/12.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=13>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/13.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=14>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/14.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=15>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/15.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=16>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/16.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=17>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/17.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=18>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/18.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=19>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/19.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=20>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/20.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=21>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/21.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=22>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/22.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=23>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/23.gif"
            width=13>&nbsp;<br>
            <input name=usericon type=radio value=24>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/24.gif"
            width=13>&nbsp;
            <input name=usericon type=radio value=25>
            <img
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/25.gif" width=13>&nbsp;
          </td>
        </tr>
        <tr>
          <td rowspan="2" align="right" valign="top" class="table3"><font class="grey8b">�榡
            �G</font> </td>
          <td class="table3"><img alt=����r class=gray height=22 onclick=bold()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/bold.gif" width=23> <img alt=����r
            class=gray height=22 onclick=italicize() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/italicize.gif"
            width=23> <img alt=�U���u class=gray height=22 onclick=underline()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/underline.gif" width=23>
            <img alt=�~��
            class=gray height=22 onclick=center() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/center.gif"
            width=23> <img alt=���J�W�s�� class=gray height=22 onclick=hyperlink()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/url.gif" width=23> <img alt=���J�l��a�}
            class=gray height=22 onclick=email() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/email.gif"
            width=23> <img alt=���J�Ϥ� class=gray height=22 onclick=image()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/image.gif" width=23> <img
            alt="���J Flash �ʵe" class=gray height=22 onclick=setflash()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/swf.gif" width=23> <img alt=���J�n��
            class=gray height=22 onclick=setsound() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/sound.gif"
            width=23> <img alt=���J�N�X class=gray height=22 onclick=showcode()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/code.gif" width=23> <img alt=���J�ޥ�
            class=gray height=22 onclick=quote() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/quote.gif"
            width=23> <img alt=���J�C�� class=gray height=22 onclick=list()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/list.gif" width=23> <img alt=����r
            class=gray height=22 onclick=setfly() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/fly.gif"
            width=23> <img alt=���ʦr class=gray height=22 onclick=move()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/move.gif" width=23> <img alt=�o���r
            class=gray height=22 onclick=glow() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/glow.gif"
            width=23> <img alt=���v�r class=gray height=22 onclick=shadow()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/shadow.gif" width=23> <img alt=���J���N�X
            class=gray height=22 onclick=smilieopen() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/smilie.gif"
            width=23> </td>
        </tr>
        <tr>
          <td class="table3">�r��G
            <select name=select>
              <option value=�ө���>�ө���</option>
              <option value=�з���>�з���</option>
              <option value=Arial>Arial</option>
              <option value="Book Antiqua">Book Antiqua</option>
              <option value="Century Gothic">Century Gothic</option>
              <option value="Comic Sans MS">Comic Sans MS</option>
              <option value="Courier New">Courier New</option>
              <option value="Georgia">Georgia</option>
              <option value="Impact">Impact</option>
              <option value="Tahoma">Tahoma</option>
              <option value="Times New Roman">Times New Roman</option>
              <option value="Trebuchet MS">Trebuchet MS</option>
              <option value="Script MT Bold">Script MT Bold</option>
              <option value=Stencil>Stencil</option>
              <option value=Verdana>Verdana</option>
              <option value="Lucida Console">Lucida Console</option>
            </select>
            �r���j�p�G
            <select name=size onchange=showsize(this.options[this.selectedIndex].value)>
              <option value=1>&nbsp;1&nbsp;</option>
              <option value=2>&nbsp;2&nbsp;</option>
              <option value=3>&nbsp;3&nbsp;</option>
              <option value=4>&nbsp;4&nbsp;</option>
              <option value=5>&nbsp;5&nbsp;</option>
              <option value=6>&nbsp;6&nbsp;</option>
            </select>
            �C��G
            <select name=color onchange=showcolor(this.options[this.selectedIndex].value)>
              <option style="BACKGROUND-COLOR: #6898ed; COLOR: black" value=black>&nbsp;�w�]��&nbsp;</option>
              <option style="BACKGROUND-COLOR: black; COLOR: black" value=black>[ �¦� ]</option>
              <option style="BACKGROUND-COLOR: white; COLOR: white" value=white>[ �զ� ]</option>
              <option style="BACKGROUND-COLOR: silver; COLOR: silver" value=silver>[ �ȥ� ]</option>
              <option style="BACKGROUND-COLOR: gray; COLOR: gray" value=gray>[ �Ǧ� ]</option>
              <option style="BACKGROUND-COLOR: red; COLOR: red" value=red>[ ���� ]</option>
              <option style="BACKGROUND-COLOR: yellow; COLOR: yellow" value=yellow>[ ���� ]</option>
              <option style="BACKGROUND-COLOR: gold; COLOR: gold" value=gold>[ ���� ]</option>
              <option style="BACKGROUND-COLOR: pink; COLOR: pink" value=pink>[ ���� ]</option>
              <option style="BACKGROUND-COLOR: green; COLOR: green" value=green>[ ��� ]</option>
              <option style="BACKGROUND-COLOR: orange; COLOR: orange" value=orange>[ ��� ]</option>
              <option style="BACKGROUND-COLOR: purple; COLOR: purple" value=purple>[ ���� ]</option>
              <option style="BACKGROUND-COLOR: blue; COLOR: blue" value=blue>[ �Ŧ� ]</option>
              <option style="BACKGROUND-COLOR: beige; COLOR: beige" value=beige>[ �̶� ]</option>
              <option style="BACKGROUND-COLOR: brown; COLOR: brown" value=brown>[ �Ħ� ]</option>
              <option style="BACKGROUND-COLOR: teal; COLOR: teal" value=teal>[ �ź� ]</option>
              <option style="BACKGROUND-COLOR: navy; COLOR: navy" value=navy>[ �`�� ]</option>
              <option style="BACKGROUND-COLOR: maroon; COLOR: maroon" value=maroon>[ �ŵ� ]</option>
              <option style="BACKGROUND-COLOR: limegreen; COLOR: limegreen" value=limeGreen>[ ���� ]</option>
              <option style="BACKGROUND-COLOR: violet; COLOR: violet" value=violet>[ �H�� ]</option>
            </select>
          </td>
        </tr>
        <tr>
          <td align="right" valign="top" class="table3">
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="grey8">
              <tr>
                <td align="right"><font class="grey8b">���e �G</font></td>
              </tr>
              <tr>
                <td>* HTML �y�k�}��</td>
              </tr>
              <tr>
                <td>* [CODE] ���Ҷ}��</td>
              </tr>
              <tr>
                <td>* [FLASH] ���Ҷ}��</td>
              </tr>
              <tr>
                <td>* �����M�ΥN�X�}��</td>
              </tr>
            </table>
          </td>
          <td valign="top" class="table3">�˨ϥ�HTML�N�X����:�y<html:link styleClass="link1" href="#">EN21�׾�
            HTML �s�边</html:link>�z ���JJS���q��ʿ�J[code]...[/code]����<br>
            <html:textarea cols="60" property="message"></html:textarea>
            <br>
            �Ҧ�:
            <input name=font onclick=thelp(1) type=radio value=1>
            ���U
            <input
            CHECKED name=font onclick=thelp(2) type=radio value=2>
            ����
            <input
            name=font onclick=thelp(0) type=radio value=0>
            �򥻡@�@ &gt;&gt; <html:link styleClass="link1" href="#">�ƻs��ŶKï</html:link> | <html:link styleClass="link1" href="#">�d�ݤ峹����</html:link>
            &lt;&lt; </td>
        </tr>
        <tr align="center">
          <td colspan="2" valign="top" class="table3"> �I����ϮקY�i�b�峹���[�J�۹��������]�C�Ӫ��̦h�P�����
            3 ���^ [��h���Ÿ�]<br>
            <span onclick="javascript:insertsmilie('[:em01:]');"
            style="CURSOR: hand"><img alt=1 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em01.gif"></span> <span
            onclick="javascript:insertsmilie('[:em02:]');"
            style="CURSOR: hand"><img alt=2 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em02.gif"></span> <span
            onclick="javascript:insertsmilie('[:em03:]');"
            style="CURSOR: hand"><img alt=3 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em03.gif"></span> <span
            onclick="javascript:insertsmilie('[:em04:]');"
            style="CURSOR: hand"><img alt=4 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em04.gif"></span> <span
            onclick="javascript:insertsmilie('[:em05:]');"
            style="CURSOR: hand"><img alt=5 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em05.gif"></span> <span
            onclick="javascript:insertsmilie('[:em06:]');"
            style="CURSOR: hand"><img alt=6 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em06.gif"></span> <span
            onclick="javascript:insertsmilie('[:em07:]');"
            style="CURSOR: hand"><img alt=7 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em07.gif"></span> <span
            onclick="javascript:insertsmilie('[:em08:]');"
            style="CURSOR: hand"><img alt=8 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em08.gif"></span> <span
            onclick="javascript:insertsmilie('[:em09:]');"
            style="CURSOR: hand"><img alt=9 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em09.gif"></span> <span
            onclick="javascript:insertsmilie('[:em10:]');"
            style="CURSOR: hand"><img alt=10 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em10.gif"></span> <span
            onclick="javascript:insertsmilie('[:em11:]');"
            style="CURSOR: hand"><img alt=11 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em11.gif"></span> <span
            onclick="javascript:insertsmilie('[:em12:]');"
            style="CURSOR: hand"><img alt=12 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em12.gif"></span> <span
            onclick="javascript:insertsmilie('[:em13:]');"
            style="CURSOR: hand"><img alt=13 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em13.gif"></span> <span
            onclick="javascript:insertsmilie('[:em14:]');"
            style="CURSOR: hand"><img alt=14 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em14.gif"></span> <span
            onclick="javascript:insertsmilie('[:em15:]');"
            style="CURSOR: hand"><img alt=15 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em15.gif"></span> <span
            onclick="javascript:insertsmilie('[:em16:]');"
            style="CURSOR: hand"><img alt=16 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em16.gif"></span> <span
            onclick="javascript:insertsmilie('[:em17:]');"
            style="CURSOR: hand"><img alt=17 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em17.gif"></span> <span
            onclick="javascript:insertsmilie('[:em18:]');"
            style="CURSOR: hand"><img alt=18 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em18.gif"></span> <span
            onclick="javascript:insertsmilie('[:em19:]');"
            style="CURSOR: hand"><img alt=19 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em19.gif"></span> <span
            onclick="javascript:insertsmilie('[:em20:]');"
            style="CURSOR: hand"><img alt=20 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em20.gif"></span> <span
            onclick="javascript:insertsmilie('[:em21:]');"
            style="CURSOR: hand"><img alt=21 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em21.gif"></span> <span
            onclick="javascript:insertsmilie('[:em22:]');"
            style="CURSOR: hand"><img alt=22 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em22.gif"></span> <span
            onclick="javascript:insertsmilie('[:em23:]');"
            style="CURSOR: hand"><img alt=23 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em23.gif"></span> <span
            onclick="javascript:insertsmilie('[:em24:]');"
            style="CURSOR: hand"><img alt=24 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em24.gif"></span> <span
            onclick="javascript:insertsmilie('[:em25:]');"
            style="CURSOR: hand"><img alt=25 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em25.gif"></span> <span
            onclick="javascript:insertsmilie('[:em26:]');"
            style="CURSOR: hand"><img alt=26 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em26.gif"></span> <span
            onclick="javascript:insertsmilie('[:em27:]');"
            style="CURSOR: hand"><img alt=27 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em27.gif"></span> <span
            onclick="javascript:insertsmilie('[:em28:]');"
            style="CURSOR: hand"><img alt=28 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em28.gif"></span> <span
            onclick="javascript:insertsmilie('[em29:]');"
            style="CURSOR: hand"><img alt=29 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em29.gif"></span> <span
            onclick="javascript:insertsmilie('[:qq1:]');"
            style="CURSOR: hand"><img alt=a1 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/qq01.gif"></span> </td>
        </tr>
        <tr>
          <td align="right" valign="top" class="table3">�W�Ǫ���ιϤ��G </td>
          <td class="table3">���[�ɮ�:
            <html:file property="upload" /><br>
            ���\�W���ɮ�����(.zip;.txt;.rar;.jpg;.gif;.xls;.doc;.bmp) �ɮפj�p�W�� <font color="#FF0000">5000
            </font>KB </td>
        </tr>
        <tr>
          <td align="right" valign="top" class="table3">�ﶵ�G <br>
          </td>
          <td class="table3">
            <html:checkbox property="sign" /> �O�_��ܱz��ñ�W�H
          </td>
        </tr>
        <tr>
          <td colspan="2" align="center" class="table3"><html:link href="javascript:document.member4Form.submit();"><html:img width="95" height="21" border="0" src="../image/new-topic.gif"/></html:link>�@<html:link href="#"><html:img width="58" height="21" border="0" src="../image/preview.gif"/></html:link>�@<html:link href="#"><html:img width="58" height="21" border="0" src="../image/clear.gif"/></html:link></td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</html:form>
