<#if PAGE_TPL_AREA9_COM_DEFS??>
<#list PAGE_TPL_AREA9_COM_DEFS as def>
	<#include def.ftlPath>
</#list>
<#else>
	<div id="AREA9" style="width:100%; background-color: #9999CC;">
		AREA9
	</div>
</#if>