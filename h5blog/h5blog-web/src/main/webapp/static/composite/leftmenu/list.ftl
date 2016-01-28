<#assign menu="comdef">
<#assign submenu="comdef_leftmenu">
<#include "/manage/head.ftl">
<style type="text/css">
</style>
<!--main content start-->
<section id="main-content">
	<section class="wrapper">
		<!-- page start-->
		<div class="row">
				<div class="col-xs-12">
					<section class="panel">
	                  <header class="panel-heading">
	                      
	                  </header>
	                  <div class="panel-body" id="attachment">
	                  	<div>
	                  		<table class="table table-striped table-advance table-hover">
                            	<thead>
                                	<tr>
                                		<th>顺序</th>
                						<th>菜单名</th>
                						<th>链接</th>
                						<th>系统关键字</th>
                						<th>操作</th>
              						</tr>
                                </thead>
                            	<tbody role="alert" aria-live="polite" aria-relevant="all">
                            		<#list leftMenuList as menu>
                            		<tr class="gradeA odd">
                            			<td>
                                    		<input type="text" autocomplete="off" style="width: 40px;" class="js_headline_sort" name="sort" value="${menu.order}" menuId="${menu.id}">
                                    	</td>
                                    	<td>
                                    		 ${menu.name}
                                    	</td>
                                    	<td>
                                    		${menu.url}
                                    	</td>
                                    	<td>
                                    		${menu.key}
                                    	</td>
                                    	<td>
                  							<!-- Icons -->
		                                      <a class="fancybox" rel="group" href="${BASE_PATH}/manage/leftmenu/update/${menu.id}.htm">修改</a> | 
		                                      <a class="js_delete" href="javascript:void(0);" menuId="${menu.id}">删除</a>
                						</td>
                                	</tr>
                                	</#list>
                               	</tbody>
                              </table>
                      	</div>
						<div>
							<button type="button" class="btn btn-info js_update_sort">
								<i class="icon-refresh"></i> 更新排序
							</button>
							<a href="${BASE_PATH}/manage/leftmenu/add.htm" type="button" class="btn btn-info">
								<i class="icon-refresh"></i> 增加菜单
							</a>
						</div>                      	
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
		jQuery(".fancybox").fancybox();
	    $('.js_update_sort').click(function() {
	        var headlineSort = new Array();
	        $('.js_headline_sort').each(function(i, element) {
	            var headline = {};
	            headline.headlineId = $(element).attr('headlineId');
	            headline.sort = $(element).val();
	            headlineSort.push(headline);
	        });
	        $.post("${BASE_PATH}/manage/leftmenu/headline/sort.json", {
	            "sortJson": $.toJSON(headlineSort)
	        },
	        function(data) {
	            if (data.result) {
	                bootbox.alert("更新成功",
	                function() {
	                    window.location.reload();
	                });
	            } else {
	                bootbox.alert(data.msg,
	                function() {
	          		});
	            }
	        },
	        "json");
	    }); 
		$('#attachment .js_delete').click(function(){
			var file = $(this);
			bootbox.confirm("是否要删除此项菜单？", function(result) {
				if (result) {
					$.post("${BASE_PATH}/manage/leftmenu/delete.json",{'menuId':file.attr("menuId")},function(data){
						if(data.result){
							window.location.reload();
						}
					},"json");
				}
			});		
		});	    	
	});	
</script>
<#include "/manage/foot.ftl">