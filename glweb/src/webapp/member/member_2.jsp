<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>

<html:form action="/member/MemberDataAction" method="post">
<html:hidden value="addUser" property="action" />
<table width="100%" border="0" cellpadding="0" cellspacing="8" class="table3">
  <tr>
    <td height="28" colspan="2" class="table3"><html:link href="#" >GL台灣影音旅(論壇報)</html:link>
      &gt; <html:link href="#" >【旅遊相關討論版】</html:link> &gt; <html:link href="#" >加入會員</html:link></td>
  </tr>
  <tr>
    <td height="28" colspan="2" align="center" class="table1"><font class="grey8">前面有
      <font color="#FF0000">*</font> 的欄位都必須填寫</font></td>
  </tr>
  <tr>
    <td width="50%" valign="top" >
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table4">
        <tr>
          <td>
            <table width="100%" border="0" cellpadding="5" cellspacing="1" class="grey8">
              <tr align="center">
                <td colspan="2" class="table2"><font class="grey9b">聯絡方法</font></td>
              </tr>
              <tr>
                <td width="35%" align="right" class="table3"><font color="#FF0000" >*</font><font class="grey8b">
                  電子郵件： </font> </td>
                <td width="65%" class="table3">
                  <html:text value="" property="email" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">不顯示信箱位址： </td>
                <td class="table3">是
                  <html:radio value="yes" property="emailDisplay"/>
                  否
                  <html:radio value="no" property="emailDisplay"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">ICQ號碼： </td>
                <td class="table3">
                  <html:text value="" property="icq" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr align="center">
                <td colspan="2" class="table2"><font class="grey9b">相關連結</font>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">個人首頁： </td>
                <td class="table3">
                  <html:text value="" property="personHomePage" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr align="center">
                <td colspan="2" class="table2"><font class="grey9b">個性頭像 </font>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">個性圖片：</td>
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
                  <html:link href="#" >按此查看個性頭像圖庫</html:link></td>
              </tr>
              <tr>
                <td align="right" class="table3">自訂大頭貼： </td>
                <td class="table3">圖址：
                  <html:text value="" property="personImgURL" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="18"/>
                  <br>
                  <font color="#FF0000">必須帶有 http:// 的完整URL地址</font><br>
                  <html:text value="" property="personImgHigh" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="4"/>寬　度： 20 -- 120 之間的整數<br>
                  <html:text value="" property="personImgWidth" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="4"/>高　度： 20 -- 120 之間的整數 </td>
              </tr>
              <tr align="center">
                <td colspan="2" class="table3">如果圖像位置中有連結，圖片將以自訂的為主 </td>
              </tr>
              <tr align="center">
                <td colspan="2" class="table2"><font class="grey9b">更多詳細資料</font>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">個人簡介： </td>
                <td class="table3">
                  <html:textarea property="personDesc"></html:textarea>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">個人愛好： </td>
                <td class="table3">
                  <html:textarea property="personFancy"></html:textarea>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">座 右 銘： </td>
                <td class="table3">
                  <html:textarea property="motto"></html:textarea>
                </td>
              </tr>
              <tr align="center">
                <td height="26" colspan="2" class="table2"><font class="grey9b">額外資料</font></td>
              </tr>
              <tr>
                <td align="right" class="table3"><font class="grey8b">星座：</font></td>
                <td class="table3">
                  <html:text value="" property="starSign" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3"><font class="grey8b">MSN Messenger：</font></td>
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
                <td colspan="2" class="table2"><font class="grey9b">基本資料</font></td>
              </tr>
              <tr>
                <td width="35%" align="right" class="table3"><font color="#FF0000">*</font><font class="grey8b">
                  用戶名稱： </font></td>
                <td width="65%" class="table3">
                  <html:text value="" property="userName" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3"><font color="#FF0000" >*</font><font class="grey8b">
                  用戶密碼：</font></td>
                <td class="table3">
                  <html:password value="" property="userPwd" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3"><font color="#FF0000" >*</font><font class="grey8b">
                  確認密碼：</font></td>
                <td class="table3">
                  <html:password value="" property="confirmPwd" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">真實名字：</td>
                <td class="table3">
                  <html:text value="" property="lastName" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">你的姓氏：</td>
                <td class="table3">
                  <html:text value="" property="firstName" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">居住城市：</td>
                <td class="table3">
                  <html:text value="" property="city" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">所在省分：</td>
                <td class="table3">
                  <html:text value="" property="province" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">國家地區：</td>
                <td class="table3">
                  <html:select property="country" size="1">
                    <html:option value="white"></html:option>
                    <html:option value="阿爾巴尼亞">阿爾巴尼亞</html:option>
                    <html:option value="阿爾及利亞">阿爾及利亞</html:option>
                    <html:option value="安道爾">安道爾</html:option>
                    <html:option value="安哥拉">安哥拉</html:option>
                    <html:option value="安圭拉島">安圭拉島</html:option>
                    <html:option value="阿根廷">阿根廷</html:option>
                    <html:option value="亞美尼亞">亞美尼亞</html:option>
                    <html:option value="阿魯巴島">阿魯巴島</html:option>
                    <html:option value="澳大利亞">澳大利亞</html:option>
                    <html:option value="奧地利">奧地利</html:option>
                    <html:option value="阿塞拜疆">阿塞拜疆</html:option>
                    <html:option value="巴哈馬群島">巴哈馬群島</html:option>
                    <html:option value="巴巴多斯島">巴巴多斯島</html:option>
                    <html:option value="比利時">比利時</html:option>
                    <html:option value="伯利茲城">伯利茲城</html:option>
                    <html:option value="貝寧灣">貝寧灣</html:option>
                    <html:option value="百慕大群島">百慕大群島</html:option>
                    <html:option value="不旦">不旦</html:option>
                    <html:option value="玻利維亞">玻利維亞</html:option>
                    <html:option value="波士尼亞">波士尼亞</html:option>
                    <html:option value="博茨瓦納">博茨瓦納</html:option>
                    <html:option value="巴西">巴西</html:option>
                    <html:option value="汶萊">汶萊</html:option>
                    <html:option value="保加利亞">保加利亞</html:option>
                    <html:option value="伯基納法索">伯基納法索</html:option>
                    <html:option value="布隆迪">布隆迪</html:option>
                    <html:option value="柬埔寨">柬埔寨</html:option>
                    <html:option value="加拿大">加拿大</html:option>
                    <html:option value="好望角">好望角</html:option>
                    <html:option value="鱷魚島">鱷魚島</html:option>
                    <html:option value="中非">中非</html:option>
                    <html:option value="智利">智利</html:option>
                    <html:option value="哥倫比亞">哥倫比亞</html:option>
                    <html:option value="剛果">剛果</html:option>
                    <html:option value="哥斯大黎加">哥斯大黎加</html:option>
                    <html:option value="克羅地亞">克羅地亞</html:option>
                    <html:option value="古巴">古巴</html:option>
                    <html:option value="賽普勒斯">賽普勒斯</html:option>
                    <html:option value="捷克">捷克</html:option>
                    <html:option value="丹麥">丹麥</html:option>
                    <html:option value="多明尼加">多明尼加</html:option>
                    <html:option value="東帝汶">東帝汶</html:option>
                    <html:option value="厄瓜多爾">厄瓜多爾</html:option>
                    <html:option value="埃及">埃及</html:option>
                    <html:option value="薩爾瓦多">薩爾瓦多</html:option>
                    <html:option value="幾內亞">幾內亞</html:option>
                    <html:option value="愛沙尼亞">愛沙尼亞</html:option>
                    <html:option value="埃塞俄比亞">埃塞俄比亞</html:option>
                    <html:option value="菲濟">菲濟</html:option>
                    <html:option value="芬蘭">芬蘭</html:option>
                    <html:option value="法國">法國</html:option>
                    <html:option value="馬其頓">馬其頓</html:option>
                    <html:option value="德國">德國</html:option>
                    <html:option value="加納">加納</html:option>
                    <html:option value="希臘">希臘</html:option>
                    <html:option value="幾內亞">幾內亞</html:option>
                    <html:option value="海地">海地</html:option>
                    <html:option value="洪都拉斯">洪都拉斯</html:option>
                    <html:option value="匈牙利">匈牙利</html:option>
                    <html:option value="冰島">冰島</html:option>
                    <html:option value="印度">印度</html:option>
                    <html:option value="印尼">印尼</html:option>
                    <html:option value="伊朗">伊朗</html:option>
                    <html:option value="伊拉克">伊拉克</html:option>
                    <html:option value="愛爾蘭">愛爾蘭</html:option>
                    <html:option value="以色列">以色列</html:option>
                    <html:option value="義大利">義大利</html:option>
                    <html:option value="牙買加">牙買加</html:option>
                    <html:option value="日本">日本</html:option>
                    <html:option value="約旦">約旦</html:option>
                    <html:option value="肯雅">肯雅</html:option>
                    <html:option value="朝鮮">朝鮮</html:option>
                    <html:option value="科威特">科威特</html:option>
                    <html:option value="老撾">老撾</html:option>
                    <html:option value="黎巴嫩">黎巴嫩</html:option>
                    <html:option value="利比理亞">利比理亞</html:option>
                    <html:option value="立陶宛">立陶宛</html:option>
                    <html:option value="盧森堡">盧森堡</html:option>
                    <html:option value="馬達加斯加">馬達加斯加</html:option>
                    <html:option value="馬來西亞">馬來西亞</html:option>
                    <html:option value="馬爾代夫">馬爾代夫</html:option>
                    <html:option value="毛里求斯">毛里求斯</html:option>
                    <html:option value="墨西哥">墨西哥</html:option>
                    <html:option value="莫爾達瓦">莫爾達瓦</html:option>
                    <html:option value="摩納哥">摩納哥</html:option>
                    <html:option value="蒙古">蒙古</html:option>
                    <html:option value="摩洛哥">摩洛哥</html:option>
                    <html:option value="莫三比克">莫三比克</html:option>
                    <html:option value="緬甸">緬甸</html:option>
                    <html:option value="納米比亞">納米比亞</html:option>
                    <html:option value="尼泊爾">尼泊爾</html:option>
                    <html:option value="荷蘭">荷蘭</html:option>
                    <html:option value="新西蘭">新西蘭</html:option>
                    <html:option value="尼加拉瓜">尼加拉瓜</html:option>
                    <html:option value="尼日爾">尼日爾</html:option>
                    <html:option value="尼日利亞">尼日利亞</html:option>
                    <html:option value="挪威">挪威</html:option>
                    <html:option value="阿曼">阿曼</html:option>
                    <html:option value="巴基斯坦">巴基斯坦</html:option>
                    <html:option value="巴勒斯坦">巴勒斯坦</html:option>
                    <html:option value="巴拿馬">巴拿馬</html:option>
                    <html:option value="巴布亞新磯內亞">巴布亞新磯內亞</html:option>
                    <html:option value="巴拉圭">巴拉圭</html:option>
                    <html:option value="秘魯">秘魯</html:option>
                    <html:option value="菲律賓">菲律賓</html:option>
                    <html:option value="波蘭">波蘭</html:option>
                    <html:option value="葡萄牙">葡萄牙</html:option>
                    <html:option value="卡塔爾">卡塔爾</html:option>
                    <html:option value="韓國">韓國</html:option>
                    <html:option value="羅馬尼亞">羅馬尼亞</html:option>
                    <html:option value="俄羅斯">俄羅斯</html:option>
                    <html:option value="盧旺達">盧旺達</html:option>
                    <html:option value="聖盧西亞島">聖盧西亞島</html:option>
                    <html:option value="沙烏地阿拉伯">沙烏地阿拉伯</html:option>
                    <html:option value="塞內加爾">塞內加爾</html:option>
                    <html:option value="塞舌耳">塞舌耳</html:option>
                    <html:option value="塞拉里昂">塞拉里昂</html:option>
                    <html:option value="新加坡">新加坡</html:option>
                    <html:option value="斯洛伐克">斯洛伐克</html:option>
                    <html:option value="斯洛文尼亞">斯洛文尼亞</html:option>
                    <html:option value="所羅門">所羅門</html:option>
                    <html:option value="索馬里">索馬里</html:option>
                    <html:option value="南非">南非</html:option>
                    <html:option value="西班牙">西班牙</html:option>
                    <html:option value="斯里蘭卡">斯里蘭卡</html:option>
                    <html:option value="蘇丹">蘇丹</html:option>
                    <html:option value="斯威士蘭">斯威士蘭</html:option>
                    <html:option value="瑞典">瑞典</html:option>
                    <html:option value="瑞士">瑞士</html:option>
                    <html:option value="敘利亞">敘利亞</html:option>
                    <html:option value="中華民國 台北市">中華民國 台北市</html:option>
                    <html:option value="中華民國 高雄市">中華民國 高雄市</html:option>
                    <html:option value="中華民國 台灣">中華民國 台灣</html:option>
                    <html:option value="台灣 台北縣">台灣 台北縣</html:option>
                    <html:option value="台灣 基隆">台灣 基隆</html:option>
                    <html:option value="台灣 桃園">台灣 桃園</html:option>
                    <html:option value="台灣 新竹">台灣 新竹</html:option>
                    <html:option value="台灣 苗栗">台灣 苗栗</html:option>
                    <html:option value="台灣 台中">台灣 台中</html:option>
                    <html:option value="台灣 彰化">台灣 彰化</html:option>
                    <html:option value="台灣 南投">台灣 南投</html:option>
                    <html:option value="台灣 雲林">台灣 雲林</html:option>
                    <html:option value="台灣 嘉義">台灣 嘉義</html:option>
                    <html:option value="台灣 台南">台灣 台南</html:option>
                    <html:option value="台灣 高雄縣">台灣 高雄縣</html:option>
                    <html:option value="台灣 屏東">台灣 屏東</html:option>
                    <html:option value="台灣 宜蘭">台灣 宜蘭</html:option>
                    <html:option value="台灣 花蓮">台灣 花蓮</html:option>
                    <html:option value="台灣 台東">台灣 台東</html:option>
                    <html:option value="台灣 澎湖">台灣 澎湖</html:option>
                    <html:option value="台灣 金馬">台灣 金馬</html:option>
                    <html:option value="台灣 綠島蘭嶼">台灣 綠島蘭嶼</html:option>
                    <html:option value="台灣 琉球">台灣 琉球</html:option>
                    <html:option value="中國">中國</html:option>
                    <html:option value="中國 北京">中國 北京</html:option>
                    <html:option value="中國 廣東">中國 廣東</html:option>
                    <html:option value="中國 上海">中國 上海</html:option>
                    <html:option value="中國 新疆">中國 新疆</html:option>
                    <html:option value="中國 遼寧">中國 遼寧</html:option>
                    <html:option value="中國 廣西">中國 廣西</html:option>
                    <html:option value="中國 海南">中國 海南</html:option>
                    <html:option value="中國 湖南">中國 湖南</html:option>
                    <html:option value="中國 甘肅">中國 甘肅</html:option>
                    <html:option value="中國 河北">中國 河北</html:option>
                    <html:option value="中國 湖北">中國 湖北</html:option>
                    <html:option value="中國 江西">中國 江西</html:option>
                    <html:option value="中國 江蘇">中國 江蘇</html:option>
                    <html:option value="中國 西藏">中國 西藏</html:option>
                    <html:option value="中國 山東">中國 山東</html:option>
                    <html:option value="中國 浙江">中國 浙江</html:option>
                    <html:option value="中國 安徽">中國 安徽</html:option>
                    <html:option value="中國 福建">中國 福建</html:option>
                    <html:option value="中國 吉林">中國 吉林</html:option>
                    <html:option value="中國 山西">中國 山西</html:option>
                    <html:option value="中國 雲南">中國 雲南</html:option>
                    <html:option value="中國 貴州">中國 貴州</html:option>
                    <html:option value="中國 四川">中國 四川</html:option>
                    <html:option value="中國 陝西">中國 陝西</html:option>
                    <html:option value="中國 重慶">中國 重慶</html:option>
                    <html:option value="中國 天津">中國 天津</html:option>
                    <html:option value="中國 河南">中國 河南</html:option>
                    <html:option value="中國 青海">中國 青海</html:option>
                    <html:option value="中國 寧夏">中國 寧夏</html:option>
                    <html:option value="中國 香港">中國 香港</html:option>
                    <html:option value="中國 澳門">中國 澳門</html:option>
                    <html:option value="中國 其他">中國 其他</html:option>
                    <html:option value="塔吉克斯坦">塔吉克斯坦</html:option>
                    <html:option value="坦桑尼亞">坦桑尼亞</html:option>
                    <html:option value="泰國">泰國</html:option>
                    <html:option value="多哥">多哥</html:option>
                    <html:option value="湯加">湯加</html:option>
                    <html:option value="特立尼達和多巴哥">特立尼達和多巴哥</html:option>
                    <html:option value="突尼斯">突尼斯</html:option>
                    <html:option value="土庫曼斯坦">土庫曼斯坦</html:option>
                    <html:option value="土耳其">土耳其</html:option>
                    <html:option value="圖瓦盧">圖瓦盧</html:option>
                    <html:option value="美國">美國</html:option>
                    <html:option value="烏干達">烏干達</html:option>
                    <html:option value="烏克蘭">烏克蘭</html:option>
                    <html:option value="英國">英國</html:option>
                    <html:option value="烏拉圭">烏拉圭</html:option>
                    <html:option value="烏茲別克斯坦">烏茲別克斯坦</html:option>
                    <html:option value="瓦努阿圖">瓦努阿圖</html:option>
                    <html:option value="梵蒂岡">梵蒂岡</html:option>
                    <html:option value="委內瑞拉">委內瑞拉</html:option>
                    <html:option value="越南">越南</html:option>
                    <html:option value="維爾津群島">維爾津群島</html:option>
                    <html:option value="瓦利斯、富圖納群島">瓦利斯、富圖納群島</html:option>
                    <html:option value="薩哈拉">薩哈拉</html:option>
                    <html:option value="西薩摩亞">西薩摩亞</html:option>
                    <html:option value="葉門">葉門</html:option>
                    <html:option value="尚比亞">尚比亞</html:option>
                    <html:option value="辛巴威">辛巴威</html:option>
                  </html:select>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">年 齡：</td>
                <td class="table3">
                  <html:text value="" property="age" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">性 別： </td>
                <td class="table3">
                  <html:select property="sex" size="1">
                    <html:option value="" >&nbsp;</html:option>
                    <html:option value="male">帥哥&nbsp;</html:option>
                    <html:option value="female">美女&nbsp;</html:option>
                  </html:select>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">現任職務：</td>
                <td class="table3">
                  <html:text value="" property="position" style="BORDER-RIGHT: #666666 1px solid; BORDER-TOP: #666666 1px solid; BORDER-LEFT: #666666 1px solid; BORDER-BOTTOM: #666666 1px solid" size="25"/>
                </td>
              </tr>
              <tr>
                <td align="right" class="table3">個人簽名：</td>
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
          送出
       </html:submit>
    </td>
    <td align="left" valign="top" >
       <html:cancel onclick="bCancel=true;">
          取消
       </html:cancel>
    </td>
  </tr>
</table>
</html:form>
