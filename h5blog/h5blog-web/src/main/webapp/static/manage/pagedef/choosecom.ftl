<#assign menu="role">
<#assign submenu="choosecom">
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
								<a class="btn btn-primary" style="float:right;" href="${BASE_PATH}/manage/pagedef/choosetpl/${pageId}.htm"">选择模板</a>
						   </div>
						</div>
				</header>
                <div class="panel-body">
                	<div class="adv-table">
                    	<div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
                            <table class="table table-striped table-advance table-hover">
                            	<thead>
                                	<tr>
                                		<th>区域名称</th>
                                		<th>组件</th>
                						<th>操作</th>
              						</tr>
                                </thead>
                            	<tbody role="alert" aria-live="polite" aria-relevant="all">
                            		<#list areaList as pageArea>
                            		<tr class="gradeA odd">
                            			<td>
                                    		${pageArea.areaName}
                                    	</td>
                                    	<td>
                                    		<#if pageArea.comName??>${pageArea.comName}</#if>
                                    	</td>
                                    	<td>
                  							 <a class="preview" rel="group" href="${BASE_PATH}/manage/pagetpl/preview/pageTpl.id.htm">预览</a> | 
		                                     <a class="fancybox" rel="group" href="javascript:chooseCom(${pageArea.pgTplArea})">选择组件</a>
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
		<div class="modal fade" id="COM_DEF" tabindex="-1" role="dialog" 
		   aria-labelledby="myModalLabel" aria-hidden="true">
		   <div class="modal-dialog">
		      <div class="modal-content">
		         <div class="modal-header">
		            <button type="button" class="close" 
		               data-dismiss="modal" aria-hidden="true">
		                  &times;
		            </button>
		            <h4 class="modal-title" id="myModalLabel">
		              	选择组件
		            </h4>
		         </div>
		         <div class="modal-body">
		            <div class="adv-table">
                    	<div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
                            <table class="table table-striped table-advance table-hover">
                            	<thead>
                                	<tr>
                                		<th>组件名称</th>
                                		<th>组件描述</th>
                                        <th>组件定义描述</th>
                						<th>操作</th>
              						</tr>
                                </thead>
                            	<tbody role="alert" aria-live="polite" aria-relevant="all">
                            		<#list comDefs as comDef>
                            		<tr class="gradeA odd">
                            			<td>
                                    		<#if comDef.pageCom??>${comDef.pageCom.name}</#if>
                                    	</td>
                                    	<td>
                                    		<#if comDef.pageCom??>${comDef.pageCom.desc}</#if>
                                    	</td>
                                        <td>
                                            <#if comDef.desc??>${comDef.desc}</#if>
                                        </td>
                                    	<td>
                  							 <a class="preview" rel="group" href="${BASE_PATH}/manage/pagetpl/preview/pageTpl.id.htm">预览</a> | 
		                                     <a class="fancybox" rel="group" href="javascript:useCom(${comDef.id})">使用此组件</a>
                                			</a>
                						</td>
                                	</tr>
                                	</#list>
                               	</tbody>
                              </table>
                           </div>
                        </div>	
		         </div>
		         <div class="modal-footer">
		            <button type="button" class="btn btn-default" 
		               data-dismiss="modal">关闭
		            </button>
		            <button type="button" class="btn btn-primary">
		              	 确认
		            </button>
		         </div>
		      </div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
<script type="text/javascript">
    var page = {
    	pageId : ${pageId},
    	pageTplId : ${pageTplId},
    	areaId : 0,
    	comDefId : 0
    } 
	function chooseCom(areaId){
		$('#COM_DEF').modal('show');
		page.areaId = areaId;
	}
	
	function useCom(comDefId){
		page.comDefId = comDefId;
		 $.ajax({
			type: "post",
			data : page,
			dataType : 'json',
			url: "${BASE_PATH}/manage/pagedef/usecom.json",
			success : function(data) {
			 	if (data.result){
			 		 window.location.href = "${BASE_PATH}/manage/pagedef/choosecom/" + 
			 		 	page.pageId + "/" + page.pageTplId + ".htm";
			 	}
			}
	});
	}
</script>
<#include "/manage/foot.ftl">
