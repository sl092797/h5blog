<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type"></meta>
<link href="${CCB_BASE_PATH}/css/common.css" rel="stylesheet" type="text/css" />
<link href="${CCB_BASE_PATH}/css/layout.css" rel="stylesheet" type="text/css" />
<link href="${CCB_BASE_PATH}/css/style.css" rel="stylesheet" type="text/css" />
<title>${webTitle}</title>

<script type="text/javascript" src="${CCB_BASE_PATH}/js/active.js"></script>

</head>
<body>
	<div class="master">

<script type="text/javascript">
	function chLang(lang){
		var url = '../../'+lang+'/pages/logon.jsp';
		if(window.parent){
			window.parent.location.href = url;
		}else{
			window.location.href = url;
		}
	}
	
	var rsaPublicKeyN = "${rsaPublicKeyN}";
	var rsaPublicKeyE = "${rsaPublicKeyE}";
	var rsaIndex = 1;
	
	
</script>

<script  src="${CCB_BASE_PATH}/js/rsaEnc.js"></script>
<div class="header">
		<img class="logo" alt="${logoAlt}" src="${CCB_BASE_PATH}/images/logo.jpg" />
     	
     	<div class="functionsBar">
		<table cellspacing="0" cellpadding="0" border="0">
			<tbody>
				<tr>
		         	<td valign="middle" style="padding:0 2px;">
		         		<img src="${CCB_BASE_PATH}/images/btn_language.jpg" />
		         	</td>
		         	<td valign="middle" style="padding:0 4px;">
		         		<a href="javascript:chLang('en')"><img src="${CCB_BASE_PATH}/images/btn_en.jpg" /></a>
		         	</td>
       			</tr>
     			</tbody>
     		</table>
     	</div> 
     
	<div id="topMenu" class="topMenu">
		<ul class="tab-menu" data-tab="personal">
			<li class="tab-menu-item"></li>
			<li class="tab-menu-item cancelBg highlight"><a href="#">预付卡</a></li>
		</ul>
	</div>        
</div>