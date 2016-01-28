<#assign menu="role">
<#assign submenu="detail_role">
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
 					角色详细信息
				</header>
				<div class="panel-body">
					<form id="update_role_form" method="post" class="form-horizontal" autocomplete="off" action="${BASE_PATH}/manage/role/update.json">
					<fieldset>
                                  <div class="form-group">
                                  <input type="hidden" name="roleId" value="${role.roleId}">
                                      <label class="col-sm-2 col-sm-2 control-label">角色名称</label>
                                      <div class="col-sm-4">
                                          ${role.roleName}
                                      </div>
                                     <label class="col-sm-2 col-sm-2 control-label">角色代码</label>
                                      <div class="col-sm-4">
                                          ${role.roleNo}
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">角色描述</label>
                                      <div class="col-sm-4">
                                         ${role.roleDesc}
                                      </div>
                                  </div> 
                                   <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">创建时间</label>
                                      <div class="col-sm-4">
                                     	${role.createTime}
                                      </div> 
                                      <label class="col-sm-2 col-sm-2 control-label">最后修改时间</label>
                                       <div class="col-sm-4">
                                      	${role.lastModifyTime}
                                       </div>
                                  </div>              
                                 </fieldset>
                                 <hr>
                                 <fieldset>
                                 <#if allList??>        
                                  <#list allList as auths>
                                  <#if auths_index % 2 == 0>
                                    <div class="form-group">
                                   </#if>
                                 	<label class="col-sm-2 col-sm-2 control-label">${auths.authorityName}</label>
                                 	 <div class="col-sm-4">
                                 	 	 <#if auths.isTrue == "1">
                                 	 	<input type="checkbox" value="${auths.authorityId}" name="authority" checked="checked">
                                 	 <#else>
                                 	 	<input type="checkbox" value="${auths.authorityId}" name="authority">
                                 	 </#if> 
                                     </div>
                                   <#if (auths_index+1) % 2 == 0>
                                    </div>
                                    <#else>
                                    <#if !auths_has_next>
                                   		</div>
                                   	</#if> 
                                   </#if>
                                  </#list>
                                  </#if>         
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