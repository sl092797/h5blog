function killErrors() {
	return true;
}
window.onerror = killErrors;

function f_check() {

	var loginuser = document.loginForm.j_username.value;
	var loginpassword = document.loginForm.static_pin.value;

	if (loginuser == null || loginuser == "") {
		document.loginForm.j_username.focus();
		alert("账户号码不能为空");
		return false;
	} else if (loginuser.length < 16) {
		alert("账户号码长度不正确！");
		return false;
	}

	if (loginpassword == null || loginpassword == "") {
		alert("请输入查询密码！");
		document.loginForm.static_pin.focus();
		return false;
	} else if (loginpassword.length != 6) {
		alert("请输入六位查询密码！");
		document.loginForm.static_pin.focus();
		return false;
	}

	if (document.loginForm.j_captcha_response.value == null || document.loginForm.j_captcha_response.value == "") {
		document.loginForm.j_captcha_response.focus();
		alert("请输入验证码");
		return false;
	} else {
		var url = "../../include/checkRand.jsp?rand=" + document.loginForm.j_captcha_response.value;
		var re = doRequest(url);
		if (re == 0) {
			alert("验证码输入不正确");
			document.loginForm.j_captcha_response.value = "";
			return false;
		}
	}
	
	jStaticForm = document.loginForm;
	
	var publicKeyN = jStaticForm.PublicKeyN.value;
	var publicKeyE = jStaticForm.PublicKeyE.value;
	var pinVlaue = RSAEnc("06"+loginpassword,publicKeyN,publicKeyE);
	jStaticForm.encPin.value = RSAEnc(loginuser.length+loginuser+pinVlaue+GetRandomNum(0,999),rsaPublicKeyN,rsaPublicKeyE);

	document.loginForm.j_username.value = "";
	document.loginForm.static_pin.value = "000000";
	document.loginForm.submit();
}

function f_reset() {
	document.loginForm.j_username.value = "";
	document.loginForm.static_pin.value = "";
	document.loginForm.j_captcha_response.value = "";
}

//重新获取验证字符  
function changeImage() {
	//单击触发图片重载事件，完成图片验证码的更换  
	document.getElementById("imgRandom").src = document.getElementById("imgRandom").src+ '?';
}
