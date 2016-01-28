<table width=130px border="0"
	style="background-image: url(${CCB_BASE_PATH}/images/20130111-00-09.png)"
	align="center">
	<tr>
		<td height="30px"></td>
	</tr>
	<tr>
		<td style="text-align: center; width: 132px;"><span
			style="font-size: 20px; color: #006BB6; font-weight: 900;">预付卡</span></td>
	</tr>
	<tr>
		<#if pageName == "active">
		<td class="select-span"><span class="navname0"
			style="text-align: center; padding-right: 10px"><a
				href="./active.htm">卡片激活</a></span></td>
		<#else>
		<td class="tdname"><span class="navname"><a href="./active.htm">卡片激活</a></span></td>
		</#if>
	</tr>
	<tr>
		<#if pageName == "balQuery">
		<td class="select-span"><span class="navname0"
			style="text-align: center; padding-right: 10px"><a href="./balQuery.htm">余额查询</a></span></td>
		<#else>
		<td class="tdname"><span class="navname"><a
				href="./balQuery.htm">余额查询</a></span></td>
		</#if>
	</tr>
	<tr>
		<#if pageName == "tradeQuery">
		<td class="select-span"><span class="navname0"
			style="text-align: center; padding-right: 10px"><a href="./tradeQuery.htm">交易查询</a></span></td>
		<#else>
		<td class="tdname"><span class="navname"><a
				href="./tradeQuery.htm">交易查询</a></span></td>
		</#if>
	</tr>
	<tr>
		<#if pageName == "activeDate">
		<td class="select-span"><span class="navname0"
			style="text-align: center; padding-right: 10px"><a href="./activeDate.htm">有效期查询</a></span></td>
		<#else>
		<td class="tdname"><span class="navname"><a
				href="./activeDate.htm">有效期查询</a></span></td>
		</#if>
	</tr>
	<tr>
		<#if pageName == "badCard">
		<td class="select-span"><span class="navname0"
			style="text-align: center; padding-right: 10px"><a href="./badCard.htm">坏卡处理</a></span></td>
		<#else>
		<td class="tdname"><span class="navname"><a
				href="./badCard.htm">坏卡处理</a></span></td>
		</#if>
	</tr>
	<tr>
		<#if pageName == "suggest">
		<td class="select-span"><span class="navname0"
			style="text-align: center; padding-right: 10px"><a href="./suggest.htm">意见反馈</a></span></td>
		<#else>
		<td class="tdname"><span class="navname"><a
				href="./suggest.htm">意见反馈</a></span></td>
		</#if>
	</tr>
</table>

<table width=257px border="0">
	<tr>
		<td
			style="background: url(${CCB_BASE_PATH}/images/20130111-00-03.png) center; width: 257px; height: 11px;">
		</td>
	</tr>
	<tr>
		<td height="10px"></td>
	</tr>
	<tr>
		<td style="text-align: center; color: #002b61">欢迎您：${userName}</td>
	</tr>
	<tr>
		<td style="text-align: right; padding: 20px 35px"><a style="text-decoration:none" href="${CCB_BASE_PATH}/login.htm"><span
			class="button0">退出登录</span></a></td>
	</tr>
</table>