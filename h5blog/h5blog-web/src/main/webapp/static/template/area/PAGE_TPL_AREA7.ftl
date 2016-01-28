<#if PAGE_TPL_AREA7_COM_DEFS??>
<#list PAGE_TPL_AREA7_COM_DEFS as def>
	<#include def.ftlPath>
</#list>
<#else>
	<div id="AREA7" style="width:100%; background-color: #66CC66;">
		AREA7
	</div>
</#if>