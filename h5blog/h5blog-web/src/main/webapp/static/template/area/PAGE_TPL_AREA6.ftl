<#if PAGE_TPL_AREA6_COM_DEFS??>
<#list PAGE_TPL_AREA6_COM_DEFS as def>
	<#include def.ftlPath>
</#list>
<#else>
	<div id="AREA6" style="width:100%; background-color: #FF3333;">
		AREA6
	</div>
</#if>