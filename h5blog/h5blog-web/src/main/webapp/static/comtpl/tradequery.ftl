<td style="padding-top:12px" align="center" valign="top">
	<span class="content-title" style="font-size: 13px">交易查询</span>
</td>
<td valign="top">
	<@legoo_trade_query_tag>
	<table style="Border-spacing:10px 5px">
		<#if tis??>
		<thead>
			<tr>
				<td class="table-header" colspan="4">最多可显示最近10笔交易 (按 日/月/年 显示)</td>
			</tr>
		</thead>
		<tbody>
		<#list tis as ti>
			<tr>
				<td class="table-content">${ti.workDate}</td>
				<td class="table-content" style="width:250px">${ti.shopName}</td>
				<td class="table-content" style="width:100px">${ti.tranDesc}</td>
				<td class="table-content">${ti.currTrans}</td>
				<td class="table-content">${ti.amtTrans}</td>
			</tr>
		</#list>
		<#else>
			<tr>
				<td height="30" class="table-content">您没有进行交易</td>
			</tr>
		</#if>
		</tbody>
	</table>
	</@legoo_trade_query_tag>
</td>