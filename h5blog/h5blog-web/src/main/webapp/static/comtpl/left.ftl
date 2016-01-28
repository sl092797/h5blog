<table width=130px border="0"
	style="background-image: url(${PAGE_TPL_BASE_PATH}/ccb/images/20130111-00-09.png)"
	align="center">
	<tr>
		<td height="30px"></td>
	</tr>
	<tr>
		<td style="text-align: center; width: 132px;"><span
			style="font-size: 20px; color: #006BB6; font-weight: 900;">预付卡</span></td>
	</tr>
	
	<@legoo_left_menu_tag key="CCB" pageUrl=url>
		<#list LEFT_MENU_LIST as menu>
			<tr>
			<#if menu.active>
				<td class="select-span"><span class="navname0"
					style="text-align: center; padding-right: 10px"><a
						href="${menu.url}">${menu.name}</a></span></td>
				<#else>
				<td class="tdname"><span class="navname"><a href="${menu.url}">${menu.name}</a></span></td>
			</#if>
			</tr>
		</#list>
	</@legoo_left_menu_tag>
</table>

<table width=257px border="0">
	<tr>
		<td
			style="background: url(${PAGE_TPL_BASE_PATH}/ccb/images/20130111-00-03.png) center; width: 257px; height: 11px;">
		</td>
	</tr>
	<tr>
		<td height="10px"></td>
	</tr>
	<tr>
		<td style="text-align: center; color: #002b61">欢迎您：${Session.FORCE_USER}</td>
	</tr>
	<tr>
		<td style="text-align: right; padding: 20px 35px"><a style="text-decoration:none" href="${BASE_PATH}/ccba/logout.json"><span
			class="button0">退出登录</span></a></td>
	</tr>
</table>