<#assign menu="user">
<#assign submenu="add_user">
<#include "/manage/head.ftl">
<style type="text/css">
.m-bot15 {
    margin-bottom: 5px;
}
.form-control {
    border: 1px solid #E2E2E4;
    box-shadow: none;
    color: #C2C2C2;
}
.input-lg {
    border-radius: 6px;
    font-size: 15px;
    height: 40px;
    line-height: 1.33;
    padding: 9px 15px；
}

</style>
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
              <!-- page start-->
              <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <header class="panel-heading">
                            	 添加用户
                          </header>
                          <div class="panel-body">
                              <form id="add_user_form" method="post" class="form-horizontal" autocomplete="off" action="${BASE_PATH}/manage/user/addNew.json">
                              	<fieldset>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">用户名称<dfn>*</dfn></label>
                                      <div class="col-sm-4">
                                          <input type="text" class="form-control" name="loginName"
                                          	placeholder="用户名称" id="loginName">
                                      </div>
                                      <label class="col-sm-2 col-sm-2 control-label">用户密码<dfn>*</dfn></label>
                                      <div class="col-sm-4">
                                          <input type="text" class="form-control" name="loginPwd"
                                          	placeholder="用户密码" id="loginPwd">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">用户姓名</label>
                                      <div class="col-sm-4">
                                          <input type="text" class="form-control" name="realName"
                                          	placeholder="用户姓名" id="realName">
                                      </div>
                                       <label class="col-sm-2 col-sm-2 control-label">邮箱</label>
                                      <div class="col-sm-4">
                                          <input type="text" class="form-control" name="userEmail"
                                          	placeholder="邮箱" id="userEmail">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">电话</label>
                                      <div class="col-sm-4">
                                          <input type="text" class="form-control" name="userPhone"
                                          	placeholder="电话" id="userPhone">
                                      </div>
                                       <label class="col-sm-2 col-sm-2 control-label">手机</label>
                                      <div class="col-sm-4">
                                          <input type="text" class="form-control" name="userMobile"
                                          	placeholder="手机" id="userMobile">
                                      </div>
                                  </div> 
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">性别<dfn>*</dfn></label>
                                      <div class="col-sm-4">
                                      <select class="form-control" name="userSex" style="font-size:15px;width: 300px;">
                                      	<option value="1">男</option>
                                      	<option value="0">女</option>
                                      </select>
                                      </div>
                                       <label class="col-sm-2 col-sm-2 control-label">角色<dfn>*</dfn></label>
                                      <div class="col-sm-4">
                                      <select class="form-control" name="userRole" style="font-size:15px;width: 300px;">
                                      	<#list roleList as role>
                                      	<option value="${role.roleId}">${role.roleName}</option>
                                      	</#list>
                                      </select>
                                      </div>
                                  </div>
                                   <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">公司名称<dfn>*</dfn></label>
                                      <div class="col-sm-4">
                                          <input type="text" class="form-control" name="companyName"
                                          	placeholder="公司名称" id="companyName">
                                      </div>
                                      <label class="col-sm-2 col-sm-2 control-label">部门名称<dfn>*</dfn></label>
                                      <div class="col-sm-4">
                                          <input type="text" class="form-control" name="departmentName"
                                          	placeholder="部门名称" id="departmentName">
                                      </div>
                                  </div>
                                   <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">用户类型<dfn>*</dfn></label>
                                      <div class="col-sm-4">
                                         <select class="form-control" name="userFlag" style="font-size:15px;width: 300px;">
                                      	<option value="1">前台用户</option>
                                      	<option value="0">后台用户</option>
                                      </select>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                  	<label class="col-sm-2 col-sm-2 control-label"></label>
                                      <button class="btn btn-danger" type="submit">增加</button>
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
		$('#add_user_form').ajaxForm({
			dataType : 'json',
			success : function(data) {
				if (data.result) {
					bootbox.alert("保存成功", function() {
						window.location.href="${BASE_PATH}/manage/user/list.htm";
					});
				}else{
					showErrors($('#add_user_form'),data.errors);
				}
			}
		});
	});	
</script>
<#include "/manage/foot.ftl">