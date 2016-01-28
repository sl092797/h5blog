<#if PAGE_TPL_AREA4_COM_DEFS??>
<#list PAGE_TPL_AREA4_COM_DEFS as def>
	<#include def.ftlPath>
</#list>
<#else>
	<div id="AREA4" style="width:100%; background-color: #FFCCCC;">
		AREA4
	</div>
</#if>