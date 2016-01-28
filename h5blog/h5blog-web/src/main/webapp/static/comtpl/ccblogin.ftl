<script type="text/javascript" src="${PAGE_TPL_BASE_PATH}/ccb/js/logon.js"></script>
<form onsubmit="return f_check();" method="post" name="loginForm"
		action="${BASE_PATH}/ccba/login.json">
		<ul>
			<table width="100%" cellspacing="0" cellpadding="0" border="0"
				align="center">
				<tbody>
					<tr>
						<td height="25" colspan="3"></td>
					</tr>
					<tr>
						<td></td>
						<td align="center" class="table-header">预付卡持卡人登录</td>
					</tr>
					<tr>
						<td height="25" colspan="3"></td>
					</tr>
				</tbody>
			</table>
			<table width="280" cellspacing="2" cellpadding="0" border="0"
				align="center">
				<tbody>
					<tr>
						<td width="55" height="36" align="center"><span
							class="table-content">卡号 </span> <span style="color:#FF0000">*</span>
						</td>
						<td align="center" colspan="2"><input type="text"
							style="width:200px; height:15px;" autocomplete="off" value=""
							name="j_username" /></td>
					</tr>

					<tr>
						<td width="55" height="45" align="center"><span
							class="table-content">密码 </span> <span style="color:#FF0000">*</span>
						</td>
						<td align="center" colspan="2"><input type="password"
							style="width:200px; height:15px;" autocomplete="off"
							id="static_pin" /> <input type="hidden" value="" name="encPin" />
						</td>
					</tr>

					<tr>
						<td width="55" height="45" align="center"><span
							class="table-content">验证码 </span><span style="color: #FF0000">*</span>
						</td>
						<td align="right"><input name="j_captcha_response"
							autocomplete="off" type="text" style="width:150px; height:15px;" />
						</td>
						<td align="left">
							<img title="看不清楚?点击更换验证码 "
								onclick="this.src='${BASE_PATH}/ccba/captcha.htm?'+Math.random();"
								src="${BASE_PATH}/ccba/captcha.htm"
								style="width:55px; height:25px;cursor:pointer;" id="imgRandom"/>
						</td>
					</tr>
				</tbody>
			</table>
			<table align="center">
				<tr>
					<td align="left"><span class="button" onclick="f_check()">登陆</span>
					</td>
					<td width="50" align="right"></td>
					<td align="left">
						<span class="button" onclick="javascript: return f_reset()">取消</span> 
						<input type="hidden" value="1" name="login_type" />
						<input type="hidden" value="zh_cn" name="Lang" />
						<@legoo_rsa_tag>
							<input type="hidden" name="PublicKeyN" value="${PublicKeyN}" /> 
							<input type="hidden" name="PublicKeyE" value="${PublicKeyE}" />
							<script  type="text/javascript">
								var rsaPublicKeyN = "${rsaPublicKeyN}";
								var rsaPublicKeyE = "${rsaPublicKeyE}";
								var rsaIndex = 1;
							</script>
							
						</@legoo_rsa_tag>
					</td>
				</tr>
					
				<tr>
					<td height="25" colspan="3"></td>
				</tr>
			</table>
		</ul>
	</form>