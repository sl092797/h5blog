<#assign menu="pagetpl">
<#assign submenu="pagetpl_list">
<#include header>
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
	                      模板列表
	                  </header>
	                  <div class="panel-body" id="attachment">
	                  	<div>
	                  		<table class="table table-striped table-advance table-hover">
                            	<thead>
                                	<tr>
                                		<th>模板名称</th>
                						<th>模板描述</th>
                						<th>模板地址</th>
                						<th>操作</th>
              						</tr>
                                </thead>
                            	<tbody role="alert" aria-live="polite" aria-relevant="all">
                            		<#list pageTplList as pageTpl>
                            		<tr class="gradeA odd">
                            			<td>
                                    		${pageTpl.name}
                                    	</td>
                                    	<td>
                                    		${pageTpl.desc}
                                    	</td>
                                    	<td>
                                    		${pageTpl.path}
                                    	</td>
                                    	<td>
                  							<!-- Icons -->
		                                      <a class="preview" rel="group" href="javascript:window.open('${BASE_PATH}/manage/pagetpl/preview/${pageTpl.id}.htm', '', 'height=700, width=1000, top=0, left=200, toolbar=no, menubar=no, scrollbars=yes,resizable=yes,location=no, status=no')">预览</a> | 
		                                      <a class="fancybox" rel="group" href="${BASE_PATH}/manage/pagetpl/update/${pageTpl.id}.htm">修改</a> | 
		                                      <a class="js_delete" href="javascript:void(0);" pageTplId="${pageTpl.id}">删除</a>
                						</td>
                                	</tr>
                                	</#list>
                               	</tbody>
                              </table>
                      	</div>
						<div>
							<a href="${BASE_PATH}/manage/pagetpl/add.htm" type="button" class="btn btn-info">
								<i class="icon-refresh"></i> 新增模板
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
	    $('.js_upload').click(function() {
	        var pageTplSort = new Array();
	        $('.js_pageTpl_name').each(function(i, element) {
	            var pageTpl = {};
	            pageTpl.pageTplId = $(element).attr('pageTplId');
	            pageTpl.sort = $(element).val();
	            pageTplSort.push(pageTpl);
	        });
	        $.post("${BASE_PATH}/manage/pageTpl/sort.json", {
	            "sortJson": $.toJSON(pageTplSort)
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
			bootbox.confirm("是否要删除文件？", function(result) {
				if (result) {
					$.post("${BASE_PATH}/manage/pageTpl/delete.json",{'pageTplId':file.attr("pageTplId")},function(data){
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