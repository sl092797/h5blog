<#if PAGE_TPL_AREA5_COM_DEFS??>
<#list PAGE_TPL_AREA5_COM_DEFS as def>
	<#include def.ftlPath>
</#list>
<#else>
	<div id="AREA5" style="width:100%; background-color: #FFFF66;">
		AREA5
	</div>
</#if>