<%--
 $Id: member_5.jsp,v 1.3 2003/09/22 17:00:10 primo Exp $
 $Revision: 1.3 $
 $Date: 2003/09/22 17:00:10 $
 $Author: primo $
--%>

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>

<html:form action="/member/member5.do" method="post" enctype="multipart/form-data">
<table width="100%" border="0" cellspacing="8" cellpadding="0">
  <html:hidden property="categoryId" />
  <html:hidden property="messageId" />
  <html:hidden property="action" value="insert" />
  <tr>
    <td class="table3"> <html:link styleClass="link1" href="#">GL�x�W�v����(�׾³�)</html:link> &gt; <html:link styleClass="link1" href="#">�i�ȹC�����Q�ת��j</html:link>
      &gt; <html:link styleClass="link1" href="#">�o��^��</html:link></td>
  </tr>
  <tr>
    <td class="table4">
      <table width="100%" border="0" cellpadding="5" cellspacing="1" class="grey8">
        <tr>
          <td height="26" colspan="2" align="center" class="table3">�o��^�� </td>
        </tr>
        <tr>
          <td height="26" colspan="2" class="table2"><font class="grey8"><B>�`�N�G</B>�^�Ф峹���e���������U���|���C���U��<html:link styleClass="link1" href="#">���o�̵��U</html:link>�C���U�O�����K�O���I</font></td>
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
            <INPUT name=usericon type=radio
            value=00>
            <IMG border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/00.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=01>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/01.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=02>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/02.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=03>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/03.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=04>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/04.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=05>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/05.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=06>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/06.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=07>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/07.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=08>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/08.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=09>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/09.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=10>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/10.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=11>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/11.gif"
            width=13>&nbsp; <br>
            <INPUT name=usericon type=radio value=12>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/12.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=13>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/13.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=14>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/14.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=15>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/15.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=16>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/16.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=17>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/17.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=18>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/18.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=19>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/19.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=20>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/20.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=21>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/21.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=22>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/22.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=23>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/23.gif"
            width=13>&nbsp;<br>
            <INPUT name=usericon type=radio value=24>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/24.gif"
            width=13>&nbsp;
            <INPUT name=usericon type=radio value=25>
            <IMG
            border=0 height=13 src="http://www.gl.com.tw/bbs/non-asp/face/25.gif" width=13>&nbsp;
          </td>
        </tr>
        <tr>
          <td rowspan="2" align="right" valign="top" class="table3"><font class="grey8b">�榡
            �G</font> </td>
          <td class="table3"><IMG alt=����r class=gray height=22 onclick=bold()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/bold.gif" width=23> <IMG alt=����r
            class=gray height=22 onclick=italicize() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/italicize.gif"
            width=23> <IMG alt=�U���u class=gray height=22 onclick=underline()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/underline.gif" width=23>
            <IMG alt=�~��
            class=gray height=22 onclick=center() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/center.gif"
            width=23> <IMG alt=���J�W�s�� class=gray height=22 onclick=hyperlink()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/url.gif" width=23> <IMG alt=���J�l��a�}
            class=gray height=22 onclick=email() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/email.gif"
            width=23> <IMG alt=���J�Ϥ� class=gray height=22 onclick=image()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/image.gif" width=23> <IMG
            alt="���J Flash �ʵe" class=gray height=22 onclick=setflash()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/swf.gif" width=23> <IMG alt=���J�n��
            class=gray height=22 onclick=setsound() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/sound.gif"
            width=23> <IMG alt=���J�N�X class=gray height=22 onclick=showcode()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/code.gif" width=23> <IMG alt=���J�ޥ�
            class=gray height=22 onclick=quote() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/quote.gif"
            width=23> <IMG alt=���J�C�� class=gray height=22 onclick=list()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/list.gif" width=23> <IMG alt=����r
            class=gray height=22 onclick=setfly() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/fly.gif"
            width=23> <IMG alt=���ʦr class=gray height=22 onclick=move()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/move.gif" width=23> <IMG alt=�o���r
            class=gray height=22 onclick=glow() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/glow.gif"
            width=23> <IMG alt=���v�r class=gray height=22 onclick=shadow()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/shadow.gif" width=23> <IMG alt=���J���N�X
            class=gray height=22 onclick=smilieopen() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/smilie.gif"
            width=23> </td>
        </tr>
        <tr>
          <td class="table3">�r��G
            <SELECT name=select
            onchange=showfont(this.options[this.selectedIndex].value)>
              <OPTION
              selected value=�ө���>�ө���</OPTION>
              <OPTION value=�з���>�з���</OPTION>
              <OPTION value=Arial>Arial</OPTION>
              <OPTION
              value="Book Antiqua">Book Antiqua</OPTION>
              <OPTION
              value="Century Gothic">Century Gothic</OPTION>
              <OPTION
              value="Comic Sans MS">Comic Sans MS</OPTION>
              <OPTION
              value="Courier New">Courier New</OPTION>
              <OPTION
              value=Georgia>Georgia</OPTION>
              <OPTION
              value=Impact>Impact</OPTION>
              <OPTION value=Tahoma>Tahoma</OPTION>
              <OPTION value="Times New Roman">Times New Roman</OPTION>
              <OPTION
              value="Trebuchet MS">Trebuchet MS</OPTION>
              <OPTION
              value="Script MT Bold">Script MT Bold</OPTION>
              <OPTION
              value=Stencil>Stencil</OPTION>
              <OPTION
              value=Verdana>Verdana</OPTION>
              <OPTION
              value="Lucida Console">Lucida Console</OPTION>
            </SELECT>
            �r���j�p�G
            <SELECT name=size
            onchange=showsize(this.options[this.selectedIndex].value)>
              <OPTION
              value=1>&nbsp;1&nbsp;</OPTION>
              <OPTION
              value=2>&nbsp;2&nbsp;</OPTION>
              <OPTION selected
              value=3>&nbsp;3&nbsp;</OPTION>
              <OPTION
              value=4>&nbsp;4&nbsp;</OPTION>
              <OPTION
              value=5>&nbsp;5&nbsp;</OPTION>
              <OPTION
              value=6>&nbsp;6&nbsp;</OPTION>
            </SELECT>
            �C��G
            <SELECT
            name=color
            onchange=showcolor(this.options[this.selectedIndex].value)>
              <OPTION selected style="BACKGROUND-COLOR: #6898ed; COLOR: black"
              value=black>&nbsp;�w�]��&nbsp;</OPTION>
              <OPTION
              style="BACKGROUND-COLOR: black; COLOR: black" value=black>[ �¦� ]</OPTION>
              <OPTION style="BACKGROUND-COLOR: white; COLOR: white"
              value=white>[ �զ� ]</OPTION>
              <OPTION
              style="BACKGROUND-COLOR: silver; COLOR: silver" value=silver>[ �ȥ�
              ]</OPTION>
              <OPTION style="BACKGROUND-COLOR: gray; COLOR: gray"
              value=gray>[ �Ǧ� ]</OPTION>
              <OPTION
              style="BACKGROUND-COLOR: red; COLOR: red" value=red>[ ���� ]</OPTION>
              <OPTION style="BACKGROUND-COLOR: yellow; COLOR: yellow"
              value=yellow>[ ���� ]</OPTION>
              <OPTION
              style="BACKGROUND-COLOR: gold; COLOR: gold" value=gold>[ ���� ]</OPTION>
              <OPTION style="BACKGROUND-COLOR: pink; COLOR: pink"
              value=pink>[ ���� ]</OPTION>
              <OPTION
              style="BACKGROUND-COLOR: green; COLOR: green" value=green>[ ��� ]</OPTION>
              <OPTION style="BACKGROUND-COLOR: orange; COLOR: orange"
              value=orange>[ ��� ]</OPTION>
              <OPTION
              style="BACKGROUND-COLOR: purple; COLOR: purple" value=purple>[ ����
              ]</OPTION>
              <OPTION style="BACKGROUND-COLOR: blue; COLOR: blue"
              value=blue>[ �Ŧ� ]</OPTION>
              <OPTION
              style="BACKGROUND-COLOR: beige; COLOR: beige" value=beige>[ �̶� ]</OPTION>
              <OPTION style="BACKGROUND-COLOR: brown; COLOR: brown"
              value=brown>[ �Ħ� ]</OPTION>
              <OPTION
              style="BACKGROUND-COLOR: teal; COLOR: teal" value=teal>[ �ź� ]</OPTION>
              <OPTION style="BACKGROUND-COLOR: navy; COLOR: navy"
              value=navy>[ �`�� ]</OPTION>
              <OPTION
              style="BACKGROUND-COLOR: maroon; COLOR: maroon" value=maroon>[ �ŵ�
              ]</OPTION>
              <OPTION
              style="BACKGROUND-COLOR: limegreen; COLOR: limegreen"
              value=limeGreen>[ ���� ]</OPTION>
              <OPTION
              style="BACKGROUND-COLOR: violet; COLOR: violet" value=violet>[ �H��
              ]</OPTION>
            </SELECT>
          </td>
        </tr>
        <tr>
          <td height="116" align="right" valign="top" class="table3">
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
            <INPUT name=font onclick=thelp(1) type=radio value=1>
            ���U
            <INPUT
            CHECKED name=font onclick=thelp(2) type=radio value=2>
            ����
            <INPUT
            name=font onclick=thelp(0) type=radio value=0>
            �򥻡@�@ &gt;&gt; <html:link styleClass="link1" href="#">�ƻs��ŶKï</html:link> | <html:link styleClass="link1" href="#">�d�ݤ峹����</html:link>
            &lt;&lt; </td>
        </tr>
        <tr align="center">
          <td colspan="2" valign="top" class="table3"> �I����ϮקY�i�b�峹���[�J�۹��������]�C�Ӫ��̦h�P�����
            3 ���^ [��h���Ÿ�]<br>
            <SPAN onclick="javascript:insertsmilie('[:em01:]');"
            style="CURSOR: hand"><IMG alt=1 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em01.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em02:]');"
            style="CURSOR: hand"><IMG alt=2 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em02.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em03:]');"
            style="CURSOR: hand"><IMG alt=3 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em03.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em04:]');"
            style="CURSOR: hand"><IMG alt=4 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em04.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em05:]');"
            style="CURSOR: hand"><IMG alt=5 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em05.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em06:]');"
            style="CURSOR: hand"><IMG alt=6 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em06.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em07:]');"
            style="CURSOR: hand"><IMG alt=7 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em07.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em08:]');"
            style="CURSOR: hand"><IMG alt=8 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em08.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em09:]');"
            style="CURSOR: hand"><IMG alt=9 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em09.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em10:]');"
            style="CURSOR: hand"><IMG alt=10 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em10.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em11:]');"
            style="CURSOR: hand"><IMG alt=11 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em11.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em12:]');"
            style="CURSOR: hand"><IMG alt=12 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em12.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em13:]');"
            style="CURSOR: hand"><IMG alt=13 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em13.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em14:]');"
            style="CURSOR: hand"><IMG alt=14 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em14.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em15:]');"
            style="CURSOR: hand"><IMG alt=15 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em15.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em16:]');"
            style="CURSOR: hand"><IMG alt=16 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em16.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em17:]');"
            style="CURSOR: hand"><IMG alt=17 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em17.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em18:]');"
            style="CURSOR: hand"><IMG alt=18 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em18.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em19:]');"
            style="CURSOR: hand"><IMG alt=19 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em19.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em20:]');"
            style="CURSOR: hand"><IMG alt=20 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em20.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em21:]');"
            style="CURSOR: hand"><IMG alt=21 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em21.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em22:]');"
            style="CURSOR: hand"><IMG alt=22 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em22.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em23:]');"
            style="CURSOR: hand"><IMG alt=23 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em23.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em24:]');"
            style="CURSOR: hand"><IMG alt=24 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em24.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em25:]');"
            style="CURSOR: hand"><IMG alt=25 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em25.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em26:]');"
            style="CURSOR: hand"><IMG alt=26 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em26.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em27:]');"
            style="CURSOR: hand"><IMG alt=27 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em27.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:em28:]');"
            style="CURSOR: hand"><IMG alt=28 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em28.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[em29:]');"
            style="CURSOR: hand"><IMG alt=29 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/em29.gif"></SPAN> <SPAN
            onclick="javascript:insertsmilie('[:qq1:]');"
            style="CURSOR: hand"><IMG alt=a1 border=0
            src="http://www.gl.com.tw/bbs/non-asp/emot/qq01.gif"></SPAN> </td>
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
          <td colspan="2" align="center" class="table3"><html:link href="javascript:document.member5Form.submit();"><html:img width="75" height="21" border="0" src="../image/reply.gif"/></html:link>�@<html:link href="#"><html:img width="58" height="21" border="0" src="../image/preview.gif"/></html:link>�@<html:link href="#"><html:img width="58" height="21" border="0" src="../image/clear.gif"/></html:link></td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td class="table4">
      <table width="100%" border="0" cellpadding="5" cellspacing="1" class="grey8">
        <tr>
          <td height="26" colspan="2" class="table2"><font class="grey9b">GL�x�W�v����(�׾³�)�A�ȱ��کM�n��
            </font></td>
        </tr>
        <tr>
          <td width="25%" rowspan="2" class="table3">
            <p>�ɦ�t</p>
          </td>
          <td width="75%" class="table3">�o���G 2003/03/15 16:18:14</td>
        </tr>
        <tr>
          <td class="table3">&nbsp;</td>
        </tr>
        <tr>
          <td colspan="2" class="table1">&nbsp;</td>
        </tr>
        <tr>
          <td rowspan="2" class="table3">pony</td>
          <td class="table3">�o���G 2003/03/15 18:18:46</td>
        </tr>
        <tr>
          <td class="table3">�L�ᤤ.....�@�Ӯୱ����</td>
        </tr>
        <tr>
          <td colspan="2" align="center" class="table1">&nbsp;</td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</html:form>