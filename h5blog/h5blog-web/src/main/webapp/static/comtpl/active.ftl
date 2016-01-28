<script type="text/javascript" src="${PAGE_TPL_BASE_PATH}/ccb/js/active.js"></script>
<td style="padding-top:12px" align="center" valign="top">
	<span class="content-title" style="font-size: 13px">卡片激活</span>
</td>
	<td valign="top">
		<table width="100%" border="0" cellspacing="2" cellpadding="0">
			<tr>
				<td width="61%" height="90">
					<form action="${BASE_PATH}/ccba/active.json" name="activeForm" method="post">
						<input type="hidden" name="Language" value="1" />
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td>
									<table border="0" cellpadding="0" cellspacing="2">
										<tr>
											<td align="right" height="30"><span
												class="table-content">卡号:</span></td>
											<td width="170" align="left" height="30">
											<input type="text" name="j_username" value="${Session.FORCE_USER}"
												readonly="readonly" style="width: 150px; height: 15px;" />
											</td>
										</tr>
										<tr>
											<td align="right" height="30"><span
												class="table-content">密码:</span></td>
											<td align="left"><input type="password" maxlength="6"
												id='static_pin' style="width: 150px; height: 15px;" /> <input
												type="hidden" name="encPin" value="" /></td>
											<td align="left" height="30"><span
												style="font-size: 13px; color: #006BB6;">印于预付卡背面</span></td>
										</tr>
										<tr>
											<td align="right">&nbsp;</td>
											<td colspan="3" align="left">
												<table border="0" cellpadding="0" cellspacing="0">
													<tr>
														<td height="30" style="padding-left: 40px"><span
															class="button0" onclick="f_check()">提交</span>
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<@legoo_rsa_tag>
							<input type="hidden" name="PublicKeyN" value="${PublicKeyN}" /> 
							<input type="hidden" name="PublicKeyE" value="${PublicKeyE}" />
							<script  type="text/javascript">
								var rsaPublicKeyN = "${rsaPublicKeyN}";
								var rsaPublicKeyE = "${rsaPublicKeyE}";
								var rsaIndex = 1;
							</script>
							
						</@legoo_rsa_tag>
					</form>
				</td>
			</tr>
		</table>
	</td>
	