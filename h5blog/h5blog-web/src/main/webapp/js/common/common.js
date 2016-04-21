// 通用TIP提示方法
function j_tip(message, type) {

	var toastrObj = toastr;
	if (window.parent.toastr) {
		toastrObj = window.parent.toastr;
	}

	if (type == undefined || type == null) {
		toastrObj.info(message);
	} else if (type == "error") {
		toastrObj.error(message);
	} else if (type == "success") {
		toastrObj.success(message);
	} else if (type == "warning") {
		toastrObj.warning(message);
	} else {
		toastrObj.info(message);
	}
}