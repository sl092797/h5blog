<#assign menu="role">
<#assign submenu="role_list">
<#include "/manage/head.ftl">
<style type="text/css">
.pagination {
    border-radius: 4px;
    display: inline-block;
    margin: 0;
    padding-left: 0;
}
</style>
	<!--main content start-->
	<section id="main-content">
		<section class="wrapper">
        	<!-- page start-->
            <section class="panel">
             	<header class="panel-heading">
		                <div class="row">
						   <div class="col-lg-12">
								<a class="btn btn-primary" style="float:right;" href="${BASE_PATH}/manage/role/add.htm">增加后台角色</a>
								<a class="btn btn-primary" style="float:right;" href="${BASE_PATH}/manage/role/fore.htm">增加前台角色</a>							
						   </div>
						</div>
				</header>
                <div class="panel-body">
                	<div class="adv-table">
                	<h4>后台角色</h4>
                    	<div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
                            <table class="table table-striped table-advance table-hover">
                            	<thead>
                                	<tr>
                                		<th>序号</th>
                						<th>角色名称</th>
                						<th>角色代码</th>
                						<th>角色描述</th>
                						<th>创建时间</th>
                						<th>最后修改时间</th>
                						<th>操作</th>
              						</tr>
                                </thead>
                            	<tbody role="alert" aria-live="polite" aria-relevant="all">
                            		<#list backList as e>
                            		<tr class="gradeA odd">
                            			<td class="js_roleId">${e.roleId}</td>
                            			<td>${e_index+1}</td>
                                    	<td>${e.roleName}</td>
                                    	<td>${e.roleNo}</td>
                                    	<td>${e.roleDesc}</td>
                                    	<td>${e.createTime}</td>
                                    	<td>${e.lastModifyTime}</td>
                                    	<td>
                  							<!-- Icons -->
                  							<a href="${BASE_PATH}/manage/role/detail.htm?roleId=${e.roleId}" title="详细">
                								<button class="btn btn-primary btn-xs">
                									<i class="icon-eye-open"></i>
                								</button>
                							</a>
                							<a href="${BASE_PATH}/manage/role/update.htm?roleId=${e.roleId}" title="修改">
                								<button class="btn btn-primary btn-xs">
                									<i class="icon-edit"></i>
                								</button>
                							</a>
                							<a href="javascript:void(0);" roleId="${e.roleId}" title="删除" class="js_delete_role">
                                				<button class="btn btn-danger btn-xs">
                  									<i class="icon-trash "></i>
                  								</button>
                                			</a>
                						</td>
                                	</tr>
                                	</#list>
                               	</tbody>
                              </table>
                           </div>
                        </div>
                  </div>
                  <div class="panel-body">
                	<div class="adv-table">
                	<h4>前台角色</h4>
                    	<div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
                            <table class="table table-striped table-advance table-hover">
                            	<thead>
                                	<tr>
                                		<th>序号</th>
                						<th>角色名称</th>
                						<th>角色代码</th>
                						<th>角色描述</th>
                						<th>创建时间</th>
                						<th>最后修改时间</th>
                						<th>操作</th>
              						</tr>
                                </thead>
                            	<tbody role="alert" aria-live="polite" aria-relevant="all">
                            		<#list foreList as e>
                            		<tr class="gradeA odd">
                            			<td class="js_roleId">${e.roleId}</td>
                            			<td>${e_index+1}</td>
                                    	<td>${e.roleName}</td>
                                    	<td>${e.roleNo}</td>
                                    	<td>${e.roleDesc}</td>
                                    	<td>${e.createTime}</td>
                                    	<td>${e.lastModifyTime}</td>
                                    	<td>
                  							<!-- Icons -->
                  							<a href="${BASE_PATH}/manage/role/detail.htm?roleId=${e.roleId}" title="详细">
                								<button class="btn btn-primary btn-xs">
                									<i class="icon-eye-open"></i>
                								</button>
                							</a>
                							<a href="${BASE_PATH}/manage/role/update.htm?roleId=${e.roleId}" title="修改">
                								<button class="btn btn-primary btn-xs">
                									<i class="icon-edit"></i>
                								</button>
                							</a>
                							<a href="javascript:void(0);" roleId="${e.roleId}" title="删除" class="js_delete_role">
                                				<button class="btn btn-danger btn-xs">
                  									<i class="icon-trash "></i>
                  								</button>
                                			</a>
                						</td>
                                	</tr>
                                	</#list>
                               	</tbody>
                              </table>
                           </div>
                        </div>
                  </div>
              </section>
              <!-- page end-->
          </section>
		</section>
		<!--main content end-->
<script type="text/javascript">
	$(function() {
		$('.js_roleId').hide();
		
		$('.js_delete_role').click(function() {
		var roleId= $(this).attr('roleId');
        bootbox.dialog({
            message: "是否" + $(this).attr('title') + "角色",
            title: "提示",
            buttons: {
                "delete": {
                    label: "删除",
                    className: "btn-success",
                    callback: function() {
                        $.post("${BASE_PATH}/manage/role/delete.json", {
                            "roleId": roleId
                        },
                        function(data) {
                            if (data.result) {
                                bootbox.alert("删除成功",
                                function() {
                                   window.location.reload();
                                });
                            } else {
                                bootbox.alert(data.msg,
                                function() {});
                            }
                        },
                        "json");
                    }
                },
                "cancel": {
                    label: "取消",
                    className: "btn-primary",
                    callback: function() {}
                }
            }
        });
    });
	});	
</script>
<#include "/manage/foot.ftl">
