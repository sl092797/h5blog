<#assign menu="role">
<#assign submenu="choosetpl">
<#include "/manage/head.ftl">
<style type="text/css">
.pagination {
    border-radius: 4px;
    display: inline-block;
    margin: 0;
    padding-left: 0;
}
.selected{
	color: #FF6C60;
}

.selected a{
	color: #FF6C60;
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
								<a class="btn btn-primary" style="float:right; " href="${BASE_PATH}/manage/pagedef/list.htm">页面定义</a>
								<#if pageTplId??><a class="btn btn-primary" style="float:right;margin-right:5px;" href="${BASE_PATH}/manage/pagedef/choosecom/${pageId}/${pageTplId}.htm">选择组件</a></#if>
						   </div>
						</div>
				</header>
                <div class="panel-body">
                	<div class="adv-table">
                    	<div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
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
                            		<tr class="gradeA odd <#if pageTplId??><#if pageTplId==pageTpl.id> selected</#if></#if>">
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
                  							 <a class="preview" rel="group" href="javascript:window.open('${BASE_PATH}/manage/pagetpl/preview/${pageTpl.id}.htm', '', 'height=700, width=1000, top=0, left=200, toolbar=no, menubar=no, scrollbars=yes,resizable=yes,location=no, status=no')">预览</a> | 
		                                      <a class="fancybox" rel="group" href="${BASE_PATH}/manage/pagedef/choosecom/${pageId}/${pageTpl.id}.htm"><#if pageTplId??><#if pageTplId==pageTpl.id>使用中<#else>使用此模板</#if><#else>使用此模板</#if></a>
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

</script>
<#include "/manage/foot.ftl">
