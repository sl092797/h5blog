<#if PAGE_TPL_AREA2_COM_DEFS??>
<#list PAGE_TPL_AREA2_COM_DEFS as def>
	<#include def.ftlPath>
</#list>
<#else>
	<div id="AREA2" style="width:100%; background-color: #00CC33;">
		AREA2
	</div>
</#if>