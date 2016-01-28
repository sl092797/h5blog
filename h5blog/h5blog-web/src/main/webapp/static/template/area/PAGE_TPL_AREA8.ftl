<#if PAGE_TPL_AREA8_COM_DEFS??>
<#list PAGE_TPL_AREA8_COM_DEFS as def>
	<#include def.ftlPath>
</#list>
<#else>
	<div id="AREA8" style="width:100%; background-color: #33CCFF;">
		AREA8
	</div>
</#if>