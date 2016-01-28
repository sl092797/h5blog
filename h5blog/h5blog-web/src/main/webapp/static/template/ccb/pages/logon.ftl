<#include "head.ftl">
		<form onsubmit="return f_check();" method="post" name="loginForm" action="./login">
		<table width="100%" cellspacing="0" cellpadding="0" border="0">
			<tbody>
				<tr><td height="12"></td></tr>
 				<tr>
					<td align="center" style="padding:0px; margin:0px; width:400px; height:auto; border:1px solid #002b61; background-color:#ffffff">
						<ul>
							<table width="100%" cellspacing="0" cellpadding="0" border="0" align="center">
  								<tbody>
  									<tr>
    									<td height="25" colspan="3"></td>
									</tr>
									<tr>
										<td ></td>
										<td align="center" class ="table-header">预付卡持卡人登录</td>
  									</tr>
  									<tr>
    									<td height="25" colspan="3"></td>
									</tr>
								</tbody>
							</table>
							<table width="255" cellspacing="2" cellpadding="0" border="0" align="center">
								<tbody>
									<tr>
										<td width="55" height="36" align="center">
											<span class="table-content">卡号 </span>
											<span style="color:#FF0000">*</span>
										</td>
										<td align="center" colspan="2">
											<input type="text" style="width:200px; height:15px;" autocomplete="off" value="" name="j_username" />
										</td>
									</tr>
	  
									<tr>
										<td width="55" height="45" align="center">
											<span class="table-content">密码 </span>
											<span style="color:#FF0000">*</span>
										</td>
										<td align="center" colspan="2">
											<input type="password" style="width:200px; height:15px;" autocomplete="off" id="static_pin" />
											<input type="hidden" value="" name="encPin" />
										</td>        
									</tr>
	  								
	  								<tr>
    									<td width="55" height="45" align="center"><span class="table-content">验证码 </span><span style="color: #FF0000">*</span></td>
										<td align="right">
											<input name="j_captcha_response" autocomplete="off" type="text" style="width:150px; height:15px;"  />
										</td>
										<td align="left">
											<img title="看不清楚?点击更换验证码 " src= "./check"  style="width:50px; height:15px;" id="imgRandom" onclick="changeImage()"/>
										</td>
									</tr>
    							</tbody>
    						</table>
    						<table align="center">
    							<tr>
									<td align="left">
       									<span class="button" onclick="f_check()">登陆</span>
       								</td>
       								<td width="50" align="right"></td>
	 								<td align="left">
	 									<span class="button" onclick="javascript: return f_reset()">取消</span>
         								<input type="hidden" value="1" name="login_type" />
         								<input type="hidden" value="<%=PublicKeyN%>" name="PublicKeyN" />
										<input type="hidden" name="PublicKeyE" value="<%=PublicKeyE%>" />
										<input type="hidden" value="zh_cn" name="Lang" />
									</td>
     								</tr>
									
									<tr>
    									<td height="25" colspan="3"></td>
									</tr>
    						</table>
      					</ul>
      				</td>
      				<td>
						<p style="margin-left: 18pt" class="table-header">
							建行（亚洲）预付卡是一种创新的支付产品，使用便利，该卡可在全球银联商户刷卡消费，适合送礼、商务、自用或纪念。
						</p>
						<p>
							&nbsp;
						</p>
						<ul style="margin-left: 18pt" class="table-header">
							<li>
								无需记名
							</li>
						</ul>
						<p style="margin-left: 18pt" class="content-paragraph">
							建行（亚洲）预付卡是不记名卡。</p>
						<ul style="margin-left: 18pt" class="table-header">
							<li>
								全球通用
							</li>
						</ul>
						<p style="margin-left: 18pt" class="content-paragraph">
							使用前只须在卡背面签署便可凭卡背面签名式样在全球接受银联的商户刷卡消费，无须签账密码。</p>
						<ul style="margin-left: 18pt" class="table-header">
							<li>
								馈赠首选</li>
						</ul>
						<p style="margin-left: 18pt" class="content-paragraph">
							建行（亚洲）预付卡可自由转让，是馈赠亲友及商业送礼的最佳选择，惟持卡人必须年满18周岁。</p>
						<ul style="margin-left: 18pt" class="table-header">
							<li>
								24小时查询服务</li>
						</ul>
						<p style="margin-left: 18pt" class="content-paragraph">
							无论身处何地，只需登陆www.asia.ccb.com/cardprepaid或致电24小时服务热线4001&nbsp;203328，即可查询账户余额及有效期等信息。</p>
						<ul style="margin-left: 18pt" class="table-header">
							<li><a href="../file/Agreement_SC.pdf" style="color:#003576;">用卡协议</a>&nbsp;及&nbsp;<a href="../file/Fee schedule_SC.pdf" style="color:#003576;">收费表</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="../file/faq.pdf" style="color:#003576;">常见问题</a></li>
						</ul>
						
      				</td>
  				</tr>
			</tbody>
		</table>
		<table width="100%" cellspacing="0" cellpadding="0" border="0">
		  <tbody>
		  <tr>
		  	<td height="10"></td>
		  </tr>
		  <tr>
		  	<td class="table-content">注：本网站仅提供预付卡产品相关服务。操作银行户口，信用卡户口请往www.asia.ccb.com。</td>
		  </tr>
		  <tr>
		    <td height="40"></td>
		  </tr>
		</tbody></table>

</form>
</div>
<#include "foot.ftl">
</body>
</html>