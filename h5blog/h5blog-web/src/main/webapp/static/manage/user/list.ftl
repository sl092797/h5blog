<#assign menu="user">
<#assign submenu="user_list">
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
        	<div class="row">
	                  <div class="col-lg-12">
	                      <!--breadcrumbs start -->
	                      <ul class="breadcrumb">
					<li>
						全部用户(${total})
					</li>
					<li>
						后台用户(${backCount})
					</li>
					<li>
						前台用户(${foreCount})
					</li>
	                      </ul>
	                      <!--breadcrumbs end -->
	                  </div>
	              </div>
            <section class="panel">
             	<header class="panel-heading">
		                <div class="row">
						   <div class="col-lg-12">
								<a class="btn btn-primary" style="float:right;" href="${BASE_PATH}/manage/user/add.htm">增加用户</a>
						   </div>
						</div>
				</header>
                <div class="panel-body">
                	<h4>后台用户</h4>
                	<div class="adv-table">
                    	<div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
                            <table class="table table-striped table-advance table-hover">
                            	<thead>
                                	<tr>
                                		<th>序号</th>
                						<th>用户名</th>
                						<th>性别</th>
                						<th>部门</th>
                						<th>公司</th>
                						<th>用户状态</th>
                						<th>用户角色</th>
                						<th>创建时间</th>
                						<th>最后修改时间</th>
                						<th>操作</th>
              						</tr>
                                </thead>
                            	<tbody role="alert" aria-live="polite" aria-relevant="all">
                            		<#list backList as e>
                            		<tr class="gradeA odd">
                            			<td class="js_userId">${e.userId}</td>
                            			<td>${e_index+1}</td>
                                    	<td>${e.loginName}</td>
                                    	<td><#if e.userSex == 1>男<#else>女</#if></td>
                                    	<td>${e.departmentName}</td>
                                    	<td>${e.companyName}</td>
                                    	<td><#if e.userState=="1">正常<#else>锁定</#if></td>
                                    	<td>${e.userRole}</td>
                                    	<td>${e.createTime}</td>
                                    	<td>${e.lastModifyTime}</td>
                                    	<td>
                  							<!-- Icons -->
                  							<a href="${BASE_PATH}/manage/user/detail.htm?userId=${e.userId}" title="详细">
                								<button class="btn btn-primary btn-xs">
                									<i class="icon-eye-open"></i>
                								</button>
                							</a>
                							<a href="${BASE_PATH}/manage/user/update.htm?userId=${e.userId}" title="修改">
                								<button class="btn btn-primary btn-xs">
                									<i class="icon-edit"></i>
                								</button>
                							</a>
                							<a href="javascript:void(0);" userId="${e.userId}" title="删除" class="js_delete_user">
                                				<button class="btn btn-danger btn-xs">
                  									<i class="icon-trash "></i>
                  								</button>
                                			</a>
                						</td>
                                	</tr>
                                	</#list>
                               	</tbody>
                              </table>
                              <div style="height: 30px;">
                             	<div class="pagination">${pageVo.pageNumHtml} </div>
                              </div>
                           </div>
                        </div>
                  </div>
                  <!-- 前台用户 -->
                    <div class="panel-body">
                    <h4>前台用户</h4>
                	<div class="adv-table">
                    	<div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
                            <table class="table table-striped table-advance table-hover">
                            	<thead>
                                	<tr>
                                		<th>序号</th>
                						<th>用户名</th>
                						<th>性别</th>
                						<th>部门</th>
                						<th>公司</th>
                						<th>用户状态</th>
                						<th>用户角色</th>
                						<th>创建时间</th>
                						<th>最后修改时间</th>
                						<th>操作</th>
              						</tr>
                                </thead>
                            	<tbody role="alert" aria-live="polite" aria-relevant="all">
                            		<#list foreList as e>
                            		<tr class="gradeA odd">
                            			<td class="js_userId">${e.userId}</td>
                            			<td>${e_index+1}</td>
                                    	<td>${e.loginName}</td>
                                    	<td><#if e.userSex == 1>男<#else>女</#if></td>
                                    	<td>${e.departmentName}</td>
                                    	<td>${e.companyName}</td>
                                    	<td><#if e.userState=="1">正常<#else>锁定</#if></td>
                                    	<td>${e.userRole}</td>
                                    	<td>${e.createTime}</td>
                                    	<td>${e.lastModifyTime}</td>
                                    	<td>
                  							<!-- Icons -->
                  							<a href="${BASE_PATH}/manage/user/detail.htm?userId=${e.userId}" title="详细">
                								<button class="btn btn-primary btn-xs">
                									<i class="icon-eye-open"></i>
                								</button>
                							</a>
                							<a href="${BASE_PATH}/manage/user/update.htm?userId=${e.userId}" title="修改">
                								<button class="btn btn-primary btn-xs">
                									<i class="icon-edit"></i>
                								</button>
                							</a>
                							<a href="javascript:void(0);" userId="${e.userId}" title="删除" class="js_delete_user">
                                				<button class="btn btn-danger btn-xs">
                  									<i class="icon-trash "></i>
                  								</button>
                                			</a>
                						</td>
                                	</tr>
                                	</#list>
                               	</tbody>
                              </table>
                              <div style="height: 30px;">
                             	<div class="pagination">${pageVo.pageNumHtml} </div>
                              </div>
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
		$('.js_userId').hide();
		
		$('.js_delete_user').click(function() {
		var userId= $(this).attr('userId');
        bootbox.dialog({
            message: "是否" + $(this).attr('title') + "用户",
            title: "提示",
            buttons: {
                "delete": {
                    label: "删除",
                    className: "btn-success",
                    callback: function() {
                        $.post("${BASE_PATH}/manage/user/delete.json", {
                            "userId": userId
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
