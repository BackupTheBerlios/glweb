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
    <td class="table3"><html:link styleClass="link1" href="../forum/forum.do">GL台灣影音旅(論壇報)</html:link> &gt; <html:link styleClass="link1" href="#">【旅遊相關討論版】</html:link>
      &gt; <html:link styleClass="link1" href="#">發表新主題</html:link></td>
  </tr>
  <tr>
    <td class="table4">
      <table width="100%" border="0" cellpadding="5" cellspacing="1" class="grey8">
        <tr>
          <td height="26" colspan="2" align="center" class="table3">發表新主題 </td>
        </tr>
        <tr>
          <td height="26" colspan="2" class="table2"><font class="grey8">注意： 發表文章之前必須先註冊成會員。註冊請<html:link styleClass="link1" href="member1.do">按這裡註冊</html:link>。註冊是完全免費的！</font></td>
        </tr>
        <tr>
          <td width="25%" align="right" valign="top" class="table3">
            <p><font class="grey8b">文章主題：</font>
              <html:select property="main">
                <html:option value="">選擇話題</html:option>
                <html:option value="原創">[原創]</html:option>
                <html:option value="轉貼">[轉貼]</html:option>
                <html:option value="灌水">[灌水]</html:option>
                <html:option value="討論">[討論]</html:option>
                <html:option value="求助">[求助]</html:option>
                <html:option value="推薦">[推薦]</html:option>
                <html:option value="公告">[公告]</html:option>
                <html:option value="注意">[注意]</html:option>
                <html:option value="貼圖">[貼圖]</html:option>
                <html:option value="建議">[建議]</html:option>
                <html:option value="下載">[下載]</html:option>
                <html:option value="分享">[分享]</html:option>
                <html:option value="資料">[資料]</html:option>
                <html:option value="技巧">[技巧]</html:option>
                <html:option value="新聞">[新聞]</html:option>
              </html:select>
            </p>
          </td>
          <td width="75%" class="table3">
            <html:text maxlength = "40" property="subject" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="40"/>
            不得超過 40 個中文字
          </td>
        </tr>
        <tr>
          <td align="right" valign="top" class="table3">用戶名稱：</td>
          <td class="table3">
            <html:text property="name" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
            <html:link styleClass="link1" href="member1.do">您還沒有註冊？</html:link></td>
        </tr>
        <tr>
          <td align="right" valign="top" class="table3">密碼：</td>
          <td class="table3">
            <html:password  property="password" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
            <html:link styleClass="link1" href="#">忘記密碼？</html:link></td>
        </tr>
        <tr>
          <td align="right" valign="top" class="table3"><font class="grey8b">目前心情：</font>
            <br>
            將放在文章的前面</td>
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
          <td rowspan="2" align="right" valign="top" class="table3"><font class="grey8b">格式
            ：</font> </td>
          <td class="table3"><img alt=粗體字 class=gray height=22 onclick=bold()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/bold.gif" width=23> <img alt=斜體字
            class=gray height=22 onclick=italicize() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/italicize.gif"
            width=23> <img alt=下底線 class=gray height=22 onclick=underline()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/underline.gif" width=23>
            <img alt=居中
            class=gray height=22 onclick=center() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/center.gif"
            width=23> <img alt=插入超連結 class=gray height=22 onclick=hyperlink()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/url.gif" width=23> <img alt=插入郵件地址
            class=gray height=22 onclick=email() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/email.gif"
            width=23> <img alt=插入圖片 class=gray height=22 onclick=image()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/image.gif" width=23> <img
            alt="插入 Flash 動畫" class=gray height=22 onclick=setflash()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/swf.gif" width=23> <img alt=插入聲音
            class=gray height=22 onclick=setsound() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/sound.gif"
            width=23> <img alt=插入代碼 class=gray height=22 onclick=showcode()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/code.gif" width=23> <img alt=插入引用
            class=gray height=22 onclick=quote() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/quote.gif"
            width=23> <img alt=插入列表 class=gray height=22 onclick=list()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/list.gif" width=23> <img alt=飛行字
            class=gray height=22 onclick=setfly() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/fly.gif"
            width=23> <img alt=移動字 class=gray height=22 onclick=move()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/move.gif" width=23> <img alt=發光字
            class=gray height=22 onclick=glow() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/glow.gif"
            width=23> <img alt=陰影字 class=gray height=22 onclick=shadow()
            onmouseout=disable(this) onmouseover=enable(this)
            src="http://www.gl.com.tw/bbs/non-asp/btg/shadow.gif" width=23> <img alt=插入表情代碼
            class=gray height=22 onclick=smilieopen() onmouseout=disable(this)
            onmouseover=enable(this) src="http://www.gl.com.tw/bbs/non-asp/btg/smilie.gif"
            width=23> </td>
        </tr>
        <tr>
          <td class="table3">字體：
            <select name=select>
              <option value=細明體>細明體</option>
              <option value=標楷體>標楷體</option>
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
            字型大小：
            <select name=size onchange=showsize(this.options[this.selectedIndex].value)>
              <option value=1>&nbsp;1&nbsp;</option>
              <option value=2>&nbsp;2&nbsp;</option>
              <option value=3>&nbsp;3&nbsp;</option>
              <option value=4>&nbsp;4&nbsp;</option>
              <option value=5>&nbsp;5&nbsp;</option>
              <option value=6>&nbsp;6&nbsp;</option>
            </select>
            顏色：
            <select name=color onchange=showcolor(this.options[this.selectedIndex].value)>
              <option style="BACKGROUND-COLOR: #6898ed; COLOR: black" value=black>&nbsp;預設值&nbsp;</option>
              <option style="BACKGROUND-COLOR: black; COLOR: black" value=black>[ 黑色 ]</option>
              <option style="BACKGROUND-COLOR: white; COLOR: white" value=white>[ 白色 ]</option>
              <option style="BACKGROUND-COLOR: silver; COLOR: silver" value=silver>[ 銀白 ]</option>
              <option style="BACKGROUND-COLOR: gray; COLOR: gray" value=gray>[ 灰色 ]</option>
              <option style="BACKGROUND-COLOR: red; COLOR: red" value=red>[ 紅色 ]</option>
              <option style="BACKGROUND-COLOR: yellow; COLOR: yellow" value=yellow>[ 黃色 ]</option>
              <option style="BACKGROUND-COLOR: gold; COLOR: gold" value=gold>[ 金色 ]</option>
              <option style="BACKGROUND-COLOR: pink; COLOR: pink" value=pink>[ 粉紅 ]</option>
              <option style="BACKGROUND-COLOR: green; COLOR: green" value=green>[ 綠色 ]</option>
              <option style="BACKGROUND-COLOR: orange; COLOR: orange" value=orange>[ 橘色 ]</option>
              <option style="BACKGROUND-COLOR: purple; COLOR: purple" value=purple>[ 紫色 ]</option>
              <option style="BACKGROUND-COLOR: blue; COLOR: blue" value=blue>[ 藍色 ]</option>
              <option style="BACKGROUND-COLOR: beige; COLOR: beige" value=beige>[ 米黃 ]</option>
              <option style="BACKGROUND-COLOR: brown; COLOR: brown" value=brown>[ 棕色 ]</option>
              <option style="BACKGROUND-COLOR: teal; COLOR: teal" value=teal>[ 藍綠 ]</option>
              <option style="BACKGROUND-COLOR: navy; COLOR: navy" value=navy>[ 深藍 ]</option>
              <option style="BACKGROUND-COLOR: maroon; COLOR: maroon" value=maroon>[ 褐紫 ]</option>
              <option style="BACKGROUND-COLOR: limegreen; COLOR: limegreen" value=limeGreen>[ 黃綠 ]</option>
              <option style="BACKGROUND-COLOR: violet; COLOR: violet" value=violet>[ 淡紫 ]</option>
            </select>
          </td>
        </tr>
        <tr>
          <td align="right" valign="top" class="table3">
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="grey8">
              <tr>
                <td align="right"><font class="grey8b">內容 ：</font></td>
              </tr>
              <tr>
                <td>* HTML 語法開啟</td>
              </tr>
              <tr>
                <td>* [CODE] 標籤開啟</td>
              </tr>
              <tr>
                <td>* [FLASH] 標籤開啟</td>
              </tr>
              <tr>
                <td>* 本版專用代碼開啟</td>
              </tr>
            </table>
          </td>
          <td valign="top" class="table3">薦使用HTML代碼標籤:『<html:link styleClass="link1" href="#">EN21論壇
            HTML 編輯器</html:link>』 插入JS儘量手動輸入[code]...[/code]標籤<br>
            <html:textarea cols="60" property="message"></html:textarea>
            <br>
            模式:
            <input name=font onclick=thelp(1) type=radio value=1>
            幫助
            <input
            CHECKED name=font onclick=thelp(2) type=radio value=2>
            完全
            <input
            name=font onclick=thelp(0) type=radio value=0>
            基本　　 &gt;&gt; <html:link styleClass="link1" href="#">複製到剪貼簿</html:link> | <html:link styleClass="link1" href="#">查看文章長度</html:link>
            &lt;&lt; </td>
        </tr>
        <tr align="center">
          <td colspan="2" valign="top" class="table3"> 點選表情圖案即可在文章中加入相對應的表情（每個表情最多同時顯示
            3 次） [更多表情符號]<br>
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
          <td align="right" valign="top" class="table3">上傳附件或圖片： </td>
          <td class="table3">附加檔案:
            <html:file property="upload" /><br>
            允許上傳檔案類型(.zip;.txt;.rar;.jpg;.gif;.xls;.doc;.bmp) 檔案大小上限 <font color="#FF0000">5000
            </font>KB </td>
        </tr>
        <tr>
          <td align="right" valign="top" class="table3">選項： <br>
          </td>
          <td class="table3">
            <html:checkbox property="sign" /> 是否顯示您的簽名？
          </td>
        </tr>
        <tr>
          <td colspan="2" align="center" class="table3"><html:link href="javascript:document.member4Form.submit();"><html:img width="95" height="21" border="0" src="../image/new-topic.gif"/></html:link>　<html:link href="#"><html:img width="58" height="21" border="0" src="../image/preview.gif"/></html:link>　<html:link href="#"><html:img width="58" height="21" border="0" src="../image/clear.gif"/></html:link></td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</html:form>
