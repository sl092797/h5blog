function killErrors() {
	return true;
}
window.onerror = killErrors;

function f_check() {

	var loginuser = document.activeForm.j_username.value;
	var loginpassword = document.activeForm.static_pin.value;

	if (loginuser == null || loginuser == "") {
		document.activeForm.j_username.focus();
		alert("账户号码不能为空");
		return false;
	} else if (loginuser.length < 16) {
		alert("账户号码长度不正确！");
		return false;
	}

	if (loginpassword == null || loginpassword == "") {
		alert("请输入查询密码！");
		document.activeForm.j_password.focus();
		return false;
	} else if (loginpassword.length != 6) {
		alert("请输入六位查询密码！");
		document.activeForm.j_password.focus();
		return false;
	}

	jStaticForm = document.activeForm;
	
	var publicKeyN = jStaticForm.PublicKeyN.value;
	var publicKeyE = jStaticForm.PublicKeyE.value;
	var pinVlaue = RSAEnc("06"+loginpassword,publicKeyN,publicKeyE);
	jStaticForm.encPin.value = RSAEnc(loginuser.length+loginuser+pinVlaue+GetRandomNum(0,999),rsaPublicKeyN,rsaPublicKeyE);

	document.activeForm.j_username.value = "";
	document.activeForm.static_pin.value = "000000";

	document.activeForm.submit();
}

function f_reset() {
	document.activeForm.j_username.value = "";
	document.activeForm.j_password.value = "";
	document.activeForm.j_captcha_response.value = "";
}

