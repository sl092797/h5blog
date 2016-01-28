<#assign menu="user">
<#assign submenu="update_user">
<#include "/manage/head.ftl">
<style type="text/css">
</style>
<!--main content start-->
	<section id="main-content">
		<section class="wrapper">
		<!-- page start-->
			<div class="row">
			<div class="col-lg-12">
			<section class="panel">
				<header class="panel-heading">
				 <div class="row">
				 	<div class="col-lg-4">
				 		修改用户资料
				 	</div>
					<div class="col-lg-12">
						<a class="btn btn-danger" style="float:right;" onclick="resetPwd();">重置密码</a>
					</div>
						</div>
 					
				</header>
				<div class="panel-body">
					<form id="update_user_form" method="post" class="form-horizontal" autocomplete="off" action="${BASE_PATH}/manage/user/update.json">
					<fieldset>
                                  <div class="form-group">
                                  <input type="hidden" id="userId" name="userId" value="${user.userId}">
                                      <label class="col-sm-2 col-sm-2 control-label">用户名称<dfn>*</dfn></label>
                                      <div class="col-sm-4">
                                          ${user.loginName}
                                      </div>
                                       <label class="col-sm-2 col-sm-2 control-label">用户角色<dfn>*</dfn></label>
                                      <div class="col-sm-4">
                                      <select class="form-control" name="userRole" style="font-size:15px;width: 300px;">
                                      	<#list roleList as role>
                                      		<option value="${role.roleId}" <#if user.userRole == role.roleId?c>selected</#if>>${role.roleName}</option>
                                      	</#list>
                                      </select>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">用户姓名</label>
                                      <div class="col-sm-4">
                                          <input type="text" class="form-control" name="realName"
                                          	placeholder="用户姓名" id="realName" value="${user.realName}">
                                      </div>
                                       <label class="col-sm-2 col-sm-2 control-label">邮箱</label>
                                      <div class="col-sm-4">
                                          <input type="text" class="form-control" name="userEmail"
                                          	placeholder="邮箱" id="userEmail" value="${user.userEmail}">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">电话</label>
                                      <div class="col-sm-4">
                                          <input type="text" class="form-control" name="userPhone"
                                          	placeholder="电话" id="userPhone" value="${user.userPhone}">
                                      </div>
                                       <label class="col-sm-2 col-sm-2 control-label">手机</label>
                                      <div class="col-sm-4">
                                          <input type="text" class="form-control" name="userMobile"
                                          	placeholder="手机" id="userMobile" value="${user.userMobile}">
                                      </div>
                                  </div> 
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">性别<dfn>*</dfn></label>
                                      <div class="col-sm-4">
                                      <select class="form-control" name="userSex" style="font-size:15px;width: 300px;">
                                      	<option value="1" <#if user.userSex==1>selected</#if>>男</option>
                                      	<option value="0"<#if user.userSex==0>selected</#if>>女</option>
                                      </select>
                                      </div>
                                       <label class="col-sm-2 col-sm-2 control-label">用户状态<dfn>*</dfn></label>
                                      <div class="col-sm-4">
                                      <select class="form-control" name="userState" style="font-size:15px;width: 300px;">
                                      	<option value="1" <#if user.userState=="1">selected</#if>>正常</option>
                                      	<option value="0"<#if user.userState=="0">selected</#if>>锁定</option>
                                      </select>
                                      </div>
                                  </div>
                                   <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">公司名称<dfn>*</dfn></label>
                                      <div class="col-sm-4">
                                          <input type="text" class="form-control" name="companyName"
                                          	placeholder="公司名称" id="companyName" value="${user.companyName}">
                                      </div>
                                      <label class="col-sm-2 col-sm-2 control-label">部门名称<dfn>*</dfn></label>
                                      <div class="col-sm-4">
                                          <input type="text" class="form-control" name="departmentName"
                                          	placeholder="部门名称" id="departmentName" value="${user.departmentName}">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                  	<label class="col-sm-2 col-sm-2 control-label"></label>
                                      <button class="btn btn-danger" type="submit">修改</button>
                                  </div>
                                 </fieldset>
				</form>
				</div>
			</section>
		</div>
		</div>
<!-- page end-->
		</section>
	</section>
 <!--main content end-->
<script type="text/javascript">
	$(function() {
		$("#update_userId").hide();
		$('#update_user_form').ajaxForm({
			dataType : 'json',
			success : function(data) {
				if (data.result) {
					bootbox.alert("保存成功，将刷新页面", function() {
						window.location.reload();
					});
				}else{
					showErrors($('#update_user_form'),data.errors);
				}
			}
		});
	});	

	function resetPwd(){
		bootbox.confirm("是否重置密码",function(){
			var userId = document.getElementById("userId").value;
			$.ajax({
				type: "POST",
				url: "${BASE_PATH}/manage/user/reset.json",
				data: "{userId:userId}",
				dataType: "json",
				success: function (data) {
					 bootbox.alert("重置成功，将刷新页面", function() {
						window.location.reload();
					});
				},
				error: function (data) {
                showErrors($('#update_user_form'),data.errors);
            }
			});	
		});
	}
</script>
<#include "/manage/foot.ftl">