<#assign menu="user">
<#assign submenu="detail_user">
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
 					用户详细资料
				</header>
				<div class="panel-body">
					<form id="update_user_form" method="post" class="form-horizontal" autocomplete="off" action="${BASE_PATH}/manage/user/update.json">
					<fieldset>
                                  <div class="form-group">
                                  <input type="hidden" name="userId" value="${user.userId}">
                                      <label class="col-sm-2 col-sm-2 control-label">登陆名称</label>
                                      <div class="col-sm-4">
                                          ${user.loginName}
                                      </div>
                                     <label class="col-sm-2 col-sm-2 control-label">用户姓名</label>
                                      <div class="col-sm-4">
                                          ${user.realName}
                                      </div>
                                  </div>
                                  <div class="form-group">
                                   	  <label class="col-sm-2 col-sm-2 control-label">性别</label>
                                   	   <div class="col-sm-4">
                                       <#if user.userSex==1>男<#else>女</#if>
                                      </div>
                                      <label class="col-sm-2 col-sm-2 control-label">邮箱</label>
                                      <div class="col-sm-4">
                                        ${user.userEmail}
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">电话</label>
                                      <div class="col-sm-4">
                                         ${user.userPhone}
                                      </div>
                                       <label class="col-sm-2 col-sm-2 control-label">手机</label>
                                      <div class="col-sm-4">
                                         ${user.userMobile}
                                      </div>
                                  </div> 
                                   <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">公司名称</label>
                                      <div class="col-sm-4">
                                     	${user.companyName}
                                      </div> 
                                      <label class="col-sm-2 col-sm-2 control-label">部门名称</label>
                                       <div class="col-sm-4">
                                      	${user.departmentName}
                                       </div>
                                  </div>
                                   <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">创建时间</label>
                                      <div class="col-sm-4">
                                     	${user.createTime}
                                      </div> 
                                      <label class="col-sm-2 col-sm-2 control-label">最后修改时间</label>
                                       <div class="col-sm-4">
                                      	${user.lastModifyTime}
                                       </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">用户状态</label>
                                      <div class="col-sm-4">
                                       <#if user.userState=="1">正常<#else>锁定</#if>
                                      </div>
                                       <label class="col-sm-2 col-sm-2 control-label">用户角色</label>
                                      <div class="col-sm-4">
                                       	${user.userRole}
                                      </div>
                                  </div>      
                                  <div class="form-group">   
                                       <label class="col-sm-2 col-sm-2 control-label">用户类型</label>
                                      <div class="col-sm-4">
                                       	 <#if user.userFlag=="1">前台用户<#else>后台用户</#if>
                                      </div>
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
<#include "/manage/foot.ftl">