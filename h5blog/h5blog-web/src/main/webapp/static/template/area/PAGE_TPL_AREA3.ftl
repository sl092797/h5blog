<#if PAGE_TPL_AREA3_COM_DEFS??>
<#list PAGE_TPL_AREA3_COM_DEFS as def>
	<#include def.ftlPath>
</#list>
<#else>
	<div id="AREA3" style="width:100%; background-color: #339999;">
		AREA3
	</div>
</#if>