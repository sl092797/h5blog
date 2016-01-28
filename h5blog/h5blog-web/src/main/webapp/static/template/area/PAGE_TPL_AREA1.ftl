<#if PAGE_TPL_AREA1_COM_DEFS??>
<#list PAGE_TPL_AREA1_COM_DEFS as def>
	<#include def.ftlPath>
</#list>
<#else>
	<div id="AREA1" style="width:100%; height:100%; background-color: #CCCCCC;">
		AREA1
	</div>
	<script type="text/javascript">
	
		window.onload = function(){
			for(var i=1; i<10; i++){
				var areaId = "AREA" + i;
				var areaDom = document.getElementById(areaId);
				if(areaDom){
					var height = areaDom.parentNode.clientHeight;
					areaDom.style.height = height + "px";
				}
			}
		}
	</script>
</#if>