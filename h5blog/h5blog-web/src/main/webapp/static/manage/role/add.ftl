<#assign menu="role">
<#assign submenu="add_role">
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
 					新增角色
				</header>
				<div class="panel-body">
					<form id="add_role_form" method="post" class="form-horizontal" autocomplete="off" action="${BASE_PATH}/manage/role/add.json">
					<fieldset>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">角色名称<dfn>*</dfn></label>
                                      <div class="col-sm-4">
                                          <input type="text" class="form-control" name="roleName"
                                          	placeholder="角色名称" id="roleName">
                                      </div>
                                     <label class="col-sm-2 col-sm-2 control-label">角色代码<dfn>*</dfn></label>
                                      <div class="col-sm-4">
                                          <input type="text" class="form-control" name="roleNo"
                                          	placeholder="角色代码" id="roleNo">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">角色描述<dfn>*</dfn></label>
                                      <div class="col-sm-4">
                                        <input type="text" class="form-control" name="roleDesc"
                                          	placeholder="角色描述" id="roleDesc" >
                                      </div>
                                  </div> 
                                 </fieldset>
                                 <hr>
                                 <fieldset>          
                                  <#list allList as auths>
                                  <#if auths_index % 2 == 0>
                                    <div class="form-group">
                                   </#if>
                                 	<label class="col-sm-2 col-sm-2 control-label">${auths.authorityName}</label>
                                 	 <div class="col-sm-4">
                                 	 	<input type="checkbox" value="${auths.authorityId}" name="authority">	
                                     </div>
                                   <#if (auths_index+1) % 2 == 0>
                                    </div>
                                    <#else>
                                    <#if !auths_has_next>
                                   		</div>
                                   	</#if> 
                                   </#if>
                                  </#list>
                                   <div class="form-group">
                                  	<label class="col-sm-2 col-sm-2 control-label"></label>
                                      <button class="btn btn-danger" type="submit">新增</button>
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
		$("#update_roleId").hide();
		$('#add_role_form').ajaxForm({
			dataType : 'json',
			success : function(data) {
				if (data.result) {
					bootbox.alert("保存成功，将刷新页面", function() {
						window.location.reload();
					});
				}else{
					showErrors($('#add_role_form'),data.errors);
				}
			}
		});
	});	
</script>
<#include "/manage/foot.ftl">