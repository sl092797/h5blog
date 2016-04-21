<!DOCTYPE html>
<html lang="en">
  	<head>
	    <meta charset="utf-8">
	    <title>Admin</title>
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="">

	    <!-- Bootstrap core CSS -->
	    <link href="${BASE_PATH}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Font Awesome -->
		<link href="${BASE_PATH}/css/font-awesome.min.css" rel="stylesheet">

		<!-- ionicons -->
		<link href="${BASE_PATH}/css/ionicons.min.css" rel="stylesheet">
		
		<!-- Simplify -->
		<link href="${BASE_PATH}/css/simplify.min.css" rel="stylesheet">

		<!-- Toastr -->
		<link href="${BASE_PATH}/css/toastr.css" rel="stylesheet">
		<style type="text/css">
			p.error {
				color: #DE5959;
			}

			.form-signin input[type="text"].error, .form-signin input[type="password"].error
				{
				border-color: #b94a48;
				color: #b94a48;
				-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
				box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
			}

			input.error:focus {
				border-color: #953b39;
				color: #b94a48;
				-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 6px
					#d59392;
				box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 6px #d59392;
			}
		</style>
	
  	</head>

  	<body class="overflow-hidden light-background">
		<div class="wrapper no-navigation preload">
			<div class="sign-in-wrapper">
				<div class="sign-in-inner">
					<div class="login-brand text-center">
						<strong class="text-skin">沪城学士</strong>
					</div>

					<form id="adminForm" action="login.json" method="post">
						<div class="form-group m-bottom-md">
							<input type="text" class="form-control" name="name" placeholder="用户名">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="password" placeholder="密码">
						</div>

						<div class="m-top-md p-top-sm">
							 <button class="btn btn-success" type="submit" style="width: 100%">登 录</button>
						</div>
					</form>
				</div><!-- ./sign-in-inner -->
			</div><!-- ./sign-in-wrapper -->
		</div><!-- /wrapper -->

		<a href="" id="scroll-to-top" class="hidden-print"><i class="icon-chevron-up"></i></a>

	    <!-- Le javascript
	    ================================================== -->
	    <!-- Placed at the end of the document so the pages load faster -->
		
		<!-- Jquery -->
		<script src="${BASE_PATH}/js/jquery-1.11.1.min.js"></script>

		<!-- form -->
		<script src='${BASE_PATH}/js/jquery.form.min.js'></script>
		
		<!-- Bootstrap -->
	    <script src="${BASE_PATH}/bootstrap/js/bootstrap.min.js"></script>
		
		<!-- Slimscroll -->
		<script src='${BASE_PATH}/js/jquery.slimscroll.min.js'></script>
		
		<!-- Popup Overlay -->
		<script src='${BASE_PATH}/js/jquery.popupoverlay.min.js'></script>

		<!-- Modernizr -->
		<script src='${BASE_PATH}/js/modernizr.min.js'></script>
		
		<!-- Simplify -->
		<script src="${BASE_PATH}/js/simplify/simplify.js"></script>

		<!-- Toastr -->
		<script src='${BASE_PATH}/js/toastr.js'></script>
	
  	</body>
</html>
<script type="text/javascript">
		/**
		 * 显示表单的错误提示
		 * @param id 表单ID
		 * @param errors 错误列表
		 */
		function showErrors(id, errors) {
			id.find('p[class=error]').hide();
			id.find('input,select').removeClass("error");
			for ( var name in errors) {
				var e = id.find('p[for=' + name + ']');
				id.find('input[name=' + name + '],select[name=' + name + ']')
						.addClass("error");
				if (e.length == 0) {
					id.find(
							'input[name=' + name + '],select[name=' + name
									+ ']').after(
							'<p for="'+name+'" class="error"></p>');
					e = id.find('p[for=' + name + ']');
				}
				if (errors[name] != "") {
					e.html(errors[name]);
					e.show();
				}
			}
		}
		$(function() {
			$('#adminForm')
					.ajaxForm(
							{
								dataType : 'json',
								success : function(data) {
									if (data.result) {
										location.href = "${BASE_PATH}/manage/index.htm";
									} else {
										toastr.error(data.errors['password']);
									}
								}
							});
		});
	</script>
